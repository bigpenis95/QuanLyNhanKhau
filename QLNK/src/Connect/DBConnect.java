package Connect;

import java.sql.Connection;
import java.sql.DriverManager;
public class DBConnect {
	public static Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String url = "jdbc:sqlserver://localhost:1433;databaseName=QLNK;user=sa;password=050803";
			String user = "sa";
			String pass = "050803";
			connection = DriverManager.getConnection(url, user, pass);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return connection;
	}
	
	public static void closeConnection(Connection con) {
		if(con != null) {
			try {
				con.close();
			} catch(Exception ex) {
				ex.printStackTrace();
			}
		}
	}
	public static void main (String[] args) {
		System.out.println(getConnection());
	}
}

