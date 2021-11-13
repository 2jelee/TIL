[02 멀티채팅]

(단체 채팅을 가정)
A | B | C
귓속말(1:1대화)은 서버를 거쳐가지 않는다? (X)
항상 모든 내역들은 서버를 거쳐서 가므로 서버에 남아있다.
>> 서버가 Echo한다.

#멀티채팅 구현4
(java실습)
chat4는 chat3을 복사하여
Receiver 클래스에 catch절에 SocketException 생성해줌
(cmd 실습)

#멀티채팅 구현5
클라이언트 -> Sender(쓰레드 클래스) 추가
>> 한 서버에 여러 클라이언트가 붙을 수 있음
(작성용교안)
Q. init() 메소드는 무슨 역할이지..?
아마 초기화..

accept이 무한루프안에 들어가서
client가 접속할때마다 접속 허용을 해줌.
while(true)
	socket~
	Thread~
)

클래스 안에 또다른 클래스가 정의됨 >> 내부클래스
class MultiServerT extends Thread {
client 한명당 Thread 1개씩

Server
 |
 | accept >> 입력스트림(수신), 출력스트림(발신)
 | 
C1	C2 ?? >> 입출력스트림이 클라이언트 한명당 하나씩 만들어져야함.

1:N 가능해짐.

클라이언트 한명당 ..
쓰레드가 만들어지는 이유? ... (추후 설명-제대로 못들음)

#멀티채팅 구현6	>>>>>>>>>>>>>>> 멀티채팅 가능하게 됨
(노트 확인)
HashMap 사용
HashMap<String, PrintWriter>

이제 클라이언트는 바뀌지 않음.
so, 패키지 chat5 복사> chat6로
서버만 변경

MultiServer
Map<String, PrintWriter> clientMap;
: Map객체 추가됨 이름은 clientMap으로 명명.

public MultiServer(){
	clientMap = new HashMap<~>
	Coolections.syn~ >> 동기화
}

sendAllMsg 클래스 커진다.
아래 반복하는 객체 > Iterator/for 사용

아래, if 이름이 공백이면 없이 메세지(msg)보내고
       else 이름이 있으면 이름과 함께 보내겠다?

@run 메소드
최초로 메시지를 받았다 >> 접속자가 들어왔다는 것
clientMap.put(name,out)  >> name과 out?을 해쉬맵이 저장

접속자가 접속을 끊으면, finally에서 remove 시키고

서버)cd\ 입력 ->
C:\02Workspaces\K01NetworkChat\bin>java chat6.MultiServer

(1개 이상의)클라이언트) cd\ 입력->
C:\02Workspaces\K01NetworkChat\bin>java chat6.MultiClient

cls >> clear 기능

#귓속말
기능 추가시 해당 패키지에 file을 생성함
