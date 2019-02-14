class Demo implements Runnable
{
	public void run() 
	{
		
	}
}
public class MainClass 
{
	public static void main(String[] args) 
	{
		Runnable r;
		Thread t;
		Demo d=new Demo();
		r=d;
		t=(Thread)r;
	}

}
