/*********************************
파일명 : Or12Sequence & Index.sql
시퀀스 & 인덱스
설명 : 테이블의 기본키 필드에 순차적인 일련번호를 부여하는 시퀀스와 검색속도를 향상시킬 수 있는 인덱스
*********************************/

--study 계정에서 실습함.

/*
시퀀스 
    : 테이블의 컬럼에 중복되지 않는 순차적인 일련번호를 부여하는 역할을 함.
      항상 증가만 되고 감소는 되지 않는 특징을 가짐.
*/

--상품테이블 생성
create table tb_goods (
    g_idx number(10) primary key,
    g_name varchar2(30)
);
insert into tb_goods values (1, '새우깡');     --입력 성공
insert into tb_goods values (1, '양파깡');     --입력 실패

--시퀀스가 없다면 max() 함수를 통해 일련번호를 구해야된다.
select max(g_idx)+1 from tb_goods;
insert into tb_goods values (2, '양파깡');
/*
입력 전 함수를 통해 확인하는 것은 번거로우므로
시퀀스를 생성하여 입력 시 사용한다.
*/
create sequence seq_serial_num
    increment by 1      --증가치
    start with 100       --시작할 값
    minvalue 99          --최솟값
    maxvalue 110        --최댓값
    cycle                      --싸이클 사용여부(현재 사용함으로 지정함)
    nocache;                --캐시 사용여부(현재 사용안함으로 지정함)

--데이터 사전에서 생성한 시퀀스 확인
select * from user_sequences;

--시퀀스를 사용해서 데이터 입력
insert into tb_goods values (seq_serial_num.nextval, '고구마깡');
insert into tb_goods values (seq_serial_num.nextval, '홈런볼');
select * from tb_goods;

/*
    currval : 현재 시퀀스값을 반환한다.
    nextval : 다음 시퀀스를 반환한다.
*/
select seq_serial_num.currval from dual;
select seq_serial_num.nextval from dual;        --실행할 때마다 증가(최대값까지)

--10번이상 입력하면 PK제약조건 위배로 error가 발생!
insert into tb_goods values (seq_serial_num.nextval, '몽쉘통통');
select * from tb_goods;
/*
    시퀀스의 cycle 옵션에 의해 최댓값에 도달하면 다시 처음으로 돌아가서
    일련번호가 생성되므로 무결성 제약조건에 위배된다.
    즉, 기본키에 사용할 시퀀스는 cycle 옵션을 사용하면 안된다. ☆☆
*/

--시퀀스 수정하기 (alter)
alter sequence seq_serial_num
    increment by 10
    nomaxvalue      --maxvalue를 사용하지 않겠다.   >> sequence가 표현할 수 있는 가장 최대의 값을 쓰겠다는 의미. 
                              --시퀀스가 표현할 수 있는 최대치를 사용하겠다는 의미임.
    minvalue 1
    nocycle
    nocache;           --start with는 수정할 수 없다.
select seq_serial_num.currval from dual;

--시퀀스 삭제하기
drop sequence seq_serial_num;
select * from user_sequences;

--일반적인 시퀀스 생성은 아래와 같이 한다.
create sequence seq_serial_num
    increment by 1
    start with 1
    minvalue 1
    nomaxvalue
    nocycle
    nocache; /*
            최대값, 싸이클, 캐쉬는 일반적으로 사용하지 않는다.
    */
select * from user_sequences;

select seq_serial_num.currval from dual;        --최초 실행시는 안됨. 무조건 nextval를 한 후 실행 해야한다.
select seq_serial_num.nextval from dual;
/*
시퀀스 생성 후 최초 실행시에는 currval(current value?)은 에러가 발생함.
nextval을 먼저 실행하여 시퀀스값을 반환한 후 currval을 실행했을 때 마지막 시퀀스가 반환된다.
*/

--상품 테이블에 새로운 컬럼을 추가
alter table tb_goods add re_idx number;
select * from tb_goods;

/*
동일 쿼리문 내에서는 nextval을 여러번 사용하더라도 항상 같은 값만 반환한다.
*/
insert into tb_goods values (seq_serial_num.nextval,
        '노트북', seq_serial_num.nextval);     --한 문장에 next val를 2번 실행한다?   <<여러번 사용하더라도 항상 같은 값만 반환한다.
select * from tb_goods;
        

/*
인덱스 : 행의 검색속도를 향상시킬 목적으로 생성하는 개체
    primary key, unique로 지정된 컬럼에는 자동으로 index가 생성됨.
*/
--인덱스 생성
create index tb_goods_name_idx on tb_goods (g_name);

--데이터 사전에서 확인하기
select * from user_ind_columns;

--인덱스 삭제
drop index tb_goods_name_idx;

--인덱스는 수정이 불가능하므로 만약 수정이 필요하다면 삭제 후 다시 생성한다.