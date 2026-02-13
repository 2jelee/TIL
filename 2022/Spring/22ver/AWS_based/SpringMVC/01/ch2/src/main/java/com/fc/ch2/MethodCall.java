package com.fc.ch2;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

// Controller를 직접 생성하고 method 호출하는 예제 

class ModelController {
	public String main(HashMap map) {
		// 작업 결과를 map에 저장 
		map.put("id", "asdf");
		map.put("pwd", "1111");
		
		return "txtView2"; // view 이름을 반환 
	}
}

public class MethodCall {
	public static void main(String[] args) throws Exception{
		HashMap map = new HashMap();
		System.out.println("before : " + map); //결과 : before : { }

		ModelController mc = new ModelController(); // ModelController라는 클래스 호출 
		String viewName = mc.main(map); // mc의 main을 호출하여 map에 값을 담기 
		
		System.out.println("after : "+map); // map에 값을 저장하여 반환하기 => 결과 : after : {id=asdf, pwd=1111}
		
		render(map, viewName);
	}
	
	static void render(HashMap map, String viewName) throws IOException {
		String result = "";
		
		// 1. 뷰의 내용을 한줄씩 읽어서 하나의 문자열로 만든다.
		Scanner sc = new Scanner(new File(viewName+".txt"));
		
		while(sc.hasNextLine()) {
			result += sc.nextLine()+ System.lineSeparator();			
		}
		
		// 2. map에 담긴 key를 하나씩 읽어서 template의 ${key}를 value바꾼다.
		Iterator it = map.keySet().iterator();
		
		while(it.hasNext()) {
			String key = (String)it.next();

			// 3. replace()로 key를 value 치환한다.
			result = result.replace("${"+key+"}", (String)map.get(key));
		}
		
		// 4.렌더링 결과를 출력한다.
		System.out.println(result);
	}
} 

/*
[txtView1.txt]
id=${id}, pwd=${pwd}

[txtView2.txt]
id:${id}
pwd:${pwd}



[실행결과]
before : {}
after : {id=asdf, pwd=1111}
[txtView2.txt]
id:asdf
pwd:1111
*/