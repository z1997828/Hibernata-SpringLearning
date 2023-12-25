package ch04._02.aspectj.aspect._01;

import java.util.Arrays;
import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect; // 需要 aspectjrt.jar
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspectBeforeAdvice {

//	@Before說明本通知為一個前置通知：在監控(即目標)方法開始執行之前，先執行此通知
//	注意：在@Before內之Pointcut Expression，不可以寫出方法的形式參數名稱，即不要寫參數的名稱，即(int, int)
//   	
	@Before("execution (* ch04._02.aspectj.interfaces.ArithmeticCalculator.add(int, int)) || execution (* ch04._02.aspectj.interfaces.ArithmeticCalculator.mul(int, int))")
	public void beforeMethod(JoinPoint joinPoint) {
		String methodName = joinPoint.getSignature().getName();
		List<Object> args = Arrays.asList(joinPoint.getArgs());
		System.out.println("Before Advice送出的訊息：方法 " + methodName + " 開始執行，傳入的參數為 " + args);
	}
}
