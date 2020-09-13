import java.util.*;
import java.util.Scanner;

class StringExample{
	int i,j,len;
	
	LinkedHashMap c=new LinkedHashMap();
	String str=new String();	
	void getInput()
	{
		Scanner scan=new Scanner(System.in);
		try{
			System.out.println("Enter Your Word-->");
			str=scan.next();
			System.out.println("Your Entered Word Is--> '"+str+"'");
			System.out.println("Now We Are Calculating In This Word ");
			System.out.println("If Any Character Repeatation Found Or Not");
			System.out.println("Please Wait........");
			
			
		}catch(Exception e){}
	}
	
	void characterCount()
	{
		char x = 0;
		int count=0;
		len=str.length();
		
		
		for(i=0;i<len-1;i++)
		{
			count=0;
			
				{
			           for(j=i+1;j<len;j++)
			                {
			                    	if((str.charAt(i))==(str.charAt(j)))
						                {
					                            count++;
						  
					                            x=str.charAt(i);
					                           
							             }
			                    	
						
						      }
			           if(c.containsKey(x)==false)
                       {
                       	c.put(x, count);
                       	count=0;
                       }
		             }
		     }  
	
	
	
	     if(c.isEmpty()==true)
		      {
		     	System.out.println("No Character Repetation Found");
		      }
	    	else
		     {
			System.out.println("The Repeated Characters Are Found : ");
			System.out.println(c);
	     	 }
		
	}
}
public class MainCount {

	public static void main(String[] args) 
	{
		StringExample obj=new StringExample();
		obj.getInput();
		obj.characterCount();
	
		
	}

}
