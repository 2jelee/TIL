/***************************
파일명: Or09Join.sql
테이블 조인
설명 : 두 개 이상의 테이블을 동시에 참조하여 데이터를 가져와야할 때
        사용하는 SQL문
****************************/

/*
1] inner join(내부조인)
- 가장 많이 사용되는 조인문으로 테이블 간에 연결조건을 모두 만족하는 행을 검색할 때 사용됨
- 일반적으로 기본키(primary key)와 외래키(foreign key)를 사용하여 join하는 경우가 대부분.
- 두 개의 테이블에 '동일'한 이름의 컬럼이 존재하면 "테이블명.컬럼명" 형태로 기술해야함.
- 테이블의 별칭을 사용한다면 "별칭명.컬럼명" 형태로도 쓸 수 있음.

형식1(ANSI 표준방식)
    select 
        컬럼1, 컬럼2, ...
    from 테이블1 inner join 테이블2
        on 테이블1.기본키컬럼=테이블2.외래키컬럼
    where
        조건1 and 조건2 ... ;
*/


/*
시나리오] 사원테이블과 부서테이블을 조인하여 각 직원이 어떤 부서에서 근무하는지 출력하시오.
            단, 표준방식으로 작성하시오.
            출력결과 : 사원아이디, 이름1, 이름2, 이메일, 부서번호, 부서명
*/
select
    employee_id, first_name, last_name, email,
    department_id, department_name
from employees inner join departments
    on employees.department_id=departments.department_id;  /*
    에러발생. 양쪽 테이블 모두에 존재하는 department_id 컬럼이 있으므로
    column ambiguously defined 에러가 발생함
    이때는 어떤 테이블에서 가져올지 명시해야 한다.*/
    
--as(별칭) 없이 작성하여 쿼리문이 길어짐. 테이블명을 그대로 사용함.
select
    employee_id, first_name, last_name, email,
    employees.department_id, department_name
from employees inner join departments
    on employees.department_id=departments.department_id;
    
--as(별칭)을 추가하여 작성 >> 쿼리문이 간결해짐
select
    employee_id, first_name, last_name, email,
    emp.department_id, department_name
from employees emp inner join departments dep
    on emp.department_id=dep.department_id;    
    
    
/*
3개 이상의 테이블 조인

시나리오] seattle(시애틀)에 위치한 부서에서 근무하는 직원의 정보를 출력하는 쿼리문을 작성하시오.
              단, 표준방식으로 작성.
              출력결과] 사원이름, 이메일, 부서아이디, 부서명, 담당업무 아이디, 담당업무명, 근무지역
*/
select
    first_name, last_name, email, E.department_id, department_name,
    E.job_id, job_title, city, state_province
from locations L
    inner join departments D on L.location_id = D.location_id
    inner join employees E on E.department_id=D.department_id
    inner join jobs J on E.job_id=J.job_id
where lower(city)='seattle';

/*
형식1] 오라클 방식
    select
        컬럼1, 컬럼2, ... 컬럼n
    from
        테이블명1, 테이블명2
    where
        테이블명1.기본키컬럼=테이블명2.참조키컬럼
        and 조건1 and 조건2;
*/
/*
시나리오] 사원테이블과 부서테이블을 조인하여 각 직원이 어떤 부서에서 근무하는지 출력하시오.
                단, 오라클방식으로 작성하시오.
                출력결과 : 사원아이디, 이름1, 이름2, 이메일, 부서번호, 부서명
*/
select
    employee_id, first_name, last_name, email, dep.department_id, department_name
from employees emp, departments dep
where emp.department_id=dep.department_id;

/*
시나리오] seattle(시애틀)에 위치한 부서에서 근무하는 직원의 정보를 출력하는 쿼리문을 작성하시오.
              단, 오라클 방식으로 작성하시오.
              출력결과] 사원이름, 이메일, 부서아이디, 부서명, 담당업무아이디, 담당업무명, 근무지역
*/
select
    first_name, last_name, email,  D.department_id, department_name, j.job_id, job_title
from locations L, departments D, employees E, jobs J
where
    L.location_id=D.location_id
    and D.department_id=e.department_id
    and E.job_id=J.job_id
    and city='Seattle';
 
 
  
