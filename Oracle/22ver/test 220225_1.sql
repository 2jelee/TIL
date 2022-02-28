/*
PL/SQL (Procedural Language) << Oracle 저장 프로시져
형식 :
    Declare -변수 선언[선택]
        begin 
            실행[필수]
        end;
Declare ?
    선언(선택)
as[is]
    being
    
    end;

trigger : 어떤 것을 하고 나서 바로 실행되는 것
*/

Begin
    DBMS_output.put_line('2jelee'); --출력
End;
--해당 결과 보이지 X (결과를 return하지 않음) -> 이를 확인하기 위해서는 [보기] > DBMS 출력 


declare name varchar2(20) := '2jelee';
    begin
        dbms_output.put_line('이름은 ' || name); --화면에 출력
    END;
    
--------------
declare e_name emp.ename%type;
        e_sal emp.sal%type;
    
BEGIN
    select sal, ename into e_sal, e_name from emp where empno='7788';
    dbms_output.put_line('7788님의 이름은 ' || e_name || ' 급여는 ' || e_sal);
END;  -- || 연결하겠다.

--------------

--테이블로부터 가져온 필드의 값을 변수에 저장하기 위해서 select 절에서 into 사용
DECLARE data emp%rowtype;
begin
    select * into data from emp where empno='7788';
    dbms_output.put_line(data.ename || ', ' || data.job || ', ' || data.mgr || ', ' || data.deptno);
END;

-------------------
declare
    num1 number:=3;
    num2 number:=5;
begin
    if num1>num2 then
        DBMS_OUTPUT.PUT_LINE(num1 || '이/가 큽니다');
    else DBMS_OUTPUT.PUT_LINE(num2 || '이/가 큽니다');
    end if;
END;


------------------- 
    declare
        v_salary number :=0;
        v_dept_id number :=0;
    BEGIN
        v_dept_id :=(dbms_random.value(10, 120), -1);
        select sal into v_salary from emp where deptno = v_dept_id and rownum=1;
        dbms_output.put_line(v_salary);
        
        if v_salary between 1 and 3000 then DBMS_OUTPUT.PUT_LINE('보수 적음');
        ELSIF v_salary between 3001 and 6000 then DBMS_OUTPUT.PUT_LINE('시세에 맞춰줌');
        ELSIF v_salary between 6001 and 9000 then DBMS_OUTPUT.PUT_LINE('보수 좋음');
        else
            DBMS_OUTPUT.PUT_LINE('완전 높음');
        end if;
    end;

----
create procedure p_test2
is
begin
    dbms_output.put_line('금요일');
end;
---------
execut p_test2; --프로시저 실행
exec p_test2;

--------
create or replace procedure p_test2(
    name in varchar2
)
is
begin
    dbms_output.put_line(name || '님 안녕하세요');
end;


/**************************/


--  PL/SQL (Procedural Language) -----------------------
/*형식>
Declare ? 선언(선택)
    Begin
         실행(필수)
    End;
*/

Begin
    DBMS_output.put_line('이도연'); --출력
End;
---------------------------------------------
DECLARE NAME VARCHAR2(20):='김연아';
    BEGIN
        DBMS_OUTPUT.PUT_LINE('이름은 ' || name); --화면에출력
    END;
-----------------------------------------------------
declare e_name emp.ename%type;
        e_sal emp.sal%type;
BEGIN
    select sal, ename into e_sal, e_name from emp where empno='7788';
    DBMS_OUTPUT.PUT_LINE('7788님의 이름은 ' || e_name ||' 급여는 ' || e_sal);
end;
-----------------------------------------------------
declare 
    num1 number :=3;
    num2 number :=5;
BEGIN
   if num1 >= num2 then 
         DBMS_OUTPUT.PUT_LINE(num1 || '이 큽니다');
    else   DBMS_OUTPUT.PUT_LINE(num2 || '이 큽니다');
   end if;
end;

-----------------------------------------------------
create PROCEDURE p_sal
is
        v_salary number :=0;
        v_dept_id number :=0;
    BEGIN
       v_dept_id := round(dbms_random.value(10, 120), -1);
       
       select sal into v_salary from emp where deptno = v_dept_id and rownum = 1;
       DBMS_OUTPUT.PUT_LINE(v_salary);
       
       if v_salary between 1 and 3000 then 
                        DBMS_OUTPUT.PUT_LINE('보수적음');
       ELSIF v_salary BETWEEN 3001 and 6000 then 
                        DBMS_OUTPUT.PUT_LINE('시세에 맞춰줌');
       ELSIF v_salary BETWEEN 6001 and 9000 then 
                        DBMS_OUTPUT.PUT_LINE('보수 좋음');
       else 
            DBMS_OUTPUT.PUT_LINE('완전 높음');
        end if;
    end;
-------------------------------------------------
create PROCEDURE p_test   -- 프로시저 생성 
is
begin
    DBMS_OUTPUT.PUT_LINE('주말 잘보내자요~~~');
end;
-----------------------------------------------------
EXECUT p_test;  -- 프로시저 실행
EXEC p_test;

------------------------------------
create or replace PROCEDURE p_test(      -- 프로시저 생성 
            name in VARCHAR2
) 
is
begin
    DBMS_OUTPUT.PUT_LINE(name || '님 완전 좋은 주말 보내세요~~~');
end;
---------------------------------------------
EXECUT p_test('강감찬');  -- 프로시저 실행
EXEC p_test; 