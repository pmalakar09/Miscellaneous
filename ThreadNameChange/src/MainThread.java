class DemoThread extends Thread
{
	
}
public class MainThread 
{
public static void main(String[] args) 
{
	DemoThread dt=new DemoThread();
	dt.setName("Prasenjit");
	System.out.println(dt.getName());
	System.out.println(Thread.currentThread().getName());
	
}

}
