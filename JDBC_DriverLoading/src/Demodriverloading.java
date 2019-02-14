import java.sql.DriverManager;
import java.sql.SQLException;
import oracle.jdbc.driver.OracleDriver;

public class Demodriverloading {

	public static void main(String[] args) {
	
try {
	DriverManager.registerDriver(new OracleDriver());
	System.out.println("Driver Loading Is Done Successfully");
} catch (SQLException e) {
	
	e.printStackTrace();
}
	}

}
