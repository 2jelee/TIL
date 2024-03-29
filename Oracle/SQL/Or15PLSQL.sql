/************
파일명 : Or15PLSQL.sql
PL/SQL
설명 : 오라클에서 제공하는 프로그래밍 언어
*************/

/*
PL/SQL(Procedural Language)
    : 일반 프로그래밍 언어에서 가지고 있는 요소를 모두 가지고 있으며 DB업무를
    처리하기 위해 최적화된 언어이다
*/
--HR계정에서 실습합니다. 

--화면상에 내용을 출력하고 싶을때 on으로 설정한다. off일때는 출력되지 않는다.
set serveroutput on;
declare --선언부 : 변수를 주로 선언한다. 
    cnt number; --숫자타입의 변수를 선언함.
begin --실행부 : begin~end절 사이에 실행을 위한 로직을 기술한다. 
    cnt := 10; --변수cnt에 10을 할당한다. 이때 대입연산자는 := 을 사용한다. 
    cnt := cnt + 1;
    dbms_output.put_line(cnt);--java에서 println()과 동일하다.
end;
/
/*
    PL/SQL '문장의 끝에는 반드시 /'를 붙여야 하는데, 만약 
    없으면 호스트환경으로 빠져나오지 못한다. 즉 PL/SQL문장을 
    탈출하기위해 필요하다. 
*/


/*
시나리오] 사원테이블에서 사원번호가 120인 사원의 이름과 연락처를 출력하는
    PL/SQL문을 작성하시오.
*/
select concat(first_name||' ', last_name), phone_number 
    from employees 
    where employee_id=120;

declare
    /*
    선언부에서 변수를 지정할때 테이블 생성시와 동일하게
    선언하면된다. 단 first_name과 last_name이 합쳐진 형태이므로
    조금더 넉넉한 크기로 설정하는것이 좋다. 
    */
    empName varchar2(50);
    empPhone varchar2(30);
begin
    /*
    실행부 : select절에서 가져온 결과를 선언부에서 선언한 변수에 1:1로 대입하여 값을 저장한다.
        이때 into를 사용한다. 
    */
    select concat(first_name||' ', last_name), phone_number 
        into empName, empPhone
    from employees 
    where employee_id=120;
    
    dbms_output.put_line(empName||' '||empPhone);
end;
/


/*
시나리오] 부서번호 10인 사원의 사원번호, 급여, 부서번호를 가져와서 
    아래 변수에 대입후 화면상에 출력하는 PL/SQL문을 작성하시오. 
    단, 변수는 기존테이블의 자료형을 참조하는 '참조변수'로 선언하시오.
    
    참조변수 : 특정 테이블의 특정 컬럼을 참조하는 변수로써 
        동일한 자료형과 크기로 선언하고 싶을때 사용한다. 
        형식] 테이블명.컬럼명%type
            => 테이블의 '하나'의 컬럼만을 참조한다. 
*/
--시나리오의 조건에 맞는 select 문을 작성한다. 
select employee_id, salary, department_id
    from employees where department_id=10;

declare
    --사원테이블의 특정 컬럼을 참조하는 참조변수로 선언한다.
    empNo employees.employee_id%type;--NUMBER(6,0)
    empSal employees.salary%type;--NUMBER(8,2)
    deptId employees.department_id%type;--NUMBER(4,0) 와 동일하다.
begin
    --select의 결과를 into를 통해 선언한 변수에 할당한다.
    select employee_id, salary, department_id
        into empNo, empSal, deptId
    from employees where department_id=10;
    --결과출력
    dbms_output.put_line(empNo||' '||empSal||' '||deptId);
end;
/

/*
시나리오] 사원번호가 100인 사원의 레코드를 가져와서 emp_row변수에 전체컬럼을
저장한 후 화면에 다음 정보를 출력하시오.
단, emp_row는 사원테이블이 전체컬럼을 저장할 수 있는 참조변수로 선언해야한다.
출력정보 : 사원번호, 이름, 이메일, 급여
*/
select * from employees where employee_id=100;

declare
    /*
    전체컬럼을 참조하는 참조변수 : 테이블명뒤에 %rowtype을 붙여서
        선언한다. 
    */
    emp_row employees%rowtype;
