package etc_MAR.book;

import java.util.Date;
import java.util.Enumeration;
import java.util.Properties;

public class Practice200_SystemTest {
	public static void main(String[] args) {
		long ltime = System.currentTimeMillis();
		System.out.println((ltime));
		for(int i=0; i<100000;i++) {
			System.out.println("");
		}
		long ltime2 = System.currentTimeMillis();
		System.out.println((ltime2-ltime));
		System.out.println(ltime2/1000/60/60/24/365+"년");
		Properties prop = System.getProperties();
		System.out.println(prop.getProperty("java.vm.version"));
		System.out.println(prop.getProperty("file.separator"));
		
		System.out.println(new Date(System.currentTimeMillis()));
		Enumeration<Object> enu = prop.keys();
		int i=0;
		while(enu.hasMoreElements()) {
			String keys = (String)enu.nextElement();
			System.out.println((++i+"")+keys+":"+prop.getProperty(keys));
		}
		
	}
}