/*
2] 외부조인(outer join)
    outer join은 inner join과는 다른 두 테이블에 조인조건이 정확히 일치하지 않아도
    기준이 되는 테이블에서 결과값을 가져오는 join문이다.
    outer join을 사용할 때는 반드시 outer 전에 데이터를 어떤 테이블을 기준으로
    가져올지를 기술해야 한다.
        -> left(왼쪽테이블), right(오른쪽 테이블), full(양쪽 테이블)

형식1(표준방식)
    select 컬럼1, 컬럼2 ...
    from 테이블 1
        left[right, full] outer join 테이블2
            on 테이블1.기본키=테이블2.참조키
        where 조건1 and 조건2 or 조건3;
*/

/*
시나리오] 전체 직원의 사원번호, 이름, 부서아이디, 부서명, 지역을
            외부조인(left)을 통해 출력하시오.
*/
select
    employee_id, first_name, last_name, E.department_id,
    department_name, D.location_id, city, state_province
from employees E 
    left outer join departments D
        on E.department_id=D.department_id
    left outer join locations L
        on D.location_id=L.location_id;
        
    
/*
시나리오] 전체 직원의 사원번호, 이름, 부서아이디, 부서명, 지역을
            외부조인(right)을 통해 출력하시오.
*/
select
    employee_id, first_name, last_name, E.department_id,
    department_name, D.location_id, city, state_province
from employees E 
    right outer join departments D
        on E.department_id=D.department_id
    right outer join locations L
        on D.location_id=L.location_id;
--left 혹은 right와 같이 기준이 되는 테이블이 달라지면 인출되는 결과도 달라진다.

/*
형식2(오라클방식)
    select
        컬럼1, 컬럼2 .... 컬럼N
    from
        테이블1, 테이블2
    where
        테이블1.기본키 = 테이블2.외래키(+)
        and 조건1 or 조건2 ... 조건 n;
    => 오라클 방식으로 변경 시에는 outer join연산자인 (+)를 where에 붙여준다.
    => 위의 경우, 왼쪽 테이블이 기준이 된다.
*/
/*
시나리오] 전체 직원의 사원번호, 이름, 부서아이디, 부서명, 지역을 외부조인(left)을 통해 출력하시오.
                단, 오라클방식으로 작성하시오.
*/
select
    employee_id, first_name, last_name, Emp.department_id, department_name,
    Loc.location_id, city, state_province
from employees  Emp, departments Dep, locations Loc
where 
    Emp.department_id=Dep.department_id(+)
    and Dep.location_id = Loc.location_id(+) ;
   
    
/*
3] self join(셀프 조인)
    셀프조인은 하나의 테이블에 있는 컬럼끼리 연결해야 하는 경우에 사용.
    즉, 자기자신의 테이블과 조인을 맺는 것이다.
    셀프조인에서는 "별칭"이 테이블을 구분하는 구분자 역할을 하므로 굉장히 중요함!
    
    형식]
        select
            별칭1.컬럼, 별칭2.컬럼 ...
        from
            테이블 별칭1, 테이블 별칭2
        where
            별칭1.컬럼=별칭2.컬럼 ;
*/

/*
시나리오] 사원테이블에서 각 사원의 매니져아이디와 매니져이름을 출력하시오.
                단, 이름은 first_name과 last_name을 하나로 연결해서 출력하시오.
                
            절차] 1. 하나의 테이블을 각각 사원정보 테이블, 매니져 정보테이블로 나눈다.
                    2. 사원의 매니져아이디와 매니져의 사원아이디를 join한다.
                    3. 각각의 테이블 별칭을 이용해서 필요한 정보를 select 한다.
*/
select
    empClerk.employee_id "사원번호",
    (empClerk.first_name||' '||empClerk.last_name) "사원이름",
    empManager.employee_id "매니져아이디",
    concat(empManager.first_name||' ', empManager.last_name) "매니져이름"
from 
    employees empClerk, employees empManager
where
    empClerk.manager_id=empManager.employee_id;        --셀프조인 끝
    

/*
시나리오] self join을 사용하여 "Kimberely / Grant" 사원보다 입사일이 늦은 사원의
            이름과 입사일을 출력하시오.
            출력목록 : first_name, last_name, hire_date
*/
--1. Kimberely의 정보 확인
select * from employees
    where first_name='Kimberely'
             and last_name='Grant';
--2. 07/05/24 이후에 입사한 직원들을 인출
select * from employees
    where hire_date > '07/05/24';
    
--3. self join으로 위 쿼리문들을 합침
select
    Clerk.first_name, Clerk.last_name, Clerk.hire_date
