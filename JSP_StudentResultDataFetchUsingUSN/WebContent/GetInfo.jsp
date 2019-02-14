<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%!
Connection con=null;
String TextValues=null;
public void jspInit()
{
	try{
	Class.forName("oracle.jdbc.driver.OracleDriver");
	System.out.println("Driver Loaded");
	con=DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/XE","admin","1989");
	System.out.println("Connection Stablished");
	     }
	catch(Exception e)
	{
		e.printStackTrace();
	}
}
%>
<%
try
{
	String temp=request.getParameter("USN");
	if(temp.length()!=7)
	{
		out.println("Please Enter A Valid USN");
	}
	
	else
	{
		String query="select * from studentresult where usn=?";
		PreparedStatement pstmt=con.prepareStatement(query);
		pstmt.setString(1, temp);
		ResultSet res=pstmt.executeQuery();
		while(res.next())
		{
			String s1=res.getString(1);
			String s2=res.getString(2);
			int s3=res.getInt(3);
			out.println(s1+" "+s2+" "+s3);
			TextValues=s1;
			
		}
		System.out.println("Query Executed");
	}
}
catch(Exception e)
{
	e.printStackTrace();
	
}
request.setAttribute("TextValue",TextValues);

%>
<form action="">
<input type="text" name="done" value='<%=request.getAttribute("TextValue")%>'/>
</form>
</body>
</html>