begin
    /*
    와일드카드 *를 통해 얻어온 전체컬럼을 변수 emp_row에 
    한꺼번에 저장한다. 
    */
    select * into emp_row
    from employees where employee_id=100;
    
    /*
    emp_row에는 전체컬럼의 정보가 저장되므로 출력시에는
    변수명.컬럼명 형태로 기술해야한다. 
    */
    dbms_output.put_line(emp_row.employee_id||' '||
                        emp_row.first_name||' '||
                        emp_row.email||' '||
                        emp_row.salary);
end;
/




/*
복합변수
    : class를 정의하듯 필요한 자료형을 묶어서 생성하는 변수
    
    아래는 3개의 자료형을 가진 복합변수를 생성하고 있다. 
    특정 컬럼을 그대로 사용할때는 참조변수 %type형태로 선언하고
    컬럼을 합치거나 변경해야 할 경우 임의생성도 가능하다. 
    형식]
        type 복합변수자료형 is record(
            컬럼명1 자료형1,
            컬럼명2 참조변수%type ....
        );
*/
declare
    --3개의 값을 저장할수 있는 복합자료형을 선언한다. 
    type emp_3type is record (
        emp_id employees.employee_id%type, --기존테이블의 컬럼을 참조하는 변수
        emp_name varchar2(50), --새롭게 생성한 변수
        emp_job employees.job_id%type
    );
    --복합자료형을 통해 선언한 복합변수. 3개의 컬럼을 저장할수 있다. 
    record3 emp_3type;
begin    
    -- select절에서 가져온 3개의 컬럼을 하나의 복합변수에 저장한다.
    select employee_id, first_name||' '||last_name, job_id
        into record3
    from employees
    where department_id=10;

    --출력시에는 변수명.컬럼명 형태로 기술한다. 
    dbms_output.put_line(record3.emp_id||' '||
				record3.emp_name||' '||record3.emp_job);
end;
/

/*
퀴즈] 아래 절차에 따라 PL/SQL문을 작성하시오.
1.복합변수생성
    참조테이블 : employees
    복합변수자료형의 이름 : empTypes
        멤버1 : emp_id -> 사원번호
        멤버2 : emp_name -> 사원의전체이름(이름+성)
        멤버3 : emp_salary -> 급여
        멤버4 : emp_percent -> 보너스율
    위에서 생성한 자료형을 이용하여 복합변수 rec2를 생성후 사원번호 
    100번의 정보를 할당한다.
    
2. 1의 내용을 출력한다.

3.위 내용을 완료한후 치환연산자를 사용하여 사원번호를 사용자로부터 입력받은후
    해당 사원의 정보를 출력할 수 있도록 수정하시오.
*/                                                                                                     

select * from employees where employee_id=100;
select employee_id, first_name||' '||last_name, salary, nvl(commission_pct,0) 
    from employees where employee_id=100;

set serveroutput on;
declare
    --4개의 멤버를 가진 복합변수자료형 선언
    type empTypes is record (
        emp_id employees.employee_id%type,
        emp_name varchar2(60),
        emp_salary employees.salary%type,
        emp_percent employees.commission_pct%type
    );
    --복합변수선언
    rec2 empTypes;
begin
    --문제의 조건에 부합하는 select문 선언
    select employee_id, first_name||' '||last_name, salary, nvl(commission_pct,0) 
        into rec2
    from employees where employee_id=100;
    
    dbms_output.put_line('사원번호 / 사원명 / 급여 / 보너스율');
    dbms_output.put_line(rec2.emp_id||' / '||rec2.emp_name
                ||' / '||rec2.emp_salary||' / '||rec2.emp_percent);
end;
/

/*
치환연산자 : PL/SQL 에서 사용자로부터 데이터를 입력받을 때 사용하는 연산자로
    변수 앞에 &를 붙여주면 된다.
    실행 시 입력창이 뜬다.
*/
--앞의 퀴즈 3번에서 요구한 치환연산자로 변경하여 사원번호를 입력받아 처리한다.
select * from employees where employee_id=100;
select employee_id, first_name||' '||last_name, salary, nvl(commission_pct,0) 
    from employees where employee_id=100;

set serveroutput on;
declare
    --4개의 멤버를 가진 복합변수자료형 선언
    type empTypes is record (
        emp_id employees.employee_id%type,
        emp_name varchar2(60),
        emp_salary employees.salary%type,
        emp_percent employees.commission_pct%type
    );
    --복합변수선언
    rec2 empTypes;
    --치환 연산자를 통해 입력받은 값을 할당받는 변수
    inputNum number(3) := &inputNum;
