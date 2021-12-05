210621 Spring
>>Spring 종류 2
1. Legacy
2. Boot ?

sts : Spring Tool Suite

site : spring.io

spring >> 기본적으로 무겁다.
*Dependency 의존성 
	: 어떠한 프로그램을 사용하겠다. 라는 뜻
	이하 확장 라이브러리(jar)들을 사용하겠다.
Maven << 빌드 도구
ㄴ pom.xml에서 몇가지 수정하면 사용?할 수 있다. (기존방식과 다르게)

/K11SpringLegacy/src/main/java/com/kosmo/k11springlegacy/HomeController.java
에서 어노테이션 확인
@RequestMapping(value = "/", method = RequestMethod.GET)
URL창에서 http://localhost:8081/k11springlegacy/
	ㄴ 이하 뒷문장 ~~~.jsp없이도 사용 O

/K11SpringLegacy/src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml
에서
<beans:bean class="org.springframework.web.servlet.view.InternalResourceViewResolver">
		<beans:property name="prefix" value="/WEB-INF/views/" />
		<beans:property name="suffix" value=".jsp" />
	</beans:bean>
를 확인해보면
/K11SpringLegacy/src/main/webapp/WEB-INF/views/home.jsp [비교]
/WEB-INF/views/   << 같다
.jsp		<< 같다
이처럼 이를 따와서 조립하는.

WEB-INF/servlet-context.xml << 앞으로 자주 열게 될 파일
여기서
<resources mapping="/resources/**" location="/resources/" />
<resources mapping="/images/**" location="/resources/" />  <-새로 지정함.
이름만 다를뿐 같은 경로임.
이처럼 스프링은 처음부터 끝까지 매핑임(농담반)

[Spring 실행방법]
실행을 하기 위해서는 .jsp에서 직접 실행하지 않고
프로젝트 폴더에서 마우스 우클릭>Run As
로 실행한다.

home.jsp 에서 
<h3>첫번째 컨트롤러 만들기</h3>
<ul>
	<li><a href="./home/helloSpring" target="_blank">
		첫번째 컨트롤러 바로가기
	</a></li>
</ul>

이를 매핑하기 위해 src/main/java 패키지 하위의 HomeController.java에서
@RequestMapping("/home/helloSpring")
public String helloSpring(Model model) {
		
	String firstMessage = "My first SPRING MVC 컨트롤러";
	model.addAttribute("firstMessage", firstMessage);
		
	return "HelloSpring";
}
한 뒤, WEB-INF폴다 하위의 views에 HelloSpring.jsp를 생성
