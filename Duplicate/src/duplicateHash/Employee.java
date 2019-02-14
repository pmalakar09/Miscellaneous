package duplicateHash;

public class Employee 
{
	int EID;
	String name;
	double sal;
	
	public Employee(int EID, String name, double sal) 
	{
		super();
		this.EID = EID;
		this.name = name;
		this.sal = sal;
	}
	
	@Override
	public String toString()
	
	{
		String info = "Name "+name+",EID "+EID+", Salary "+sal;
		return info;
	
	}

}

