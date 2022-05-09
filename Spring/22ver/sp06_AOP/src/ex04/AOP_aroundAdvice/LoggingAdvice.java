package ex04.AOP_aroundAdvice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.util.StopWatch;

// XML 기반 POJO 방식의 AspectJ를 이용한 AOP 방법 
public class LoggingAdvice {
	public Object arround(ProceedingJoinPoint pjp) throws Throwable { // 예외발생 - 위임
		String methodName1 = pjp.getKind(); // getKind() : 추상메서드 
		String methodName2 = pjp.getSignature().getName();
		
		System.out.println("[LOG] methodName1 = " + methodName1 + ", methodName2 = " + methodName2+ " 호출되기 전");
		
		StopWatch sw = new StopWatch();
		sw.start(methodName1);
		
		/*
		 * Around 방식의 사전/사후 처리 AOP around 방식으로 할 때는 반드시 인수(파라미터)로,
		 * ProceddingJoinPoint, 리턴 - Object type 필수
		 */
		
		// main 관심 실행 
		/////////////////////////A/////////////////////
		Object obj = pjp.proceed(); // .proceed() : Join Point  
		//////////////////////////////////////////////
		
		System.out.println("[LOG] "+methodName2+ " 호출 완료되었음.");
		System.out.println("[LOG] 실행시간 : "+ sw.getTotalTimeMillis()/1000+ "초");
		return null;
	}
}
