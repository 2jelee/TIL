/**************************************
파일명 : Or06GroupBy.sql
그룹함수(select문 2번째)
설명 : 전체 레코드(로우)통계적인 결과를 구하기 위해 하나 이상의 레코드를
        그룹으로 묶어서 연산 후 결과를 반환하는 함수 혹은 쿼리문
**************************************/

/*
distinct   
    - 중복되는 레코드를 제거한 후 하나의 레코드만 가져와서 보여줌.
    - 따라서 통계적인 데이터를 계산할 수 없다.
*/
select distinct job_id from employees;
/*
group by
    - 동일한 값이 있는 레코드를 하나의 그룹으로 묶어서 가져온다.
    - 보여지는 결과는 하나의 레코드이지만
        여러개의 레코드가 묶여진 결과이므로 통계적인 데이터를 계산할 수 있다.
    - 최대, 최소, 평균, 합산 등이 가능
*/
select job_id from employees group by job_id;


/*
그룹함수의 기본형식
    : [] 대괄호 부분은 생략 가능
    
    select
        컬럼1, 컬럼2, ... 혹은 *(전체)
    from 
        테이블명
    [where
        조건 1 or 조건 2 and 조건 3......]
    [group by
        데이터 그룹화를 위한 컬럼명]
    [having
        그룹에서 찾을 조건]                     --where의 조건과는 차이가 있다!... 추후에
    [order by
        레코드 정렬을 위한 컬럼과 정렬방식(asc/desc)]
        
    ※쿼리의 실행 순서
        from -> where -> group by -> having -> select -> order by
*/

/*
sum() : 합계를 구할 때 사용하는 함수
    형식]  sum(컬럼)
    - number 타입의 컬럼에서만 사용 가능
    - 필드명이 필요한 경우 AS를 이용해서 별칭 부여 가능
*/
-- 전체 직원의 급여의 합계를 출력하시오.
select
    sum(salary) "급여의 합계1",
    to_char(sum(salary), '000,000') "급여의합계2"
from employees;

--10번 부서에서 근무하는 사원들의 급여합계는 얼마인지 출력하시오.
select
    sum(salary) "급여1",
    to_char(sum(salary), '999,999') "급여2",    
    to_char(sum(salary), '000,999') "급여3",
    ltrim(to_char(sum(salary), '9,999,999')) "급여4"
from employees
where department_id=10;

--sum()과 같은 그룹함수는 number타입의 컬럼에서만 사용 가능.
select sum(first_name) from employees;      --error


/*
 count() : 레코드의 갯수를 카운트할 때 사용하는 함수
*/
--사원 테이블에 저장된 전체 사원 수는 몇명?
select count(*) from employees;
select count(employee_id) from employees;
/*
    count()함수를 사용할 때는 위 2가지 방법 모두 가능하나,
    *를 사용할 것을 권장!
    컬럼의 특성을 타지 않아 검색속도가 빠름
*/

/*
    count()함수의
                    사용법 1 : count(all 컬럼명)
                            => default로 컬럼 전체의 레코드를 기준으로 카운트한다.
                    사용법 2 : count(distinct 컬럼명)
                            => 중복을 제거한 상태에서 카운트한다.
*/
select
    count(all job_id) "담당업무 전체 갯수",
    count(distinct job_id) "순수 담당업무 갯수"
from employees;


/*
avg() : 평균값을 구할 때 사용하는 함수
*/
--전체 사원의 평균급여는 얼마인지를 출력하는 쿼리문을 작성하시오.
select
    count(*) "사원수",
    sum(salary) "급여의합계",
    sum(salary)/count(*) "평균급여1",
    avg(salary) "평균급여2",
    to_char(avg(salary), '$999,000') "평균급여3"
from employees
where 1=1;
-- 명시적 의미) 1=1 같다 >> 전체 다 가져오겠다. | 1=0 다르다 >> 하나도 가져오지 않겠다.


--영업팀의 평균 급여는 얼마인가?
--1. 부서테이블에서 영업팀의 부서번호를 확인한다.
select * from departments where department_name='Sales';
select * from departments where lower(department_name)='sales';
select * from departments where upper(department_name)='SALES';
/*
    정보 검색 시 대소문자 혹은 공백이 포함된 경우,
    모든 레코드에 대해 문자열을 확인하는 것은 불가능하므로 일괄적인 규칙을 적용하기 위해
    upper()와 같은 변환함수를 사용하여 검색하면 편리함.
*/

--2. 위에서 찾은 80번 부서에서 근무하는 직원의 평균 급여를 구한다.
select
    avg(salary) "영업팀 평균 급여1",
    to_char(avg(salary), '$999,000.00') "영업팀 평균 급여2"
from employees where department_id=80;      /*
    to_char()를 통해 세 자리마다 컴마와 통화 표시.
    그리고 소숫점 이하 2자리까지 서식으로 표현.
*/


/*
min() / max() : 최소 / 최대값을 찾을 때 사용하는 함수
*/
-- 사원중 가장 낮은 급여를 받는 사람은 누구?
select min(salary) from employees;      --1. 사원테이블에서 가장 낮은 급여는 얼마?
select first_name, last_name from employees
    where salary=2100;                            --2. 앞에서 구한 2100을 받는 사원을 select 해서 결과 출력
/*
    사원 중 가장 낮은 급여는 min()으로 구할 수 있으나,
    가장 낮은 급여를 받는 사람은 위와 같이 2번의 쿼리를 사용하거나
    서브쿼리를 사용하여 구할 수 있다.
*/
select first_name, last_name from employees
    where salary=(select min(salary) from employees);
    
/*
group by절 : 여러개의 레코드를 하나의 그룹으로 그룹화하여 묶여진 결과를 반환하는 쿼리문
                    ※ distinct는 단순히 중복값을 제거함.
*/
--사원테이블에서 레코드를 부서별로 그룹화하여 확인하기
select department_id from employees
group by department_id;

