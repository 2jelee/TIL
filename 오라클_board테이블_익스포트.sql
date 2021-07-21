--------------------------------------------------------
--  파일이 생성됨 - 금요일-6월-04-2021   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table BOARD
--------------------------------------------------------

  CREATE TABLE "KOSMO"."BOARD" 
   (	"NUM" NUMBER, 
	"TITLE" VARCHAR2(200 BYTE), 
	"CONTENT" VARCHAR2(2000 BYTE), 
	"ID" VARCHAR2(30 BYTE), 
	"POSTDATE" DATE DEFAULT sysdate, 
	"VISITCOUNT" NUMBER DEFAULT 0
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
REM INSERTING into KOSMO.BOARD
SET DEFINE OFF;
Insert into KOSMO.BOARD (NUM,TITLE,CONTENT,ID,POSTDATE,VISITCOUNT) values (19,'제목1입니다','내용1입니다','kosmo',to_date('21/05/18','RR/MM/DD'),15);
Insert into KOSMO.BOARD (NUM,TITLE,CONTENT,ID,POSTDATE,VISITCOUNT) values (20,'20번 게시물 수정합니다.','수정되었나요?','kosmo',to_date('21/05/18','RR/MM/DD'),7);
Insert into KOSMO.BOARD (NUM,TITLE,CONTENT,ID,POSTDATE,VISITCOUNT) values (21,'제목3입니다','내용3입니다','kosmo',to_date('21/05/18','RR/MM/DD'),3);
Insert into KOSMO.BOARD (NUM,TITLE,CONTENT,ID,POSTDATE,VISITCOUNT) values (22,'제목4입니다','내용4입니다','kosmo',to_date('21/05/18','RR/MM/DD'),10);
Insert into KOSMO.BOARD (NUM,TITLE,CONTENT,ID,POSTDATE,VISITCOUNT) values (23,'제목5입니다','내용5입니다','kosmo',to_date('21/05/18','RR/MM/DD'),4);
Insert into KOSMO.BOARD (NUM,TITLE,CONTENT,ID,POSTDATE,VISITCOUNT) values (24,'dd','ddd','kosmo',to_date('21/05/18','RR/MM/DD'),4);
Insert into KOSMO.BOARD (NUM,TITLE,CONTENT,ID,POSTDATE,VISITCOUNT) values (27,'1번째 페이지 테스트 게시물','페이지 테스트 게시물
','kosmo',to_date('21/05/20','RR/MM/DD'),0);
Insert into KOSMO.BOARD (NUM,TITLE,CONTENT,ID,POSTDATE,VISITCOUNT) values (26,'test','test','test',to_date('21/05/20','RR/MM/DD'),2);
Insert into KOSMO.BOARD (NUM,TITLE,CONTENT,ID,POSTDATE,VISITCOUNT) values (28,'2번째 페이지 테스트 게시물','페이지 테스트 게시물
','kosmo',to_date('21/05/20','RR/MM/DD'),0);
Insert into KOSMO.BOARD (NUM,TITLE,CONTENT,ID,POSTDATE,VISITCOUNT) values (29,'3번째 페이지 테스트 게시물','페이지 테스트 게시물
','kosmo',to_date('21/05/20','RR/MM/DD'),0);
Insert into KOSMO.BOARD (NUM,TITLE,CONTENT,ID,POSTDATE,VISITCOUNT) values (30,'4번째 페이지 테스트 게시물','페이지 테스트 게시물
','kosmo',to_date('21/05/20','RR/MM/DD'),0);
Insert into KOSMO.BOARD (NUM,TITLE,CONTENT,ID,POSTDATE,VISITCOUNT) values (31,'5번째 페이지 테스트 게시물','페이지 테스트 게시물
','kosmo',to_date('21/05/20','RR/MM/DD'),0);
Insert into KOSMO.BOARD (NUM,TITLE,CONTENT,ID,POSTDATE,VISITCOUNT) values (32,'6번째 페이지 테스트 게시물','페이지 테스트 게시물
','kosmo',to_date('21/05/20','RR/MM/DD'),0);
Insert into KOSMO.BOARD (NUM,TITLE,CONTENT,ID,POSTDATE,VISITCOUNT) values (33,'7번째 페이지 테스트 게시물','페이지 테스트 게시물
','kosmo',to_date('21/05/20','RR/MM/DD'),0);
Insert into KOSMO.BOARD (NUM,TITLE,CONTENT,ID,POSTDATE,VISITCOUNT) values (34,'8번째 페이지 테스트 게시물','페이지 테스트 게시물
','kosmo',to_date('21/05/20','RR/MM/DD'),0);
Insert into KOSMO.BOARD (NUM,TITLE,CONTENT,ID,POSTDATE,VISITCOUNT) values (35,'9번째 페이지 테스트 게시물','페이지 테스트 게시물
','kosmo',to_date('21/05/20','RR/MM/DD'),0);
Insert into KOSMO.BOARD (NUM,TITLE,CONTENT,ID,POSTDATE,VISITCOUNT) values (36,'10번째 페이지 테스트 게시물','페이지 테스트 게시물
','kosmo',to_date('21/05/20','RR/MM/DD'),0);
Insert into KOSMO.BOARD (NUM,TITLE,CONTENT,ID,POSTDATE,VISITCOUNT) values (37,'11번째 페이지 테스트 게시물','페이지 테스트 게시물
','kosmo',to_date('21/05/20','RR/MM/DD'),0);
Insert into KOSMO.BOARD (NUM,TITLE,CONTENT,ID,POSTDATE,VISITCOUNT) values (38,'12번째 페이지 테스트 게시물','페이지 테스트 게시물
','kosmo',to_date('21/05/20','RR/MM/DD'),0);
Insert into KOSMO.BOARD (NUM,TITLE,CONTENT,ID,POSTDATE,VISITCOUNT) values (39,'13번째 페이지 테스트 게시물','페이지 테스트 게시물
','kosmo',to_date('21/05/20','RR/MM/DD'),0);
Insert into KOSMO.BOARD (NUM,TITLE,CONTENT,ID,POSTDATE,VISITCOUNT) values (40,'14번째 페이지 테스트 게시물','페이지 테스트 게시물
','kosmo',to_date('21/05/20','RR/MM/DD'),0);
Insert into KOSMO.BOARD (NUM,TITLE,CONTENT,ID,POSTDATE,VISITCOUNT) values (41,'15번째 페이지 테스트 게시물','페이지 테스트 게시물
','kosmo',to_date('21/05/20','RR/MM/DD'),0);
Insert into KOSMO.BOARD (NUM,TITLE,CONTENT,ID,POSTDATE,VISITCOUNT) values (42,'16번째 페이지 테스트 게시물','페이지 테스트 게시물
','kosmo',to_date('21/05/20','RR/MM/DD'),0);
Insert into KOSMO.BOARD (NUM,TITLE,CONTENT,ID,POSTDATE,VISITCOUNT) values (43,'17번째 페이지 테스트 게시물','페이지 테스트 게시물
','kosmo',to_date('21/05/20','RR/MM/DD'),1);
Insert into KOSMO.BOARD (NUM,TITLE,CONTENT,ID,POSTDATE,VISITCOUNT) values (44,'18번째 페이지 테스트 게시물','페이지 테스트 게시물
','kosmo',to_date('21/05/20','RR/MM/DD'),0);
Insert into KOSMO.BOARD (NUM,TITLE,CONTENT,ID,POSTDATE,VISITCOUNT) values (45,'19번째 페이지 테스트 게시물','페이지 테스트 게시물
','kosmo',to_date('21/05/20','RR/MM/DD'),0);
Insert into KOSMO.BOARD (NUM,TITLE,CONTENT,ID,POSTDATE,VISITCOUNT) values (46,'20번째 페이지 테스트 게시물','페이지 테스트 게시물
','kosmo',to_date('21/05/20','RR/MM/DD'),0);
Insert into KOSMO.BOARD (NUM,TITLE,CONTENT,ID,POSTDATE,VISITCOUNT) values (47,'21번째 페이지 테스트 게시물','페이지 테스트 게시물
','kosmo',to_date('21/05/20','RR/MM/DD'),0);
Insert into KOSMO.BOARD (NUM,TITLE,CONTENT,ID,POSTDATE,VISITCOUNT) values (48,'22번째 페이지 테스트 게시물','페이지 테스트 게시물
','kosmo',to_date('21/05/20','RR/MM/DD'),0);
Insert into KOSMO.BOARD (NUM,TITLE,CONTENT,ID,POSTDATE,VISITCOUNT) values (49,'23번째 페이지 테스트 게시물','페이지 테스트 게시물
','kosmo',to_date('21/05/20','RR/MM/DD'),0);
Insert into KOSMO.BOARD (NUM,TITLE,CONTENT,ID,POSTDATE,VISITCOUNT) values (50,'24번째 페이지 테스트 게시물','페이지 테스트 게시물
','kosmo',to_date('21/05/20','RR/MM/DD'),0);
Insert into KOSMO.BOARD (NUM,TITLE,CONTENT,ID,POSTDATE,VISITCOUNT) values (51,'25번째 페이지 테스트 게시물','페이지 테스트 게시물
','kosmo',to_date('21/05/20','RR/MM/DD'),0);
Insert into KOSMO.BOARD (NUM,TITLE,CONTENT,ID,POSTDATE,VISITCOUNT) values (52,'26번째 페이지 테스트 게시물','페이지 테스트 게시물
','kosmo',to_date('21/05/20','RR/MM/DD'),0);
Insert into KOSMO.BOARD (NUM,TITLE,CONTENT,ID,POSTDATE,VISITCOUNT) values (53,'27번째 페이지 테스트 게시물','페이지 테스트 게시물
','kosmo',to_date('21/05/20','RR/MM/DD'),0);
Insert into KOSMO.BOARD (NUM,TITLE,CONTENT,ID,POSTDATE,VISITCOUNT) values (54,'28번째 페이지 테스트 게시물','페이지 테스트 게시물
','kosmo',to_date('21/05/20','RR/MM/DD'),0);
Insert into KOSMO.BOARD (NUM,TITLE,CONTENT,ID,POSTDATE,VISITCOUNT) values (55,'29번째 페이지 테스트 게시물','페이지 테스트 게시물
','kosmo',to_date('21/05/20','RR/MM/DD'),0);
Insert into KOSMO.BOARD (NUM,TITLE,CONTENT,ID,POSTDATE,VISITCOUNT) values (56,'30번째 페이지 테스트 게시물','페이지 테스트 게시물
','kosmo',to_date('21/05/20','RR/MM/DD'),0);
Insert into KOSMO.BOARD (NUM,TITLE,CONTENT,ID,POSTDATE,VISITCOUNT) values (57,'31번째 페이지 테스트 게시물','페이지 테스트 게시물
','kosmo',to_date('21/05/20','RR/MM/DD'),0);
Insert into KOSMO.BOARD (NUM,TITLE,CONTENT,ID,POSTDATE,VISITCOUNT) values (58,'32번째 페이지 테스트 게시물','페이지 테스트 게시물
','kosmo',to_date('21/05/20','RR/MM/DD'),0);
Insert into KOSMO.BOARD (NUM,TITLE,CONTENT,ID,POSTDATE,VISITCOUNT) values (59,'33번째 페이지 테스트 게시물','페이지 테스트 게시물
','kosmo',to_date('21/05/20','RR/MM/DD'),0);
Insert into KOSMO.BOARD (NUM,TITLE,CONTENT,ID,POSTDATE,VISITCOUNT) values (60,'34번째 페이지 테스트 게시물','페이지 테스트 게시물
','kosmo',to_date('21/05/20','RR/MM/DD'),0);
Insert into KOSMO.BOARD (NUM,TITLE,CONTENT,ID,POSTDATE,VISITCOUNT) values (61,'35번째 페이지 테스트 게시물','페이지 테스트 게시물
','kosmo',to_date('21/05/20','RR/MM/DD'),0);
Insert into KOSMO.BOARD (NUM,TITLE,CONTENT,ID,POSTDATE,VISITCOUNT) values (62,'36번째 페이지 테스트 게시물','페이지 테스트 게시물
','kosmo',to_date('21/05/20','RR/MM/DD'),0);
Insert into KOSMO.BOARD (NUM,TITLE,CONTENT,ID,POSTDATE,VISITCOUNT) values (63,'37번째 페이지 테스트 게시물','페이지 테스트 게시물
','kosmo',to_date('21/05/20','RR/MM/DD'),0);
Insert into KOSMO.BOARD (NUM,TITLE,CONTENT,ID,POSTDATE,VISITCOUNT) values (64,'38번째 페이지 테스트 게시물','페이지 테스트 게시물
','kosmo',to_date('21/05/20','RR/MM/DD'),0);
Insert into KOSMO.BOARD (NUM,TITLE,CONTENT,ID,POSTDATE,VISITCOUNT) values (65,'39번째 페이지 테스트 게시물','페이지 테스트 게시물
','kosmo',to_date('21/05/20','RR/MM/DD'),0);
Insert into KOSMO.BOARD (NUM,TITLE,CONTENT,ID,POSTDATE,VISITCOUNT) values (66,'40번째 페이지 테스트 게시물','페이지 테스트 게시물
','kosmo',to_date('21/05/20','RR/MM/DD'),0);
Insert into KOSMO.BOARD (NUM,TITLE,CONTENT,ID,POSTDATE,VISITCOUNT) values (67,'41번째 페이지 테스트 게시물','페이지 테스트 게시물
','kosmo',to_date('21/05/20','RR/MM/DD'),0);
Insert into KOSMO.BOARD (NUM,TITLE,CONTENT,ID,POSTDATE,VISITCOUNT) values (68,'42번째 페이지 테스트 게시물','페이지 테스트 게시물
','kosmo',to_date('21/05/20','RR/MM/DD'),0);
Insert into KOSMO.BOARD (NUM,TITLE,CONTENT,ID,POSTDATE,VISITCOUNT) values (69,'43번째 페이지 테스트 게시물','페이지 테스트 게시물
','kosmo',to_date('21/05/20','RR/MM/DD'),0);
Insert into KOSMO.BOARD (NUM,TITLE,CONTENT,ID,POSTDATE,VISITCOUNT) values (70,'44번째 페이지 테스트 게시물','페이지 테스트 게시물
','kosmo',to_date('21/05/20','RR/MM/DD'),0);
Insert into KOSMO.BOARD (NUM,TITLE,CONTENT,ID,POSTDATE,VISITCOUNT) values (71,'45번째 페이지 테스트 게시물','페이지 테스트 게시물
','kosmo',to_date('21/05/20','RR/MM/DD'),0);
Insert into KOSMO.BOARD (NUM,TITLE,CONTENT,ID,POSTDATE,VISITCOUNT) values (72,'46번째 페이지 테스트 게시물','페이지 테스트 게시물
','kosmo',to_date('21/05/20','RR/MM/DD'),0);
Insert into KOSMO.BOARD (NUM,TITLE,CONTENT,ID,POSTDATE,VISITCOUNT) values (73,'47번째 페이지 테스트 게시물','페이지 테스트 게시물
','kosmo',to_date('21/05/20','RR/MM/DD'),1);
Insert into KOSMO.BOARD (NUM,TITLE,CONTENT,ID,POSTDATE,VISITCOUNT) values (74,'48번째 페이지 테스트 게시물','페이지 테스트 게시물
','kosmo',to_date('21/05/20','RR/MM/DD'),0);
Insert into KOSMO.BOARD (NUM,TITLE,CONTENT,ID,POSTDATE,VISITCOUNT) values (75,'49번째 페이지 테스트 게시물','페이지 테스트 게시물
','kosmo',to_date('21/05/20','RR/MM/DD'),0);
Insert into KOSMO.BOARD (NUM,TITLE,CONTENT,ID,POSTDATE,VISITCOUNT) values (76,'50번째 페이지 테스트 게시물','페이지 테스트 게시물
','kosmo',to_date('21/05/20','RR/MM/DD'),0);
Insert into KOSMO.BOARD (NUM,TITLE,CONTENT,ID,POSTDATE,VISITCOUNT) values (77,'51번째 페이지 테스트 게시물','페이지 테스트 게시물
','kosmo',to_date('21/05/20','RR/MM/DD'),0);
Insert into KOSMO.BOARD (NUM,TITLE,CONTENT,ID,POSTDATE,VISITCOUNT) values (78,'52번째 페이지 테스트 게시물','페이지 테스트 게시물
','kosmo',to_date('21/05/20','RR/MM/DD'),3);
Insert into KOSMO.BOARD (NUM,TITLE,CONTENT,ID,POSTDATE,VISITCOUNT) values (79,'53번째 페이지 테스트 게시물','페이지 테스트 게시물
','kosmo',to_date('21/05/20','RR/MM/DD'),0);
Insert into KOSMO.BOARD (NUM,TITLE,CONTENT,ID,POSTDATE,VISITCOUNT) values (80,'54번째 페이지 테스트 게시물','페이지 테스트 게시물
','kosmo',to_date('21/05/20','RR/MM/DD'),0);
Insert into KOSMO.BOARD (NUM,TITLE,CONTENT,ID,POSTDATE,VISITCOUNT) values (81,'55번째 페이지 테스트 게시물','페이지 테스트 게시물
','kosmo',to_date('21/05/20','RR/MM/DD'),0);
Insert into KOSMO.BOARD (NUM,TITLE,CONTENT,ID,POSTDATE,VISITCOUNT) values (82,'56번째 페이지 테스트 게시물','페이지 테스트 게시물
','kosmo',to_date('21/05/20','RR/MM/DD'),0);
Insert into KOSMO.BOARD (NUM,TITLE,CONTENT,ID,POSTDATE,VISITCOUNT) values (83,'57번째 페이지 테스트 게시물','페이지 테스트 게시물
','kosmo',to_date('21/05/20','RR/MM/DD'),1);
Insert into KOSMO.BOARD (NUM,TITLE,CONTENT,ID,POSTDATE,VISITCOUNT) values (84,'58번째 페이지 테스트 게시물','페이지 테스트 게시물
','kosmo',to_date('21/05/20','RR/MM/DD'),0);
Insert into KOSMO.BOARD (NUM,TITLE,CONTENT,ID,POSTDATE,VISITCOUNT) values (85,'59번째 페이지 테스트 게시물','페이지 테스트 게시물
','kosmo',to_date('21/05/20','RR/MM/DD'),4);
Insert into KOSMO.BOARD (NUM,TITLE,CONTENT,ID,POSTDATE,VISITCOUNT) values (86,'60번째 페이지 테스트 게시물','페이지 테스트 게시물
','kosmo',to_date('21/05/20','RR/MM/DD'),0);
Insert into KOSMO.BOARD (NUM,TITLE,CONTENT,ID,POSTDATE,VISITCOUNT) values (87,'61번째 페이지 테스트 게시물','페이지 테스트 게시물
','kosmo',to_date('21/05/20','RR/MM/DD'),2);
Insert into KOSMO.BOARD (NUM,TITLE,CONTENT,ID,POSTDATE,VISITCOUNT) values (88,'62번째 페이지 테스트 게시물','페이지 테스트 게시물
','kosmo',to_date('21/05/20','RR/MM/DD'),3);
Insert into KOSMO.BOARD (NUM,TITLE,CONTENT,ID,POSTDATE,VISITCOUNT) values (89,'63번째 페이지 테스트 게시물','페이지 테스트 게시물
','kosmo',to_date('21/05/20','RR/MM/DD'),0);
Insert into KOSMO.BOARD (NUM,TITLE,CONTENT,ID,POSTDATE,VISITCOUNT) values (90,'64번째 페이지 테스트 게시물','페이지 테스트 게시물
','kosmo',to_date('21/05/20','RR/MM/DD'),0);
Insert into KOSMO.BOARD (NUM,TITLE,CONTENT,ID,POSTDATE,VISITCOUNT) values (91,'65번째 페이지 테스트 게시물','페이지 테스트 게시물
','kosmo',to_date('21/05/20','RR/MM/DD'),0);
Insert into KOSMO.BOARD (NUM,TITLE,CONTENT,ID,POSTDATE,VISITCOUNT) values (92,'66번째 페이지 테스트 게시물','페이지 테스트 게시물
','kosmo',to_date('21/05/20','RR/MM/DD'),0);
Insert into KOSMO.BOARD (NUM,TITLE,CONTENT,ID,POSTDATE,VISITCOUNT) values (93,'67번째 페이지 테스트 게시물','페이지 테스트 게시물
','kosmo',to_date('21/05/20','RR/MM/DD'),2);
Insert into KOSMO.BOARD (NUM,TITLE,CONTENT,ID,POSTDATE,VISITCOUNT) values (94,'68번째 페이지 테스트 게시물','페이지 테스트 게시물
','kosmo',to_date('21/05/20','RR/MM/DD'),0);
Insert into KOSMO.BOARD (NUM,TITLE,CONTENT,ID,POSTDATE,VISITCOUNT) values (95,'69번째 페이지 테스트 게시물','페이지 테스트 게시물
','kosmo',to_date('21/05/20','RR/MM/DD'),2);
Insert into KOSMO.BOARD (NUM,TITLE,CONTENT,ID,POSTDATE,VISITCOUNT) values (96,'70번째 페이지 테스트 게시물','페이지 테스트 게시물
','kosmo',to_date('21/05/20','RR/MM/DD'),0);
Insert into KOSMO.BOARD (NUM,TITLE,CONTENT,ID,POSTDATE,VISITCOUNT) values (97,'71번째 페이지 테스트 게시물','페이지 테스트 게시물
','kosmo',to_date('21/05/20','RR/MM/DD'),0);
Insert into KOSMO.BOARD (NUM,TITLE,CONTENT,ID,POSTDATE,VISITCOUNT) values (98,'72번째 페이지 테스트 게시물','페이지 테스트 게시물
','kosmo',to_date('21/05/20','RR/MM/DD'),6);
Insert into KOSMO.BOARD (NUM,TITLE,CONTENT,ID,POSTDATE,VISITCOUNT) values (99,'73번째 페이지 테스트 게시물','페이지 테스트 게시물
','kosmo',to_date('21/05/20','RR/MM/DD'),0);
Insert into KOSMO.BOARD (NUM,TITLE,CONTENT,ID,POSTDATE,VISITCOUNT) values (100,'74번째 페이지 테스트 게시물','페이지 테스트 게시물
','kosmo',to_date('21/05/20','RR/MM/DD'),0);
Insert into KOSMO.BOARD (NUM,TITLE,CONTENT,ID,POSTDATE,VISITCOUNT) values (101,'75번째 페이지 테스트 게시물','페이지 테스트 게시물
','kosmo',to_date('21/05/20','RR/MM/DD'),0);
Insert into KOSMO.BOARD (NUM,TITLE,CONTENT,ID,POSTDATE,VISITCOUNT) values (102,'76번째 페이지 테스트 게시물','페이지 테스트 게시물
','kosmo',to_date('21/05/20','RR/MM/DD'),0);
Insert into KOSMO.BOARD (NUM,TITLE,CONTENT,ID,POSTDATE,VISITCOUNT) values (103,'77번째 페이지 테스트 게시물','페이지 테스트 게시물
','kosmo',to_date('21/05/20','RR/MM/DD'),3);
Insert into KOSMO.BOARD (NUM,TITLE,CONTENT,ID,POSTDATE,VISITCOUNT) values (104,'78번째 페이지 테스트 게시물','페이지 테스트 게시물
','kosmo',to_date('21/05/20','RR/MM/DD'),0);
Insert into KOSMO.BOARD (NUM,TITLE,CONTENT,ID,POSTDATE,VISITCOUNT) values (105,'79번째 페이지 테스트 게시물','페이지 테스트 게시물
','kosmo',to_date('21/05/20','RR/MM/DD'),4);
Insert into KOSMO.BOARD (NUM,TITLE,CONTENT,ID,POSTDATE,VISITCOUNT) values (106,'80번째 페이지 테스트 게시물','페이지 테스트 게시물
','kosmo',to_date('21/05/20','RR/MM/DD'),0);
Insert into KOSMO.BOARD (NUM,TITLE,CONTENT,ID,POSTDATE,VISITCOUNT) values (107,'81번째 페이지 테스트 게시물','페이지 테스트 게시물
','kosmo',to_date('21/05/20','RR/MM/DD'),0);
Insert into KOSMO.BOARD (NUM,TITLE,CONTENT,ID,POSTDATE,VISITCOUNT) values (108,'82번째 페이지 테스트 게시물','페이지 테스트 게시물
','kosmo',to_date('21/05/20','RR/MM/DD'),2);
Insert into KOSMO.BOARD (NUM,TITLE,CONTENT,ID,POSTDATE,VISITCOUNT) values (109,'83번째 페이지 테스트 게시물','페이지 테스트 게시물
','kosmo',to_date('21/05/20','RR/MM/DD'),0);
Insert into KOSMO.BOARD (NUM,TITLE,CONTENT,ID,POSTDATE,VISITCOUNT) values (110,'84번째 페이지 테스트 게시물','페이지 테스트 게시물
','kosmo',to_date('21/05/20','RR/MM/DD'),0);
Insert into KOSMO.BOARD (NUM,TITLE,CONTENT,ID,POSTDATE,VISITCOUNT) values (111,'85번째 페이지 테스트 게시물','페이지 테스트 게시물
','kosmo',to_date('21/05/20','RR/MM/DD'),0);
Insert into KOSMO.BOARD (NUM,TITLE,CONTENT,ID,POSTDATE,VISITCOUNT) values (112,'86번째 페이지 테스트 게시물','페이지 테스트 게시물
','kosmo',to_date('21/05/20','RR/MM/DD'),0);
Insert into KOSMO.BOARD (NUM,TITLE,CONTENT,ID,POSTDATE,VISITCOUNT) values (113,'87번째 페이지 테스트 게시물','페이지 테스트 게시물
','kosmo',to_date('21/05/20','RR/MM/DD'),5);
Insert into KOSMO.BOARD (NUM,TITLE,CONTENT,ID,POSTDATE,VISITCOUNT) values (114,'88번째 페이지 테스트 게시물','페이지 테스트 게시물
','kosmo',to_date('21/05/20','RR/MM/DD'),0);
Insert into KOSMO.BOARD (NUM,TITLE,CONTENT,ID,POSTDATE,VISITCOUNT) values (115,'89번째 페이지 테스트 게시물','페이지 테스트 게시물
','kosmo',to_date('21/05/20','RR/MM/DD'),7);
Insert into KOSMO.BOARD (NUM,TITLE,CONTENT,ID,POSTDATE,VISITCOUNT) values (116,'90번째 페이지 테스트 게시물','페이지 테스트 게시물
','kosmo',to_date('21/05/20','RR/MM/DD'),0);
Insert into KOSMO.BOARD (NUM,TITLE,CONTENT,ID,POSTDATE,VISITCOUNT) values (117,'91번째 페이지 테스트 게시물','페이지 테스트 게시물
','kosmo',to_date('21/05/20','RR/MM/DD'),0);
Insert into KOSMO.BOARD (NUM,TITLE,CONTENT,ID,POSTDATE,VISITCOUNT) values (118,'92번째 페이지 테스트 게시물','페이지 테스트 게시물
','kosmo',to_date('21/05/20','RR/MM/DD'),3);
Insert into KOSMO.BOARD (NUM,TITLE,CONTENT,ID,POSTDATE,VISITCOUNT) values (119,'93번째 페이지 테스트 게시물','페이지 테스트 게시물
','kosmo',to_date('21/05/20','RR/MM/DD'),0);
Insert into KOSMO.BOARD (NUM,TITLE,CONTENT,ID,POSTDATE,VISITCOUNT) values (120,'94번째 페이지 테스트 게시물','페이지 테스트 게시물
','kosmo',to_date('21/05/20','RR/MM/DD'),0);
Insert into KOSMO.BOARD (NUM,TITLE,CONTENT,ID,POSTDATE,VISITCOUNT) values (121,'95번째 페이지 테스트 게시물','페이지 테스트 게시물
','kosmo',to_date('21/05/20','RR/MM/DD'),0);
Insert into KOSMO.BOARD (NUM,TITLE,CONTENT,ID,POSTDATE,VISITCOUNT) values (122,'96번째 페이지 테스트 게시물','페이지 테스트 게시물
','kosmo',to_date('21/05/20','RR/MM/DD'),0);
Insert into KOSMO.BOARD (NUM,TITLE,CONTENT,ID,POSTDATE,VISITCOUNT) values (123,'97번째 페이지 테스트 게시물','페이지 테스트 게시물
','kosmo',to_date('21/05/20','RR/MM/DD'),7);
Insert into KOSMO.BOARD (NUM,TITLE,CONTENT,ID,POSTDATE,VISITCOUNT) values (124,'98번째 페이지 테스트 게시물','페이지 테스트 게시물
','kosmo',to_date('21/05/20','RR/MM/DD'),1);
Insert into KOSMO.BOARD (NUM,TITLE,CONTENT,ID,POSTDATE,VISITCOUNT) values (125,'99번째 페이지 테스트 게시물','페이지 테스트 게시물
','kosmo',to_date('21/05/20','RR/MM/DD'),11);
Insert into KOSMO.BOARD (NUM,TITLE,CONTENT,ID,POSTDATE,VISITCOUNT) values (126,'100번째 페이지 테스트 게시물','페이지 테스트 게시물
','kosmo',to_date('21/05/20','RR/MM/DD'),1);
Insert into KOSMO.BOARD (NUM,TITLE,CONTENT,ID,POSTDATE,VISITCOUNT) values (127,'1개만 입력이 잘되나요?','1개','kosmo',to_date('21/05/20','RR/MM/DD'),4);
--------------------------------------------------------
--  DDL for Index SYS_C007251
--------------------------------------------------------

  CREATE UNIQUE INDEX "KOSMO"."SYS_C007251" ON "KOSMO"."BOARD" ("NUM") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  Constraints for Table BOARD
--------------------------------------------------------

  ALTER TABLE "KOSMO"."BOARD" ADD PRIMARY KEY ("NUM")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
  ALTER TABLE "KOSMO"."BOARD" MODIFY ("VISITCOUNT" NOT NULL ENABLE);
  ALTER TABLE "KOSMO"."BOARD" MODIFY ("POSTDATE" NOT NULL ENABLE);
  ALTER TABLE "KOSMO"."BOARD" MODIFY ("ID" NOT NULL ENABLE);
  ALTER TABLE "KOSMO"."BOARD" MODIFY ("CONTENT" NOT NULL ENABLE);
  ALTER TABLE "KOSMO"."BOARD" MODIFY ("TITLE" NOT NULL ENABLE);
--------------------------------------------------------
--  Ref Constraints for Table BOARD
--------------------------------------------------------

  ALTER TABLE "KOSMO"."BOARD" ADD CONSTRAINT "BOARD_MEMBER_FK" FOREIGN KEY ("ID")
	  REFERENCES "KOSMO"."MEMBER" ("ID") ENABLE;
