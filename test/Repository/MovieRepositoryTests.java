package Repository;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class MovieRepositoryTests {
    private MovieRepository movieRepository;

    @Before
    public void setUp(){

        movieRepository = new MovieRepository();
    }

    @After
    public void tearsDown(){

        movieRepository = null;
    }

    @Test
    public void shouldCheckout(){

        movieRepository.movieCheckOut("CITIZEN KANE");
        boolean rs = movieRepository.movieList().get(0).isAvailable();
        assertFalse("can not checkout",rs);
    }


    @Test
    public void shouldBookReturn(){
        movieRepository.movieCheckOut("CITIZEN KANE");
        movieRepository.movieReturn("CITIZEN KANE");
        boolean rs = movieRepository.movieList().get(0).isAvailable();
        assertTrue("can not return", rs);

    }
}
