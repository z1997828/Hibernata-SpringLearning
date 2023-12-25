package ch04._02.aspectj.aspect._04;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect; // 需要 aspectjrt.jar
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspectAfterThrowing {
//
//	@AfterThrowing 說明本方法為一個例外通知，在監控(即目標)方法丟出例外後，執行此通知。若監控方法未丟出例外，則不會執行本通知。
//	 可以得到方法丟出的例外物件。
//	我們可以指定參數ex的型態(如 NullPointException)來篩選程式有興趣的例外
//
	@AfterThrowing(value = "execution (public int ch04._02.aspectj.interfaces.ArithmeticCalculator.*(..))", 
			throwing = "ex")
//  @AfterThrowing()有兩個屬性: value與throwing。throwing屬性定義一個可以傳入方法發生之例外的參數給advice。
//	因此例外通知可以定義兩個參數：
//	(1)JoinPoint，參數名稱自定
//	(2)代表例外物件的 Throwable， 參數名稱必須為throwing屬性定義的屬性值，
//	
//	我們可以更換參數ex的型態(如 NullPointException)來篩選程式有興趣的例外。當出現
//  特定的例外時才執行此通知。	
	public void afterThrowingMethod(JoinPoint joinPoint, Throwable ex) {
		String methodName = joinPoint.getSignature().getName();
		System.out.println("After Throwing送出的訊息：方法 " + methodName + " 丟出例外: " + ex);
		System.out.println("---------------------------------");
	}

}
