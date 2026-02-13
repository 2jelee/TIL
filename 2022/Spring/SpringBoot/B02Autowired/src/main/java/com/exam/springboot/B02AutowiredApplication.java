package com.exam.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
@SpringBootApplication 어노테이션은 아래 3가지 역할을 수행한다. 
	수행1 : @Congiguration 
		빈을 생성할때 싱글톤으로 한번만 생성한다. 
	수행2 : @EnableAutoConfiguration
		스프링 어플리케이션 컨텍스트를 만들때 자동으로 설정하는 기능을 켠다. 
		사용자가 필요할것 같은 빈을 추측해서 ApplicationContext를 만들때 필요한 설정을 한다. 
	수행3 : @ComponentScan
		지정한 위치 이하에 있는 @Component와 @Configuration 어노테이션이 붙은 
		클래스를 스캔해서 빈으로 등록한다. 
 */
@SpringBootApplication
public class B02AutowiredApplication {

	public static void main(String[] args) {
		/*
		스프링 부트를 실행하면 자동으로 빈을 검색하고 등록한 후 main() 메서드의 
		SpringApplication.run()을 통해 내장 톰켓을 실행한 후, 자동으로 Web
		ApplicationContext를 생성한다. 
		 */
		SpringApplication.run(B02AutowiredApplication.class, args);
	}

}
