class Demo
{
	void method(StringBuffer sb)
	{
		System.out.println("Inside StringBuffer");
	}
	void method(String s)
	{
		System.out.println("Inside String");
	}
}
public class Main {

	public static void main(String[] args) 
	{
		Demo d=new Demo();
		d.method(null);

	}

}
