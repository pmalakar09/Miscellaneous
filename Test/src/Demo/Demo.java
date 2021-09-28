package Demo;

import java.util.ArrayList;

class Demo {

	public static void main(String[] args) {
		int i[] = { 1, 2, 3, 4, 5, 6, 8, 7, 4, 3, 1, 2 };
		ArrayList<Integer> res = new ArrayList<Integer>();
		for (int j = 0; j < i.length; j++) {
			for (int k = j + 1; k < i.length; k++) {
				if (i[j] == i[k]) {
					// System.out.println(i[j]);
					res.add(i[j]);
				}

			}

		}
		System.out.println(res);
	}
}