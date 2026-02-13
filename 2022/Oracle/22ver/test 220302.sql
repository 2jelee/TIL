--정규식 표현
select * from reg_test;
/*
문자열(또는 문자열 포함 필드명), 패턴, [옵션] i: 대소문자 구분 X
*/
select * from reg_test where REGEXP_LIKE (text, '([aeiou])\1', 'i');


-- [ 과 ] 사이에 있는 문자들 중 하나
select * from reg_test where REGEXP_LIKE (text, '([abc])');

--소문자 a~z 공백 숫자
select * from reg_test
    where regexp_like(text, '[a-z] [0-9]');

insert into reg_test values('789ABC');
insert into reg_test values('789 ABC');
insert into reg_test values('123kbs');
insert into reg_test values('mbc567');
insert into reg_test values('sbs 123');

select * from reg_test;

--소문자나 공백이나 숫자가 들어가는 것
select * from reg_test where regexp_like(text, '[a-z]?[0-9]'); --대소문자 구분 X [?]
select * from reg_test where regexp_like(text, '[0-9]?[a-z]');
select * from reg_test where regexp_like(text, '[A-Z]*[0-9]'); --대소문자 구분 X [*]
select * from reg_test where regexp_like(text, '[A-Z]?[0-9]');
select * from reg_test where regexp_like(text, '[0-9]?[A-Z]'); --(text, '[0-9]?[a-z]');와 구분하기

rollback;



create user jel
  identified by xxxxxxAt22cc
  default tablespace data   --data영역
  temporary tablespace temp --temp영역
  quota 10G on data;
  
--접속, 조작 권한 부여
grant connect, resource to jel;

--drop user jel;

--lock 해제
alter user jel account unlock; 

--계정생성과 lock 해제 동시에
create user jel identified by xxxxxxAt22cc account unlock;

show user;