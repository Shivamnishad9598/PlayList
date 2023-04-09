import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Album {
   private String name;
   private String artist;
   private List<Song> songs;

    public Album(String title, String artist) {
        this.name = title;
        this.artist = artist;
        this.songs = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String title) {
        this.name = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public List<Song> getSong() {
        return songs;
    }

    public void setSongs(List<Song> song) {
        this.songs = song;
    }

    // Find song
    boolean findsong(String title){
        for (Song song:songs) {
            if(song.getTitle().equals(title))
                return true;
        }
        return false;
    }

    //add song to album
    String addSongToAlbum(String title , double duration){

        if(findsong(title)==false){
            Song s = new Song(title,duration);
            songs.add(s);
            return "Song added to be album";
        }
        return "song already exits";
    }

    // concept
    public String addSongToPlayListfromAlbum(String title , List<Song> playList){
        if(findsong(title)==true){
           for(Song s:this.songs){
               if(s.getTitle().equals(title)){
                   playList.add(s);
                   return "Song added to your playlist";
               }
           }
        }
        return "Song not present in album";
    }

    public String addSongToPlayListfromAlbum(int  trackNo , List<Song> playList){

        int index = trackNo-1;
        if(index >=0 && index<this.songs.size()){
            playList.add(this.songs.get(index));
            return " Song has been added to your playList ";
        }
        return "Invalid position of song ";
    }

}
