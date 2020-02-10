package Repository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class CustomerRepositoryTests {

    private CustomerRepository customerRepository;

    @Before
    public void setUp(){
        customerRepository = new CustomerRepository();
    }

    @After
    public void tearsDown(){
        customerRepository = null;
    }

    @Test
    public void shouldLogin(){
        int rs = customerRepository.login("1231-4567","waitingandhope");
        assertEquals("can't pass with the right libNum and password",1,rs);
        customerRepository.logout();
        rs = customerRepository.login("1231-4567","asdfasdfsadfaf");
        assertEquals("can't pass with the wrong or and wrong password",0,rs);
        customerRepository.logout();
        rs = customerRepository.login("127","waitingandhope");
        assertEquals("can't pass with the invalid libNum",-1,rs);
    }



}
