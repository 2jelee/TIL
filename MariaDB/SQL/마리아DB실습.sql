SHOW TABLES;

/*
블럭단위 주석
*/

#라인단위 주석



/*******
데이터 타입의 종류
	1. 숫자형
*******/
CREATE TABLE tb_int (
	idx INT PRIMARY KEY AUTO_INCREMENT,
	
	num1 TINYINT UNSIGNED NOT NULL,
	num2 SMALLINT NOT NULL,
	num3 MEDIUMINT DEFAULT '100',
	num4 BIGINT,
	
	fnum1 FLOAT(10,5) NOT NULL,
	fnum2 DOUBLE(20,10)
);
/*
	AUTO_INCREMENT : 테이블 생성시 자동증가 컬럼으로,
		지정할때 사용하는 제약조건.
		오라클은 테이블과 별도로 시퀀스를 생성하지만
		MySQL의 경우는 테이블의 특정 컬럼에 지정하게 됨.
	UNSIGNED : 숫자컬럼인 경우 주로 -100~100과 같은 형태로
		범위가 지정되는데 음수는 사용하지 않고
		양수만 사용하고 싶을 때 지정하는 제약조건.
		단, 지정 시 음수의 범위만큼 양수의 범위가 2배로 늘어나게 됨.
*/
DESC tb_int;

#idx는 자동증가 컬럼으로 지정했으므로 insert시 컬럼명은 생략함.
INSERT INTO tb_int(num1,num2,num3,num4,fnum1,fnum2)
	VALUES (100, 12345, 1234567, 1234567890,
		12345.12345, 1234567890.12345678791);
		
SELECT * FROM tb_int;

/*
자동증가 컬럼에 임의의 값을 삽입할 수는 있으나,
가능한 한 사용하지 않는 것을 권장. (위험)
*/
INSERT INTO tb_int(idx,num2,num3,num4,fnum1,fnum2)
	VALUES (3, 12345, 1234567, 1234567890,
		12345.12345, 1234567890.12345678791);

#idx 컬럼은 PK로 지정했으므로 빈값 삽입 X. >> 에러발생
INSERT INTO tb_int(idx,num2,num3,num4,fnum1,fnum2)
	VALUES ('', 12345, 1234567, 1234567890,
		12345.12345, 1234567890.12345678791);

#날짜형
CREATE TABLE tb_date (
	idx INT PRIMARY KEY AUTO_INCREMENT,
	
	DATE1 DATE NOT NULL,
	DATE2 DATETIME DEFAULT current_timestamp
);
DESC tb_date;
/*
	테이블 생성 시 혹은 삽입 시
	오라클에서는 sysdate를 사용.
	MySQL에서는 삽입 시, NOW() 함수를 사용해서 현재시간을 가져옴.
					생성 시, current_timestamp를 default값으로 사용함.
*/
#데이터 삽입
INSERT INTO tb_Date (DATE1, DATE2)
	VALUES ('2021-06-04', NOW());
	
INSERT INTO tb_date (DATE1) VALUES('2021-09-04');	
SELECT * FROM tb_date;

/*
날짜 및 시간 변환함수
	date_format(컬럼명, '서식')
*/
SELECT DATE_FORMAT(DATE2, '%Y-%m-%d') FROM tb_date;
SELECT DATE_FORMAT(DATE2, '%H:%i:%s') FROM tb_date;

#특수형
/*
	enum : 정해진 항목 중에서 하나만 선택가능.
	set : 정해진 항목 중에서 여러개 선택가능.
		콤마로 구분해서 선택함.
*/
CREATE TABLE tb_spec (
	idx INT AUTO_INCREMENT,
	
	spec1 ENUM('M','W','T'),
	spec2 SET('A','B','C','D'),
	
	PRIMARY KEY(idx)
);

#설정된 값 중 선택해서 입력함(정상입력)
INSERT INTO tb_spec (spec1, spec2) VALUES ('W', 'A,B,D');
SELECT * FROM tb_spec;
#spec1은 null을 허용하는 컬럼이므로 정상입력됨.
INSERT INTO tb_spec (spec2) VALUES('A,B,C');
#설정된 값이 아니므로 입력시 오류발생(data truncated for column 'spec1' at row 1)
INSERT INTO tb_spec (spec1,spec2) VALUES('A', 'A,B,E');

#문자형
/*
	오라클 => varchar2(크기) 로 사용.
	MySQL => 짧은 글인 경우에는 varchar(크기)를,
				긴 글인 경우에는 text를 사용.
*/
CREATE TABLE tb_string (
	idx INT PRIMARY KEY AUTO_INCREMENT,
	
	str1 VARCHAR(30) NOT NULL,
	str2 TEXT
);
DESC tb_string;

INSERT INTO tb_string (str1, str2)
	VALUES ('나는 짧은 글', '나는 엄청나게 긴글');
SELECT * FROM tb_string;
