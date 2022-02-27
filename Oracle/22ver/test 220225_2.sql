/*
[레코드 복사]

형식 :
insert into 테이블명
    select 컬럼명, ... from 테이블명
*/
--전체 복사
select * from c_emp;
--조건(부서번호가 20인 레코드)에 맞는 테이블 생성
select * from c_emp_20;
--empno, ename, job, sal 원하는 필드만 복사
select * from c_emp3;
--구조물만 복사된 상태 (레코드 복사 제외)
select * from c_emp4;

--레코드 삽입
insert into c_emp4 --열의 갯수가 맞지 않으므로 error
    select ename, mar, sal, deptno from emp;

-- 열에 갯수에 맞춰 삽입
insert into c_emp4 (ename, mgr, sal, deptno)
    select ename, mgr, sal, deptno from emp;
select * from c_emp4; --선택되지 않은 것은 null로 들어가 있음을 알 수 있다.

--다른 테이블에서도 레코드 복사 가능
desc c_emp4;
--data type, field 갯수, 데이터 크기를 맞춰야 insert 가능
insert into c_emp4 ( hiredate )
    select birthday from emp2; 
 
select * from c_emp4;  --4, 9, date, 7
desc emp2;             --4, 

/*
rownum : 검색 할 때 자동 행 번호 추가
게시판 만들 때 페이징 처리 시 사용
ex) 1 limit 7 : mySQL
*/ 
select * from emp;
select rownum, ename, job, sal from emp;

select rownum, job from emp where rownum=3; --물리적으로 들어가 있는 field가 아니므로

select rowid, ename, job, sal from emp;

--0227추가
select  ename, job, rownum,sal from emp;

select rownum, job from emp where sal > 3000; -- rownum : 조건 적용 X
select rownum, job sal, rowid from emp; --  where sal > 3000; 

-- 가상 테이블 : dual 
select sysdate from dual;
-- //

-----------------------Sequence-----------------------
/*
create sequence 시퀀스이름    --1부터 시작 1씩 증가
    [start with 시작값]
    [increment by 증가치]
    [maxvalue 최대값]
    [minvalue 최소값]
    [cycle | nocycle ]
    [cache | nocache ]
*/
drop sequence autonum;

create sequence autonum; --1부터 시작해서 1씩 증가

 --시퀀스값 증가
select autonum.nextval from dual;

 --현재 시퀀스값 가져오기
select autonum.currval from dual;
 
--Sequence는 number type에 들어간다.
create table kosa_T (
   no number,
   name varchar2(20)
);    

insert into kosa_T values(autonum.nextval, 'aa');
insert into kosa_T values(autonum.nextval, 'bb');
insert into kosa_T values(autonum.nextval, 'cc');

select * from kosa_T;
 
 
create SEQUENCE seq_kosa;
insert into kosa values(seq_kosa.nextval, 'aa', 'name');
insert into kosa values(seq_kosa.nextval, 'bb', 'name');
insert into kosa values(seq_kosa.nextval, 'cc', 'name');
insert into kosa values(seq_kosa.nextval, 'dd', 'name'); 
--re

create sequence seq_kosa
    increment by 100; --100씩 증가  

create table kosa2(
    num number,
    id varchar2(20),
    name varchar2(20)
);
insert into kosa2 values(seq_board.nextval, 'aa', 'name');
insert into kosa2 values(seq_board.nextval, 'bb', 'name');
insert into kosa2 values(seq_board.nextval, 'cc', 'name');



---re---

create sequence seq_jumin_no
    increment by 10
    start with 10
    maxvalue 150
    minvalue 9
    cycle
    cache 2 --cycle돌면 cache값 1보다 커야한다.
;
 
drop table jumin;

create table jumin_T(
    seq number,
    name varchar2(10),
    phone varchar2(15)
) segment creation immediate;

--segment란?

insert into jumin_T values (seq_jumin_no.nextval, 'aa', 111);
insert into jumin_T values (seq_jumin_no.nextval, 'bb', 222);
insert into jumin_T values (seq_jumin_no.nextval, 'cc', 333);

select * from jumin_T;

delete jumin_T;
drop sequence seq_jumin_no;



-----Transaction-----
--구조 복사(c_)
create table c_emp100
as
    select * from emp where 1=2; --조건에 맞지 않은 상태

--데이터 밀어넣기

BEGIN --나 지금부터 저장프로시저 시작할거다
END; --끝이다 

BEGIN
    for i in 1..10000 LOOP
        insert into c_emp100
            select * from emp;
    END LOOP;
END;
 --10,000번을 돌림
 select * from c_emp100;
 
 ROLLBACK;
 COMMIT;
 
 update c_emp100 set sal=1000;
 
 -----------
 update c_emp100 set sal=10 where deptno=30;
 savepoint update_sal_30;
 
update c_emp100 set sal=1 where deptno=30;

 select * from c_emp100;
 select sum(sal) from c_emp100;
 rollback to savepoint update_sal;
 
 --실습 X ..
 
 
 commit / rollback; -- DML 명령에 적용된다.
 
 --다른 계정에 있는 테이블 접근하기
 /*
 현재 접속된 user 알아오기
show user;
- 다른계정에 있는 테이블에 접근하기 위해서는 권한설정 필요.
1. system계정으로 접속하여 권한부여
grant all on 계정명.테이블이름 to 계정명;
2. 다른 계정으로 접속
conn 계정명/비번
3. 다른 계정에 있는 테이블접속하기
SELECT * FROM 계정명.테이블이름;
4. 권한 취소
revoke all on 계정명.테이블이름 from 계정명;
 */
 
 show user;
 
 
 
 ----------------------------------------
 /*
 1. 테이블을 export 하는 방법.
    => data를 옮기고 싶은 테이블을 dmp 파일로 만든다.
    방법) cmd 창을연다(cmd창 위치는 상관 없다.)
    exp id/pwd tables=(xxx,xxx,xxx ...) file=c:\aaa.dmp
    exp id/pwd file=c:\aaa.dmp -> 모든테이블 백업
    => xxx부분은 테이블이름으로 가지고 오고자하는 테이블 이름을콤마로 연결한다.
    => aaa.dmp는 aaa는 원하는 파일명지정한다. c:\폴더에 만들어진다.
2. 만들어진 aaa.dmp 파일을 import 하는 방법.
    방법) cmd 창을 연다.(cmd창 위치는 상관 없다.)
    imp id/pwd ignore=y full=y file=c:\aaa.dmp
    imp id/pwd file=c:\aaa.dmp full=y 
    => c:\aaa.dmp는 export로 만들 어진 파일을 가지고와
    현재 컴퓨터의 c:\폴더에 넣어놓아야한다.
    => 기존에 테이블이 존재 한다면 데이터가 추가 되고
    테이블이 존재 하지 않으면 테이블을 자동으로 만들어 추가된다.
 */
 /*
 걸려있는 제약조건까지 제거
 drop table table명 [CASCADE CONSTRAINTS];
 */
 
 drop table dept CASCADE CONSTRAINTS; 