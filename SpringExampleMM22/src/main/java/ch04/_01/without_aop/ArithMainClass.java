package ch04._01.without_aop;

import ch04._01.without_aop.impl.ArithmeticCalculatorLoggingImpl;
import ch04._01.without_aop.interfaces.ArithmeticCalculator;

public class ArithMainClass {

	public static void main(String[] args) {
		ArithmeticCalculator ac = new ArithmeticCalculatorLoggingImpl();
		int result = ac.add(1, 2);
		System.out.println("-->" + result);
		result = ac.div(4, 2);
		System.out.println("-->" + result);

	}

}
