class Demo extends Thread
{
	public void run()
	{
		if(getName().equals("Banking"))
			{
				banking();
			}
		else if (Thread.currentThread().getName().equals("Adding")) 
		{
			adding();
		}
		else
		{
			printing();
		}
	}
	void banking()
	{
		System.out.println("In Banking Task");
	}
	void adding()
	{
		System.out.println("In Adding Task");
	}
	void printing()
	{
		System.out.println("In Printing Task");
	}
}
public class MainThread 
{
public static void main(String[] args) 
{
	Demo d1=new Demo();
	d1.setName("Banking");
	Demo d2=new Demo();
	d2.setName("Adding");
	Demo d3=new Demo();
	d3.setName("printing");
	d1.start();
	d2.start();
	d3.start();
}
}
