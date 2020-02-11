package Repository;
import data.Customer;

import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Pattern;

public class CustomerRepository {

    private HashMap<String, String>   userLogin;
    private HashMap<String, Customer> custData;
    private Customer currentCustomer = null;



    //Customers' information is pre-stored.No database is used
    public CustomerRepository(){

        userLogin = new HashMap<String, String>();
        userLogin.put("1231-4567","waitingandhope");
        userLogin.put("6785-9890","staywithme");
        userLogin.put("4376-9802","bakakloka");

        custData = new HashMap<String, Customer>();

        custData.put("1231-4567", new Customer("Nacy Keller", "Nacy@163.com", "13550342701"));
        custData.put("6785-9890",new Customer("Xianhao Ni", "xianhaoni@gmail.com","13789021220"));
        custData.put("4376-9802", new Customer("Qianmin Li","qianminli@gmail.com","17898761112"));


    }

    //if the LibNum is invalid return -1, if password does not match return 0, if it's a registered user
    // and the password matches, return 1

    public int login(String libNum, String passWord){

        if(!Pattern.matches("[0-9]{4}-[0-9]{4}",libNum))
            return -1;
        else if (passWord.equals(userLogin.get(libNum))) {
            currentCustomer = custData.get(libNum);
            return 1;
        }
        else return 0;
    }



    public void logout(){
        currentCustomer = null;
    }

    public String currentCust(){

        return currentCustomer.getUsername();
    }



    public void printInformation(){

        System.out.println("////////////////////////////////////");
        System.out.println("        Customer Information        ");
        System.out.println("////////////////////////////////////");

        System.out.println("Name: "+currentCustomer.getUsername());
        System.out.println("Email: "+currentCustomer.getEmail());
        System.out.println("Phone Number: "+currentCustomer.getPhoneNumber());
        System.out.print("please press enter to continue: ");
        Scanner sc = new Scanner(System.in);
        sc.nextLine();

    }

}
