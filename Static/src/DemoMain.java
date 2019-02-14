class Demo
{
	static int a;
	{
		System.out.println("In The Initialization Block");
    }
	Demo()
	{
		System.out.println("In The Constructor");
	}
	static
	{
		
		System.out.println("In The Static Block");
		
	}

}
class DemoMain
{
	static int c=200;
       {
          System.out.println(c);
       }
	static{
		System.out.println("In The Main Class Static block");
	}
	public static void main(String[] args) {
		Demo d=new Demo();
		Demo d2=new Demo();
		
		//System.out.println(c);
	}
}