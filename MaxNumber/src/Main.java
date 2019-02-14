
public class Main 
{
public static void main(String[] args)
{
	int num[]={-10,20,-30,-100};
	//int max=Integer.MAX_VALUE;
	//int max=0;
	int max=num[0];
	for(int i=0;i<4;i++)
	{
		if(num[i]>max)
		{
			max=num[i];
			
		}
			
	}
System.out.println("Maximum Number Is: "+max);
}
}

/*
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;


public class Page {
	public static void main(String[] args) {
		int j=0;
		Scanner sc = new Scanner(System.in);
		System.out.println("Please Enter The No. of Digit: ");
		j=sc.nextInt();
		int[] i = new int[j];
		for (int k=0;k<j;k++){
			i[k]=sc.nextInt();
		}
		//int max=0; //** Fails when all the values in the Array are -ve
		int max=Integer.MIN_VALUE;
		for(int k=0;k<i.length;k++){
			if(max<i[k]){
				max=i[k];
			}
		}
		System.out.println("MAX No. Is: "+max);
	}
}

*/
