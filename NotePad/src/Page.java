import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

public class Page {
	public static void main(String[] args) {
		int j = 0;
		Scanner sc = new Scanner(System.in);
		System.out.println("Please Enter The No. of Digit: ");
		j = sc.nextInt();
		double d= sc.nextDouble()
				String s=sc.nextLine();
		s.length()
		int[] i = new int[j];
		for (int k = 0; k < j; k++) {
			i[k] = sc.nextInt();
		}
		// int max=0; //** Fails when all the values in the Array are -ve
		int max = Integer.MIN_VALUE;
		for (int k = 0; k < i.length; k++) {
			if (max < i[k]) {
				max = i[k];
			}
		}
		System.out.println("MAX No. Is: " + max);
		System.out.println("Withou Sorted Array :" + Arrays.toString(i));
		Arrays.sort(i);
		//int Amount = ((int)Float.parseFloat(pTransRec.getServiceCharge().getAmount()))*10000;
		//int Amount = ((int)Float.parseFloat(0.10))*10000;
		System.out.println(Float.MAX_EXPONENT+"-----"+Float.MAX_VALUE);
		/*
		 * System.out.println("Sorted Array :" + Arrays.toString(i)); int[] p =
		 * new int[j]; int c; for (c = 0; c < j; c++){ if (i[c] >=i[c + 1]) {
		 * p[c]=i[c+1]; } }
		 * System.out.println("Sorted value: "+Arrays.toString(p));
		 */
		/*
		 * int temp=0; for (int count=1; count<i.length;count++){ for(int
		 * count1=count;count1<0;count1--){ if (i[count1]<i[count1-1]){
		 * temp=i[count1]; i[count1]=i[count1-1]; i[count1-1]=temp; } } } for
		 * (int x = 0; x < i.length; x++) { System.out.println("LOOP: "+i[x]); }
		 */
		String Timestamp=new java.text.SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ").format(new Date());
		System.out.println(Timestamp);
	}
}
