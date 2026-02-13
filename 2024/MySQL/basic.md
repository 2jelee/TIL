<h1>MySQL</h1>
[키워드 정리]

- MySQL 서버 : 데이터베이스 엔진을 운영하는 가장 중요한 프로그램
- MySQL 워크벤치 : MySQL 서버에 접속하기 위한 프로그램
- root : MySQL 관리자 이름 (가장 높은 권한의 사용자로 MySQL을 설치할 때 기본적으로 생성됨.)

[용어]

- MySQL : 대표적인 관계형 DBMS
- MariaDB : MySQL 초기 개발자가 오라클 社를 퇴사한 후 만든 DBMS. MySQL과 상당히 유사하여 완전 무료로 사용 可
- MySQL Server : MySQL의 여러 소프트웨어 중 엔진 기능을 하는 핵심 소프트웨어(DBMS)
- MySQL Workbench : MySQL 서버에 접속/연결하기 위한 클라이언트 도구. 이곳에 SQL문을 입력 및 실행

<br>
접속 : https://dev.mysql.com/downloads/windows/installer/8.0.html <br>
설치 : Windows (x86, 32-bit), MSI Installer
       (mysql-installer-community-8.0.27.1.msi) <br>
installing : <br>
<img src="https://user-images.githubusercontent.com/82863823/144197840-55f899f8-5e90-453c-9689-9c7c9b4c093a.png" />
<img src="https://user-images.githubusercontent.com/82863823/144199297-e31d841c-de67-44a8-9c8c-7075b5ee86bf.png" />

<h2>MySQL vs MariaDB</h2>

```
이 둘은 핵심 개발자가 같고 문법 또한 비슷하므로 자매 제품으로 보면 된다.
SQL도 MySQL과 MariaDB에서 모두 작동함.

MariaDB는 회사에서 상용으로 작업하는 것이 무료이므로 부담 없이 사용 O.

[단점]
- MySQL보다 인지도 ↓
- MySQL 워크벤치보다 기능이 부족한 HeidiSQL이라는 도구를 사용.

*사용방법은 MySQL 워크벤치와 비슷함.
```
MariaDB Download URL : https://mariaDB.org


SELECT
========================
구축이 완료된 테이블에서 데이터를 추출하는 기능을 한다.

기본 형식

```
[SELECT ~ FROM ~ WHERE]

SELECT 열
    FROM 테이블
    WHERE 조건식

SELECT 열_이름
    FROM 테이블_이름
    WHERE 조건식
    GROUP BY 열_이름
    HAVING 조건식
    ORDER BY 열_이름
    LIMIT 숫자
```

```
DROP DATABASE IF EXISTS market_db; -- 만약 market_db가 존재하면 우선 삭제한다.
CREATE DATABASE market_db;

USE market_db;
CREATE TABLE member -- 회원 테이블
( mem_id  		CHAR(8) NOT NULL PRIMARY KEY, -- 사용자 아이디(PK)
  mem_name    	VARCHAR(10) NOT NULL, -- 이름
  mem_number    INT NOT NULL,  -- 인원수
  addr	  		CHAR(2) NOT NULL, -- 지역(경기,서울,경남 식으로 2글자만입력)
  phone1		CHAR(3), -- 연락처의 국번(02, 031, 055 등)
  phone2		CHAR(8), -- 연락처의 나머지 전화번호(하이픈제외)
  height    	SMALLINT,  -- 평균 키
  debut_date	DATE  -- 데뷔 일자
);
CREATE TABLE buy -- 구매 테이블
(  num 		INT AUTO_INCREMENT NOT NULL PRIMARY KEY, -- 순번(PK)
   mem_id  	CHAR(8) NOT NULL, -- 아이디(FK)
   prod_name 	CHAR(6) NOT NULL, --  제품이름
   group_name 	CHAR(4)  , -- 분류
   price     	INT  NOT NULL, -- 가격
   amount    	SMALLINT  NOT NULL, -- 수량
   FOREIGN KEY (mem_id) REFERENCES member(mem_id)
);

INSERT INTO member VALUES('TWC', '트와이스', 9, '서울', '02', '11111111', 167, '2015.10.19');
INSERT INTO member VALUES('BLK', '블랙핑크', 4, '경남', '055', '22222222', 163, '2016.08.08');
INSERT INTO member VALUES('WMN', '여자친구', 6, '경기', '031', '33333333', 166, '2015.01.15');
INSERT INTO member VALUES('OMY', '오마이걸', 7, '서울', NULL, NULL, 160, '2015.04.21');
INSERT INTO member VALUES('GRL', '소녀시대', 8, '서울', '02', '44444444', 168, '2007.08.02');
INSERT INTO member VALUES('ITZ', '잇지', 5, '경남', NULL, NULL, 167, '2019.02.12');
INSERT INTO member VALUES('RED', '레드벨벳', 4, '경북', '054', '55555555', 161, '2014.08.01');
INSERT INTO member VALUES('APN', '에이핑크', 6, '경기', '031', '77777777', 164, '2011.02.10');
INSERT INTO member VALUES('SPC', '우주소녀', 13, '서울', '02', '88888888', 162, '2016.02.25');
INSERT INTO member VALUES('MMU', '마마무', 4, '전남', '061', '99999999', 165, '2014.06.19');

INSERT INTO buy VALUES(NULL, 'BLK', '지갑', NULL, 30, 2);
INSERT INTO buy VALUES(NULL, 'BLK', '맥북프로', '디지털', 1000, 1);
INSERT INTO buy VALUES(NULL, 'APN', '아이폰', '디지털', 200, 1);
INSERT INTO buy VALUES(NULL, 'MMU', '아이폰', '디지털', 200, 5);
INSERT INTO buy VALUES(NULL, 'BLK', '청바지', '패션', 50, 3);
INSERT INTO buy VALUES(NULL, 'MMU', '에어팟', '디지털', 80, 10);
INSERT INTO buy VALUES(NULL, 'GRL', '2jelee', '서적', 15, 5);
INSERT INTO buy VALUES(NULL, 'APN', '2jelee', '서적', 15, 2);
INSERT INTO buy VALUES(NULL, 'APN', '청바지', '패션', 50, 1);
INSERT INTO buy VALUES(NULL, 'MMU', '지갑', NULL, 30, 1);
INSERT INTO buy VALUES(NULL, 'APN', '2jelee', '서적', 15, 1);
INSERT INTO buy VALUES(NULL, 'MMU', '지갑', NULL, 30, 4);

SELECT * FROM member;
SELECT * FROM buy;
```

