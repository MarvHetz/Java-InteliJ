public class Song
{
    private final String title;
    private final int song_id;

    public Song(int song_id, String title)
    {
        this.song_id = song_id;
        this.title = title;
    }

    public int getSong_id()
    {
        return song_id;
    }

    public String getTitle()
    {
        return title;
    }
}
