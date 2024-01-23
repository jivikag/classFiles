/**
 * The APCS exam tests for the following exceptions.
 *	- ArithmeticException
 *	- NullPointerException
 *	- IndexOutOfBoundsException
 *	- ArrayIndexOutOfBoundsException
 *	- IllegalArgumentException
 */

public class ExceptionExamples {
	public static void main(String[] args) {
		ExceptionExamples ee = new ExceptionExamples();
		ee.run();
	}
	
	public void run() {
		arithmetic();
		nullPointer();
		indexBounds();
		arrayIndexBounds();
		illegalArgument();
	}
	
	public void arithmetic() {
		int x = 1;
		int y = 0;
		
		try {
			int z = x/y;
		}
		catch (ArithmeticException e) {
			System.out.println("ERROR: ArithmeticException");
		}
	}
	
	public void nullPointer() {
		Integer[] arr = new Integer[10];
		
		try {
			int z = arr[0].intValue();
		}
		catch (NullPointerException e) {
			System.err.println("ERROR: NullPointerException");
		}
		
	}
	
	public void indexBounds() {
		String hello = "Hello";
		
		try {
			char c = hello.charAt(hello.length());
		}
		catch (IndexOutOfBoundsException e) {
			System.err.println("ERROR: IndexOutOfBoundsException");
		}
	}
	//indexoutofbounds is a super exception to arrindexoutofbounds so it can catch array index out of bounds exception too!!
	public void arrayIndexBounds() {
		int[] arr = new int[10];
		
		try {
			int k = arr[10];
		}
		//arrindexoutofbounds OR indexoutofbounds will work
		catch (ArrayIndexOutOfBoundsException e) {
			System.err.println("ERROR: ArrayIndexOutOfBoundsException");
		}
	}
	
	public void illegalArgument() {
		String str = "hello";
		//compiler doesnt check comments and doesn't check inside the double quotes
		//so this will work, compiler wil js take it as a regular string
		//there will be a runtime error tho
		try {
			System.out.printf("%d\n", str);
		}
		catch(IllegalArgumentException e) {
			System.err.println("ERROR: IllegalArgumentException");
		}
	}
	
}
