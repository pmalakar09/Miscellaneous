import java.util.*;
class Book {
    
       private int page;
       
    void setPage(int page)
    {
        if (page>0)
    
    {
        this.page=page;
    }   
    else
    {
       System.out.println ("Invalid Page Want To Access : " +page);
    }
    }
    
    
int getPage()
{
return page;
}
}
class BookApp{
    public static void main(String[] args) {
        
       int p;
      System.err.println("Enter The Page Number :");
      Scanner sc=new Scanner(System.in);
      p=sc.nextInt();
      Book b=new Book();
      b.setPage(p);
      System.out.print("You Want To Access Page Number :");
      System.out.print(b.getPage());
    }
}