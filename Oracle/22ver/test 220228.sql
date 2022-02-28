/*
PL/SQL (Procedural Language)

[형식]
create [or replace] procedure 프로시져명 (
    변수이름 in 데이터타입, 변수이름 in 데이터타입, ...
)
is(또는 as)
    변수이름 데이터타입;     --프로시저 내에서 사용할 변수
Begin
    실행[필수]
End;

------------------------------
[실행 형식]
execute 프로시저명;
exec 프로시저명;

*/
--v의미 : virtual
Declare 
    --vno number(4);
    vno emp2.empno%type;
    vname varchar2(20);
Begin
    select empno, name into vno, vame
        from emp2
        where empno = &empno; -- &empno를 통해서 값을 입력받기 => &
        dbms_output.put_line('입력된 사번 : ' || vno || ' <---> ' || vname);
END;
/

select * from emp2;

-------------------------------------

--프로시저 생성
create or replace PROCEDURE p_test (
    name in varchar2,
    su in number
)
is
begin
    dbms_output.put_line(name || '님의 점수 :' || su );
End;
/

exec p_test('2jele', 95);

------------------------------------

select * from userlist;
drop table userlist; 

create table userlist(
    id varchar2(10),
    name varchar2(20),
    age number,
    addr varchar2(50)
);


--프로시저 생성
--Type -> 대소문자 구분 X
--초기값 넣을 때 := 사용
create or replace PROCEDURE p_userlist (
    --name in varchar2,
    v_id in userlist.id%Type := '2jelee',
    v_name in userlist.name%TYPE default 'eun',
    v_age in userlist.age%type := 10,         -- 없으면 10으로 하겠다.
    v_addr in userlist.addr%type := null
)
is
begin
    insert into userlist values (v_id, v_name, v_age, v_addr);
    dbms_output.put_line('insert된 정보는 :' || v_id || ' ' || v_name || ' ' || v_age || ' ' || v_addr );
End;
/

--전체필드에 추가
exec p_userlist('2jelee', 'eun', 26, '경기');
-- default value가 insert됨
exec p_userlist;                            
-- => 사용, 원하는 필드에만 값 추가. 단, 필드를 지정하지 않을 경우 default값 들어간다.
exec p_userlist(v_id=>'가가가', v_age=>30); 

select * from userlist;


------------------------------------

Declare
    su number := 90; --초기값 90
Begin
    dbms_output.put_line('Program started!');
    if(su >=90) then
        dbms_output.put_line('A');
    elsif(su>=80) then
        dbms_output.put_line(su||' B');
    end if;
    dbms_output.put_line('Program END');
End;
/

------------------------------------

--초기값 넣기 :=
Declare
    su number := 90;
    grade varchar2(2);
Begin 
    if(su >=90) then grade :='A';
    elsif(su>=80) then grade :='B';
    elsif(su>=70) then grade :='C';
    elsif(su>=60) then grade :='D';
    else grade:='F';
    end if; 
    DBMS_OUTPUT.PUT_LINE('당신의 : ' || su || '점은 ' || grade || '학점입니다');
End;
/

------------------------------------

/*
[형식]
for 변수이름 in 시작..끝 loop
    반복실행;
end loop;
/
*/

begin
    for i in 1..100 loop
        if mod(i, 2) = 0 then DBMS_OUTPUT.PUT_LINE(i || ' => even(짝수)');   --oracle은 같으면을 ==으로 표현하지 않고 = 하나로 표현
        else DBMS_OUTPUT.PUT_LINE(i || ' => odd(홀수)');
        end if;
    end loop;
end;
/

--------------------------

begin
    for su_list in ( 
        select 1 as num from dual
        union all
        select 2 as num from dual
        union all
        select 3 as num from dual
        union all
        select 4 as num from dual
    ) 
    loop
        if mod(su_list.num, 2) = 0 then
            DBMS_OUTPUT.PUT_LINE(su_list.num || ' => even(짝수)');
        else DBMS_OUTPUT.PUT_LINE(su_list.num || ' => odd(홀수)');
        end if;
    end loop;
