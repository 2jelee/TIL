package test;

public class Jari {
	public static void main(String[] args) {
		String[] name = {
						        "김병권",  "김성은",  "김용갑",  "김현재",  "나기팔",  "문재웅",  "박영태",  
								"박한수",  "방명철",  "서승범",  "신지훈",  "안민철",  "엄태광",  "윤은혜",  "이람", 
								"doyeon",	"이유경",  "정경수",  "정민석",  "주재철",  "최민혁",  "홍원기"  
							};
						
		int sumName = -1;
		String Aname = "";
		String temp = "";

		System.out.println("th160기 학생 인원수 < " + name.length + " > 명");
		System.out.println("< < < 자리 랜덤 출력 시스템 > > >");
		for (int i = 0; i < 1000; i++) {

			sumName = (int) (Math.random() * name.length);
			//System.out.println("뽑힌 이름 number : " + sumName);
			temp = name[0];
			name[0] = name[sumName];
			name[sumName] = temp;
		
		}
		for (int i = 0; i < name.length; i++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
			System.out.println(+i + 1 + "번 자리는 :" + " < < " + name[i]
					+ " > > " + "님!!!!! 빨리 자리로 달려가세요 님아.....");
		}

	}
}
