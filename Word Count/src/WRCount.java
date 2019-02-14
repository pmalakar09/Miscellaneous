/*Write a program to enter a text. Then enter a pattern and count the number of pattern is repeated in the text.
 Input: She sells sea shells on the sea shore
 Enter Pattern: sea
 output: Pattern found in two times*/
import java.util.*;

class StringRepeat{
		private static final String String = null;
		int i=0,c=0;
	String str=new String();
	
	public void getInput()
	{
		Scanner input=new Scanner(System.in);
			try
			{
				System.out.println("Enter your String-->");
				str=input.nextLine();
				
			}catch(Exception e){}
			
			
	}
	
	public void repeatcomma()
	{
		StringTokenizer token=new StringTokenizer(str,".");
		while(token.hasMoreTokens()==true)
			{
				String s=token.nextToken();
				StringTokenizer stc=new StringTokenizer(s,",");
				while(stc.hasMoreTokens()==true)
					{
						String ss=stc.nextToken();
						StringTokenizer st=new StringTokenizer(ss," ");
							while(st.hasMoreTokens()==true)
								{
									st.nextToken();
									i++;
								}
					}
				c=i;
			}
	
		
	}
/*	public void repeatCal()
	{
		System.out.println("C"+c);
		StringTokenizer st=new StringTokenizer(str," ");
		while(st.hasMoreTokens()==true)
		{
			   st.nextToken();
			
				i++;
		
		}
		if (c>0)
		{
			c=c-1;
		}
	}*/
	public void display()
	{
		
                System.out.println("\nTHE NO. OF WORD FOUND: "+c);
	}
	
}
public class WRCount {
	public static void main(String[] args) {
		StringRepeat obj=new StringRepeat();
			obj.getInput();
			obj.repeatcomma();
			//obj.repeatCal();
			obj.display();
		
	}

}