end;
/

-----
/*
[형식]
while문
    WHILE 조건식 LOOP
    실행문장;
    증감식;
END LOOP;
*/

Declare
    su number := 0; --초기화
begin 
    while su < 50 loop
        su := su + 1; --증감식
        DBMS_OUTPUT.PUT_LINE('현재 값은 ' || su);
    end loop;
end;
/

----
--연습문제
/*
ex) 1~10 까지 출력

ex) 1~10사이의 짝수만 출력

ex) 2단의 구구단 출력

ex) 사용자 입력(단수)를 받아 구구단 출력
[힌트] 
DECLARE vdan NUMBER(1) := &dan; -- &는 사용자입력값 받을 때 사용하는 키워드

ex) 구구단을 2중 반복문

ex) 1~10까지 총 합계를 구하기(loop)
*/

--1~10 까지 출력  
Declare
    su number := 0; 
begin 
    while su < 10 loop
        su := su + 1; 
        DBMS_OUTPUT.PUT_LINE(su);
    end loop;
end;
/

--1~10사이의 짝수만 출력
begin
    for i in 1..100 loop
        if mod(i, 2) = 0 then DBMS_OUTPUT.PUT_LINE(i); 
        end if;
    end loop;
end;
/

--2단의 구구단 출력
Declare
    dan number := 2;
    su number := 1;
    result number := 0; --담아줄 변수
begin 
    while su <= 9 loop
        result := dan*su; 
        DBMS_OUTPUT.PUT_LINE(desult);
    end loop;
end;
/

--solv
declare
    dan number(1) := &inputDan;
begin
    for i in 1..9 loop
        dbms_output.put_line(dan || '*' || i || '=' || i*dan);
    end loop;
end;
/

--역순으로 출력 >> in 뒤에 REVERSE 사용하기
declare
    dan number(1) := &inputDan;
begin
    for i in REVERSE 1..9 loop --in뒤에 
        dbms_output.put_line(dan || '*' || i || '=' || i*dan);
    end loop;
end;
/


/*****************************************************************/

--프로시저 찾기
select * from user_objects
    where lower(object_type)='procedure';      --해당 계정이 가지고 있는 프로시저 리스트 보기

-- p_test 프로시저의 만들어진 내용(text) 보기     
select text from user_source
    where lower(name) = 'p_test';


-- re?
Declare
    v_emprow emp%rowtype;
begin
    for i in 1..5 loop
        select * into v_emprow 
            from (select * from emp (select * from emp order by sal desc)
                 where rownum <= i ) where rownum <= 5;
    end loop;
end;
/
 
----------------------------

select rownum, ename, sal from emp order by sal desc;

create or replace procedure p_empMaxSal
is
    v_emprow emp%rowtype;
    begin
        for i in 1..5 loop
            select * into v_emprow        
                from ( select * from ( select * from emp order by sal desc)
                         where rownum <= i order by sal, ename ) where rownum =1 order by sal asc;
                DBMS_output.put_line(v_emprow.empno || ' ' || v_emprow.ename|| ' ' || v_emprow.sal);
            end loop;
        end;
        /

exec p_empmaxsal;

desc emp;
insert into emp(empno, ename, sal) values(8888, '2jelee', 5500);

--학생 테이블에서 키가 제일 큰 순서로 3명 출력하는 프로시저 만들기

create or replace procedure p_stdMaxHeight
is
    v_stdrow student%rowtype;
    begin
        for i in 1..3 loop
            select * into v_stdrow
            from ( select *
                    from ( select * from student order by height desc)
                        where rownum <= i order by height, name) where rownum = 1; 
            dbms_output.put_line(v_stdrow.studno||' '||v_stdrow.name||' ' || v_stdrow.height);
        end loop;
    end;
/

exec p_stdMaxHeight;

select * from student;

