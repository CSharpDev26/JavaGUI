package Encyclopedia.OtherClasses;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DataManagement {
	//Singleton??
	private Connection createConnection() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		Connection con = null;
		String url = "jdbc:mysql://localhost:3306/starwars";
		String userName = "root";
		String passw = "RootPassword123";
		con = DriverManager.getConnection(url, userName, passw);
		return con;
	}	
	
	public ArrayList<String> getNames(String type) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
		Connection con = createConnection();
		ArrayList<String> Names = new ArrayList<String>();
		PreparedStatement ps = con.prepareStatement(createNamesQuery(type));
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			Names.add(rs.getString(1));
		}
		con.close();
		return Names;
	}
	
	private String createNamesQuery(String type) {
		String query = null;
		switch(type) {
		case "faunas":
			query = "SELECT name FROM faunas";
			break;
		case "planets":
			query = "SELECT name FROM planets";
			break;
		case "Jedi":
			query = "SELECT name FROM people WHERE occupation = 'jedi'";
			break;
		case "Sith":
			query = "SELECT name FROM people WHERE occupation = 'sith'";
			break;
		case "Senator":
			query = "SELECT name FROM people WHERE occupation = 'senator'";
			break;
		case "Crime lord":
			query = "SELECT name FROM people WHERE occupation = 'crime lord'";
			break;
		case "Smuggler":
			query = "SELECT name FROM people WHERE occupation = 'smuggler'";
			break;
		case "Bounty hunter":
			query = "SELECT name FROM people WHERE occupation = 'bounty hunter'";
			break;
		case "Other":
			query = "SELECT name FROM people WHERE occupation = 'other'";
			break;
		default:
			query = "SELECT name FROM planets";
			break;
		}
		return query;
	}
	
	
	public Object[] getPlanetData(String name) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		Object[] result = new Object[10];
		Connection con = createConnection();
		PreparedStatement ps = con.prepareStatement("SELECT * FROM planets WHERE name = ?" );
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
			result[9] = rs.getInt(10);
		}
		con.close();
		return result;
	}

	public Object[] getPersonData(String name) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		Object[] result = new Object[15];
		Connection con = createConnection();
		PreparedStatement ps = con.prepareStatement("SELECT * FROM people WHERE name = ?" );
		ps.setString(1, name);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			result[0] = rs.getInt(1);
			result[1] = rs.getString(2);
			result[2] = rs.getString(3);
			result[3] = rs.getString(4);
			result[4] = rs.getString(5);
			result[5] = rs.getString(6);
			result[6] = rs.getString(7);
			result[7] = rs.getDouble(8);
			result[8] = rs.getInt(9);
			result[9] = rs.getString(10);
			result[10] = rs.getString(11);
			result[11] = rs.getString(12);
			result[12] = rs.getString(13);
			result[13] = rs.getString(14);
			result[14] = rs.getString(15);
		}
		con.close();
		return result;
	}
	
	public Object[] getFaunaData(String name) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		Object[] result = new Object[11];
		Connection con = createConnection();
		PreparedStatement ps = con.prepareStatement("SELECT * FROM faunas WHERE name = ?" );
		ps.setString(1, name);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			result[0] = rs.getInt(1);
			result[1] = rs.getString(2);
			result[2] = rs.getString(3);
			result[3] = rs.getDouble(4);
			result[4] = rs.getInt(5);
			result[5] = rs.getString(6);
			result[6] = rs.getString(7);
			result[7] = rs.getString(8);
			result[8] = rs.getString(9);
			result[9] = rs.getString(10);
			result[10] = rs.getString(11);
		}
		con.close();
		return result;
	}
}
