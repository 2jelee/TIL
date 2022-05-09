package ex01;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StopWatch;

// 사칙연산 프로그램 - 더하기, 빼기, 나누기, 곱하기 
public class Calc {
	public int add(int x, int y) {
		// pom.xml에 dependency 추가 (Log, StopWatch) 
		// logging 남기기 
		Log log = LogFactory.getLog(this.getClass()); 
		StopWatch sw = new StopWatch();
		sw.start(); //시간 측정 시작
		log.info("타이머 시작");
		
		int result = x + y; //중심(관심, 주가 되는) 코드 
		
		log.info("타이머 정지");
		sw.stop(); //시간 측정 끝 
		
		log.info("[TimerLOG] Method: add");
		log.info("[TimerLOG] process Time: "+sw.getTotalTimeMillis());
		return result;
	}
	
	public int mul(int x, int y) {
		// pom.xml에 dependency 추가 (Log, StopWatch) 
		// logging 남기기 
		Log log = LogFactory.getLog(this.getClass()); 
		StopWatch sw = new StopWatch();
		sw.start(); //시간 측정 시작
		log.info("타이머 시작");
		
		int result = x - y; //중심(관심, 주가 되는) 코드 
		
		log.info("타이머 정지");
		sw.stop(); //시간 측정 끝 
		
		log.info("[TimerLOG] Method: add");
		log.info("[TimerLOG] process Time: "+sw.getTotalTimeMillis());
		return result;
	}
}