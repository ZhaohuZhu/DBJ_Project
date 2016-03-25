package ch4.test;

import javax.naming.InitialContext;
import javax.naming.NamingException;


import ejb.book.ch4.CalculatorRemoteBusiness;

public class Main {

	private static CalculatorRemoteBusiness calc;
	private static CalculatorAssertionDelegate assertion;

	public Main() {
		super();
		assertion = new CalculatorAssertionDelegate();
	}

	private void findBean() throws NamingException {
		InitialContext ctx = new InitialContext();
		calc = (CalculatorRemoteBusiness)
				ctx.lookup("java:global/CalculatorEAR/CalculatorEJB/CalculatorBean!ejb.book.ch4.CalculatorRemoteBusiness");
		System.out.println(calc);
	}

	public void doTest() {
		try {
			findBean();
			assertion.assertAdditionSucceeds(calc);
			

		} catch (Exception ex) {
			System.err.println("Caught an unexpected exception!");
			ex.printStackTrace();
			System.exit(1);
		}
	}

	public static void main(String[] args) {
		Main m = new Main();
		m.doTest();
	}

}