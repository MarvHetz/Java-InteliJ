import java.util.ArrayList;

public class Playlist<T extends Song>
{
	private final int id;
	private final ArrayList<? extends Song> songs;
	private final String titel;
	public Playlist(int id, ArrayList<? extends Song> songs, String titel)
	{
		this.id = id;
		this.songs = songs;
		this.titel = titel;
	}

	public int getId()
	{
		return id;
	}
}
