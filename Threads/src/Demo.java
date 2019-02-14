import java.util.*;
import java.io.*;
class Demo1 extends Thread
{
	public void run()
	{
		try{
		System.out.println(Thread.currentThread().getName());
		System.out.println("Banking Process Is Starting");
		Scanner scan=new Scanner(System.in);
		System.out.println("Please Enter Your Account No.: ");
		int accno=scan.nextInt();
		System.out.println("Please Enter Your Password");
	                   int pass=scan.nextInt();
		Thread.sleep(3000);
		System.out.println("Please Collect Your Money");
		System.out.println("Banking Process Is Completed");
		    }
		catch(Exception e)
		{
			System.out.println("Some Exception Occur");
		}
	}
}
class Demo2 extends Thread
{
public void run()
{
	try{
	   	   System.out.println(Thread.currentThread().getName());
	       System.out.println("Printing Task Is Starting");
	       for(int i=1;i<=5;i++)
	           {
	            	System.out.println("Prasenjit Malakar");
		            Thread.sleep(2000);
	           }
	       System.out.println("Printing Process Is Completed");
          }

catch (Exception e)
   {
	System.out.println("Some Exception Occur");
    }
}
}
class Demo3 extends Thread
{
	
	public void run()
	{
		try{
	    System.out.println(Thread.currentThread().getName());
		System.out.println("Adding Process Is Started");
		int i=5000;
		int j=6000;
		int k=i+j;
		Thread.sleep(3000);
		System.out.println(k);
		System.out.println("Adding Process Is Completed");
                                            }
	catch (Exception e)
	          {
		          System.out.println("Some Exception Occur");
	          }
	}
}

class Demo
{
	public static void main(String[] args)  throws Exception
	{
		Demo1  d1=new Demo1();
		d1.setName("Banking");
		Demo2 d2=new Demo2();
		d2.setName("Printing");
		Demo3 d3=new Demo3();
		d3.setName("Adding");
		System.out.println(Thread.currentThread().getName());
		d1.start();
		System.out.println(Thread.currentThread());
	   d1.join();
		System.out.println(Thread.currentThread().getName());
		d2.start();
		System.out.println(Thread.currentThread().getName());
		d3.start();
              System.out.println(d1.isAlive());
              System.out.println(d2.isAlive());
              System.out.println(d3.isAlive());
              d1.join();
              d2.join();
             d3.join();
              System.out.println("In Main Method()");
              System.out.println(Thread.currentThread());
              System.out.println(d1.isAlive());
              System.out.println(d2.isAlive());
              System.out.println(d3.isAlive());
             // System.out.println(d1.getName());
              System.out.println(Thread.currentThread());
	}
}