begin
    --문제의 조건에 부합하는 select문 선언
    select employee_id, first_name||' '||last_name, salary, nvl(commission_pct,0) 
        into rec2
    from employees where employee_id = inputNum;
    
    dbms_output.put_line('사원번호 / 사원명 / 급여 / 보너스율');
    dbms_output.put_line(rec2.emp_id||' / '||rec2.emp_name
                ||' / '||rec2.emp_salary||' / '||rec2.emp_percent);
end;
/


/*
-바인드 변수
    : 호스트 환경에서 선언된 변수로써 비 PL/SQL변수이다.
    호스트환경이란, PL/SQL의 블럭을 제외한 나머지 부분을 말한다.
    콘솔(CMD)에서는 SQL> 명령프롬프트가 있는 상태를 말한다.
    
    형식 : 
        var 변수명 자료형;
        혹은
        variable 변수명 자료형;
*/
set serveroutput on;            --실행 순서 : set절 --> var절 -> declare절 -> print절
var return_var number;       --호스트환경 (SQL>)에서 바인드 변수 선언     | declare~end;/ 까지가 PL/SQL 블럭으로 묶..
declare
begin
    --PL/SQL에서 사용할 때는 반드시 :을 변수 앞에 붙여야한다.
    --콜론(:)은 일반변수와 바인드 변수를 구분하기 위한 용도로 사용됨.
    :return_var := 999;
    dbms_output.put_line(:return_var);
end;
/
print return_var;       --호스트환경 (SQL>)
/*
    호스트 환경에서 출력할 때는 print문을 사용한다.
    출력이 안되면 CMD창에서 확인해본다.
*/


--------------------------------------------------
--제어문(조건문) : if문, case문과 같은 조건문

--if문
--홀수 짝수를 판단하는 if문 예제
declare
    num number;
begin
    num:=10;
    
    if mod(num,2) = 0 then
        dbms_output.put_line(num || '은 짝수');
    else
        dbms_output.put_line(num || '은 홀수');
    end if;
end;
/
--위 예제를 치환연산자를 통해 숫자를 입력받은 후 판단할 수 있도록 수정.
declare
    --치환연산자는 선언부에 사용가능함.
    num number := &num ;
begin
    
    if mod(num,2) = 0 then
        dbms_output.put_line(num || '은 짝수');
    else
        dbms_output.put_line(num || '은 홀수');
    end if;
end;
/

/*
시나리오]
    사원번호를 사용자로부터 입력받은 후             --치환연산자를 써라..
    해당 사원이 어떤 부서에서 근무하는지를 출력하는 PL/SQL문을 작성하시오.
    단, if~elsif문을 사용하여 구현하시오.
*/
declare
    --치환 연산자를 통해 사원번호를 입력받음
    emp_id employees.employee_id%type := &emp_id;
    emp_name varchar2(50);
    emp_dept employees.department_id%type;
    dept_name varchar2(30) := '부서정보 없음';        --부서명은 선언과 동시에 초기화
begin
    select employee_id, last_name, department_id
        into emp_id, emp_name, emp_dept
    from employees
    where employee_id = emp_id;     --입력받은 사원번호를 통해 쿼리 실행함.
    
    /*
    여러개의 조건을 사용할 경우, java와 같이 else if를 사용하지 않고
                                                              elsif로 사용해야한다.
    또한 중괄호 대신 then과 ;이 사용된다.
    */
    if emp_dept = 50 then
        dept_name := 'Shipping';
    elsif emp_dept = 60 then
        dept_name := 'IT';
     elsif emp_dept = 70 then
       dept_name := 'Public Relations';
    elsif emp_dept = 80 then
       dept_name := 'Sales';
    elsif emp_dept = 90 then
       dept_name := 'Executive';
    elsif emp_dept = 100 then
       dept_name := 'Finance';
    end if;
    
    dbms_output.put_line('사원번호' || emp_id || '의 정보');
    dbms_output.put_line('이름:' || emp_name
                ||', 부서번호:' || emp_dept
                ||', 부서명:' || dept_name );
end;
/
                
/*
case문 : java의 switch문과 비슷한 조건문
형식]
    case 변수
        when 값1 then '할당값1'
        when 값2 then '할당값2'
        ....
    end;
    
시나리오] 위에서 if~elsif로 작성한 PL/SQL문을 case~when문으로 변경하시오.
*/
declare
    --치환 연산자를 통해 사원번호를 입력받음
    emp_id employees.employee_id%type := &emp_id;
    emp_name varchar2(50);
    emp_dept employees.department_id%type;
    dept_name varchar2(30) := '부서정보 없음';        --부서명은 선언과 동시에 초기화
