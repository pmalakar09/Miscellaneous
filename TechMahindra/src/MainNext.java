public class MainNext {
	public static void main(String[] args) {
		int i[] = { 1, 2, 3, 4, 5 };
		char c[] = { 'a', 'b', 'c', 'd', 'e' };
		if (i.length == c.length) {
			for (int a = 0; a < i.length; a++) {
				System.out.print(i[a] + "" + c[a]);
			}
		} else {
			System.out.println("Length of i and j mismatched!!");
		}
	}
}
