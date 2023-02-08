import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBHandler
{
	Connection connection;

	public DBHandler()
	{
		// Load the UCANACCESS JDBC driver
		try
		{
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
		}
		catch (ClassNotFoundException e)
		{
			System.out.println("UCANACCESS driver not found in classpath");
			e.printStackTrace();
			return;
		}

		// Connect to the Microsoft Access database using the UCANACCESS JDBC driver
		connection = null;
		try
		{
			connection = DriverManager.getConnection("jdbc:ucanaccess://DB.accdb");
		}
		catch (SQLException e)
		{
			System.out.println("Failed to connect to the database");
			e.printStackTrace();
		}
		closeConnection();
		createPlaylist("Test");
	}

	private void openConnection()
	{
		try
		{
			connection = DriverManager.getConnection("jdbc:ucanaccess://DB.accdb");
		}
		catch (SQLException e)
		{
			System.out.println("Failed to connect to the database");
			e.printStackTrace();
		}
	}

	public void createPlaylist(String name)
	{
		openConnection();
		try
		{
			PreparedStatement pstmtCreateTable = connection.prepareStatement("CREATE TABLE " + name + " (id int PRIMARY KEY, song_id int references songs(song_id));");
			pstmtCreateTable.executeUpdate();
			pstmtCreateTable.close();

			PreparedStatement pstmtInsertPlaylist = connection.prepareStatement("Insert into Playlists (titel) values (?);");
			pstmtInsertPlaylist.setString(1, name);
			pstmtInsertPlaylist.executeUpdate();
			pstmtInsertPlaylist.close();
		}
		catch (SQLException e)
		{
			System.out.println("Failed to create statement");
			e.printStackTrace();
		}
	}

	private void closeConnection()
	{
		try
		{
			connection.close();
		}
		catch (SQLException e)
		{
			System.out.println("Failed to close the connection");
			e.printStackTrace();
		}
	}
}