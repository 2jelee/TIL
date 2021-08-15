/**************************
파일명 : Or03String.sql
문자열 처리함수
설명 : 문자열에 대해 대소문자를 변환하거나
        문자열의 길이를 반환하는 등 문자열을 조작하는 함수
**************************/

/*
concat(문자열1, 문자열2)
    : 문자열 1과 2를 서로 연결해서 출력하는 함수
    사용법 1 : concat('문자열1','문자열2')
    사용법 2 : '문자열1' || '문자열 2'
*/
select concat('Good', ' morning') AS "아침인사" from dual;
select 'Oracle' || ' 11g' || ' Good' from dual;
-- => 위의 SQL문을 concat()으로 변경하면..
        select concat(concat('Oracle', ' 11g'), ' Good') from dual;
        
        
/*
initcap(문자열)
    : 문자열의 첫 문자만 대문자로 변환하는 함수.
    단, 첫 문자를 인식하는 기준은 다음과 같다.
    - 공백문자 다음에 나오는 첫 문자를 대문자로 변환한다.
    - 알파벳 숫자를 제외한 나머지 문자 다음에 나오는 첫번째 문자를 대문자로 변환한다.
*/
 select initcap('hi hello 안녕') from dual;
 select initcap('good/bad morning') from dual;
 select initcap('never6say*good가bye') from dual;
 
 --사원테이블에서 john을 찾아서 인출하시오.
 select first_name, last_name from employees
 where first_name='john';       --결과 없음
 
 select first_name, last_name from employees
 where first_name='John';       --3개 인출
 
 select first_name, last_name from employees
 where first_name=initcap('john');      --3개 인출
 
 
 /*
 대소문자 변경
lower() : 소문자로 변경함
upper() : 대문자로 변경함
 */
 select lower('GOOD'), upper('bad') from dual;
 
 -- 위에서와 같이 john을 검색하려면
 select * from employees where lower(first_name)='john';
 select * from employees where upper(first_name)='JOHN';
 
 --컬럼에 저장된 값을 대문자 혹은 소문자로 변경한 후 조건으로 검색한다.
 
 /*
 lpad(), rpad()
    : 문자열의 왼쪽, 오른쪽에 특정한 기호로 채울 때 사용하는 함수
    형식 ] lpad('문자열', '전체자리수', '채울문자열')
        -> 전체자리수에서 문자열의 길이만큼을 제외한 나머지
            좌측부분을 주어진 문자열로 채워주는 함수
            rpad()는 오른쪽을 채워줌.
 */
 select
    'good',
    lpad('good',7,'#'),
    rpad('good',7,'#'),
    lpad('good',7),
    rpad('good',7)
from dual;


/*
trim() : 공백을 제거할때 사용하는 함수
    형식 ] trim([leading | trailing | both] 제거할 문자 from 컬럼)
        - leading : 왼쪽에서 제거
        - trailing : 오른쪽에서 제거
        - both : 양쪽에서 제거.
                    설정값이 없으면 both가 디폴트
        [주의1] 양쪽 끝의 문자만 제거되고 중간에 있는 문자는 제거되지 않음.
        [주의2] '문자'만 제거할 수 있되 '문자열'은 제거할 수 없음. >> error 발생
*/

select
    ' 공백제거테스트 ' as trim1,
   trim( ' 공백제거테스트 ') as trim2,
   trim ('다' from '다람쥐가 나무를 탑니다') as trim3,
   trim (both '다' from '다람쥐가 나무를 탑니다') as trim4,
   trim (leading '다' from '다람쥐가 나무를 탑니다') as trim5,
   trim (trailing '다' from '다람쥐가 나무를 탑니다') as trim6,
   trim (both '다' from '다람쥐가 다리 위의 나무를 탑니다') as trim7
from dual;
--trim7 : 중간의 '다'는 제거되지 X
--옵션이 없는 경우, both가 디폴트이므로 trim3, trim4는 동일한 결과가 나옴