--각 부서별 급여의 합계는 얼마?
select 
    department_id,
    sum(salary) "부서별 급여 총합1",
    to_char(sum(salary), '999,000') "부서별 급여 총합2"
from employees
group by department_id;

/*
시나리오]
        퀴즈] 부서별 사원수와 평균급여는 얼마?
        출력결과] 부서번호, 급여총합, 사원총합, 평균급여, 부서번호 순서대로 오름차순 정렬하시오.
*/
 select
    department_id "부서번호",
    sum(salary) "급여총합",
    count(*) "사원총합",
   to_char(avg(salary), '$999,000.00') "평균급여"
from employees
group by department_id
order by department_id asc;


 select
    department_id "부서번호",
    first_name                                  /*컴퓨터) 무엇을 선택해야할지 애매.. error 발생*/
from employees
group by department_id;     --error발생
/*
위에서 사용했던 group by절에 first_name만 추가했으나 에러가 발생함.
select절은 group by절에 사용한 컬럼만 from절에서 사용할 수 있으므로
그룹화된 상태에서 특정 레코드 하나만 선택하는 것이 애매. >>error
*/


/*
부서별 급여의 합계는 distinct를 사용해서 SQL문을 작성할 수 없다.
*/
select distinct department_id, sum(salary) from employees;      --error

/*
시나리오] 부서 아이디가 50인 사원들의 직원 총합,  평균급여, 급여총합이 얼마인지
표현하는 쿼리문을 작성.
*/
select
count (*) "직원수",
trim(to_char(avg(salary), '999,000.00')) "평균급여",
trim(to_char(sum(salary), '999,000')) "급여총합"
from employees
where department_id = 50
group by department_id;


/*
having절 : 물리적으로 존재하는 컬럼이 아닌 그룹함수를 통해
    논리적으로 생성된 컬럼의 조건을 추가할 때 사용한다.
    해당 조건을 where절에 추가하면 에러가 발생한다.
*/
/*
시나리오] 사원테이블에서 각 부서별로 근무하고 있는 직원의 담당업무별
사원수와 평균급여가 얼마인지를 출력하는 쿼리문을 작성하시오.
단, 사원의 총합이 10명을 초과하는 레코드만 추출하시오.
*/
select
    department_id "부서번호", job_id "담당업무ID", count (*) "사원수",
    avg(salary)
from employees
group by department_id, job_id
having count(*)>10
order by department_id asc;

/*
count(*)와 같이 그룹과 관련된 조건은 where절에 사용할 수 없다.
*/
select
    department_id "부서번호", job_id "담당업무ID", count (*) "사원수",
    avg(salary)
from employees
where count(*)>10
group by department_id, job_id
order by department_id asc;





/*****************************
연습문제
*****************************/
--1
select
    min(salary) "MinPay",
    max(salary) "MaxPay",
    round(avg(salary),0) "AvgPay"
from employees;

--------------------------------------
--2
select job_id,
    trim(to_char(max(salary), '990,000')) "MaxPay",
    trim(to_char(min(salary), '990,000')) "MinPay",
    trim(to_char(sum(salary), '990,000')) "SumPay",
    trim(to_char(avg(salary), '990,000')) "AvgPay"
from employees
group by job_id
order by  to_char(sum(salary), '999,000') asc;

--------------------------------------
--3
select
    job_id,
    count (*) "직원합계"
from employees
group by job_id
--order by count(*) asc;        --정렬방법1
order by "직원합계" asc;        --정렬방법2
/*
물리적으로 존재하지 않는 컬럼의 경우,
order by절에 사용할 때는 원형을 그대로 쓰거나 별칭을 사용하면 됨
*/

-------------------------------------
--4
select job_id,
    count(*) "합계인원수"
from employees
    where salary>=10000     --급여는 물리적으로 존재하는 컬럼이므로 where절에 조건을 건다.
group by job_id;

------------------------------------
--5.
select
    max(salary)-min(salary) "최고최소급여차"
from employees;
------------------------------------
--6 ★
select job_id,
    min(salary) "직급별최소급여" 
from employees
    where manager_id is not null
group by job_id
having min(salary)>3000
order by min(salary) desc;
/*
    관리자를 알 수 없는  => 물리적으로 존재하는 컬럼이므로 where에
★최저급여가 3000미만인 => 물리적으로 존재하지 않는 그룹함수에 의해
                                        논리적으로 추가된 컬럼이므로 having에 기술
*/
------------------------------------
--7
select
    department_id,
    count(*),
    round(avg(salary),2) "평균급여"
from employees
group by department_id
order by department_id asc;
------------------------------------
--8 ★★★
/*
8. 각 부서에 대해 부서번호, 부서이름, 지역명, 사원수,
부서 내의 모든 사원의 평균급여를 출력하시오.
평균급여는 정수로 반올림하고 세자리마다 컴마를 출력하시오.
decode함수를 사용하여 각 부서번호에 맞는 부서명과 지역명을 나오게 하시오. (수정 추가)
*/
select 
    department_id,
    decode(department_id,
            10 , 'Administration',
            20,	'Marketing',
            30,	'Purchasing',
            40,	'Human Resources',
            50,	'Shipping',
            60,	'IT',
            70, 'Public Relations',
            80, 'Sales',
            90, 'Executive',
            100, 'Finance',
            '그냥부서') AS 부서이름,
   decode(department_id,
            10, 'Seattle',
            20, 'Toronto',
            30, 'Seattle',
            40, 'London',
            50,
    count(department_id) "사원수",
    to_char(avg(salary),'999,000') "평균급여"
from employees
group by department_id
order by department_id asc;