begin
    select employee_id, last_name, department_id
        into emp_id, emp_name, emp_dept
    from employees
    where employee_id = emp_id; --입력받은 사원번호를 통해 쿼리실행함
    
    /*
    case~when문이 if문과 다른 점은 할당할 변수를 먼저 선언한 후
    문장 내에서 조건을 판단하여 하나의 값을 할당하는 방식이다.
    */
    dept_name :=
        case emp_dept
            when 50 then 'Shipping'
            when 60 then 'IT'
            when 70 then 'Public Realtions'
            when 80 then 'Sales'
            when 90 then 'Executive'
            when 100 then 'Finance'
        end;
            
    dbms_output.put_line('사원번호' || emp_id || '의 정보');
    dbms_output.put_line('이름:' || emp_name
                ||', 부서번호:' || emp_dept
                ||', 부서명:' || dept_name );
end;
/


/*
제어문(반복문)

반복문1 : Basic loop문
    java의 do~while문과 같이 조건체크 없이 일단 loop로 진입한 후
    탈출조건이 될 때까지 반복한다.
*/
declare
    num number := 0;
begin
    loop
        -- 0~10까지 출력됨.
        dbms_output.put_line(num);
        num := num+1;
        exit when (num>10);     --10이상이 되는 그'때(when)' 탈출한다. (java] break;)
    end loop;
end;
/
/*
퀴즈] Basic loop문으로 1부터 10까지의 정수의 합을 구하는 프로그램을 작성하시오.
*/
declare     --변수선언
    i number := 1;      --증가시킬 변수
    sumNum number := 0;     --누적합을 구할 변수
    /*
    변수명으로  sum을 사용할 수 X !!
    예약어이므로 오류가 발생!
    */
begin       --실행부
    /*
    복합대입 연산자, 증감연산자가 없으므로 누적합 혹은 변수의 증가는
    아래와 같이 구현해야 한다.
    */
    loop
        sumNum := sumNum + i;
        i := i+1;
        exit when (i>10);    
    end loop;
    dbms_output.put_line('1~10까지의 합은 : '|| sumNum);
end;
/


/*
반복문2 : while문
    Basic loop와는 다르게 '조건을 먼저 확인'한 후 진입.
    즉, 조건에 맞지 않는다면 한번도 실행되지 않을 수도 있다.
*/
declare
    num1 number := 0;
begin
    --while문으로 진입하기 전, 조건을 먼저 판단함!
    while num1<11 loop
        dbms_output.put_line('이번숫자는 : ' || num1);
        num1 := num1 +1;
        end loop;
end;
/
/*
퀴즈] while loop문으로 1부터 10까지의 정수의 합을 구하는 프로그램을 작성하시오.
*/
declare
    i number := 1;
    sumNum number := 0;
begin
    while i<11 loop
        sumNum := sumNum + i;
        i := i+1;
    end loop;
    dbms_output.put_line('1~10까지의 합은 : ' || sumNum);
end;
/

/*
반복문 3 : for문
    반복의 횟수를 지정하여 사용할 수 있는 반복문으로
    반복을 위한 변수를 '별도로 선언하지 않아도 된다.'
    그러므로 특별한 이유가 없다면 declare(선언부)를 기술하지 않아도 된다.
*/
declare
begin
    for num2 in 0 .. 10 loop
        dbms_output.put_line('for문 짱인듯:' || num2);
    end loop;
end;
/

                --declare 지움 >> 없어도 정상 실행 O
begin
    for num3 in reverse 0 .. 10 loop
        dbms_output.put_line('거꾸로 for문 짱인듯:' || num3);
    end loop;
end;
/
/*
시나리오]
    for loop문으로 구구단을 출력하시오.
*/
--방법 1 : 줄바꿈이 되는 버젼
declare
begin
    for dan in 2 .. 9 loop
    dbms_output.put_line(dan || '단');
        for su in 1 .. 9 loop
            dbms_output.put_line(dan || '*' || su || '=' || (dan * su));
        end loop;
    end loop;
end;
/

--방법 2 : 줄바꿈이 없는 버젼
declare
    --구구단에서 하나의 단을 '저장'하기 위한 변수(누적해서 저장할 수 있는 문자열 생성)
    guguStr varchar(1000);       --oracle >>  문자열 X >> 문자타입만 있을 뿐... varchar