/*
아래 문장은 쿼리 에러 발생. trim()은 문자만 제거할 수 있다.
만약 문자열을 제거하고 싶다면 replace() 함수를 사용해야 된다.
*/
select
   trim (both '다람쥐' from '다람쥐가 다리 위의 나무를 탑니다') as trimError
from dual;

/*
ltrim(), rtrim() -> L[eft]TRIM, R[ight]TRIM
    : 좌측, 우측, '문자' 혹은 '문자열'을 제거할 대 사용함
    ※ TRIM은 문자열을 제거할 수 없지만
        LTRIM과 RTRIM은 문자열까지 제거할 수 있다.
*/
select
    ltrim(' 좌측공백제거 ') ltrim1,
    ltrim('좌측문자열제거', '좌측') ltrim2,
    rtrim('우측문자열제거', '제거') ltrim3,
    rtrim('우측문자열제거', '문자열') ltrim4
from dual;

/*
substr() : 문자열에서 시작인덱스부터 길이만큼 잘라서 문자열을 출력한다.
    형식] substr(컬럼, 시작인덱스, 길이)

    참고1) 오라클의 인덱스는 1부터 시작한다. (0부터 아님) >> ※주의!!!
    참고2) '길이'에 해당하는 인자가 없으면 문자열의 끝까지를 의미한다.
    참고3) 시작인덱스가 음수면 우측끝부터 좌로 인덱스를 적용한다.
*/
select substr('good morning john', 8, 4) from dual;     --rnin
select substr('good morning john', 8) from dual;     --rning john
--인덱스 2부터 잘라냄. 한글이므로 영문과는 결과가 조금 다름
select substr('안녕하세요',2) from dual;     --녕하세요 >> '안'만 잘려나감

/*
substrb() : byte 단위로 잘라낸다.
    통상적으로 한글과 같은 유니코드는 한 글자에 3byte로 표현되나,
    조금씩 어긋나는 경우가 발생하므로 테스트가 필요함.
*/
select substrb('안녕하세요', 1) from dual; 
select substrb('안녕하세요', 2) from dual; 
select substrb('안녕하세요', 3) from dual; 
select substrb('안녕하세요', 4) from dual; 
select substrb('안녕하세요', 5) from dual; 
select substrb('안녕하세요', 6) from dual; 
select substrb('안녕하세요', 7) from dual; 
select substrb('안녕하세요', 8) from dual; 


/*
replace() : 문다열을 다른 문자열로 대체할 때 사용한다.
    형식] replace(컬럼명or문자열, '변경할 대상의 문자', '변경할 문자')
    
    ※trim(), ltrim(), rtrim() 메소드의 기능을 replace() 메소드 하나로 대체할 수 있으므로
        trim()에 비해 replace()가 훨씬 더 사용빈도가 높음.
*/
select replace('good morning tom', 'morning', 'evening') as "문자열대체"
from dual;
select replace('good morning tom', 'morning ', '') as "문자열삭제"
from dual;

--trim은 좌우측의 공백은 제거되나, 중간의 공백은 제거되지 X
select trim(' blank1 blank2 ') as "공백제거1" from dual;
--replace는 좌우측 뿐만 아니라 중간의 공백도 제거할 수 O
select replace(' blank1 blank2 ', ' ', '') as "공백제거2" from dual;


/*
instr() : 해당 문자열에서 특정 문자가 위치한 인덱스 값을 반환한다.
    형식 1] instr(컬럼명, '찾을문자')
        => 문자열의 처음부터 문자를 찾는다.
    형식 2] instr(컬럼명, '찾을문자', '탐색을 시작할 인덱스', '몇번째문자')
        => 탐색할 인덱스부터 문자를 찾는다.
             단, 찾는 문자 중 몇번째에 있는 문자인지 지정할 수 있다.
*/
--n이 발견된 첫번째 인덱스 반환
select instr('good morning john', 'n') from dual;       --9
--n이 발견된 두번째 인덱스 반환
select instr('good morning john', 'n', 1, 2) from dual;     --11
--10번째 인덱스부터 탐색을 시작하여 n이 발견된 2번째 인덱스 반환
select instr('good morning john', 'n', 10, 2) from dual;        --17
















