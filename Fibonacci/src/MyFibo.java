import java.util.Scanner;

public class MyFibo 
{
public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	int i=1,j=1,k,count,max=0;
	System.out.println("Enter The Max limit :");
	max=sc.nextInt();
	System.out.print(" "+i+" "+j);
	for(count=0;count<=max;count++)
	{
		k=i+j;
		System.out.print(" "+k);
		i=j;
		j=k;
	}
}
}
