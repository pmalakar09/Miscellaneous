package onmobile.atlantis.ps.utils;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DbConnection {
	  private static Connection connection;
	  private static String dbUrl = null;
	  private static String dbUsername = null;
	  private static String dbPassword = null;
	  private static String dbDriver = null;
	  public static Connection getConnection()
			    throws ClassNotFoundException, SQLException
			  {
			    if (connection != null)
			    {
			      try
			      {
			        Statement stmt = connection.createStatement();
			        stmt.close();
			      } catch (Exception e) {
			        connection = null;
			      }
			    }

			    if (connection == null)
			    {
			      connection = DatabaseUtil.getConnectionDirect(dbUrl, dbUsername, dbPassword, dbDriver);
			    }
			    return connection;
			  }

			  static
			  {
			    dbUrl = HelperUtility.getValueFromResourceBundle("DATABASE.URL");
			    dbUsername = HelperUtility.getValueFromResourceBundle("DATEBASE.USERNAME");
			    dbPassword = HelperUtility.getValueFromResourceBundle("DATABASE.PASSWORD");
			    dbDriver = HelperUtility.getValueFromResourceBundle("DATABASE.DRIVER");
			  }
			

}
