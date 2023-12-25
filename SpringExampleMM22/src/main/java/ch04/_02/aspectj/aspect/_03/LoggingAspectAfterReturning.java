package ch04._02.aspectj.aspect._03;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect; // 需要 aspectjrt.jar
import org.springframework.stereotype.Component;


@Aspect
@Component
public class LoggingAspectAfterReturning {
//	@AfterReturning()有兩個屬性：value與returning。returning屬性定義一個可以傳入方法傳回值的參數給advice。
//	因此返回通知可以定義兩個參數：
//	(1)JoinPoint，參數名稱自定
//	(2)代表傳回值的 Object， 參數名稱必須為returning屬性定義的屬性值
	@AfterReturning(
      	value = "execution (* ch04._02.aspectj.interfaces.ArithmeticCalculator.*(..))", 
			returning = "result")
	public void afterReturningMethod(JoinPoint joinPoint, Object result) {
		String methodName = joinPoint.getSignature().getName();
	    System.out.println("After Returning送出的訊息：方法 " + methodName + " 結束執行，傳回值為" + result);
	}	
}