/*************************************/
--프로시저 output
/*
프로시저를 실행한 후 특정 결과값을 out 변수에 저장하여 보낼 수 있다.

<out이 있는 프로시저 작성법>

CREATE PROCEDURE 프로시져명(
    변수이름 IN 테이터타입, 변수이름 IN 테이터타입, ...
    변수이름 out 테이터타입, 변수이름 out 테이터타입, ...
)
IS
[
    변수이름 데이터타입;         --프로시져 내에서 사용할 변수 선언
    변수이름 데이터타입;
    ....
]
BEGIN
    기능 구현;
END;
/
*/

--out : 내보내겠다.
create or replace procedure p_outTest (
    name out varchar2, age out varchar2
)
is
begin
    name := '이나영';
    age := 20;
    dbms_output.put_line('out을 이용한 프로시저 완료');
end;
/

----------------

variable v_name varchar2(20);
variable v_age varchar2(3);

EXEC p_outTest(:v_name, :v_age);
-- :(colone)이 들어간 것들은 프로시저로부터 받아온다는 의미다.

--실행시키기
print v_name;
print v_age;

print(v_name, v_age);


---------------------------
--in과 out 동시에 쓰기
create or replace procedure p_out(x in out number)
as
begin
    dbms_output.put_line('x = ' || x);
    x := 55;
end;
/

VARIABLE x VARCHAR2(25);
EXEC p_out(:x);
print x;

EXEC p_out(33);

VARIABLE y VARCHAR2(25);
EXEC p_out(:y);
print y;

/*
--teacher

create or replace procedure p_out( x in out number )
as
begin
    dbms_output.put_line( 'x = ' || x );
    x := 55;
end;

VARIABLE x VARCHAR2(25);
exec p_out(:x);
print x;
*/

---------------------------------
/*
Cursor
*/
select * from emp;

create or replace procedure p_emp_job(
    v_job in emp.job%type
)
is
    name emp.ename%type;
    cursor c_name is select empno, ename, sal from emp where job=v_job;     --커서 선언
begin
    open c_name;                            --2. 커서 열기(OPEN)
    dbms_output.put_line('-------------------');
    
    LOOP
        fetch c_name into name;             -- 3. 인출(꺼내오기) (FETCH) => 커서로부터 데이터 읽기
        EXIT WHEN c_name%notfound;          -- 찾을 데이터가 더이상 없을 때 반복문 탈출 (EXIT)
        dbms_output.put_line(name || ' ' || empno || ' ' || sal || ' ' || v_job);
    END LOOP;
    
    dbms_output.put_line('Result record count = '||c_name%rowcount); --rowcount : 레코드수 몇 개
    close c_name;       -- 4. cursor 닫기(CLOSE)
end;
/

exec p_emp_job('SALESMAN');

/*
--teacher

create or replace procedure p_emp_job( v_job in emp.job%type )
is
    name emp.ename%type;
    empno emp.empno%type;
    sal emp.sal%type;
--  cursor c_name is select empno, ename, sal from emp where job=upper(v_job) or job=lower(v_job);   -- 1.커서선언
    cursor c_name is select empno, ename, sal from emp where job in(upper(v_job), lower(v_job));   -- 1.커서선언
begin
    open c_name;   -- 2.커서열기
    dbms_output.put_line('------------------------------');
    loop
        fetch c_name into empno, name, sal;  -- 3.커서로부터 데이터 읽기
        exit when c_name%NOTFOUND; -- 찾을 데이터가 없으면 반복문 탈출한다.
        dbms_output.put_line(name ||' '||empno||' '||sal||' ' ||v_job);
    end loop;
    dbms_output.put_line('result recode count ==> ' || c_name%rowcount);
     
    close c_name;  -- 4.커서닫기
end;
--------------------------------------------------------------
exec p_emp_job('manager');  -- 레코드 대소문자 구분함
exec p_emp_job(upper('manager'));

select * from emp where job ='manager';
*/

/*********************************************/

EXEC p_emp_job('manager'); --레코드 대소문자 구분
exec p_emp_job(upper('manager'));

select * from emp where job = 'manager';

