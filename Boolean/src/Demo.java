
public class Demo {
	int k;
	boolean disp()
	{
		int i=5,j=10,k=0; 
		System.out.println("Start");
		boolean result = false;
		try
		{
			while(i>j)
			{
			result=true;
			k++;
			System.out.println(k);
			}
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}
public static void main(String[] args) {
	Demo objDemo=new Demo();
	System.out.println("MAIN K "+objDemo.k);
	System.out.println(objDemo.disp());
}
}
