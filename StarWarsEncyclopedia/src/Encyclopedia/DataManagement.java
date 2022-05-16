package Encyclopedia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DataManagement {
	//Singleton??
	private Connection createConnection() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		Connection con = null;
		String dbName = "starwars";
		String url = "jdbc:mysql://localhost:3306/starwars";
		String userName = "root";
		String passw = "RootPassword123";
		con = DriverManager.getConnection(url,userName,passw);
		return con;
	}
	public ArrayList<String> getPlanetNames() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		Connection con = createConnection();
		PreparedStatement ps = con.prepareStatement("SELECT name FROM Planets");
		ArrayList<String> planetNames = new ArrayList<String>();
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			planetNames.add(rs.getString(1));
		}
		con.close();
		return planetNames;
	}
	public Object[] getPlanetData(String name) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		Object[] result = new Object[9];
		Connection con = createConnection();
		PreparedStatement ps = con.prepareStatement("SELECT * FROM Planets WHERE name = ?" );
		ps.setString(1, name);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			result[0] = rs.getInt(1);
			result[1] = rs.getString(2);
			result[2] = rs.getString(3);
			result[3] = rs.getInt(4);
			result[4] = rs.getInt(5);
			result[5] = rs.getString(6);
			result[6] = rs.getString(7);
			result[7] = rs.getString(8);
			result[8] = rs.getString(9);
		}
		con.close();
		return result;
	}
}
