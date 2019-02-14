interface Train
{
	void deperture();
	void running();
	void arrived();
}
class YPR implements Train
{
	public void deperture()
	{
		System.out.println("YPR Is Ready For Deperture :)");
	}
	public void running()
	{
		System.out.println("YPR Is Running At The Speed Of 110Km/Hr");
	}
	public void arrived()
	{
		System.out.println("YPR Is Arrived At The Right Time");
	}
}
class Duronto implements Train
{
	public void deperture()
	{
		System.out.println("DURONTO Is Ready For Deperture :)");
	}
	public void running()
	{
		System.out.println("DURONTO Is Running At The Speed Of 150Km/Hr");
	}
	public void arrived()
	{
		System.out.println("DURONTO Is Arrived At The Right Time");
	}	
}
class Platform
{
	void allowTrain(Train t)
	{
		t.deperture();
		t.running();
		t.arrived();
	}
}
public class MainClass
{
public static void main(String[] args) 
{
	YPR y=new YPR();
	Duronto d=new Duronto();
	Platform p=new Platform();
	p.allowTrain(y);
	p.allowTrain(d);
}
}
