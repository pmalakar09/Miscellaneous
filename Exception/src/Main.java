import java.util.Scanner;

class Demo {
	int a, b;
	float res;

	void input() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Please Input The 1st Digit");
		a = scan.nextInt();
		System.out.println("Please Input The 2nd Digit");
		b = scan.nextInt();
	}

	float cal() {
		try {
			res = a / b;
			// return res;
		} catch (ArithmeticException e) {
			System.out.println("Div By Zero");
			throw e;
		}
		// System.out.println("After Catch");
		finally {
			System.out.println("Finally Block");
			// return res;
		}
		return res;
	}
}

public class Main {
	public static void main(String[] args) {
		Demo d = new Demo();
		d.input();
		try {
			System.out.println(d.cal());
		} catch (ArithmeticException e) {
			System.out.println("In Main Catch");
		}
	}
}
