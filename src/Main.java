import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
      Album album1 = new Album("Udd gye" , "Ritviz");
      album1.addSongToAlbum("Song 1" , 5.3);
      album1.addSongToAlbum("Song 2", 4.3);
      album1.addSongToAlbum("Song 3" , 3.4);


        Album album2 = new Album("Phir na aise" , "Ritviz");
        album2.addSongToAlbum("Desh mere " , 5.5);
        album2.addSongToAlbum(" Galti se mistake", 4.3);
        album2.addSongToAlbum(" Agar tum sath ho" , 3.4);


        List<Song> myPlayList = new LinkedList<>();
      System.out.println(album2.addSongToPlayListfromAlbum("Desh mere",myPlayList));
      System.out.println(album1.addSongToPlayListfromAlbum(2,myPlayList));
      System.out.println(album2.addSongToPlayListfromAlbum("Galti se mistake" , myPlayList));
      
      play(myPlayList);
    }

  private static void play(List<Song> playList) {

    ListIterator<Song> itr = playList.listIterator();

      if(playList.size()==0){
        System.out.println("PlayList is empty");
        return;
      }

      boolean isNext;

    System.out.println("Currently playing ");
    System.out.println(itr.next());
    isNext=true;



    Scanner sc = new Scanner(System.in);
    System.out.println("Enter your  choice ");
    printMenu();
    while(true){
      int choice =sc.nextInt();

      switch (choice){

        case 1:
             if(!isNext){
               itr.next();
             }
             if(itr.hasNext()){
               System.out.println("Now Playing ");
               System.out.println(itr.next());
               isNext = true;
             }
             else{
               System.out.println("You have reached the end of the list");
             }
             break;
        case 2:
          if(isNext){
           itr.hasPrevious();
          }
          if(itr.hasPrevious()){
            System.out.println("Now Playing ");
            System.out.println(itr.hasPrevious());
            isNext = false;
          }
          else{
            System.out.println("You are on the first song already ");

          }
          break;

        case 3:
          break;

        case 4:
          break;

        case 5:
          printAllSongs(playList);

        case 6:
          printMenu();

        case 7:// exit
           return;


      }
    }
  }

  static void printAllSongs(List<Song> playlist){
      for(Song song: playlist)
        System.out.println(song);
      return;
  }

  static void printMenu(){
    System.out.println("1. Play next song");
    System.out.println("2. Play previous song");
    System.out.println("3. Play current song again");
    System.out.println("4. Delete current song");
    System.out.println("5. Show all song ");
    System.out.println("6. Show menu again");
    System.out.println("7. Exit");


  }
}