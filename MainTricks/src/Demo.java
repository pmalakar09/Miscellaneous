
public class Demo {
//void demo1()
{
	System.out.println("I AM IN OUTSIDE");
}
	public static void main(String[] args) {
	System.out.println("I AM IN MAIN");
    //Demo d;
    new Demo();
   // d.demo1();
    Thread t=Thread.currentThread();
    t.setName("Prasenjit");
    System.out.println(t);
	}

}
