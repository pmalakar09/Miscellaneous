import java.util.Scanner;
class ALessThanBException extends Exception
{
	public String mygetMessage()
	{
		return "Error in input diff is not possible";
	}
}
public class DemoEx {
	public static void main(String[] args) {
		int a,b,c;
		Scanner input=new Scanner(System.in);
		{
			System.out.println("Enter a");
			a=input.nextInt();
			System.out.println("Enter b");
			b=input.nextInt();
			try
			{
				if(a>b)
				{
					c=a-b;
					System.out.println("Difference is="+c);
				}
				else
				{
					ALessThanBException obj=new ALessThanBException();
					throw obj;
					// Alternet syntax for throwing an exception
					//throw new ALessThanBException(); 
				}
					
			}
			catch(Exception obj)
			{
				System.out.println(((ALessThanBException)obj).mygetMessage());
			}
		}
		System.out.println("Exiting main normally");
	}
}