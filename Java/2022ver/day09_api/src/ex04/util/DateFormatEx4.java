package ex04.util;
import java.util.*;
import java.text.*;
class DateFormatEx4 {
	public static void main(String[] args) {
		String pattern = "yyyy/MM/dd"; 
		DateFormat df = new SimpleDateFormat(pattern);
		Scanner s = new Scanner(System.in);
		Date inDate = null;
		System.out.println("��¥�� " + pattern + "�� ���·� �Է����ּ���.");
		while(s.hasNextLine()) {
			try {
				inDate = df.parse(s.nextLine());
				break;
			} catch(Exception e) {
				System.out.println("��¥�� " + pattern + "���·� �ٽ� �Է����ּ���.");
			}
		} // while
		Calendar cal = Calendar.getInstance();
		cal.setTime(inDate);
		Calendar today = Calendar.getInstance();
        long day = (cal.getTimeInMillis() - today.getTimeInMillis())/(60*60*1000);
		System.out.println("�Է��Ͻ� ��¥�� ����� "+ day +"�ð� ���̰� �ֽ��ϴ�.");
	} // main
}