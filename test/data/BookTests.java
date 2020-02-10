package data;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class BookTests {

    private Book book;

    //set up before every test case ,notice, every!!!!!!!
    @Before
    public void setUp(){
        book = new Book("Family Teacher", "sakura Tzu",2001,1);
    }


    @After
    public void teasDown(){
        book = null;
    }

    @Test
    public void shouldCreateBook(){

        assertNotNull(book);
    }

    @Test
    public void shouldCheckout(){

        book.checkout();
        assertFalse(book.isAvailable());
    }

    @Test
    public void shouldReturnBook(){

        book.checkout();
        book.returnBook();;
        assertTrue(book.isAvailable());
    }

}
