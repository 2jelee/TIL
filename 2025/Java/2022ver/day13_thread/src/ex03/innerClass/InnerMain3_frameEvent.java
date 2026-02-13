package ex03.innerClass;

import java.awt.Button;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

//User Class
public class InnerMain3_frameEvent {	//outer class 
	
	public static void main(String[] args) {
		Frame frame = new Frame("이벤트 처리 - 이너클래스");
		Button btn = new Button("Button-Start"); 
		
		//2. 익명클래스
		btn.addActionListener(new ActionListener() { 	//익명클래스
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("ActionEvent 발생했습니다.");
				System.out.println(e.getActionCommand());
				System.out.println(e.getSource());
			}
		}); // event를 actionListener에 붙이겠다.
		
		// Frame에 event를 붙이겠다
		frame.addWindowListener(new WindowAdapter() { // WindowAdapter 골라서 넣는 / WindowListener는 override 많
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}	 
		});
		
		frame.add(btn);
		frame.setVisible(true);
		frame.setSize(300, 200);
		frame.setLocation(300, 150);
	}
} 