package ex01.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener; 
import javax.swing.JFrame;

//JFrame이 자체적으로 Frame을 가지고 있으므로 
public class MainFrame extends JFrame implements ActionListener {
	
	public MainFrame() {
		setTitle("test");
		setVisible(true);
		setSize(300,200);
		//여기까지 창닫기를 누르면 창은 닫혀지나, 터미널은 꺼지지 않았음.
		
		//이를 추가하면 터미널까지 닫힌다.
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}
	
	public static void main(String[] args) {
		new MainFrame();
	}

}
