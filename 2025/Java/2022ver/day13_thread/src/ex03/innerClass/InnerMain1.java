package ex03.innerClass;

import java.awt.Button;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//User Class
public class InnerMain1 {	//outer class
	class EventHandler implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("ActionEvent 발생했습니다.");
			System.out.println(e.getActionCommand());
			System.out.println(e.getSource());
		}
	} //inner class END
	
	public static void main(String[] args) {
		Frame frame = new Frame("이벤트 처리 - 이너클래스");
		Button btn = new Button("Button-Start");
		
		//1.
		EventHandler handler = new InnerMain1().new EventHandler();
		btn.addActionListener(handler); // event를 actionListener에 붙이겠다.
				
		frame.add(btn);
		frame.setVisible(true);
		frame.setSize(300, 200);
		frame.setLocation(300, 150);
	}
}
