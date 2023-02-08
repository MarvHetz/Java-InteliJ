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
        createPlaylist("Test");
        deletePlaylist(1, "Test");
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
            PreparedStatement pstmtCreateTable = connection.prepareStatement("CREATE TABLE " + name + " (id int PRIMARY KEY, song_id int, constraint song_fk foreign key (song_id) references songs(song_id));");
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

    public void addSong(String titel)
    {
        openConnection();
        try
        {
            PreparedStatement pstmtAdd = connection.prepareStatement("Insert into songs (Titel) values (?);");
            pstmtAdd.setString(1, titel);
            pstmtAdd.executeUpdate();
            pstmtAdd.close();
        }
        catch(SQLException e)
        {
            System.out.println("Failed to create statement");
            e.printStackTrace();
        }

        closeConnection();
    }

    public void addSongToPlaylist(String playlist, int song_id)
    {
        openConnection();
        try
        {
            PreparedStatement pstmtInsertSong = connection.prepareStatement("Insert into " + playlist + " (song_id) values (?);");
            pstmtInsertSong.setInt(1, song_id);
            pstmtInsertSong.executeUpdate();
            pstmtInsertSong.close();
        }
        catch (SQLException e)
        {
            System.out.println("Failed to create statement");
            e.printStackTrace();
        }
        closeConnection();
    }

    public void deletePlaylist(int playlist_id, String playlist_name)
    {
        openConnection();
        try
        {
            PreparedStatement pstmtDeletePlaylist = connection.prepareStatement("Delete from Playlists where id = ?;");
            pstmtDeletePlaylist.setInt(1, playlist_id);
            pstmtDeletePlaylist.executeUpdate();
            pstmtDeletePlaylist.close();

            PreparedStatement pstmtDropPlaylist = connection.prepareStatement("Drop Table "+ playlist_name+ " ;");
            pstmtDropPlaylist.executeUpdate();
            pstmtDropPlaylist.close();
        }
        catch (SQLException e)
        {
            System.out.println("Failed to create statement");
            e.printStackTrace();
        }
        closeConnection();
    }
}