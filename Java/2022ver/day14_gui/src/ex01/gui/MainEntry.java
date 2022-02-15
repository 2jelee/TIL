package ex01.gui;

import java.awt.Color;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MainEntry {
	public static void main(String[] args) {
		Frame f = new Frame();
		
		f.setTitle("First Frame");
		f.setBackground(Color.YELLOW);
		f.setVisible(true);
		
		f.pack(); //자기 크기만큼 뜨는	만약 글자 한 글자라도 있다면 그 글자 크기만큼 나타난다.
		
		//이하 setSize, setLocation을 합친 
//		f.setBounds(500,350,500,300);
		/*
		f.setSize(500, 400);
		f.setLocation(500, 350);
		*/
		
//		WindowAdapter wa = new WindowAdapter() {
		f.addWindowListener(new WindowAdapter() {	// frame의 X를 누르면 창 닫힌다.
			@Override
			public void windowClosing(WindowEvent e) {		//익명 클래스
				System.exit(0);
			}
		});
	}
}
