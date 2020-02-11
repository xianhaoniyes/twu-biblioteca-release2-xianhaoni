package Repository;

import java.util.HashMap;
import java.util.regex.Pattern;

public class LibrarianRepository {

    private HashMap<String, String> userLogin;

    public LibrarianRepository() {

        userLogin = new HashMap<String, String>();
        userLogin.put("0000-0000", "iloveyou");
        userLogin.put("1111-1111", "xhllqm");
    }



    public int login(String libNum, String passWord){

        if(!Pattern.matches("[0-9]{4}-[0-9]{4}",libNum))
            return -1;
        else if (passWord.equals(userLogin.get(libNum))) {
            return 1;
        }
        else return 0;
    }
}
