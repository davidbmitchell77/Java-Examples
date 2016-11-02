import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Properties;

public class postgreSQLQuery {

	private static String password = "FN0-RM4LLseSOqH-jbbDaegW2ab1nnrJ";
	private static String ssl = "false";
	private static String hostname = "hard-plum.db.elephantsql.com";
	private static String user = "azitfggr";
	private static String port = "5432";
	private static String database = "azitfggr";
	private static String url;
	private static String statement = "SELECT srtext\n  FROM spatial_ref_sys\n LIMIT 10\n";

	public static void main(String[] args) {

		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		Connection conn;
		Properties props = new Properties();
		props.setProperty("user", user);
		props.setProperty("password", password);
		props.setProperty("ssl", ssl);
		url = "jdbc:postgresql://";
		url += hostname + ":" + port;
		url += "/" + database;
		//System.out.println(url);
		System.out.println("");
		System.out.println(LocalDate.now() + " " + LocalTime.now());
		System.out.println(statement);
		Integer i = 0;

		// Method 1:
		/*
		try {
			conn = DriverManager.getConnection(url, props);
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(statement);
			while (rs.next()) {
			   System.out.println("Row " + (++i) + ":");
			   System.out.println(rs.getString(1));
			   System.out.println("");
			} rs.close();
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		*/

		// Method 2:
		url = "jdbc:postgresql://" + hostname + ":" + port;
		url += "/" + database + "?" + "user=" + user;
		url += "&password=" + password;
		url += "&ssl=" + ssl;
		System.out.println(url+"\n");
		try {
			conn = DriverManager.getConnection(url);
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(statement);
			while (rs.next()) {
				System.out.println("Row " + (++i) + ":");
			    System.out.println(rs.getString(1));
			    System.out.println("");
			} rs.close();
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}
}
