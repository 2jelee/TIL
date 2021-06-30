package mybatis;

import org.springframework.stereotype.Service;

/*
@Service 어노테이션이 있으면 스프링이 시작될때 자동으로 빈이 생성된다.
따라서 해당 프로그램에서는 @Autowired하는 부분이 없으므로 어노테이션이 생략 가능함. 

>> @Service 여기서 빈을 생성할 것이 아니나, 역할을 부여하기 위해
 */
@Service
public interface MybatisMemberImpl {
	//로그인 처리
	public MemberVO login(String id, String pass);
} 
