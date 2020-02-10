package Repository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class RecordRepositoryTests {

    private RecordRepository recordRepository;


    @Before
    public void setUp(){
        recordRepository = new RecordRepository();

    }

    @After
    public void tearsDown(){
        recordRepository = null;
    }

    @Test
    public void shouldAddRecord(){
        recordRepository.addRecord("1231-4567","Family Teacher");
        HashMap<String, ArrayList<String>> rs = recordRepository.Records();
        assertTrue("add record failed",rs.get("1231-4567").contains("Family Teacher"));
    }

    @Test
    public void shouldDeleteRecord(){
        recordRepository.addRecord("1231-4567","Family Teacher");
        recordRepository.deleteRecord("1231-4567","Family Teacher");
        HashMap<String, ArrayList<String>> rs = recordRepository.Records();
        assertFalse("delete record failed",rs.get("1231-4567").contains("Family Teacher"));
    }





}
