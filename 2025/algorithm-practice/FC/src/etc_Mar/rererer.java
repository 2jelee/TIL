package etc_MAR;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.SQLException;

public class rererer {
	public static void main(String[] args) {
		int[] arr = new int[1];
		
		try {
			for (int i = 0; i < 1000; i++) { // UnCheckedException
				System.out.println(arr[i]);
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("배열 길이 보다 긴값입니다");
		}
		/*
		for (int i = 0; i < 1000; i++) { // UnCheckedException
			System.out.println(arr[i]);
		}
		
		File file = new File("없는파일");
		//FileReader fr2 = new FileReader(file);
		try {
			FileReader fr = new FileReader(file);
		} catch (FileNotFoundException e) {
			System.out.println("file이 없을수 있어서 이클립스에서 실행전에 에러를 trycach문으로 잡아야하므로 CheckedException입니다");
			e.printStackTrace();
		}
		*/
	}
}