begin
        --단에 해당하는 for loop문(2~9)
        for dan in 2 .. 9 loop
            --수에 해당하는 for loop문(1~9)
            for su in 1 .. 9 loop
                --하나의 단을 누적해서 연결한다.
                guguStr := guguStr || dan || '*' || su || '=' || (dan*su) || ' ';
            end loop;
            -- 하나의 단을 출력한 후 줄바꿈 한다.
            dbms_output.put_line(guguStr);      --putline은 자동 줄바꿈이 됨.
            --그 다음 단을 저장하기 위해 빈 문자열로 초기화 한다.
            guguStr := '';      --guguStr 을 빈 문자열로 초기화시킴
        end loop;
end;
/


/*
커서(Cursor)
    : select 문장에 의해 여러 행이 반환되는 경우
    각 행에 접근하기 위한 개체
    
    선언방법]
        Cursor 커서명 Is
            Select 문장 (단, into절이 없는 select)
    
    Open Cursor
        : 쿼리를 수행하라는 의미.
        즉, Open할 때 Cursor 선언 시의 select 문장이 실행되어 결과셋을 얻게 된다.
        Cursor는 그 결과셋의 첫번째 행에 위치하게 된다.
        
        Open 커서명;
        
    Fetch ~ Into ~
        : 결과셋에서 하나의 행을 읽어들이는 작업으로 결과셋의 인출(Fetch) 후에
        Cursor는 다음 행으로 이동함.
        
        Fetch 커서명 Into (변수1, 변수2...)
    
    Close Cursor    
        : 커서 닫기로 결과셋의 자원을 반납한다.
        select 문장이 모두 처리된 후 Cursor를 Close 해줌.
        
        Close 커서명 ;
        
    Cursor의 속성
        %Found : 가장 최근의 인출(Fetch)이 행을 Return하면 True,
                        아니면 False를 반환함.
        %RowCount : 지금까지 Return된 행의 갯수를 반환함.
*/

/*
시나리오] 부서테이블의 레코드를 Cursor를 통해 출력하는 PL/SQL문을
              작성하시오.
*/
declare
    -- 부서테이블의 전체 컬럼을 참조하는 참조변수 선언
    v_dept departments%rowtype;
    -- 커서 선언(부서테이블의 모든 레코드를 조회하는 select문)
    cursor cur1 is 
        select
            department_id, department_name, location_id
        from departments;
begin
    /*
    해당 쿼리문을 수행해서 결과셋을 가져오라는 명령으로,
    결과셋이란 쿼리(질의)문을 수행한 후 반환되는 레코드의 결과를 말한다.
    (Java에서는 ResultSet객체가 동일한 역할을 함.)
    */
    open cur1;
    /*
    basic 루프문을 통해 얻어온 결과셋의 갯수만큼 반복하여 인출한다.
    */
    loop
        /*
        각 컬럼의 값을 참조변수에 저장한다.
        */
        fetch cur1 into
            v_dept.department_id,
            v_dept.department_name,
            v_dept.location_id;
        /*
        탈출조건으로 더이상 인출할 행이 없으면 exit가 실행된다.
        */
        exit when cur1%notfound;
        dbms_output.put_line(v_dept.department_id || ' ' ||
                                            v_dept.department_name || ' ' ||
                                            v_dept.location_id);
    end loop;
    
    --커서의 자원반납 (모든 인출을 마쳤으면 닫겠다.. open >> close 꼭!)
    close cur1;
end;
/

/*
연습문제 ] Cursor를 사용하여 사원테이블에서 커미션이 null이 아닌
                사원의 사원번호, 이름, 급여를 오름차순(이름)으로 출력하시오.
*/
select * from employees where commission_pct is not null;

declare
    --문제의 조건에 맞는 커서를 생성한다. 이때, into절은 기술하지 X
    cursor cur2 is 
        select
            employee_id, first_name, last_name, salary
        from employees where commission_pct is not null
        order by last_name asc;
    --사원테이블의 전체컬럼을 참조하는 참조변수 선언        
    v_emp employees%rowtype;
    
