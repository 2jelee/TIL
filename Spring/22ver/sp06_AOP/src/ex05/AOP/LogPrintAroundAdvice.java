package ex05.AOP;

import java.util.Arrays;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StopWatch;

public class LogPrintAroundAdvice implements MethodInterceptor {

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		
		//보조 업무 구현
		
		Log log = LogFactory.getLog(this.getClass()); 
		StopWatch sw = new StopWatch();
		sw.start(); //시간 측정 시작
		log.info("타이머 시작");
		
		//////////////////////
		Object result = invocation.proceed(); //주 관심사의 함수가 호출되는 부분  
		/////////////////////
		
		log.info("타이머 정지");
		sw.stop(); //시간 측정 끝 
		
		log.info("[TimerLOG] Method: " + invocation.getMethod()); // 실행한 메소드 명칭 
		System.out.println("[Time LOG] args: " + Arrays.toString(invocation.getArguments())); //인자 넘어온거 확인
		log.info("[TimerLOG] process Time: "+sw.getTotalTimeMillis());
		
		return result;
	}

}
