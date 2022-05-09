package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import spring.Client2;

// 앞으로 너가 xml 설정파일 역할을 수행할거야.
@Configuration
public class JavaConfig2 {
	
	// @Bean
	@Bean(initMethod = "connect", destroyMethod = "close")
	@Scope("prototype")	//Scope의 역할 ?
	public Client2 client2() {
		Client2 client2 = new Client2();
		client2.setHost("서버2");
		
		return client2; 
	}
}
