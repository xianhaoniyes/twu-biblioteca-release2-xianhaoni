package Repository;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LibrarianRepositoryTests {
    private LibrarianRepository librarianRepository;

    @Before
    public void setUp(){
        librarianRepository = new LibrarianRepository();
    }

    @After
    public void tearsDown(){
        librarianRepository = null;
    }

    @Test
    public void shouldLogin(){
        int rs = librarianRepository.login("0000-0000","iloveyou");
        assertEquals("can't pass with the right libNum and password",1,rs);
        rs = librarianRepository.login("0000-0000","asdfasdfsadfaf");
        assertEquals("can't pass with the wrong or and wrong password",0,rs);
        rs = librarianRepository.login("127","waitingandhope");
        assertEquals("can't pass with the invalid libNum",-1,rs);
    }
}
