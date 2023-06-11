package project1;

import project1.ver01.PhoneInfo;

public class PhoneBookVer01 {

	public static void main(String[] args) {
		PhoneInfo pI1 = new PhoneInfo("이지은", "010-1111-1111", "950407");
		pI1.showPhoneInfo();
		System.out.println();
		
		PhoneInfo pI2 = new PhoneInfo("이지동", "010-2222-2222");	//생년월일 없이
		pI2.showPhoneInfo();
	}
}
