import java.util.ArrayList;

public class ArrrayMain {
	public static void main(String[] args) {
		ArrayList al=new ArrayList();
		al.add(1);
		al.add(2);
		al.add(3);
		al.add(4);
		al.add(5);
		System.out.println(al);
		al.add(2, 6);
		System.out.println(al);
		ArrayList al1=new ArrayList();
		al1.add(88);
		al1.add(89);
		al1.add(90);
		al1.add(91);
		al1.add(92);
		al1.add(2.5);
		System.out.println(al1);
		al.addAll(2, al1);
		System.out.println(al);
	}

}
