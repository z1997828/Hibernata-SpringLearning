package ch04._02.aspectj.aspect._02;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect; // 需要 aspectjrt.jar
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspectAfterAdvice {

//	@After說明本通知為一個後置通知：在監控(即目標)方法開始執行之後，執行此通知。
//	無論是否丟出例外，都要執行本通知。
//	注意：在後置通知中無法得到目標方的傳回值，因為目標方法也許丟出例外而沒有傳回值。
//	傳回值必須在返回通知內取得。
	@After("execution (public int ch04._02.aspectj.interfaces.ArithmeticCalculator.*(..))")
	public void afterMethod(JoinPoint joinPoint) {
		String methodName = joinPoint.getSignature().getName();
		System.out.println("After Advice送出的訊息：方法 " + methodName + " 結束執行");
	}
}
