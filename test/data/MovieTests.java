package data;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MovieTests {

    private Movie movie;

    //set up before every test case ,notice, every!!!!!!!
    @Before
    public void setUp(){
        movie = new Movie("CITIZEN KANE","Orson Welles",1941, "10",1 );
    }


    @After
    public void teasDown(){
        movie = null;
    }

    @Test
    public void shouldCreateBook(){

        assertNotNull(movie);
    }

    @Test
    public void shouldCheckout(){

        movie.checkout();
        assertFalse(movie.isAvailable());
    }

    @Test
    public void shouldReturnBook(){

        movie.checkout();
        movie.returnBook();;
        assertTrue(movie.isAvailable());
    }

}
