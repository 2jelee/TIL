select * from student;

--ANY : 검색 결과와 하나 이상이 일치하면 true
--ALL : 검색 결과의 모든 값이 일치하면 true
select * from student where weight > any(70, 80);
select * from student where weight < any(60, 70);

select Deptno2, nvl(deptno2, 0) from student;

select * from professor;
select * from professor where deptno in(103, 203);
select * from professor where deptno=103 or deptno=203;
select * from professor where deptno not in(103,203);

select * from professor where position in('정교수', '조교수');
select * from professor where position in('^정교수', '조교수');
select * from professor where position not in('정교수', '조교수');

---------------------------------------------------------------------

select * from gift;

select sum(g_start), sum(g_end) from gift;
--title 다르게 해서 보기
select sum(g_start) "시작값 합계", sum(g_end) "상품최댓값의 총합" from gift;

select sum(g_start), avg(g_start), max(g_start), min(g_start) from gift;

select * from professor; --16행
--갯수 세기
select count(*) from gift;
select count(*) from professor; --count(*) : null 포함 갯수 세어준다.
select count(hpage) from professor; -- null을 제외한 hpage를 보여준다. => null 미포함

insert into gift(gname, g_end) values('물감', 3000);
desc gift;
select count(*) from gift;
select count(gname) from gift;

--rank(expr) whithin group(order by 컬럼명 asc | desc )
select RANK(600000) within group(order by g_end desc) from gift;

select g_start from gift;
--Oracle vs MySQL => Oracle은 null값이 우선순위 ↑ / MySQL은 null값이 우선순위 ↓
select RANK(900001) within group(order by g_start desc) from gift; --1위 : null 2위 : 900001
select RANK(900001) within group(order by g_start desc) 
    from gift
    WHERE g_start is not null; -- null 제외하면 1위 나온다.


--Q1.키가 168인 사람은 몇 번째로 큰가?
select * from student;
select RANK(168) within group(order by height desc)
    from student;
--Q2. 몸무게가 58인 사람은 몇 번째인지 등수 구하기
select RANK(58) within group(order by weight desc) from student;
--Q3.g_end 가 200000, 600000보다 작은 값 출력(any사용)
select * from gift;
select * from gift where g_end < any(200000, 600000);
--Q4. 학생들의 키의 합과 평균, 가장 키가 큰 친구, 작은 친구 출력
select * from student;
select sum(height), avg(height), MAX(height), MIN(height) from student;


--집계함수 사용 시 GROUP BY : 소계(부분합)
select * from student;
--그룹(집합)함수는 일반 필드와 같이 쓸 수 X
select grade, sum(height), avg(height), max(height), min(weight)
    from student
    group by grade;
    
-- emp2 테이블에서 emp_type 별로 pay 합, 평균, 최고 급여, 최하 급여 구하기
select * from emp2;
select emp_type, sum(pay), avg(pay), max(pay), min(pay) from emp2 GROUP BY emp_type;

--(where절이 아닌) 조건 넣기 -> having 절 이용      => having절은 단독으로 쓸 수 없고 GROUP BY와 함께 사용한다. => 즉, 조건에 맞는 것을 뽑아내겠다.
--1.
select grade, sum(height), avg(height), max(height), min(weight)
    from student
    group by grade; 
--2. 전체 평균키 구하기
select avg(height) from student; -- 출력 : 172.1 => 약 173으로 간주

select grade, sum(height), avg(height), max(height), min(weight)
    from student
    group by grade; 

--emp2 테이블 이용
/*
1. 부서 deptno 별로 pay 합과 평균 구하기
2. 부서 emp_type 별로 pay 합과 평균 구하기
3. 직급별(position)별로 급여 합, 평균 구해서 급여의 전체 평균보다 많이 받는 사람 구하기
4. 직급별로 급여 합, 평균을 구하는데 직급이 과장인 사람들만 출력
*/
select * from emp2;

--1.
select deptno, sum(pay), avg(pay) from emp2 group by deptno;

--2.
select emp_type, sum(pay), avg(pay) from emp2 group by emp_type;

--3.
select avg(pay) from emp2;
select position, sum(pay), avg(pay) 
    from emp2 
    /*
    group by position
    where pay>any(43100000);  
    */
    where pay > (select avg(pay) from emp2)
    group by position;
    
--3번 문제 변환
select position, sum(pay), round(12.3456, 2), round(avg(nvl(pay, 0)), 2) 
    from emp2 
    where position is not null
    group by position
    having position = '과장';


--4.
select position, sum(pay), avg(pay) 
    from emp2 
    group by position 
    having position='과장';

-------------------------------숫자함수-------------------------------
--가상테이블 dual
-- round(숫자, 자릿수) => 반올림
-- ceil(숫자) => 올림한 후 정수반환
-- floor(숫자)=>내림한 후 정수 반환
-- mod(숫자, 나눌 수) => 나머지
-- trunc(숫자, 자릿수) => 버림
select round(12.356789, 0), round(12.3456789, 2), round(12.56789, 0) from dual;

--무조건 올림
select ceil(12.34), ceil(-12.34) from dual;
--무조건 내림
select floor(12.34), floor(-12.34) from dual;
--반올림 안되고 버림
select trunc(12.3456, 2), trunc(12.3756, 2), trunc(12.7456, 0) from dual;


/* 2장 73 ~ */


