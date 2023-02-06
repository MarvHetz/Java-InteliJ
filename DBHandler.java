import java.sql.*;

public class DBHandler
{
	Connection connection;
	public DBHandler(){
		// Load the UCANACCESS JDBC driver
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
		} catch (ClassNotFoundException e) {
			System.out.println("UCANACCESS driver not found in classpath");
			e.printStackTrace();
			return;
		}

		// Connect to the Microsoft Access database using the UCANACCESS JDBC driver
		connection = null;
		try {
			connection = DriverManager.getConnection("jdbc:ucanaccess://DB.accdb");
		} catch (SQLException e) {
			System.out.println("Failed to connect to the database");
			e.printStackTrace();
		}


		createPlaylist("test");
		closeConnection();

	}

	public void createPlaylist(String name){
		try
		{
			Statement stmt = connection.createStatement();
			stmt.executeQuery("CREATE TABLE " + name + " (id int PRIMARY KEY, name VARCHAR(255), path VARCHAR(255));");
		}
		catch (SQLException e)
		{
			System.out.println("Failed to create statement");
			e.printStackTrace();
		}


	}

	private void closeConnection()
	{
		try {
			connection.close();
		} catch (SQLException e) {
			System.out.println("Failed to close the connection");
			e.printStackTrace();
		}
	}
}