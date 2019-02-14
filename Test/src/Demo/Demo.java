package Demo;

class Demo1
{
int a =30;	
void disp()
{
	System.out.println(a);
}
}
class Demo extends Demo1
{
 public static void main(String []args)
 {
	 int a=300;
	 Demo1 d=new Demo1();
	 d.disp();
 }
}