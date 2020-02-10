package Repository;
import data.Movie;
import java.util.ArrayList;

public class MovieRepository {

    private ArrayList<Movie> movies;


    public MovieRepository(){

        movies = new ArrayList<>();
        movies.add(new Movie("CITIZEN KANE ","Orson Welles",1941, "10",1 ));
        movies.add(new Movie("ALL ABOUT EVE", "Joseph L. Mankiewicz",1950,"9",1));

    }
}
