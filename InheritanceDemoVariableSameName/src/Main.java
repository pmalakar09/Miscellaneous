class Demo
{
	int i=100;
	void disp()
	{
		System.out.println("Parent");
	}
}
class Demo1 extends Demo
{
	//int i=10;
	{
 i=20;
	}
	void disp()
	{
		System.out.println("child");
	}
}
class Main
{
	public static void main(String[] args) {
		//Demo d=new Demo();
		Demo1 d1=new Demo1();
		Demo dd=new Demo1();
		//d.disp();
		//System.out.println(d.i);
		d1.disp();
		System.out.println(d1.i);
		dd.disp();
		//System.out.println(((Demo1)dd).i);
		System.out.println(dd.i);
		
	}
}