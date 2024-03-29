CREATE TABLE "GUESTBOOK" 
 (	"NUM" NUMBER, 
	"NAME" VARCHAR2(50 BYTE), 
	"EMAIL" VARCHAR2(50 BYTE), 
	"HOME" VARCHAR2(50 BYTE), 
	"CONTENTS" VARCHAR2(2000 BYTE)
   ) SEGMENT CREATION IMMEDIATE ;
 
SET DEFINE OFF;
Insert into GUESTBOOK (NUM,NAME,EMAIL,HOME,CONTENTS) values (1,'dd','kosta@kosta.or.kr','no','test test');
Insert into GUESTBOOK (NUM,NAME,EMAIL,HOME,CONTENTS) values (21,'doyeon','kosta@k.kr',null,'test test');
Insert into GUESTBOOK (NUM,NAME,EMAIL,HOME,CONTENTS) values (1,'1','kosta@kosta.or.kr','no','test test');
Insert into GUESTBOOK (NUM,NAME,EMAIL,HOME,CONTENTS) values (2,'hh','kingsmile@paran.com','no','test test');
Insert into GUESTBOOK (NUM,NAME,EMAIL,HOME,CONTENTS) values (6,'zzz','zzz','zxcv','연아');
Insert into GUESTBOOK (NUM,NAME,EMAIL,HOME,CONTENTS) values (7,'hong','hong','hong','hong');
Insert into GUESTBOOK (NUM,NAME,EMAIL,HOME,CONTENTS) values (8,'hansu','hansu@kk.com',null,'hi');
Insert into GUESTBOOK (NUM,NAME,EMAIL,HOME,CONTENTS) values (9,'yoo','yoo@hanmail.net',null,'연재');
Insert into GUESTBOOK (NUM,NAME,EMAIL,HOME,CONTENTS) values (10,'q','q','q','q');
Insert into GUESTBOOK (NUM,NAME,EMAIL,HOME,CONTENTS) values (11,'세종왕','pol813@naver.com','www.facebook.com/pol813','세종대왕이 지나가다 썻네.');
Insert into GUESTBOOK (NUM,NAME,EMAIL,HOME,CONTENTS) values (13,'44','44','44','44');
Insert into GUESTBOOK (NUM,NAME,EMAIL,HOME,CONTENTS) values (14,'55','55','55','555');
Insert into GUESTBOOK (NUM,NAME,EMAIL,HOME,CONTENTS) values (15,'66','66','66','66');
Insert into GUESTBOOK (NUM,NAME,EMAIL,HOME,CONTENTS) values (16,'77','77','77','77');
Insert into GUESTBOOK (NUM,NAME,EMAIL,HOME,CONTENTS) values (17,'88','88','88','88');
Insert into GUESTBOOK (NUM,NAME,EMAIL,HOME,CONTENTS) values (18,'99','99','99','99');
Insert into GUESTBOOK (NUM,NAME,EMAIL,HOME,CONTENTS) values (19,'길동','happydoyeon88@gamil.com','http://sw.or.kr','test test');
Insert into GUESTBOOK (NUM,NAME,EMAIL,HOME,CONTENTS) values (20,'99','99','99','99');
Insert into GUESTBOOK (NUM,NAME,EMAIL,HOME,CONTENTS) values (21,'77','77','77','77');
Insert into GUESTBOOK (NUM,NAME,EMAIL,HOME,CONTENTS) values (22,'1000','1000','1000','10000');
Insert into GUESTBOOK (NUM,NAME,EMAIL,HOME,CONTENTS) values (41,'99','99','99','99');
--------------------------------------------------------
--  Constraints for Table GUESTBOOK
--------------------------------------------------------
commit;
select * from guestbook;