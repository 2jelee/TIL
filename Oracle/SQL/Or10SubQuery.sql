/******************************
파일명 : Or10SubQuery.sql
서브쿼리
설명 : 쿼리문 안에 또다른 쿼리문이 들어가는 형태의 select문
******************************/

/*
단일행 서브쿼리
    형식] 
        select * from 테이블명 where 컬럼=(
            select 컬럼 from 테이블명 where 조건
        );
        ※괄호 안의 서브쿼리는 반드시 하나의 결과를 인출해야 한다.
*/
/*
시나리오 ] 사원테이블에서 전체사원의 평균 급여보다 낮은 급여를 받는 사원들을
                추출하여 출력하시오.
                출력항목 : 사원번호, 이름, 이메일, 연락처, 급여
*/
select
    employee_id, first_name, last_name, email, salary
from employees
where salary < round(avg(salary)); /*
        해당 쿼리문은 문맥상 맞는듯하나,
        그룹함수를 단일행에 적용한 잘못된 쿼리문이다.       >> error
*/ 
--1단계 평균급여가 얼마인지를 구한다.
select
    round(avg(salary))
from employees;

--2단계 : 1단계 인출결과(6462)보다 적은 급여를 받는 직원을 인출한다.
select * 
    from employees
where salary<6462;          --3단계에서 6462를 ()로 바꾼 후 1단계를 삽입함

--3단계 : 2개의 쿼리를 하나의 서브쿼리문으로 합친다 (1+2단계)
select * from employees
    where salary<(select round(avg(salary)) from employees);
    

/*
시나리오] 전체 사원중 급여가 가장 적은 사원의 이름과 급여를 출력하는 서브쿼리문을 작성하시오.
    출력항목 : 이름1, 이름2, 이메일, 급여
*/
--1
select
    min(salary)
from employees;
--2
select
    first_name, last_name, email, salary from employees
where salary=2100;
--3
select
    first_name, last_name, email, salary from employees
where salary=(select min(salary) from employees);


/*
시나리오] 평균급여보다 많은 급여를 받는 사원들의 명단을 조회할 수 있는
            서브쿼리문을 작성하시오.
            출력내용 : 이름1, 이름2, 담당업무명, 급여
            ※ 담당업무명은 jobs 테이블에 있으므로 join해야 한다.
*/
--1단계 : 평균급여 구하기
select 
    trunc(avg(salary),2)
from employees;

--2단계 : 6461.83보다 급여가 많은 사원 인출
select * from employees where salary>6461.83;

--3단계 : jobs 테이블과 조인을 건다.
select
    first_name, last_name, job_title
from employees inner join jobs using (job_id)
where salary>6461.83;

--4단계 : 서브쿼리로 병합
select
    first_name, last_name, job_title
from employees inner join jobs using (job_id)
where salary>(select trunc(avg(salary),2) from employees);


/*
복수행 서브쿼리
    형식]
        select * from 테이블명 where 컬럼 in(
            select 컬럼 from 테이블명 where 조건
        );
        ※괄호 안의 서브쿼리는 2개 이상의 결과를 인출해야 한다.
*/
/*
시나리오] 담당업무별로 가장 높은 급여를 받는 사원의 명단을 조회하시오.
    출력목록 : 사원아이디, 이름, 담당업무아이디, 급여
*/
--1 : 사원테이블에서 단순 정렬을 통해 업무별 고액연봉자 확인
select
    job_id, salary
from employees
order by job_id, salary desc;

--2 : 1번에서 확인한 레코드를 group by절로 그룹화하여 각 직종별 최대급여를 확인한다.
select
    job_id, max(salary)
from employees
group by job_id;

--3 : 2번의 결과를 대상으로 단순 쿼리문 작성
select
    employee_id, first_name, job_id, salary
from employees
where
    (job_id= 'IT PROG' and salary=9000) or
    (job_id= 'AC_MGR' and salary=12008) or
    (job_id= 'AC_ACCOUNT' and salary=8300) or
    (job_id= 'ST_MAN' and salary=8200) or
    (job_id= 'PU_MAN' and salary=11000); /*
            2번에서 인춯된 19개의 결과를 단순 쿼리로 작성하면
            위와 같이 or연산자를 통해 연결할 수 있다.
            하지만 결과가 많다면 작성이 불가능할 것이다.
            */
