package env;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/*
@Configuration : XML 설정파일의 역할을 대신하는 클래스로 정의함.
	>> 이를 사용함으로써 이는 XML이 된 것임.
 */
@Configuration
public class EnvApplicationConfig {

	
	//외부파일의 '경로설정(1번째)' 및 읽어오기
	// [순서: 1번째]
	@Bean
	public static PropertySourcesPlaceholderConfigurer Properties() {
		
		//1. 프로퍼티 파일을 읽어오기 위한 객체생성
		PropertySourcesPlaceholderConfigurer config =
			new PropertySourcesPlaceholderConfigurer();
		
		//2. 프로퍼티 파일의 위치를 설정하기 위한 Resource 타입의 객체생성
		Resource[] locations = new Resource[2];
		
		//classpath:설정파일.xml과 동일한 설정
		//그러므로 EnvBoard1.properties앞에 classpath:를 붙이지 않아도 O
		//ClassPathResource객체가 대체함.
		locations[0] = new ClassPathResource("EnvBoard1.properties");
		locations[1] = new ClassPathResource("EnvBoard2.properties");
		
		//3. 설정된 위치의 config참조변수의 매개변수로 파일을 읽어옴
		config.setLocations(locations);
		
		return config;
	}
	
	
	/*
	@Value : 멤버변수 초기값을 어노테이션으로 정의한다.
			 각 프로퍼티 파일의 속성명을 EL을 통해 읽어옴.
			 >> 값을 설정함 (2번째)
	 [순서: 2번째]
	 */
	@Value("${board1.user}")
	private String board_user;
	
	@Value("${board1.pass}")
	private String board_pass;
	
	@Value("${board2.driver}")
	private String board_driver;
	
	@Value("${board2.url}")
	private String board_url;
	
	
	//Bean의 초기값을 설정하는 부분
	//프로퍼티 소스를 통해 '읽어온 값'으로 빈을 생성함.
	// [순서: 3번째]
	@Bean
	public BoardConnection boardConfig() { //boardConfig가 객체의 참조변수 이름이 됨(자바파일이므로 EnvironmnetController.java파일의 main3 bConn에) 
		
		//DTO객체를 생성하고 setter()를 통해 초기값을 설정함.
		BoardConnection bconn = new BoardConnection();
		
		bconn.setUser(board_user);
		bconn.setPass(board_pass);
		bconn.setDriver(board_driver);
		bconn.setUrl(board_url);
		
		return bconn;
	}
}
