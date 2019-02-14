interface  Plane
{
	void takeoff();
	
	void land();
	
}
class Passenger implements Plane
{
	public void takeoff()
	{
		System.out.println("Passenger Plane Is Taking Off");
	}
	void fly()
	{
		System.out.println("Passenger Plane Is Flying At Medium Speed");
	}
	public void land()
	{
		System.out.println("Passenger Plane Is Landing Safely");
	}
}
class Cargo implements Plane
{
	public void takeoff()
	{
		System.out.println("Cargo Plane Is Taking Off");
	}
	void fly()
	{
		System.out.println("Cargo Plane Is Flying At Low Speed");
	}
	public void land()
	{
		System.out.println("Cargo Plane Is Landing Safely");
	}
}
class Fighter implements Plane
{
	public void takeoff()
	{
		System.out.println("Fighter Plane Is Taking Off");
	}
	void fly()
	{
		System.out.println("Fighter Plane Is Flying At High Speed");
	}
	public void land()
	{
		System.out.println("Fighter Plane Is Landing Safely");
	}
}
class Airport
{
	void airport(Plane ref)
	{
		ref.takeoff();
		ref.land();
	}
}
class LaunchPlane
{
	public static void main(String []args)
	{
		Passenger pp=new Passenger();
		Cargo cp=new Cargo();
		Fighter fp=new Fighter();
		Airport a=new Airport();
		Plane ref;
		a.airport(pp);
		ref=pp;
	    ((Passenger)ref).fly();
		a.airport(cp);
		ref=cp;
	    ((Cargo)ref).fly();
		a.airport(fp);
		ref=fp;
	    ((Fighter)ref).fly();
	
	}
	
}