데이터베이스 생성

```
DROP DATABASE IF EXISTS market_db;
CREATE DATABASE market_db;
```

-------------------------------------
USE문

- SELECT 문을 실행하려면 먼저 사용할 데이터베이스를 지정해야 한다. 현재 사용하는 데이터베이스를 지정 or 변경하는 형식은 다음과 같음.

```
USE 데이터베이스_이름;
```
-------------------------------------

<h3>관계 연산자, 논리 연산자의 사용</h3>

```
SELECT mem_id, mem_name
    FROM member
    WHERE height <= 162;

SELECT mem_name, height, mem_number
    FROM member
    WHERE height >= 165 AND mem_number > 6;
```

<h3>BETWEEN ~ AND</h3>
AND를 사용해서 조회

```
SELECT mem_name, height
    FROM member
    WHERE height >= 163 AND <= 165;

↓

SELECT mem_name, height
    FROM member
    WHERE height BETWEEN 163 AND 165;

>> 숫자의 범위를 조건식에서 사용할 때는 BETWEEN ~ AND가 편리
```

<h3>IN()</h3>
평균 키와 같이 숫자로 구성된 데이터는 크다/작다의 범위를 지정할 수 있으므로 BETWEEN ~ AND를 사용할 수 있지만 <br>
주소와 같은 데이터는 문자로 표현되기 때문에 어느 범위에 들어있다고 표현할 수 X

```
SELECT mem_name, addr
    FROM member
    WHERE addr = '인천' OR addr = '서울' OR '경기';

↓

SELECT mem_name, addr
    FROM member
    WHERE addr IN('인천', '서울', '경기');

>> 조건식에서 여러 문자 중 하나에 포함되는지 비교할 때는 IN()이 간결
```

<h3>LIKE</h3>
문자열의 일부 글자를 검색할 때 사용.

```
SELECT *
    FROM member
    WHERE mem_name LIKE '우%';

>> 이 조건은 제일 앞 글자가 '우'이고 그 뒤는 무엇이든(%) 허용하겠다는 의미


SELECT *
    FROM member
    WHERE mem_name LIKE '__핑크';       --언더바 2개

>> 이 조건은 앞 두 글자는 상관없고 뒤는 '핑크'인 회원을 검색하겠다는 의미
```

<h2>서브쿼리</h2>
SELECT 안에는 또 다른 SELECT가 들어갈 수 있다. 이를 subquery 또는 하위 쿼리라고 부른다. <br>
[장점] <br>
2개의 SQL을 하나로 만듦으로써 하나의 SQL만 관리하면 되므로 더 간단해진다.

```
SELECT height FROM member WHERE mem_name = '투애니원';
+
SELECT mem_name, height FROM member WHERE height > 164;

SELECT mem_name, height FROM member
    WHERE height > (SELECT height FROM member WHERE mem_name = '투애니원');
```
