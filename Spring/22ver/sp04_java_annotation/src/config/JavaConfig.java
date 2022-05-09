package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import spring.Client;

// XML 기반 설정이 아닌 Java 기반 설정을 하겠다. (applicationContext.xml 역할)

// 설정 파일임을 알리는 annotation
@Configuration
public class JavaConfig {
	
	// @Bean으로 객체 생성 
	// applicationContext.xml의 Bean임을 알리는 annotation
	@Bean 
	public Client client() { // return type이 client
		Client client = new Client();
		client.setHost("Server야.");
		return client;
	}
}
