class Factory
{
int item;
synchronized void producerMachine()
{
	try
	{
		item++;
		System.out.println("Item "+item+" is under PRODUCTION");
		Thread.sleep(4000);
		System.out.println("Item "+item+" is PRODUCED");
		notify();
		wait();
	}
	catch(Exception e)
	{
		System.out.println(e.getMessage());
	}
}
synchronized void consumerMachine()
{
	try
	{
	System.out.println("Item "+item+" is under CONSUMPTION");	
	Thread.sleep(2000);
	System.out.println("Item "+item+" is CONSUMED");
	notify();
	if(item<5)
		{
			wait();
		}
	}
	catch(Exception e)
	{
		System.out.println(e.getMessage());
	}
}
}
class Producer implements  Runnable
{
	Factory f;
	Producer(Factory f)
	{
		this.f=f;
	}
	public void run() 
	{
		for(int i=1;i<=5;i++)
		{
			f.producerMachine();
		}
		
	}
}
class Consumer implements  Runnable
{
	Factory f;
	Consumer(Factory f)
	{
		this.f=f;
	}
	public void run() 
	{
		for(int i=1;i<=5;i++)
		{
			f.consumerMachine();
		}
	}
}
class PCProblem
{
	public static void main(String[] args)
	{
		Factory f=new Factory();
		Producer p=new Producer(f);
		Consumer c=new Consumer(f);
		Thread t1=new Thread(p);
		Thread t2=new Thread(c);
		t1.start();
		t2.start();
		
	}
}