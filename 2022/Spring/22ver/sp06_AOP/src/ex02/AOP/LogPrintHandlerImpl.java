package ex02.AOP;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StopWatch;

public class LogPrintHandlerImpl implements InvocationHandler {

	private Object target;
	
	// DI (생성자를 이용한 Dependency Injection 하겠다.)
	public LogPrintHandlerImpl(Object target) {
		this.target = target;
	}
	
	// 보통 이곳에 보조 프로그램을 작성한다. 
	@Override
	// Object이므로 어떤 타입이든지 올 수 있다. 
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("invoke method start !!!!!!!!!!!!!!!!!!!!");
		
		// 보조 업무 구현 
		
		Log log = LogFactory.getLog(this.getClass()); 
		StopWatch sw = new StopWatch();
		sw.start(); //시간 측정 시작
		log.info("타이머 시작");
			
		// main 관심 실행 
		//////////////////////////////////////////////
		int result = (int)method.invoke(target, args);
		//////////////////////////////////////////////
		
		log.info("타이머 정지");
		sw.stop(); //시간 측정 끝 
		
		log.info("[TimerLOG] Method: " + method.getName()); // 실행한 메소드 명칭 | invoke의 method
		log.info("[TimerLOG] process Time: "+sw.getTotalTimeMillis());
		
		return result;
	}
}
