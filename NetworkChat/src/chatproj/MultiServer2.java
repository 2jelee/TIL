//package chatproj;
//
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.io.PrintWriter;
//import java.net.ServerSocket;
//import java.net.Socket;
//import java.util.Collections;
//import java.util.HashMap;
//import java.util.Iterator;
//import java.util.Map;
//
//
//public class MultiServer2 {
//
//	//멤버변수
//	static ServerSocket serverSocket = null;
//	static Socket socket = null;
//	
//	//클라이언트 정보저장을 위한 Map 컬렉션 생성
//	Map<String, PrintWriter> clientMap;
////	Map<String, PrintWriter> blackList;
//	
//	//생성자
//	public MultiServer2() {
//		//클라이언트의 이름과 출력스트림을 저장할 HashMap 컬렉션 생성
//		clientMap = new HashMap<String, PrintWriter>();
////		blackList = new HashMap<String, PrintWriter>();
//		//HashMap 동기화 설정. 쓰레드가 사용자 정보에 동시에 접근하는 것을 차단
//		Collections.synchronizedMap(clientMap);
////		Collections.synchronizedMap(blackList);
//	}
//	
//	//채팅 서버 초기화
//	public void init () {
//		try {
//			//서버 소켓 오픈
//			serverSocket = new ServerSocket(9999);
//			System.out.println("서버가 시작되었습니다.");
//			
//			
//			//접속자수 제한
////			인터페이스형 상수를 선언하여 서버에 접속할 수 있는 최대 인원을 설정한다. 
////			해당 인원을 초과하면 접속을 차단한다. 
//
//			//대화 금칙어 처리
////			Set 추가후 금칙어를 하드코딩으로 입력한다. ⇒ pWords
//
//			
//			
//			while(true) {
//				//클라이언트의 접속허가
//				socket = serverSocket.accept();
//				
//				System.out.println(socket.getInetAddress()+"(클라이언트)의 "
//						+ socket.getPort()+"포트를 통해 "
//						+ socket.getLocalAddress()+"(서버)의 "
//						+ socket.getLocalPort()+"포트로 연결되었습니다. ");
//					
//				//쓰레드로 정의된 내부클래스 객체 생성 및 시작
//				//클라이언트 한명당 하나씩의 쓰레드가 생성됨.
//				Thread mst = new MultiServerT(socket);
//				mst.start();
//			}
//		}
//		catch (Exception e) {
//			e.printStackTrace();
//		}
//		finally {
//			try {
//				serverSocket.close();
//			}
//			catch (Exception e) {
//				e.printStackTrace();
//			}
//		}
//	}
//	
//	public static void main(String[] args) {
//		MultiServer2 ms = new MultiServer2();
//		ms.init();
//	}
//	
//	//접속된 모든 클라이언트측으로 서버의 메세지를 Echo해주는 역할 담당
//	public void sendAllMsg(String name, String msg, String flag) {
//		
//		//Map에 저장된 객체의 키값(대화명)을 먼저 얻어온다.
//		Iterator<String> it = clientMap.keySet().iterator();
//		
//		//저장된 객체(클라이언트)의 갯수만큼 반복한다.
//		while(it.hasNext()) { //전체의 반복
//			try {
//				//컬렉션의 key는 클라이언트의 대화명이다.
//				String clientName = it.next();
//				PrintWriter it_out =
//						(PrintWriter) clientMap.get(clientName);
//				
//				
//				//chat7에서 추가된 매개변수 >> flag
//				if(flag.equals("One")) {
//					//flag가 One이면 해당 클라이언트 한명에게만 전송한다. (귓속말)
//					
//					if(name.equals(clientName)) { //여기서 name은 메세지를 받는 사람을 의미.
//						//컬렉션에 저장된 접속자명과 일치하는 경우에만 메세지를 전송한다.
//						it_out.println("[귓속말]"+msg);
//					}
//				}
//				else {
//					//그외에는 모든 클라이언트에게 전송한다.
//					/*
//					클라이언트에게 메세지를 전달할 때
//					매개변수로 name이 있는 경우와 없는 경우를 구분해서 전달하게 됨.
//					 */
//					if(name.equals("")) {
//						//입장, 퇴장에서 사용되는 부분
//						it_out.println(msg);
//					}
//					else {
//						//메세지를 보낼 때 사용되는 부분
//						it_out.println("["+name+"]:"+msg);
//					}
//				}
//			}
//			catch (Exception e) {
//				System.out.println("예외:"+e);
//			}
//		}
//	}
//	
//	
//	
//	class MultiServerT extends Thread {
//		
//		//멤버변수
//		Socket socket;
//		PrintWriter out = null;
//		BufferedReader in = null;
//
//		public MultiServerT(Socket socket) {
//			this.socket = socket;
//			try {
//				out = new PrintWriter(this.socket.getOutputStream(), true);
//				in = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
//			}
//			catch (Exception e) {
//				System.out.println("예외:"+e);
//			}
//		}
//
//		@Override
//		public void run() {
//			String name = "";
//			String s = "";
//			try {
//				//01 중복 아이디 처리
////				신규 접속자는 HashMap에 저장하게된다. (이미 구현되어있음) 
////				동일한 대화명으로 접속하면 접속불가 처리한다.
//				//클라이언트의 이름을 읽어온다.
//				name = in.readLine();
//				if (name.equals(name)==true) {
//					System.out.println("[시스템] 이미 존재하는 아이디입니다. >> 접속불가"); //접속하면 접속불가 처리한다.
//					clientMap.remove(name); // Q. 지금 입력하는 아이디가 지워지는가, 원래 있는 존재하는 ID가 지워지는가/??
//				}
//				
//				
//				
//				//방금 접속한 클라이언트를 제외한 나머지에게 입장을 알림.
//				else {
//					sendAllMsg("",name+"님이 입장하셨습니다.", "All");
//					//현재 접속한 클라이언트를 HashMap에 저장한다.
//					clientMap.put(name, out); //out을 처리..???????????????
//					
//					//접속자의 이름을 서버의 콘솔에 띄워주고
//					System.out.println(name+" 접속");
//					//HashMap에 저장된 객체의 수로 현재 접속자를 파악할 수 O
//					System.out.println("현재 접속자 수는" + clientMap.size()+"명 입니다.");
//				}
//	
//				//입력한 메세지는 모든 클라이언트에게 Echo 됨.
//				while(in != null) {
//					s=in.readLine();
//					if(s==null)
//						break;
//						
//					//서버의 콘솔에 출력되고,
//					System.out.println(name + " >> " +s);
//						
//						
//					//클라이언트 측으로 전송함.
//					if(s.charAt(0)=='/') { //0번 인덱스에 있는 '/'
//						String[] strArr = s.split(" "); //스페이스를 의미
//						String msgContent = "";
//						for(int i=2; i<strArr.length; i++) {
//							msgContent += strArr[i]+" "; //묶어서 msgContent에 저장을 하겠다.
//						}
//						if(strArr[0].equals("/to")){
//							sendAllMsg(strArr[1], msgContent, "One"); //1번=>받는 사람 이름, 실제대화 내용, 1명한테만 보내겠다.
//						}
//					}
//					else {
//						sendAllMsg(name, s, "All");
//					}
//						
////						sendAllMsg(name,s);
//						
//				}
//			}
//			catch (Exception e) {
//				System.out.println("예외:"+e);
//			}
//			finally {
//				
//				/*
//				클라이언트가 접속을 종료하면 Socket 예외가 발생하게 되어
//				finally절로 진입하게 된다.
//				이때 "대화명"을 통해 정보를 삭제한다.
//				 */
//				clientMap.remove(name);
//				sendAllMsg("", name+"님이 퇴장하셨습니다.", "All"); //sendAllMsg 모두 뒤에 플래그 "All" 추가
//				System.out.println(name + " ["+ Thread.currentThread().getName()+"] 퇴장");
//				System.out.println("현재 접속자 수는" +clientMap.size()+"명 입니다.");
//				
//				try {
//					in.close();
//					out.close();
//					socket.close();
//				}
//				catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		}
//	}
//}
