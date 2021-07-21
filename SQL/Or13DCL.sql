/*****************
파일명 : Or13DCL.sql
사용자 권한
설명 : 새로운 사용자 계정을 생성하고 시스템 권한을 부여하는 방법을 학습
*****************/

/*
[사용자계정 생성 및 권한설정]
해당 내용은 DBA권한이 있는 최고관리자(sys, system)로 접속한 후 실행해야 한다.
(사용자 계정 생성 후 접속 테스트는 CMD(명령프롬프트)에서 진행하도록 한다.)
*/

/*
1] 사용자계정 생성 및 암호설정
형식]
    create user 아이디 identifided by 패스워드;
*/
create user test_user1 identified by 1234;
-- cmd에서 sqlplus 명령으로 접속 시 login denied 에러 발생됨.

/*
2] 생성된 사용자 계정에 권한 혹은 역할 부여
    형식]
        grant 시스템권한1[,시스템권한2 ...] | [역할1[,역할2...]]
            to 사용자1[,사용자2...] | [역할1[,역할2...]]
            [with grant option];
*/
--접속 권한 부여 : 접속은 되지만 테이블을 생성할 수 없다.
grant create session to test_user1;
--테이블생성 권한 부여 : 테이블 스페이스가 없어 생성되지 않는다.
grant create table to test_user1;

/*
테이블 스페이스란?
    디스크 공간을 소비하는 테이블과 뷰, 그리고 그 밖의 다른 데이터베이스 객체들이 저장되는 장소.
    예를 들어, 오라클을 최초로 설치하면 hr계정의 데이터를 저장하는 users라는 테이블 스페이스가 자동으로 생성된다.
*/
--테이블 스페이스 조회하기
select tablespace_name, status, contents from dba_tablespaces;
desc dba_tablespaces;

--테이블 스페이스별 사용 가능한 공간 확인하기
select tablespace_name, sum(bytes), max(bytes) from dba_free_space
    group by tablespace_name;
    
--앞에서 생성한 test_user1 사용자의 테이블 스페이스를 확인하기
select username, default_tablespace from dba_users
      where username in upper('test_user1');

--테이블 스페이스 영역 할당
alter user test_user1 quota 2m on system;        --quota : 몫 
/*  test_user1이 system 테이블스페이스에
    테이블을 생성할 수 있도록 2m(메가)의 용량을 할당한다. */
    
    
--2번째 사용자 추가 : 테이블스페이스 user를 사용할 수 있도록 생성.
create user test_user2 identified by 1234 default tablespace users;
--접속 권한 추가
grant create session to test_user2;
--테이블 생성 시도 1 => insufficient privileges : 권한불충분
--테이블 생성권한 추가
grant create table to test_user2;
--테이블 생성 시도 2 = > no privileges on tablespace 'USERS' : 테이블스페이스에 권한 없음.
--test_user2가 사용하는 테이블 스페이스를 확인.
select username, default_tablespace from dba_users
        where username in upper('test_user2');
--users 테이블 스페이스에 공간 할당
alter user test_user2 quota 10m on users;
--테이블 생성시도 3 => 성공


/*
생성된 사용자의 디폴트 테이블 스페이스를 변경하고 싶은 경우
    : test_user1의 디폴트 테이블 스페이스를 users로 변경한다.
*/
alter user test_user1 default tablespace user;

/*
3] 암호변경
    : alter table 사용자아이디 identified by 새로운암호;
*/
alter user test_user1 identified by 4321;