--4 : 3번의 쿼리문을 서브쿼리로 변경한다. 복수행이므로 in을 사용.
select
    employee_id, first_name, job_id, salary
from employees
where
    (job_id, salary) in (
            select
                  job_id, max(salary)
            from employees
            group by job_id
    );
    
    
/*
복수행 연산자2 : any
    메인쿼리의 비교조건이 서브쿼리의 검색결과와 하나 이상 일치하면 참이 되는 연산자.
    즉, 둘중 하나만 만족한다면 해당 레코드를 가져온다.
*/
/*
시나리오] 전체 사원중에서 부서번호가 20인 사원들의 급여보다 높은 급여를 받는 직원들을
                추출하는 서브쿼리문을 작성하시오.
*/
--1단계 : 20번 부서의 급여를 우선 확인
select  * from employees
where department_id=20;
--2단계 : 1의 결과를 단순쿼리를 만들어본다면,
select * from employees
where salary>=13000 or salary>=6000;
--3단계 : 2의 결과를 서브쿼리로 작성. 이때 any를 사용한다.
--select * from employees
 --   where salary>=any(select  * from employees where department_id=20);       --서브쿼리문의 *는 전체를 의미하여 error >> salary로 바꿔준다.
select 
    first_name, last_name, department_id, salary
from employees
    where salary>=any(select  salary from employees where department_id=20); /*
                            복수행 연산자 any를 사용하면 2번과 같이 or 조건으로 결과들을 연결하게 된다.
                            6000 또는 13000 이상인 레코드만 추출된다.
                            */
                            
                            
/*
복수행연산자3 : all
    : 메인쿼리의 비교조건이 서브쿼리의 검색결과와 모두 일치해야 참이 된다.
*/
select 
    first_name, last_name, department_id, salary
from employees
    where salary>=all(select  salary from employees where department_id=20); /*
                6000보다 크고 13000보다도 커야하므로 결과적으로 13000이상인 레코드만 추출하게 된다.
                */
                
                
/*
Top 쿼리 : 조회된 결과에서 구간을 정해 레코드를 가져올 때 사용한다.
                주로 게시판의 페이징에 사용됨.
                
                rownum : 테이블에서 레코드를 조회한 순서대로 순번이 부여되는 가상의 컬럼을 말함.
                                해당 컬럼은 모든 테이블에 존재.
*/
select * from employees;
select employee_id, first_name, rownum from employees;
select employee_id, first_name, rownum from employees order by first_name;
select employee_id, first_name, rownum from (
    select * from employees order by first_name
);


/*
사원테이블을 정해진 구간을 통해 가져오기 위한 서브쿼리문
*/
select * from
    (select Tb.*, rownum rNum from (                        --rownum부여 시 2번
        select * from employees order by employee_id desc   --rownum부여 시 1번(rownum은 오라클에서 자동으로 부여하므로 이 방법을 통해 '정렬'한다.)
    )  Tb) --(select Tb.~ Tb)까지 테이블 들어갈 자리
--where rNum between 1 and 10;        -- rNum>=1 and rNum<=10   --게시판 작성시 1page
where rNum between 11 and 20;                                   --게시판 작성시 2page

/*
    between의 구간을 위와 같이 변경해주면 해당 페이지의 레코드만 가져오게 된다.
    위의 구간은 차후 JSP에서 여러가지 변수를 조합하고 계산해서 구현하게 된다.

③ ②의 결과 전체를 가져와서..
    (② ①의 결과에 rownum을 순차적으로 부여함  (
        ①사원테이블의 모든 레코드를 내림차순 정렬해서 인출
    )  Tb)
필요한 부분을 rownu,으로 구간을 정해 인출  
*/

--------------------------------------------------------------------------------------
--------------------------------------------------------------------------------------
--연습문제                                               #scott 계정에서 진행
set serveroutput on;

--01.사원번호가 7782인 사원과 담당 업무가 같은 사원을 표시(사원이름과 담당업무)하시오.
--1단계 : 사원번호가 7782인 사원의 담당업무
select
    job
