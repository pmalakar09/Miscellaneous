import java.util.*;
class DemoEx
{
	void fun1()
	{
		System.out.println("Entering fun 1");
		try{
			fun2();	
		}
		catch(Exception e)
		{
			System.out.println("Exception caught in fun 1");
			throw e;
		}
	}
	void fun2()
	{
		System.out.println("Entering fun 2");
		int a,b,c;
		try{
			a=10;b=0;
			c=a/b;
			System.out.println(c);
		}
		catch(Exception e)
		{
			System.out.println("Exception caught in fun 2");
			throw e;
		}
	}
}
class DemoMain{
	public static void main(String[] aa)
	{
		DemoEx obj=new DemoEx();
			System.out.println("Entering main()");
			try{
				obj.fun1();
			}
			catch(Exception e)
			{
				System.out.println("Exception caught in main");
			}
			System.out.println("Exiting main normally");
	}
}