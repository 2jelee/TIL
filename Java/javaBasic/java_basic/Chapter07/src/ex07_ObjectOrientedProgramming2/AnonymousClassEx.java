package ex07_ObjectOrientedProgramming2;

import java.awt.*;
import java.awt.event.*;

class AnonymousClassEx {
	public static void main(String[] args) {
		Button btn = new Button("Start");
		btn.addActionListener(new EventHandler());
	}
}

class EventHandler implements ActionListener{
	public void actionPerformed(ActionEvent e) {
		System.out.println("ActionEvent occurred!");
	}
}