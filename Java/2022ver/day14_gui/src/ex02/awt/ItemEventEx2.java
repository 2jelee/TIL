package ex02.awt;
import java.awt.*;
import java.awt.event.*;
class  ItemEventEx2 extends Frame implements ItemListener{
	Choice c1, c2;
	Label lb;
	String [] ��� = {"�ƽþ�" ,"����","������ī"};
	String [][] ���� = {{"�ѱ�","�Ϻ�","�߱�"},
								{"����","������","������"},
								{"����Ʈ","���","�찣��"}};
	public ItemEventEx2(String str){
		super(str);
		Label lb2 = new Label("����� ���� �����ϼ���");
		Panel p = new Panel();
		lb = new Label();
		c1 = new Choice();
		c2 = new Choice();
		c1.addItemListener(this);
		c2.addItemListener(this);
		for(int i = 0; i < ���.length; i++){
			c1.add(���[i]);
		}
		c2.add("        ");
		p.add(c1);p.add(c2);
		add("North",lb2);  add("Center",p);  add("South",lb);
		setSize(300,200);  setVisible(true);
	}
	public void itemStateChanged(ItemEvent e){
		Choice obj = (Choice)e.getSource();
		String str = "������ ����� ����� : ";
		if(obj==c1){
			c2.removeAll();
			int j = c1.getSelectedIndex();
			for(int i = 0; i < ����[j].length;i++){
				c2.add(����[j][i]);
			}
		}else{
			str +=c1.getSelectedItem();
			str +=" - "+c2.getSelectedItem();
			lb.setText(str);
		}}
	public static void main(String[] args) {
		new ItemEventEx2("���̽� �̺�Ʈ");
	}
}
