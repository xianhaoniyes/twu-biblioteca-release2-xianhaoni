package data;

import org.junit.Test;
import static org.junit.Assert.*;

public class CustomerTests {

    @Test
    public void shouldCreatCustomer(){
        Customer customer = new Customer("Nacy Keller", "Nacy@163.com", "13550342701");
        assertNotNull(customer);
    }
}
