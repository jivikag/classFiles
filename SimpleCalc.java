import java.util.List;		// used by expression evaluator
import java.util.ArrayList;
import java.util.Scanner;

/**
 *	<Description goes here>
 *
 *	@author	Jivika Gulrajani
 *	@since	February 27, 2024
 */
public class SimpleCalc {
	
	private ExprUtils utils;	// expression utilities
	
	private ArrayStack<Double> valueStack;		// value stack
	private ArrayStack<String> operatorStack;	// operator stack

	// constructor	
	public SimpleCalc() {
		
	}
	
	public static void main(String[] args) {
		SimpleCalc sc = new SimpleCalc();
		sc.run();
	}
	
	public void run() {
		System.out.println("\nWelcome to SimpleCalc!!!");
		runCalc();
		System.out.println("\nThanks for using SimpleCalc! Goodbye.\n");
	}
	
	/**
	 *	Prompt the user for expressions, run the expression evaluator,
	 *	and display the answer.
	 */
	public void runCalc() {
		
		boolean quit = false;
		double answer = 0;
		while (!quit){
			
			String expression = Prompt.getString("");
			if (expression.equals("h")) {
				printHelp();
			}
			else if (expression.equals("q")) {
				quit = true;
			}
			else {
				utils = new ExprUtils();
				List<String> expressionTokens = utils.tokenizeExpression(expression);
				answer = evaluateExpression(expressionTokens);
				System.out.println(answer);
				
				
			}
		}
	}
	
	/**	Print help */
	public void printHelp() {
		System.out.println("Help:");
		System.out.println("  h - this message\n  q - quit\n");
		System.out.println("Expressions can contain:");
		System.out.println("  integers or decimal numbers");
		System.out.println("  arithmetic operators +, -, *, /, %, ^");
		System.out.println("  parentheses '(' and ')'");
	}
	
	/**
	 *	Evaluate expression and return the value
	 *	@param tokens	a List of String tokens making up an arithmetic expression
	 *	@return			a double value of the evaluated expression
	 */
	public double evaluateExpression(List<String> tokens) {
		double value = 0;
		int count = 0;
		valueStack = new ArrayStack<Double>;
		operatorStack = new ArrayStack<String>;
		
		
		while (!valueStack.isEmpty() && !operatorStack.isEmpty()) {
			
			if (utils.isOperator(tokens.get(count)) {
				valueStack.push(tokens.get(count));
			}
			else {
				operatorStack.push(tokens.get(count));
			}
			
			count++;
		}
		
		return value;
	}
	
	/**
	 *	Precedence of operators
	 *	@param op1	operator 1
	 *	@param op2	operator 2
	 *	@return		true if op2 has higher or same precedence as op1; false otherwise
	 *	Algorithm:
	 *		if op1 is exponent, then false
	 *		if op2 is either left or right parenthesis, then false
	 *		if op1 is multiplication or division or modulus and 
	 *				op2 is addition or subtraction, then false
	 *		otherwise true
	 */
	private boolean hasPrecedence(String op1, String op2) {
		if (op1.equals("^")) return false;
		if (op2.equals("(") || op2.equals(")")) return false;
		if ((op1.equals("*") || op1.equals("/") || op1.equals("%")) 
				&& (op2.equals("+") || op2.equals("-")))
			return false;
		return true;
	}
	 
}
