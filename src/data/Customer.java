package data;

public class Customer {

    private String username;
    private String email;
    private String phoneNumber;


    public Customer(String username, String email, String phoneNumber){

        this.username = username;;
        this.email = email;
        this.phoneNumber = phoneNumber;

    }

    public String getUsername(){
        return username;
    }

    public String getEmail(){
        return email;
    }

    public String getPhoneNumber(){
        return phoneNumber;
    }

}