from emp
where empno=7782;
--2단계 : 1단계의 담당업무가 같은 사원 표시
select
    ename, job
from emp
where job='MANAGER';
--3단계 : 합치기
select
    ename, job
from emp
where job=(select job from emp where empno=7782);


--02.사원번호가 7499인 사원보다 급여가 많은 사원을 표시(사원이름과 담당업무)하시오.
--1 : 사원번호가 7499인 사원
select
    sal
from emp
where empno=7499;

--2 : allen(7499)보다 급여가 많은 사원
select
    ename, job
from emp
where sal>(select sal from emp where empno=7499);


--03.최소 급여를 받는 사원의 이름, 담당 업무 및 급여를 표시하시오(그룹함수 사용).
--1 : 최소 급여 확인  >> 800
select
    ename, job, sal
from emp
order by sal asc;

--2 : 1번에서 확인한 레코드를 group by절로 그룹화, 최소 급여 확인
select
    job, min(sal)
from emp
group by job;

--3
select
    ename, job, sal
from emp
where
    (job, sal) in (
            select
                job, min(sal)
            from emp
            group by job);

/*선생님 풀이*/
select min(sal) from emp;
select * from emp where sal=800;
--서브쿼리로 결합
select empno, ename, job, sal from emp
    where sal=(select min(sal) from emp);

--04.평균 급여가 가장 적은 직급(job)과 평균 급여를 표시하시오. ★★★
--0. 평균급여 확인
select
    trunc(avg(sal),2)
from emp;

select* from emp;
select * from emp group by job;    --error : group by로 그룹화한 데이터에서 그룹함수를 통한 결과 이외의 값은 출력이 애매하므로


--2. 직급별 평균급여 확인
select
    job, trunc(avg(sal),2)
from emp
group by job;

-- : 1에서 가장 평균급여가 적은 직급    >> CLERK
select
    trunc(avg(sal),2)
from emp
where job='CLERK';

--4
select
    trunc(avg(sal),2)
from emp
where (job,sal) in (select
                        job, trunc(avg(sal),2)
                    from emp
                    group by job);

/*선생님 풀이*/
--담당업무로 그룹화하여 업무별 평균급여 조회
select job, round(avg(sal)) from emp group by job;
--오류발생 : not a single-group group function
select job, min(round(avg(sal))) from emp group by job;
--select 절에서 job을 제외한 후 실행
select min(round(avg(sal))) from emp group by job;

/*평균급여는 물리적으로 존재하는 컬럼이 아니고 where절에는 사용할 수 없고
  having절에 사용해야 한다.
  즉, 평균급여가 1017인 직급을 출력하는 방식으로 서브쿼리를 작성*/
select job, round(avg(sal))
    from emp group by job
    having round(avg(sal))=(select min(round(avg(sal))) from emp group by job);
    

--05.각 부서의 최소 급여를 받는 사원의 이름, 급여, 부서번호를 표시하시오.
--1. 각 부서의 최소급여 확인
select
    ename, sal, deptno
from emp
order by sal asc;

--2.
select
    job, min(sal)
from emp
group by job;

--3.
select
    ename, sal, deptno
from emp
where (job, sal) in (
         select
              job, min(sal)
         from emp
         group by job
      );


--06.담당 업무가 분석가(ANALYST)인 사원보다 급여가 적으면서 업무가 분석가(ANALYST)가 아닌 사원들을 표시(사원번호, 이름, 담당업무, 급여)하시오.
--1. 담당 업무가 분석가(ANALYST)인 사원
select
    empno, ename, job, sal
from emp
where job='ANALYST';

--2.
select
    empno, ename, job, sal
from emp
where sal<3000 and job!='ANALYST';


--07.부하직원이 없는 사람의 이름을 표시하시오.
select
    ename
from emp
where MGR is null;

--08.부하직원이 있는 사람의 이름을 표시하시오.
select
    ename
from emp
where MGR is not null;

--09.BLAKE와 동일한 부서에 속한 사원의 이름과 입사일을 표시하는 질의를 작성하시오. (단, BLAKE는 제외).
--1 : BLAKE의 부서번호
select
    deptno
from emp
where ename='BLAKE';

