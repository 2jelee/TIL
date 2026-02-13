package ex06.AOP.annot;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.weaver.patterns.IScope;

// Advice class - around 적용

/*
스프링의 @Aspect는 포인트컷(Pointcut)과 어드바이스(Advice)로 구성된 어드바이저(Advisor)의 생성을 편리하게 해주는 기능을 가진 어노테이션입니다. 실제 실무에서는 직접 어드바이저를 생성하는 것이 아닌 @Aspect 어노테이션을 이용하여 AOP를 적용합니다.
AspectJ는 스프링에서 지원되는 기술이지만, 사실 PARC 사에서 개발한 자바 프로그래밍 언어용 관점 지향 프로그래밍 확장 기능입니다. 출시된 이후 단순함과 편리함을 기반으로 다양한 곳에서 사용되면서 스프링 프레임워크 또한 이를 차용하여 제공된 것입니다.
Adivisor 생성 및 저장 : AutoProxyCreator는 조회된 @Aspect의 정보를 기반으로 어드바이저를 생성한 후 @AspectJAdvisorBuilder에 저장합니다.

기존에는 Pointcut객체와 MethodInterceptor를 확장(implements)하는 Advice객체를 생성하여 어드바이스 객체에 주입해주어야 했지만, 이제는 @Aspect를 사용하여 자동으로 어드바이저를 생성할 수 있습니다.

@어드바이스 : @Around, @After, @Before 등 다양한 종류가 있으며 어드바이스 로직(부가기능)을 실행 할 위치를 지정해 줍니다. 예를 들어 @After를 사용했다면, 실제 타깃 메서드를 호출한 뒤에 어드바이스 로직이 실행됩니다.
AspectJ표현식 : @어드바이스 내부에 표현된 문자열 형식의 표현식으로 프록시 적용 대상을 판별하는 포인트컷입니다.
ProceedingJoinPoint joinPoint : 기존 MethodInterceptor를 확장하여 Advice를 구현할 때 MethodInvocation invocation과 유사한 역할을 수행합니다. 내부적으로 실제 호출 대상, 호출 메서드, 전달 인자 등의 정보가 들어있습니다. 사용된 어드바이스가 @Around 일 경우에는 ProceedingJoinPoint를 사용하지만 이 외의 어드바이스를 사용하는 경우에는 JoinPoint를 사용해야 합니다.
joinPoint.proceed() : 실제 타깃 요청을 위임하는 메서드입니다. @Around 이외의 어드바이스를 사용한 경우 실제 타깃의 요청 위임은 자동으로 실행되므로 직접 호출하지 않습니다.

https://yejun-the-developer.tistory.com/10
 */

@Aspect
// aspect 안에는 반드시 pointcut과 사용하려는 AOP명칭(around, after, before 등... )이 필요하다.  
public class LogApp {
	
	//@Pointcut("execution(public void get*(..))")	// public void인 모든 get메소드
	//@Pointcut("execution(* kr.edu.패키지.*.*())")	// 패키지에 파라미터가 없는 모든 메소드
	//@Pointcut("execution(* kr.edu.패키지..*.*())")	// 패키지 & kr.edu.패키지 하위 패키지에 파라미터가 없는 모든 메소드
	//@Pointcut("execution(* kr.edu.패키지.Worker.*())")	// 패키지.Worker 안의 모든 메소드

	//@Pointcut("within(kr.edu.패키지.*)")	// 패키지 안에 있는 모든 메소드
	//@Pointcut("within(kr.edu.패키지..*)")  // 패키지 및 하위 패키지 안에 있는 모든 메소드
	@Pointcut("within(ex06.AOP.annot..*)") // 모든 메소드

//	@Pointcut("bean(student)") // student 빈에만 적용 
//	@Pointcut("bean(*ker)")	   // ~ker로 끝나는 빈에만 적용
	private void pointCutMethod() { } 
	
	// try ~ catch 대신 위임 사용
	/*
	@Around("pointCutMethod()")
	public Object loggerApp(ProceedingJoinPoint point) throws Throwable{
		String signatureString = point.getSignature().toLongString(); // toLongString() : full name으로 길게(long) 찍어준다. 
		System.out.println(signatureString + " is start !!!!!!!");
		long st = System.currentTimeMillis();
		Object object = point.proceed();
		
		return object;
	}; 
	*/
	
	@Around("pointCutMethod()")
	public Object loggerApp(ProceedingJoinPoint point) throws Throwable { 
		
		String signatureStr = point.getSignature().toLongString();
		System.out.println(signatureStr + " is start...............");
		long st = System.currentTimeMillis(); 
		
		try {
			Object obj = point.proceed(); // 실제 실행 타겟
			
			return obj;  
		} finally {
			long end = System.currentTimeMillis();
			System.out.println(signatureStr + " is finished.");
			System.out.println(signatureStr + " 경과 시간 : "+ (end - st) );
		} 	
	}  // around
	
	@Before("pointCutMethod()")
	public void beforeAdivce() {
		System.out.println("beforeAdvice( )");
		System.out.println("입학과 입사를 축하합니다.");
	}
}