select * from professor;
--1. 교수 테이블에서 월급에 인상률 2%한 결과를 출력(소숫점 0으로 처리)
select pay from professor;
select pay*1.02 from professor;

--teacher
update professor set pay=(pay*0.2);
rollback;

--2. 교수 테이블에서 모든 교수에게 보너스 1000원씩 추가 지급하기 (null 처리할 것)
select bonus, nvl(bonus,0)+1000 from professor;

----------------문자열 함수----------------
--upper
select UPPER(ID) from professor;
--initcap
select initcap(ID) from professor;

select length(id), length('abcd') from professor;

--숫자를 통해 성별 판별하기
select substr(jumin, 7, 1) from gogak; --고객테이블
select instr('abcd', 'b') from dual; --java(뿐만 아니라 다른 프로그래밍 언어도 마찬가지)와 다르게 index number의 start Number는 1부터!
--DB는 index 번호 1부터 시작한다.

select id, instr(id, 'b') from professor;
-- '-1'을 넣으면 앞에서부터가 아니라 '뒤'에서부터 찾는다
--음수값을 넣으면 뒤에서 부터 찾는다.
select instr('abcdefg', 'b', -1) from dual;
select instr('abcdefg', 'b', -3) from dual;

--왼쪽에서부터 지정한 문자로 채워준다.
select lpad('abcd', 20, '#') from dual;
--오른쪽에서
select rpad('abcd', 20, '@') from dual;

--한글 또한 한 글자(1바이트)로 취급한다.
select length('사장실') from dual;
/*
LENGTHB(char) 함수 : 문자열의 길이를 byte 단위로 구하는 함수 
*/ 
select length('사장실'), lengthb('사장실') from dual;

select * from dept2;
select dname, length(dname), lengthb(dname) from dept2;
--(지정을 따로 하지 않으면)3번째부터 다 가져오는 => substr(dname, 3)
select dname, substr(dname, 3) from dept2;
--2번째 글자부터 세 글자 가져와라
select dname, substr(dname, 2, 3) from dept2;

-- length(dname)+1 : dname의 다음 글자부터
select rpad(dname, 10, substr('1234567890', length(dname)+1)) "RPAD연습" from dept2;


/* 2장 p8 ~ */
select * from student;
--1. Student 테이블에서 1 전공이 201 번인 학생들의 ID 를 이름과 함께 소문자, 대문자로 출력하세요.
select name, lower(id), upper(id) from student where deptno1=201;

--2. Student 테이블에서 ID 가 9글자 이상인 학생들의 이름과 ID와 글자수를 출력하세요.
select name, length(id) from student where length(id) >= 9;

--3. Student 테이블에서 1 전공이 201 번인 학생들의 이름과 이름의 글자수, 이름의 바이트 수를 출력하세요
select name, length(name), lengthb(name) from student where deptno1=201;

--4. Professor 테이블에서 교수들의 이름과 직급을 출력하세요.
select name, position from professor;

--5. Student 테이블에서 jumin 컬럼을 사용해서 1 전공이 101번인 학생들의  이름과 생년월일을 출력하세요.
select * from student;
select name, substr(jumin,1, 6) from student where deptno1=101;

--6. Student 테이블에서 jumin 컬럼을 사용해서 태어난 달이 8월인 사람의 이름과 생년월일을 출력하세요.
select name, substr(jumin, 1, 6) from student where substr(jumin, 3, 2)=08;
--select name, substr(jumin,3,2) from student;

--7. Student 테이블의 tel 컬럼을 사용하여 학생의 이름과 전화번호, ‘)‘ 가 나오는 위치를 출력하세요.
select name, tel, instr(tel, ')') from student;

--8. Student 테이블을 참조해서 아래 화면과 같이 1 전공이(deptno1 컬럼) 101번인 학생의 이름과 전화번호와 지역번호를 출력하세요.
--단 지역번호는 숫자만 나와야 합니다. 
select name, tel, substr(tel,1,instr(tel, ')')) from student where deptno1=101;

--9. Student 테이블에서 1 전공이 101 번인 학과 학생들의 id를 총 10자리로 출력하되 왼쪽 빈 자리는 ‘$’ 기호로 채우세요.
select lpad(id, 10, '$') from student where deptno1=101;

/*
문자함수 퀴즈 2)
Dept2 테이블을 사용하여 dname을 오른쪽의 결과가 
나오도록 쿼리를 작성하세요.
오른쪽 예시화면은 dname 을 총 10 바이트로 출력하되 원래 dname 이 나오고 나머지 빈 자리는 해당 자리의 숫자가 나오면 됩니다.
즉, 사장실은 이름이 총 6 바이트이므로 숫자가 1234 까지 나오는 것입니다.
*/
select * from dept2;
select lengthb(dname) from dept2;
--?????????
select lpad(dname, 6, 1234) "LPAD 연습" from dept2; 

select dname,length(dname), lengthb(dname) from dept2;

/* substrb 사용? */
select dname,substr(dname, 10), substrb(dname, 10, 10) from dept2;


--11. Student 테이블에서 아래와 같이 id 를 12자리로 출력하되, 오른쪽 빈자리에는 ‘*’ 로 채우세요.
select rpad(id, 12, '*') from student;

--12. Dept2 테이블을 사용하여 dname 을 오른쪽의 결과가 나오도록 쿼리를 작성하세요.
--?????????????????
select rpad(dname, 6, 7890) from dept2;

