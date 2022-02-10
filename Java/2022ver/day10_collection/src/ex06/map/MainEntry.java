package ex06.map;

import java.util.Scanner;

public class MainEntry {
	public static void main(String[] args) {
		while(true) {
			System.out.print("[1]비디오정보 추가 [2]대여정보 출력 [3]대여정보 수정 [4]비디오 삭제 [5]EXIT : ");
			switch (new Scanner(System.in).nextInt()) {
				case 1: 
					VideoManager.insert();
					break;
				case 2: 
					VideoManager.print();
					break;
				case 3: 
					VideoManager.modify();
					break;
				case 4: 
					VideoManager.delete();
					break;
				case 5: 
					System.out.println("See ya");
					System.exit(0);
					break;
			} //switch
		} //while
	}  //main
}
