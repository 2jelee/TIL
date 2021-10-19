# Oracle #
## 계층형 쿼리 ##
계층형 구조는 상하 수직관계의 트리형태의 구조로 이루어진 형태. ex) 특정회사의 부서, 특정학교의 학과 등<br/>
계층형 쿼리는 테이블에 저장된 데이터를 계층형 구조로 반환하는 쿼리를 말한다.<br/>
Oracle에서의 계층형 쿼리는 <b>START WITH ... CONNECT BY</b> 절로 생성할 수 있으며 계층형 정보를 표현하기 위한 목적<br/>

## 수행순서 ##
1. START WITH 절에 시작조건을 찾는다.
2. CONNECT BY 절에 연결조건을 찾는다.

## 계층형 쿼리(START WITH ... CONNECT BY) 사용법 ##
SELECT [컬럼] ... <br/>
FROM [테이블] <br/>
WHERE [조건] <br/>
START WITH [최상위 조건] <br/>
CONNECT BY [NOCYCLE] [PRIOR 계층형 구조 조건]; <br/>

### START WITH ###
루트노드(행)을 명시. 최상위부터 시작, START WITH에서 column이 <b>NULL</b>인 부분을 조건식으로 넣는다.<br/>
즉, START WITH 조건에 계층형 구조의 취상위 계층의 row를 식별하는 조건을 넣는다.<br/>
  LEVEL컬럼은 레벨 의사컬럼(LEVEL Pseudocolumn)이라 하는데, 계층형 정보를 표현할 때 그 계층의 LEVEL을 나타내줌.<br/>
  이는 다양하게 응용을 할 수 있는데 가장 많이 응용하는 방법이 레벨별로 들여쓰기를 하여 좀 더 직관적으로 데이터를 표현하는 것임.<br/>
  ```
  SELECT 
  LPAD(' ', 2*(LEVEL-1)) || DEPT_NAME AS DEPT_NAME, --레벨별 들여쓰기 
  DEP_CD, 
  PARENT_CD , 
  LEVEL 
  FROM DEP  
  START WITH PARENT_CD IS NULL --최 상위노드 설정, 
  CONNECT BY PRIOR DEP_CD = PARENT_CD;--부모노드와 자식노드 연결
  ```
  레벨-1 * 공백(2)를 앞에 삽입하여 좀 더 계층형 데이터를 직관적으로 데이터를 만들었음을 확인.<br/>
  
  
### CONNECT BY ###
연결고리를 가지고 목록을 가져옴.
먼저 START WITH에서 조건에 맞는 최상위 행을 가져옴. ▶ 최상위 행을 갖게됨.
