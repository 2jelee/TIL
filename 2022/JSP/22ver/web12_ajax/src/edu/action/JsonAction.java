package edu.action;

import java.util.HashMap;
import java.util.Map;

import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonBuilderFactory;
import javax.json.JsonObjectBuilder;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class JsonAction implements CommandAction {
	 private boolean redirect = false;
	 
	@Override
	public String process(HttpServletRequest request, 
			HttpServletResponse response) throws Exception {
		// key와 value로 구성되어있는 HashMap 생성.
        Map<String, String> m = new HashMap();
         
        // Map 타입의 m을 BuilderFactory에 넣어준다. (JsonBuilderFactory는 Json을 만들기 위한 뼈대라고 보면 됨)
        JsonBuilderFactory factory = Json.createBuilderFactory(m);
         
        // createObjectBuilder는 하나씩 넣을 때, createArrayBuilder는 배열로 넣을 때.
        JsonObjectBuilder ob_1 = factory.createObjectBuilder();
        JsonObjectBuilder ob_2 = factory.createObjectBuilder();
        JsonObjectBuilder ob_3 = factory.createObjectBuilder();
        JsonArrayBuilder ab = factory.createArrayBuilder();
         
        // 첫번째 JsonObjectBuilder에 이름과 나이를 추가.
        ob_1.add("이름", "홍길동");
        ob_1.add("나이", "모름");
         
        // 두번째 JsonObjectBuilder에 홍길동의 위치(위도와 경로)를 추가.
        ob_2.add("위도", "36.3713874817");
        ob_2.add("경도", "127.645332336");
         
        // 세번째 JsonObjectBuilder에 홍길동의 위치(위도와 경로)를 추가.
        ob_3.add("위도", "50.153273512");
        ob_3.add("경도", "110.99976542");
         
        // 두번째와 세번째 JsonObjectBuilder를 ArrayBuilder에 넣어준다.
        ab.add(ob_2);
        ab.add(ob_3);
         
        // 첫번째 JsonObjectBuilder에 ArrayBuilder를 추가.
        ob_1.add("위치", ab);
         
        // 최종적으로 ob_1 JsonObjectBuilder를 build.
        String jsonStr = ob_1.build().toString();
         
        request.setAttribute("jsonStr", jsonStr);
         
        return "/WEB-INF/jsonTest.jsp";
	}

}
