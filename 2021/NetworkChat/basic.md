1. [네트워크 용어]
Server >> 서비스를 제공하는
Client = user >> 서비스를 받는

OSI 참조모델
(정처기 시험 등의 단골문제..)

가장 많이 나오는 단어 ★프로토콜 Protocol
http >> p: Protocol

네트웤을 통해 컴퓨터 간 정보를 주고받는 것.. (축약 >> '전송규약')

커다란 데이터를 작게 나누는 >> 패킷★
패킷 단위로 작게 쪼개서(조각조각)

HTTP : HyperText Transfer Protocol
FTP
SMTP
...
TCP / IP

Chatting prog >> TCP / UDP 를 통해 만들 수 있(본 과정>> TCP 사용)
TCP) client로 보내고 -> client가 회신해줌 <양방향> ... 속도 느림 (안정적)
UDP) 그냥 보냄.			    <단방향> ... 속도 빠름 (안정X)

TCP : 신뢰성 높. 확실한 데이터 통신 보증 (회신>> 양방향이므로)
UDP : 회신X 전송이 빨라야하는 것들(고속)...  ex. 동영상, 음악
       고성능. 실시간 용도에 적합

IP : 주소할당, 주소를 바탕으로 패킷 전송

마치 컨베이어 벨트처럼 큰 데이터가 한번에 가면 이것만 하게되는..
so, 패킷으로 보낸다(대신 라벨 같은 것을 붙여서)

포트번호 => 항구(port)...
포트 정해진..
http : 80
https : 443 처럼..
ex) https://www.naver.com:443
ex) www.ikosmo.co.kr:80

jsp : 8080 8081
정해진 포트를 통해 서비스를 하게 된다.

나중에 읽어보기!

=============================================

cmd창 2개 띄우기
하나는 서버, 하나는 클라이언트
@서버
cd \(C:\Users\ttobo>cd \) -> C:\>cd 02Workspaces\K01NetworkChat
-> C:\02Workspaces\K01NetworkChat>dir
->C:\02Workspaces\K01NetworkChat>cd \02Workspaces\K01NetworkChat\bin
->C:\02Workspaces\K01NetworkChat\bin>java chat1.MultiServer (숫자는 알맞게)

(단, java에서 실행하고 있으면 안된다.)
강제종료 : Ctrl + C


@클라이언트
cd \ (C:\Users\ttobo>cd\) -> C:\>cd C:\02Workspaces\K01NetworkChat
-> C:\02Workspaces\K01NetworkChat>cd bin
-> C:\02Workspaces\K01NetworkChat\bin>java (긴 문장으로 blah blah 나온다)
-> C:\02Workspaces\K01NetworkChat\bin>java chat2.MultiClient
	or C:\02Workspaces\K01NetworkChat\bin>java chat3.MultiClient
	    (숫자는 1, 2, 3으로 알맞게 씀)
(단, 3번의 경우 무한루프에 빠진다.
     so, Ctrl + C를 통해 빠져나오면 된다.)

참고) 연결(?)
C:\02Workspaces\K01NetworkChat\bin>java chat1.MultiClient 192.168.0.100
이름을 입력하세요:eun2

=============================================

2. [MultiChatting 구현하기]
구현 6단계

소켓 Socket을 통해..
소켓 : IP주소+Port번호 >>양방향 통신을 할 수 있도록 해주는 SW장치
네트워크 상에서
클라이언트 프로그램과 서버 프로그램 사이의 통신방법

C3 ----------------->
C1 -----------------> sever
C2 >> Hi ---------->

ServerSocket (서버에서 만드는)
Soket	     (클라이언트가 만드는)

소켓 송수신 과정 :
항상 Server가 뚜껑을 열고 '먼저 준비'되어야 한다!! >>> (마치 레스토랑처럼)
[S] ServerSocket
[C] Socket
[S] accept
[C] BufferedWriter
[S] BufferedReader
[S] BufferedWriter
[C] BufferedReader 		(IO : BufferedWriter~BufferedReader)

(항상 클라이언트의 요청이 첫번째! 먼저 server가 무언가 해주지는 않음)
[C] socket.close()
[S] socket.close()

멀티채팅 구현1 >> 작성용 교안 open
(실습)

@서버
<멤버변수>
ServerSocket 객체
Socket 클라이언트 사용용
String s >> s :

try~catch
ServerSocket 인자값 : 9999 => port
>> 대기상태.. 접속을 기다리고 있음

.accept
: 클라이언트의 접속을 허가함

out >>
in >> 각 객체를 생성. 인자값들 (socket.) 으로 시작하고 있음

in.readLine(); >> 말 그대로 라인으로 읽겠다.
최초 읽 : 사용자의이름 (""+s) >>콘솔에다가 메세지를 남겨주는
out.println(""+s) > 클라이언트 응답


@클라이언트
try~catch
서버에서 accept()하면 socket(, 9999) 연결되었습니다.

out =
in =

out.pirnt(s_name) >> 대화명

(추후 주석 설명 확인하자...)


멀티채팅 구현1 >> 작성용 교안 open
(실습)

@서버
out.println >> 여기서 out은 상단의 out = new 'PrintWriter' << 를 말하는 것이다.

while(in ! = null)
: null이 아닐때까지 무한루프

(추후 주석 설명 확인하자...)

@클라이언트
first 대화명 입력

out.println(s_name) >> 이름을 처음으로
out이 null이 아닐때까치(out!=null) >> 무한루프
break; >> while문 탈출
s2 >> 대화가 된다.
*q : quit
(추후 주석 설명 확인하자...)


멀티채팅 구현3
클라이언트 한명당 3개의 쓰레드 돌아가는.. 처리
Ctrl+C >> 강제종료(무한루프를)

@서버
init메소드 생김. 그외 비슷
메인 >> init메소드로 호출
sendAllMsg >> 아직 1명밖에 접속안되는 단계.. 추후 All이 될 것.

@클라이언트




※복습 : Echo해주는 절차 및 흐름에 focus를 맞춰 하기
//end
