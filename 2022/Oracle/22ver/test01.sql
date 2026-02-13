--해당 계정이 가지고 있는 테이블 리스트 보기
select * from tab;

/*
create user user01
  identified by xxxxxxAt22cc
  default tablespace data
  temporary tablespace temp
  quota 10G on data;
*/

/* create user 계정명 identified by 비밀번호;    계정명에 ""를 붙이든말든 상관 X */
/*
① 계정 만들기
    create user 계정명 identified by 비밀번호;
② 만든 계정의 lock 풀기
    alter user 계정명 account unlock; 
③ 기본 권한설정
    grant connect, resource to 계정명;
④ 권한 주기(특정 권한 부여)
    grant create session, create table, create view,
    create sequence, create procedure
    to 계정명;
*/
--계정생성
create user jel
  identified by xxxxxxAt22cc
  default tablespace data   --data영역
  temporary tablespace temp --temp영역
  quota 10G on data;
  
--접속, 조작 권한 부여
grant connect, resource to jel;

--drop user jel;

--lock 해제
alter user user01 account unlock; 

--계정생성과 lock 해제 동시에
create user user01 identified by xxxxxxAt22cc account unlock;