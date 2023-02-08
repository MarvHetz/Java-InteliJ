import java.util.ArrayList;

public class Playlist<T extends Song>
{
    private final ArrayList<? extends Song> songs;
    private final String titel;
    
    public Playlist(ArrayList<? extends Song> songs, String titel)
    {
        this.songs = songs;
        this.titel = titel;
    }
}