--2 : 
select
    ename, hiredate
from emp
where deptno in (select deptno from emp where ename='BLAKE');

--10.급여가 평균 급여보다 많은 사원들의 사원번호와 이름을 표시하되 결과를 급여에 대해서
   --오름차순으로 정렬하시오.
--1. 평균급여 확인
select
    avg(sal)
from emp;

--2. 평균급여보다 급여가 많은 사원들의 사원번호와 이름 표시
select
    empno, ename
from emp
where sal>(select avg(sal) from emp);

--3. 오름차순 정렬
select
    empno, ename
from emp
where sal>(select avg(sal) from emp)
order by sal asc;

--11.이름에 K가 포함된 사원과 같은 부서에서 일하는 사원의 사원번호와 이름을 표시하는 질의를
--   작성하시오
--1.이름에 K가 포함된 사원과 부서(번호)
select
    ename, deptno
from emp
where ename like ('%K%');               --복수행 연산자 사용해야된다.

--2.같은 부서에서 일하는 사원의 사원번호와 이름        --error ★
select
    empno, ename
from emp
where deptno in (select
    ename, deptno
from emp
where ename like ('%K%'));

/*선생님 풀이*/
select * from emp where deptno=10 or deptno =30;        --or로 조건걸기
select * from emp where deptno in (10,30);              --in으로 조건걸기

/*
    or조건을 in으로 변경할 수 있으므로
    서브쿼리에서 복수행 연산에 in을 사용
    2개 이상의 결과를 or로 연결하여 출력하는 효과를 가짐
*/
select empno, ename, deptno
from emp
where deptno in (select deptno from emp where ename like '%K%');


--12.부서 위치가 DALLAS인 사원의 이름과 부서번호 및 담당 업무를 표시하시오.
select
    ename, e.deptno, job
from emp e, dept d
where e.deptno = d.deptno
      and LOC='DALLAS';

--13.KING에게 보고하는 사원의 이름과 급여를 표시하시오.
--1. KING의 empno
select
    empno
from emp
where ename='KING';

--2.
select
    ename, sal
from emp
where MGR=(select empno from emp where ename='KING');


--14.RESEARCH 부서의 사원에 대한 부서번호 사원이름 및 담당 업무를 표시하시오.
--1. RESEARCH 부서의 부서번호
select
    deptno
from dept
where dname='RESEARCH';

select
    e.deptno, ename, job
from emp e, dept d
where
    e.deptno = d.deptno
    and dname='RESEARCH';


--15.평균 급여보다 많은 급여를 받고 이름에 k가 포함된 사원과
--   같은 부서에서 근무하는 사원의 사원번호, 이름, 급여를 표시하시오.    ★★★
--1. 평균급여 (임의로 소숫점 2자리로 표시했음)
select
    trunc(avg(sal),2)
from emp;

--2. 이름에 K가 포함된 사원 및 부서(번호)
select
    ename, deptno
from emp
where ename like '%K%';

--3. 
select
    empno, ename, sal
from emp
where (ename like '%K%')            --having이 아님... sal은 물리적으로 존재하는 컬럼
      and sal>(trunc(avg(sal),2));

/*선생님 풀이*/
select
    empno, ename, sal
from emp
where sal>2077
      and deptno in (10, 30);
--서브쿼리로 작성
select
    empno, ename, sal
from emp
where sal>(select round(avg(sal)) from emp)
      and deptno in (select deptno from emp where ename like '%K%');


--16.평균 급여가 가장 적은 업무를 찾으시오.
--1. 업무별 평균급여
select
    job, trunc(avg(sal),2)
from emp
group by job;

--2.


--17.담당 업무가 MANAGER인 사원이 소속된 부서와 동일한 부서의 사원을 표시하시오.
--1. 담당업무가 MANAGER인 사원
select
    ename, deptno
from emp
where job='MANAGER';

--2.부서명 확인
select
    ename, d.dname
from emp e, dept d
where
    e.deptno=d.deptno;

--3. 담당업무(job)가 MANAGER인 사원들의 부서명 확인    >> 동일부서 없음
select
    ename, job, d.dname
from emp e, dept d
where
    e.deptno=d.deptno
    and job='MANAGER';