begin
    --커서를 오픈하여 쿼리를 실행한다.   (오픈 = 쿼리 실행)
    open cur2;
    --Basic loop문을 통해 커서에 저장된 결과셋을 인출한다.
    loop
        --인출한 후에 변수에 저장하기 위해 into를 사용한다.
        fetch cur2
         into  v_emp.employee_id, v_emp.first_name, v_emp.last_name, v_emp.salary;
        --더이상 인출할 결과셋이 없을 때 루프를 탈출한다.
        exit when cur2%notfound;
        dbms_output.put_line(v_emp.employee_id || ' ' ||
                                            v_emp.first_name || ' ' || v_emp.last_name || ' ' ||
                                            v_emp.salary);
    end loop;
    --커서를 닫아 자원반납.
    close cur2;
end;
/


/*
컬렉션(배열)
    일반 프로그래밍 언어에서 사용하는 배열타입을 PL/SQL에서는 테이블 타입이라고 한다.
    1차원, 2차원 배열을 생각해보면 테이블(표)와 같은 형태이기 때문.
    
종류
- 연관배열
- VArray
- 중첩테이블
*/

/*
1. 연관배열(Associative Array / Index-by Table)
    : 키와 값 한쌍으로 구성된 컬렉션으로 Java의 해시맵과 같은 개념임.
    Key : 자료형은 주로 숫자를 사용하면 binary_integer, pls_integer가 사용된다.
            이 두 가지 타입은 number보다 크기는 작고 산술연산에 빠른 특징을 가짐.
            또한 문자형(varchar2)으로 사용할 수도 있다.
    Value : 자료형은 문자형이며 주로 varchar2가 사용된다.

    형식]
         Type 연관배열 자료형 Is
                 Table of 연관배열 값 타입
                 Index by 연관배열 키 타입
*/
/*
시나리오 ] 다음 조건에 맞는 연관배열을 생성한 후 값을 할당하시오.
               연관배열 자료형 명 : avType,  값의자료형:문자형, 키의자료형:문자형
                key : girl, boy
                value :  트와이스, 방탄소년단
                변수명 : var_array
*/
declare
    -- 연관배열 자료형 생성
    Type avType Is
        Table of varchar2(30)       --value(값)의 자료형 선언
        Index by varchar2(10);      --key(키)의 자료형 선언
    -- 연관배열 타입의 변수선언
    var_array avType;
begin
    --연관배열에 값 할당
    var_array('girl') := '트와이스';
    var_array('boy') := '방탄소년단';
    
    --출력
    dbms_output.put_line(var_array('girl'));
    dbms_output.put_line(var_array('boy'));
end;
/

/*
시나리오]
    100번 부서에 근무하는 사원의 이름을 저장하는 연관배열을 생성.
    key는 숫자,
    value는 full_name 으로 지정.
*/
--100번 부서에 근무하는 직원 출력
select * from employees where department_id=100;        --6명
                                                                    -- >>인출  1개 : PL/SQL  |  2개 이상 : Cursor
-- full_name을 출력
select first_name || ' ' || last_name
    from employees where department_id=100;

-- 문제의 조건을 통한 쿼리에서 다수행이 인출되므로 Cursor를 사용해야됨.
declare
    --쿼리문을 통해 커서 생성
    cursor emp_cur Is
        select first_name || ' ' || last_name from employees
        where department_id = 100;
    --연관배열 자료형 생성(값은 문자, 키는 숫자로 생성)   
    Type nameAvType Is
        Table of varchar2(30)      
        Index by binary_integer; 
    --연관배열 변수를 생성
    names_arr nameAvType;
    --사원의 이름, 인덱스로 사용할 변수 생성
    fname varchar2(50);
    idx number := 1;
begin
        open emp_cur;
        loop
            --하나의 행(row)에서 인출한 데이터(이름)을 변수에 저장.
            fetch emp_cur into fname;
            --탈출조건
            exit when emp_cur%NotFound;
            --연관배열에 데이터 삽입
            names_arr(idx) := fname;
            --키로 사용될 인덱스 증가
            idx := idx + 1;
        end loop;
        close emp_cur;
        
        --연관배열의 크기만큼 반복해서 출력
        --연관배열.count -> 배열에 저장된 갯수반환
        for i in 1 .. names_arr.count loop
            dbms_output.put_line(names_arr(i));
        end loop;
end;
/

/*
2. VArray(Variable Array)
    :  고정길이를 가진 배열로써 일반 프로그래밍 언어에서 사용하는 배열과 동일.
    크기에 제한이 있어, 선언할 때 크기(요소의 갯수) 지정하면 이보다 큰 배열로 만들 수 X
    
    형식]
        Type 배열타입명 Is
            Array(배열크기) Of 요소값_타입;
*/
set serveroutput on;