from
    employees Kimberely, employees Clerk
where
    on Kimberely.hire_date<Clerk.hire_date        --join의 조건 걸은 것_2번의 조건
    and Kimberely.first_name='Kimberely' and Kimberely.last_name='Grant';       --REEEE


/*
using : join문에서 주로 사용하는 on절을 대체할 수 있는 문장
    형식 ] on 테이블1.컬럼 = 테이블2.컬럼
        ==> using (컬럼)
*/
/*
시나리오] seattle(시애틀)에 위치한 부서에서 근무하는 직원의 정보를 출력하는 쿼리문을 작성.
단,  표준방식과 using을 사용해서 작성하라.
    출력결과] 사원이름, 이메일, 부서아이디, 부서명, 담당업무 아이디, 담당업무명, 근무지역
*/
select
    first_name, last_name, email, department_id, department_name,
    job_id, job_title, city
from locations
    inner join departments using(location_id)
    inner join employees using(department_id)
    inner join jobs using(job_id)
where lower(city)='seattle'; /*
        using절에 사용된 식별자 컬럼의 경우,
        select절에서 테이블의 별칭을 붙이면 오류가 발생함.
        using절에 사용된 컬럼명은 좌, 우측의 테이블에 동시에 존재하는 컬럼이라는 것을
        전재로 작성되므로 굳이 별칭을 붙여줄 이유가 없다.
    */

/*
 퀴즈] 2005년에 입사한 사원들중 California(STATE_PROVINCE) / 
 South San Francisco(CITY)에서 근무하는 사원들의 정보를 출력하시오.
 단, 표준방식과 using을 사용해서 작성하시오.
 
 출력결과] 사원번호, 이름, 성, 급여, 부서명, 국가코드, 국가명(COUNTRY_NAME)
        급여는 세자리마다 컴마를 표시한다. 
 참고] '국가명'은 countries 테이블에 입력되어있다. 
*/
select
    employee_id,
    first_name, last_name,
    to_char((salary),'999,000'),
    department_name,
    country_id,
    country_name
from locations
    inner join departments using(location_id)      --department를 거쳐 employees 묶
    inner join employees using(department_id)
    inner join countries using(country_id)
where 
    to_char(hire_date, 'yyyy')='2005'
    or substr(hire_date, 1, 2)='05'
    or hire_date like '05%')
    and city='South San Francisco' and state_province='California' ;        --REEEE
/*
    -날짜 형식도 문자와 마찬가지로 자르거나 like를 통해 검색이 가능.
    -함수는 select절 뿐만 아니라 where절에도 사용할 수 있다.
*/

/*******************************************************
연습문제
********************************************************/
--1.
select
    E.department_id, department_name
from employees E, departments D
where
    E.department_id=D.department_id
            and first_name='Janette';

--2.
select
    first_name, last_name,
    department_name, city
from employees E
        inner join departments D
            on E.department_id = D.department_id
        inner join location L
            on D.location_id = L.location_id;

--3.


--4.
/*
4. 내부조인을 사용하여 커미션(COMMISSION_PCT)을 받는 모든 
사원의 이름, 부서명, 도시명을 출력하시오. 
출력목록] 사원이름, 부서ID, 부서명, 도시명
*/
select
    first_name, last_name, D.department_id, department_name, city
from employees E
    inner join departments D
        on E.department_id = D. department_id
    inner join locations L
        on L.location_id=D.location_id
where commission_pct is not null;


--5.
/*
5. 사원의 이름(FIRST_NAME)에 'A'가 포함된 모든사원의 이름과 부서명을 출력하시오.
출력목록] 사원이름, 부서명
*/
select
    first_name, last_name, department_name
from employees E, departments D
where E.department_id = D.department_id
    and first_name like '%A%';      --A% : A로 시작하는 |  %A : A로 끝나는

--6.
/*
6. “city : Toronto / state_province : Ontario” 에서 근무하는 모든 사원의 이름, 업무명, 부서번호 및 부서명을 출력하시오.
출력목록] 사원이름, 업무명, 부서ID, 부서명
*/
select
    first_name, job_title, D.department_id, department_name
from locations L
    inner join departments D on L.location_id = D.location_id
    inner join employees E on D.departmnet_id = E.department_id
    inner join jobs J on E.job_id = J.job_id
where city = 'Toronto' and state_province= 'Ontario';                   ---REEE




