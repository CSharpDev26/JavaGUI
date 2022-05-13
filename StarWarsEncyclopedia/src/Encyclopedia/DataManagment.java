package Encyclopedia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataManagment {
	private Connection createConnection() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		Connection con = null;
		String dbName = "starwars";
		String url = "jdbc:mysql://localhost:3306/starwars";
		String userName = "root";
		String passw = "RootPassword123";
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		con = DriverManager.getConnection(url,userName,passw);
		return con;
	}
	public void getDagobah() {
		
	}
}
