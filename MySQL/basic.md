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

