-- table 목록보기
select * from tab;

-- create로 만들면 drop으로 지운다
-- ( ) : field list
-- 이름 자료형
-- varchar varchar2 용량 차이 (2가 더 크다)
-- 연산할 경우가 아니라면 문자를 쓰길 권장
create table sampletable (
    num number,
    name varchar2(20) not null,
    phone varchar2(15),
    address varchar2(50)
);

-- 아직 레코드 없음
select * from sampletable;

--특정 필드만 보기
select name, address from sampletable;

---------------------------------------insert---------------------------------------
-- 레코드 삽입(추가)
-- oracle은 문자든 문자열이든 ''     << 무조건!
-- ""은 AS(알리아스_별칭) 쓸 때만
-- 필드명 없이 데이터만 적을 경우 순서 지켜서 삽입
insert into sampletable values (10, '2jelee', '010-1234-5678', '인천');
insert into sampletable values (20, '2jelee2', '010-9876-5432', '경기도');

-- 필드명을 적고 그에 맞춰 순서 지켜서 삽입
insert into sampletable (name, address, phone, num) values ('aa', '제주', '010-1111-1111', 30);
insert into sampletable (name, address) values ('bb', '서울');
insert into sampletable (address, phone) values ('부산', '12345');

insert into sampletable (name, address, phone) values ('3jelee','부산', '12345');


commit;

---------------------------------------update---------------------------------------
--insert된 것에 대한 전체 수정
update sampletable set name='메타몽';

--했던 조작 취소(원상복귀)
ROLLBACK;

select * from sampletable;

--조건에 맞는 것만 수정
update sampletable set name='메타몽' where name='2jelee2';
--조건에 맞게 여러개 수정
update sampletable set name='2메타몽', address='서울' where name='메타몽';

--테이블 구조 확인
desc sampletable;

---------------------------------------delete---------------------------------------
--삭제 전에 select를 해보자!
--삭제 (from 생략가능)
--전체 레코드 삭제
delete sampletable;

--조건에 맞는 레코드 삭제
delete sampletable where name='2jelee2';

---------------------------------------drop---------------------------------------
--drop : 테이블 삭제
--이는 rollback 할 수 없다.
drop table sampletable;


select * from emp2;
desc emp2;
select empno, name, emp_type, deptno from emp2;

select *
    from emp2
    where emp_type='계약직'
    order by name; --오름차순 정렬(현재는 가나다순)
    
select *
    from emp2
    where emp_type='계약직'
    order by name    desc; --내림차순 정렬
    
--작업자가 누구인지 확인
show user;
    
--오늘의 날짜 가져오기 (레코드 수만큼 보여줌)
select sysdate from emp2;

-- oracle은 가상의 테이블을 제공함. 이는 dual
select sysdate from dual; 




------------------------제약조건------------------------

create table userlist (
    id varchar2(10) constraint id_pk primary key,
    name varchar2(10) not null 
);

select * from userlist;

insert into userlist values ('2jelee', '이이이');
insert into userlist values ('2jelee', '삼삼삼');

insert into userlist (id) values('rrr');


select * from professor;
select * from student;
select * from department;


CREATE TABLE userlist2(
    id VARCHAR2(10) CONSTRAINT userlist2_id_pk PRIMARY key, 
    jumin char(13)  CONSTRAINT jumin_un unique  --not null
);

select * from userlist2;
insert into userlist2 values ('bb', '222');
insert into userlist2 values ('aa', '111');

insert into userlist2 values ('lee', '111');
insert into userlist2 values ('lee', '111222');

insert into userlist2 (id) values ('kim');



CREATE TABLE ck_Test(
    NAME VARCHAR2(10) NOT NULL,
    age NUMBER(2) NOT NULL 
    CHECK (age BETWEEN 20 AND 30 )  --age컬럼의 값은 20~30사이만 허용
);

select * from ck_test;

insert into ck_test values('aa', 20);
insert into ck_test values('aa', 31);
insert into ck_test values('bb', 30);
insert into ck_test values('cc', 25);

--drop table ck_test;

CREATE TABLE de_Test(
    NAME VARCHAR2(10) NOT NULL,
    addr VARCHAR2(10) DEFAULT '서울'
);

select * from de_test;

desc de_test;

insert into de_test values('ii', 'incheon');
insert into de_test values('bb', 'busan');
insert into de_test (name) values('jj');
insert into de_test values('ss', default);
insert into de_test values('zz'); 