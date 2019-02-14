class Demo
{
	 void disp()
	{
		System.out.println("In Demo Class");
	}
}
class Demo1 extends Demo
{
	 void disp()
	{
		System.out.println("In Demo1 Class");
	
	}
}
class DemoMain
{
	public static void main(String[] args) {
		Demo d1=new Demo1();
		d1.disp();
	    
	}
}