package Repository;
import data.Movie;
import java.util.ArrayList;
import java.util.List;

public class MovieRepository {

    private ArrayList<Movie> movies;


    public MovieRepository(){

        movies = new ArrayList<>();
        movies.add(new Movie("CITIZEN KANE","Orson Welles",1941, "10",1 ));
        movies.add(new Movie("ALL ABOUT EVE", "Joseph L. Mankiewicz",1950,"9",1));
        movies.add(new Movie("THE MALTESE FALCON ","John Huston",1941,"Unrated",1));
        movies.add(new Movie("REAR WINDOW ","Alfred Hitchcock",1954,"9",1));
        movies.add(new Movie("PLAYTIME","Jacques Tati",1973,"8",1));

    }

    public void movieCheckOut(String movieName){

        movies.stream().filter(book -> book.getMovieName().equals(movieName)).findFirst().ifPresent(Movie::checkout);

    }

    public void movieReturn(String movieName){
        movies.stream().filter(book -> book.getMovieName().equals(movieName)).findFirst().ifPresent(Movie::returnBook);
    }


    public List<Movie> movieList(){
        return movies;
    }




}
