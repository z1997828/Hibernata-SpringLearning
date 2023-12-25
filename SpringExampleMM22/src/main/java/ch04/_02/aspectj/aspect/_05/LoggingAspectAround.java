package ch04._02.aspectj.aspect._05;

import java.util.Arrays;
import java.util.List;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect; // 需要 aspectjrt.jar
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspectAround {

// @Around說明本方法為一個環繞通知，環繞通知必須定義ProceedingJoinPoint型態的參數 ，
// 	此參數可決定是否要執行目標方法。環繞通知一定需要定義傳回值，此傳回值即為目標方法的
//	傳回值。
// 
//	環繞通知可取代前面四個通知，功能最強，但除非同時需要處理四種通知，否則不一定需要使用此種類型的通知
//	
	@Around(value = "execution (public int ch04._02.aspectj.interfaces.ArithmeticCalculator.*(..))")

	public Object aroundMethod(ProceedingJoinPoint pjp) throws Throwable {
		Object result = null;
		String methodName = pjp.getSignature().getName();
		List<Object> args = Arrays.asList(pjp.getArgs());
		try {
			// 此處的程式碼地位等同於前置通知
			System.out.println("Around送出的訊息：方法 " + methodName + " 開始執行(Around)，傳入的參數為 " + args);
			result = pjp.proceed();  // 執行目標方法
			// 此處的程式碼地位等同於返回通知，返回通知可以取得方法的傳回值，除非方法丟出例外。
			System.out.println("Around送出的訊息：方法 " + methodName + " 結束執行(Around)，傳回值為" + result);
		} catch (Throwable ex) {
			// 此處的程式碼地位等同於例外通知，可以得到方法丟出的例外
			ex.printStackTrace();
			System.out.println("Around送出的訊息：方法 " + methodName + " 丟出例外(Around): " + ex);
		}
		// 此處的程式碼地位等同於後置通知
		// 由於監控方法可能丟出例外，因此後置通知無法取得傳回值
		System.out.println("Around送出的訊息：方法 " + methodName + " 結束執行(Around)");
		return result;
	}
}
