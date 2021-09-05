package chat09;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

public class MultiServer2 extends DBConnect {  
	static ServerSocket serverSocket = null;
	static Socket socket = null;
	Map<String, PrintWriter> clientMap; 
	 
	public MultiServer2() {		 
		clientMap = new HashMap<String, PrintWriter>(); 
		Collections.synchronizedMap(clientMap);
	 
	}
	
	public void init() {
		
		try { 
			serverSocket = new ServerSocket(9999);
			System.out.println("서버가 시작되었습니다.");
			
			while(true) {
				socket = serverSocket.accept();
				System.out.println("로컬서버:"+socket.getLocalAddress()+":"+socket.getLocalPort());
				System.out.println("원격클라이언트:"+socket.getInetAddress()+":"+socket.getPort());
				 
				Thread mst = new MultiServerT(socket);
								
				if(clientMap.size()>=Const.CLIENT_CNT) {
					PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
					out.println(URLEncoder.encode("정원("+Const.CLIENT_CNT+"명)을 초과하여 접속하실수 없습니다", "UTF-8"));					
					break;
				}
				else {
					mst.start();			 
				}
			}			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				serverSocket.close();
				socket.close();
			}
			catch (Exception e) {			
				e.printStackTrace();
			}
		}	
	}
	 
	public void sendAllMsg(String name, String msg, String flag) {
		 
		Iterator<String> it = clientMap.keySet().iterator();
		String clientName;	
		
		while(it.hasNext()) {
			try { 
				clientName = it.next();
				 
				String blockValue = null;
				boolean cFlag = true;  
				
				PrintWriter it_out = (PrintWriter) clientMap.get(clientName);
				
				if(flag.equals("One")) { 
					if(name.equals(clientName)) {
						it_out.println("["+URLEncoder.encode("귓속말", "UTF-8")+"]"+ 
								URLEncoder.encode(msg, "UTF-8"));
					}
				}
				else { 
					if(name.equals("")) {					
						it_out.println(URLEncoder.encode(msg, "UTF-8"));
					}
					else {					
						it_out.println("["+ URLEncoder.encode(name, "UTF-8") +"] "+ 
								URLEncoder.encode(msg, "UTF-8"));
					}						
				}
				 			
			} 
			catch(Exception e) {
				System.out.println("예외:"+e);
			}			
		}
	}
	 
	public static void main(String[] args) { 
		MultiServer2 ms = new MultiServer2(); 
		ms.init();
	}
		
	 
	class MultiServerT extends Thread {
		
		Socket socket;
		PrintWriter out = null;
		BufferedReader in = null;
		
		public MultiServerT(Socket socket) {
			this.socket = socket;
			try {
				out = new PrintWriter(this.socket.getOutputStream(), true); 
				in = new BufferedReader(new InputStreamReader(
						this.socket.getInputStream(), "UTF-8"));
			} 
			catch (Exception e) {
				System.out.println("예외:"+ e);
			}
		}
		
		@Override
		public void run() {
			
			String name = "";  
			String s = "";
			
			try { 
				name = URLDecoder.decode(in.readLine(), "UTF-8");
				 
				Iterator<String> itr = clientMap.keySet().iterator();
				while(itr.hasNext()) {
					String connName = itr.next();
					if(connName.equalsIgnoreCase(name)) {
						System.out.println("동일한 대화명이 존재합니다. 접속을 종료합니다.");
						out.println(URLEncoder.encode("동일한 대화명이 존재합니다. 접속을 종료합니다.", "UTF-8")); 
						name = name +"temp";
						this.interrupt();
						return;
					}
				}
				 
				sendAllMsg("", name + "님이 입장하셨습니다.", "All"); 		
				 
				clientMap.put(name, out);  
				
				System.out.println(name + "> 접속");
				System.out.println("현재 접속자 수는 "+clientMap.size()+"명 입니다.");
				 
				while (in!=null) { 
					s = URLDecoder.decode(in.readLine(), "UTF-8");					
					if ( s == null ) break;					
					
					//DB입력
					try {
						String query = "INSERT INTO chatting_tb VALUES (chatting_seq.nextval, ?, ?, senddate)";
						psmt = con.prepareStatement(query);
						psmt.setString(1, name);
						psmt.setString(2, s);					 
						int affected = psmt.executeUpdate();
						System.out.println(query +"행이 입력되었습니다.");
					}
					catch (Exception e) {
						e.printStackTrace();
					}		 
				}
			} 
			catch (Exception e) {
				System.out.println("예외:"+ e);
				e.printStackTrace();
			}
			finally { 
				clientMap.remove(name); 
				sendAllMsg("", name + "님이 퇴장하셨습니다.", "All");				 
				System.out.println(name + " [" + Thread.currentThread().getName() +  "] 퇴장");
				System.out.println("현재 접속자 수는 "+clientMap.size()+"명 입니다.");

				try {
					in.close();
					out.close();
					socket.close();
					System.out.println("종료");
				} 
				catch(Exception e) {
					e.printStackTrace();
				}
			}
		}		
	}
}
