package duplicateHash;

import java.util.HashSet;
import java.util.Iterator;

public class SetDemo 
{

	public static void main(String[] args) 
	{
	 System.out.println("Program Starts...");
	 
	 HashSet hs1 = new HashSet();
	 
	 Employee e1 = new Employee(1010,"Ranbir",5000);
	 Employee e2 = new Employee(4510,"Malika",4500);
	 Employee e3 = new Employee(4561,"Rajanikanth",10000);
	 Employee e4 = new Employee(4510,"Malika",4500);
	 
	 /*System.out.println(e1.EID);
	   System.out.println(hs1.add(e3));
	   System.out.println(hs1.add(e2));
	   System.out.println(hs1.add(null));*/
	 System.out.println(hs1.add(e1)); 
	 System.out.println(hs1.add(e2));
	 System.out.println(hs1.add(e3));
	 System.out.println("--------------------");
	 System.out.println(hs1);
	 System.out.println("--------------------");
	System.out.println(hs1.contains("4561"));
	 int temp = e4.EID;
	 if(temp==e1.EID ||temp==e2.EID|| temp==e3.EID)
	 {
		 System.out.println("Can not add Employee with same EID");
	 }
	 else
	 {
		 System.out.println(hs1.add(e4)); 
	 }
	 
	 for(Object obj : hs1) 
	 {
		 System.out.println(obj); 
//Overridden method of employee class is Executed
	 }
	 Iterator itr1 = hs1.iterator();
	 
	 while(itr1.hasNext())
	 {
		 Object obj = itr1.next();
		 Employee et1 = (Employee) obj;
		 System.out.println(et1.name);
	 }
	 

	}

}

