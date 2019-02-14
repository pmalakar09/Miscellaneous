	import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import oracle.jdbc.OracleDriver;


public class GetInformation extends HttpServlet {
//private static final long serialVersionUID = 1L;
       
	public void doPost(HttpServletRequest req,HttpServletResponse res)
	{
		
		try{
			DriverManager.registerDriver(new OracleDriver());
		   // Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Oracle Driver Loading Done Successfully");
		    Connection con=DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/XE","admin","1989");
	        System.out.println("DataBase Connection Is Successfully Estabilished");
			String s="select * from studentresult where usn=?";
			PreparedStatement pstmt=con.prepareStatement(s);
			String temp=req.getParameter("USN");
			pstmt.setString(1, temp);
			ResultSet rs=pstmt.executeQuery();
				while(rs.next())
				{
					String s1=rs.getString(1);
					String s2=rs.getString(2);
					int s3=rs.getInt(3);
					PrintWriter pw=res.getWriter();
					pw.println("The Fetched Records Are Given Below :");
					pw.println(s1+" "+s2+" "+s3);
							
				}
			}
		catch(Exception e)
			{
               System.out.println("Some Exception Occure");
               e.printStackTrace();
			}
	}

}