declare
    --VArray 타입 선언 : 크기는 5, 저장할 데이터는 문자형
    type vaType is
        array(5) of varchar2(20);
    --VArray형 배열변수 선언
    v_arr vaType;
    cnt number := 0;
begin
    --생성자를 통한 값의 초기화(총 5개중 3개만 할당)
    v_arr := vaType('First', 'Second', 'Third', '', '');
    
    --Basic loop문을 통해 배열요소 출력(※인덱스는 1부터 시작!!)
    loop
        cnt := cnt + 1;
        --탈출조건
        if cnt>5 then
            exit;
        end if;
        --출력
        dbms_output.put_line(v_arr(cnt));
    end loop;
    
    --배열의 요소값 재할당
    v_arr(3) := '우리는';
    v_arr(4) := 'JAVA';
    v_arr(5) := '개발자다';
    
    --2차 출력
    for i in 1 .. 5 loop
        dbms_output.put_line(v_arr(i));
    end loop;
end;
/
    
declare
    -- 하나의 컬럼을 참조하는 참조변수를 통해 VArray자료형 선언
    type vaType1 is
        array(6) of employees.employee_id%Type;
    -- 배열 변수 선언 및 초기화
    va_one vaType1 := vaType1('','','','','','');
    cnt number := 1;
begin
    /*
    Java의 확장 for문과 비슷하게 쿼리의 결과셋 갯수만큼 자동으로
    반복하는 형태로 사용한다.
    select 절의 employee_id가 변수 i에 할당되고 이를 통해 추출한다.
    */
    for i in (select employee_id from employees where department_id=100) loop
        --추출한 데이터를 배열에 저장한다.
        va_one(cnt) := i.employee_id;
        cnt := cnt + 1;
    end loop;
    --배열의 크기만큼 반복하면서 출력
    for j in 1 .. va_one.count loop
        dbms_output.put_line(va_one(j));
    end loop;
end;
/
select * from employees where department_id=100;        --6개의 레코드가 인출됨

/*
3. 중첩테이블(Nested Table)
    : VArray와 비슷한 구조의 배열로써 배열의 크기를 명시하지 않으므로
     동적으로 배열의 크기가 설정된다.     --동적으로 늘어난다.. 그러나 무조건 늘어나는 것은 X
                                                                                       항상 생성자를 통해 늘려야함(생성자를 통한 재지정)
     여기서 말하는 테이블은 자료가 저장되는 실제테이블이 '아니라',
     컬렉션의 한 종류를 의미함.
     
     형식]
            Type 중첩테이블명 Is
               Table Of 값_타입;
*/
declare
    -- 중첩테이블 자료형 선언 및 변수선언
    type ntType is
        table of varchar2(30);
    nt_array ntType;
begin
    --생성자를 통해 값 할당(여기서 크기4의 중첩테이블 생성됨)
    nt_array := ntType('첫번째','두번째','세번째','');
    
    dbms_output.put_line(nt_array(1));
    dbms_output.put_line(nt_array(2));
    dbms_output.put_line(nt_array(3));
    nt_array(4) := '네번째 값 할당';
    dbms_output.put_line(nt_array(4));      --4번째 값까지 할당 및 출력가능
    
    --nt_array(5) := '다섯번째 값 ?? 할당??';        --error : 동적으로 늘어나나, 무조건 늘어나는 것 X     
    --error발생 >> 첨자가 갯수를 넘었습니다.
    
    --크기를 확장할 때는 생성자를 통해 배열의 크기를 동적으로 확장한다.
    nt_array := ntType('1a','2b','3c','4d','5e','6f','7g');     -- 생성자를 통한 재지정을 해야 늘어난다.
    
    --크기 7인 중첩테이블 출력
    for i in 1 .. 7 loop
        dbms_output.put_line(nt_array(i));
    end loop;
end;
/


/*
시나리오] 중첩테이블과 for문을 통해 사원테이블의
            전체 레코드의 사원번호와 이름을 출력.
*/
declare
    /*
    중첩테이블 자료형 선언 및 변수선언
    :  사원테이블 전체 컬럼을 참조하는 참조변수의 형태이므로 하나의 레코드(Row)를 저장할 수 있는
    형태로 선언했다.
    */
    type ntType is
        table of employees%rowtype;     --참조하겠다 전체를..?
    nt_array ntType;
