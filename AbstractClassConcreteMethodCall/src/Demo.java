abstract class Demo1
{
	abstract void disp1();
	void disp2()
	{
		System.out.println("I Am In Abstract Class & Concrete Method() disp2");
	}
}
class Demo extends Demo1
{
	void disp1()
	{
		System.out.println("I Am In Implemented Method() disp1");

	}
	public static void main(String[] args) {
		
		Demo1 d1;
		Demo d2=new Demo();
		d1=d2;
		d1.disp1();
		d1.disp2();
		System.out.println("-------");
		d2.disp1();
		d2.disp2();
	}
}