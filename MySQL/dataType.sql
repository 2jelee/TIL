/**
 * Data Type  | 저장가능한 양 | 특징
 * [문자]
 * CHAR		  | 0~255자       | CHAR(저장할 최대 글자수)
 * VARCHAR    | 0~65535자     | VARCHAR(저장할 최대 글자수) << 가장 자주 씀
 * TEXT       | 0~65535자
 * TINYTEXT   | 0~255자
 * MEDIUMTEXT | 0~1600만자									<< 긴 문자 저장 시 
 * LONGTEXT   | 0~42억자									<< 긴 문자 저장 시 
 * 
 * [숫자] 
 * SMALLINT	  | -32768 ~ 32767
 * MEDIUMINT  | -838만 ~ 838만
 * INT 		  | -21억 ~ 21억
 * BIGINT     | -900경 ~ 900경
 * FLOAT      | -10^38 ~ 10~^38   | 소수점 7자리까지 저장가능(약간의 오차 발생)
 * DOUBLE     | -10^308 ~ 10~^308 | 소수점 14자리까지 저장가능(약간의 오차 발생)
 * DECIMAL    | 소수점 30자리포함 최대 65자리 | 오차없이 소수점 저장가능
 * 
 * [날짜/시간]
 * DATE      | 1000년~9999년   | YYYY-MM-DD 형식
 * TIME      | -839 ~ 838시간  | HH:MM:SS 형식
 * DATETIME  | 1000년 ~ 9999년 | YYYY-MM-DD HH:MM:SS 형식			 << 주로 씀 
 * TIMESTAMP | 1970년 ~ 2038년 | YYYY-MM-DD HH:MM:SS 형식(잘 안씀)   
 * 
 * 이외에도
 * 영상, 사진같은 바이너리 데이터 = BLOB
 * JSON 형식 = JSON,
 * 참/거짓 여부 = BOOLEAN
 * 자주 안쓰므로 참고만
 */
