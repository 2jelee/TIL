package ex04.util;
import java.util.Date;
class Date1{
	public static void main(String[] args) {
		Date date = new Date();
		int h = date.getHours();
		int m = date.getMinutes();
		int s = date.getSeconds();

		System.out.println("����ð��� "+h+"�� "+m+"�� "+s+"�� �Դϴ�.");
		if(h > 12)
			System.out.println("���� �ð��� ���� "+(h-12)+"�� "+m+"�� "+s+"�� �Դϴ�.");
		else
			System.out.println("���� �ð��� ����"+h+"�� "+m+"�� "+s+"�� �Դϴ�.");
	}
}
