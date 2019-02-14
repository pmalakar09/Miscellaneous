import java.util.*;
class MatrixExample{
	int a[][], b[][],r,c,i,j;
	
	public void getInput()
	{
		Scanner input=new Scanner(System.in);
		try{
			System.out.println("Enter your array row");
			r=input.nextInt();
			System.out.println("Enetr your column");
			c=input.nextInt();
			a=new int[r][c];
			b=new int[c][r];
			System.out.println("Enter your array elements-->");
			for(i=0;i<r;i++)
			{
				for(j=0;j<c;j++)
				{
					a[i][j]=input.nextInt();
				}
			}
		}catch(Exception e){}
		
	}
	public void display()
	{
		System.out.println("Your inputed matrix like this");
		for(i=0;i<a.length;i++)
		{
			for(j=0;j<a[i].length;j++)
			{
				System.out.print(a[i][j]);
			}
			System.out.println();	
		}
		System.out.println("After matrix inverse matrix like this");
		for(i=0;i<c;i++)
		{
			for(j=0;j<r;j++)
			{
				System.out.print(b[i][j]);
			}
			System.out.println();	
		}
		
	}
	public void mInverse()
	{
		
		for(i=0 ;i<c;i++)
		{
			for(j=0 ;j<r;j++)
				b[i][j]=a[j][i];
			
		}
	}
}

public class MatrixEx {
	public static void main(String[] args) {
		MatrixExample obj= new MatrixExample();
			obj.getInput();
			obj.mInverse();
			obj.display();
			
	}

}
