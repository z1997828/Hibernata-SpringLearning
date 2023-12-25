package ch04._02.aspectj.interfaces.impl;

import org.springframework.stereotype.Component;

import ch04._02.aspectj.interfaces.ArithmeticCalculator;

@Component("arithmeticCalculator")
public class ArithmeticCalculatorImpl implements ArithmeticCalculator {

	@Override
	public int add(int i, int j) {
		int result = i + j;
		return result;
	}

	@Override
	public int sub(int i, int j) {
		int result = i - j;
		return result;
	}

	@Override
	public int mul(int i, int j) {
		int result = i * j;
		return result;
	}

	@Override
	public int div(int i, int j) {
		int result = i / j;
		return result;
	}

	@Override
	public int abs(int i) {
		return Math.abs(i);
	}

	@Override
	public String hello() {
		return "Hello, Snoopy";
		
	}

}
