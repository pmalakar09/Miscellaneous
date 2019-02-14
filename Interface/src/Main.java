interface Cal1
{
	int cal=100; //* By default final
	void mal();
}
interface Cal2
{
	void mal();
}
class Calculator implements Cal1,Cal2
{
	public void mal()
	{
		int a,b,c;
		a=20;
		b=20;
		c=a*b;
		System.out.println(c);
	}
}
class Main
{
	public static void main(String[] args) {
		Calculator c=new Calculator();
		Cal2 c2;
		c2=c;
		c2.mal();
		Cal1 c1;
		c1=c;
		c1.mal();
		System.out.println(c1.cal);
	}
}