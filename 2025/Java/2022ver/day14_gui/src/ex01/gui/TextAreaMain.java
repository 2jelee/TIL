package ex01.gui;

import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TextAreaMain extends Frame { //implements ActionListener {
	TextArea ta; //선언
	Button btn;
	
	public TextAreaMain(String str) {
		
		setTitle("First Frame");
		setBackground(Color.YELLOW);
		setVisible(true); 
		setBounds(500,350,500,300); 
		 
		btn = new Button("Button1");
		ta = new TextArea("문장을 넣으세요", 5, 30, TextArea.SCROLLBARS_VERTICAL_ONLY);
		
		this.add(ta);
//		this.add(btn); 
//		btn.addActionListener(this);
		btn.addActionListener(new ActionListener() { 	//익명 클래스로 처리
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}  
		});
		
		addWindowListener(new WindowAdapter() {	// frame의 X를 누르면 창 닫힌다.
			@Override
			public void windowClosing(WindowEvent e) {		//익명 클래스
				System.exit(0);
			}
		}); 
	}
	
	public static void main(String[] args) {
		new TextAreaMain("새 창 띄우기");
	}

	
}
