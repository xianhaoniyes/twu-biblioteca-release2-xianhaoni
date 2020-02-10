package Repository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class BookRepositoryTests {

    private BookRepository bookRepository;

    @Before
    public void setUp(){

        bookRepository = new BookRepository();
    }

    @After
    public void tearsDown(){

        bookRepository = null;
    }

    @Test
    public void shouldCheckout(){

        bookRepository.bookCheckOut("Family Teacher");
        boolean rs = bookRepository.bookList().get(0).isAvailable();
        assertFalse("can not checkout",rs);
    }


    @Test
    public void shouldBookReturn(){
        bookRepository.bookCheckOut("Family Teacher");
        bookRepository.bookReturn("Family Teacher");
        boolean rs = bookRepository.bookList().get(0).isAvailable();
        assertTrue("can not return", rs);

    }





}
