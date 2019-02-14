import java.util.*;
class MyMatrix
{
    Scanner scan=new Scanner(System.in);
    int s;
    int arr[][];
    
    void arraysize()
    {
      
        System.out.println("Matrix.arraysize()");
        System.out.println("Enter The Size Of The Square Matris : ");
        s=scan.nextInt();
        arr=new int[s][s];
    }
   
    void arrayinput()
    {
        System.out.println("Matrix.arrayinput()");
        System.out.println("Please Enter The ELEMENTS As You WishTo :");
        for(int i=0;i<arr.length;i++)
        {
            for(int j=0;j<arr[i].length;j++)
            {
                arr[i][j]=scan.nextInt();
            }
        }
    }
    
    void arraydisplay()
    {
        int i=0;
        int j=0;
        System.out.println("The Matrix Are :");
        for( ;i<arr.length;i++)
        {
            for( ;j<arr[i].length;j++)
            {
                System.out.print(" " +arr[i][j]);
            }
            System.out.println();
        }
    
      System.out.println("Now The Inverse Matris Are :");
        for(i=0;i<=arr.length-1;i++)
        {
            for(j=0;j<=arr[i].length-1;j++)
            {
                System.out.print(" " +arr[j][i]);
            }
            System.out.println();
        }
    }
}

class MInverse
{
    public static void main(String[] args) {
       MyMatrix m=new MyMatrix();
        m.arraysize();
        m.arrayinput();
        m.arraydisplay();
    }
}