begin
    --크기를 지정하지 않고 생성자를 통해 초기화.
    nt_array := ntType();
    
    /*
    사원테이블의 레코드 수만큼 반복하면서 레코드를 하나씩 rec에 할당.
    커서처럼 동작하는 for문의 형태로 Java의 확장for문 처럼 사용되었다.
    */
    for rec in (select * from employees) loop
        nt_array.extend;        --extend 메소드 사용 => extend : 중첩 테이블의 끝부분을 확장하면서 null(빈공간) 삽입
        nt_array(nt_array.last) := rec;     --마지막 인덱스에 레코드(사원정보) 삽입
    end loop;
    
    --중첩테이블의 첫 번째 인덱스부터 마지막(last) 인덱스까지 출력.
    for i in nt_array.first .. nt_array.last loop
        dbms_output.put_line(nt_array(i).employee_id ||
                '>' || nt_array(i).first_name);
    end loop;
    
end;
/

-------------------------------------------------------------------------------------
--1. 사원테이블에서 사원아이디로 조회해서 사원이름의 문자수만큼 #을 찍는 PL/SQL문을 작성하시오.
--   출력 예] 이름이 ‘Ismael’ 라면 ###### 형태로 출력된다.
select * from emp;
select ename from emp;
select ename, length(ename) from emp;
--사원아이디으로 레코드 조회하여 길이 확인
select empno, length(ename) from emp where empno=7369;
--PL/SQL 작성
declare
    input_id emp.empno%type;
begin
    select ename, elght
end;
/


/* 2. basic loop 문으로 구구단을 출력하시오. */
/*
반복문1 : Basic loop문
    java의 do~while문과 같이 조건체크 없이 일단 loop로 진입한 후
    탈출조건이 될 때까지 반복한다.
*/
declare
    dan number(2) := 2;     --2단부터 9단까지 증가
    su number(2) := 1;      --1~9까지 증가
    guguStr varchar2(300);      --구구단을 문자열로 하나의 단을 저장할 용도
begin
    --단에 해당하는 루프문
    loop
        --수에 해당하는 루프문
       loop
        --1~9까지 증가하면서 하나의 단을 문자열에 저장
         guguStr := guguStr || dan || '*' || su || '=' || (dan*su) || ' ';
         su := su + 1;
         if su>9 then
            exit;       --if문을 통한 탈출조건
         end if;
      end loop;
      --하나의 단을 출력
      dbms_output.put_line(guguStr);
      guguStr := '';    --문자열 초기화
      su := 1;      --수 초기화
      dan := dan +1;
      exit when (dan>9);        --when문을 통한 탈출조건
    end loop;
end;
/

/* 3. while loop문으로 다음과 같은 결과를 출력하시오. */
declare
    cnt number :=1;     --반복을 위한 변수  
    starStr varchar2(100);      -- *를 연결하기 위한 변수
begin
  /*
    *를 출력한 후 초기화 하지 않으므로 하나의 while문으로
    구현 가능
  */
  while cnt<=5 loop
    starStr := starStr || '*';
    dbms_output.put_line(starStr);
    cnt := cnt + 1;
  end loop;
end;
/
/* 4. for loop문으로 다음과 같은 결과를 출력하시오. */ --rererererererereere
declare
begin
  for i in 1..5 loop
    for j in 1..5 loop
        if i=j then
            numStr := numStr || '1';
        else
        numStr := numStr || '0';
        end if;
    end loop;
    dbms_output.put_line(numStr);     --1줄을 만들어놓고 출력
    numStr := ' ';        --한 줄 출력 후초기화
  end loop;
end;
/

/*5번 문제*/
select * from emp where ename='KING';

declare
    --치환연산자를 통해 입력받을 때 문자열이라면 ''을 붙여주어야 한다.
    input_name varchar2(30) := '&input_name';     --input_name >> 치환연산자
    dept_no emp.deptno%type;        --사원테이블의 부서번호 참조
    dept_name dept.dname%type;      --부서테이블의 부서명을 참조
begin
    --입력받은 이름을 통해 select한 후 부서번호를 저장
    select deptno into dept_no
    from emp
    where ename=input_name;
    
    --부서번호를 통해 부서명 판단
    if dept_no=10 then
        dept_name := 'ACCOUNTING';
    elsif dept_no=20 then
        dept_name := 'RESEARCH';
    elsif dept_no=30 then
        dept_name := 'SALES';
    elsif dept_no=40 then
        dept_name := 'OPERATIONS';
    end if;
    
    dbms_output.put_line('부서번호/부서명');
    dbms_output.put_line(dept_no || '/' || dept_name);
end;
/