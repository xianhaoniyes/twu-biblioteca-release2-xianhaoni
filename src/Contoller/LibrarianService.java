package Contoller;

import Repository.LibrarianRepository;
import Repository.RecordRepository;
import data.Book;

import java.io.Console;
import java.util.*;

public class LibrarianService {

    private enum STATUS {loggedOut, readyToView}
    private STATUS status;

    private LibrarianRepository librarianRepository;
    private RecordRepository bookRecordRepository;
    private RecordRepository movieRecordRepository;


    public LibrarianService(LibrarianRepository librarianRepository,
                            RecordRepository bookRecordRepository,RecordRepository movieRecordRepository){

        this.status =STATUS.loggedOut;
        this.librarianRepository =librarianRepository;
        this.bookRecordRepository = bookRecordRepository;
        this.movieRecordRepository = movieRecordRepository;


    }


    private void showMenuOption(STATUS status){

        switch (status){

            case loggedOut:
                System.out.println("1: Please enter your user information");
                break;

            case readyToView:
                System.out.println("1: View book records");
                System.out.println("2: View movie records");
                System.out.println("3: Logout");

                break;
        }
    }

    private int loginProcess() {
        String username;
        String password;
        String choice;
        Console console = System.console();


        l0:    while(true) {

            System.out.print("Please enter your username: ");
            username = console.readLine();
            System.out.print("Please enter your password: ");
            password = new String(console.readPassword());


            if(librarianRepository.login(username,password)<=0){
                while(true){
                    System.out.print("invalid account or wrong password, try again?(y/n)");
                    choice = console.readLine();
                    if(choice.equals("y")) continue l0;
                    else if(choice.equals("n")) return 0;
                }
            }
            break;
        }
        status = STATUS.readyToView;
        return 1;
    }

    public void viewRecord(RecordRepository recordRepository){

        int i = 1;
        Scanner sc = new Scanner(System.in);
        HashMap<String, ArrayList<String>> entry = recordRepository.records();
        if(entry.isEmpty()) {
            System.out.println("No record found.");
        }
        else{
            for (Map.Entry<String, ArrayList<String>> record: entry.entrySet()) {
                System.out.printf("%-3s %-20s: ", Integer.toString(i),record.getKey());
                for (String s: record.getValue()) {
                    System.out.printf("%-20s",s);
                }
                System.out.println();
            }
        }

        System.out.print("Please press enter to continue: ");
        sc.nextLine();

    }

    public void viewBookRecord(){
        viewRecord(bookRecordRepository);
    }

    public void viewMovieRecord(){
        viewRecord(movieRecordRepository);
    }

    private int executeOperation(){
        Scanner sc = new Scanner(System.in);
        int choice;
        while(true) {
            System.out.print("Please enter your choice: ");
            choice = sc.nextInt();
            int choiceAmount = 3;
            if(choice<1||choice> choiceAmount) {
                System.out.print("Invalid choice!\n");
                continue;
            }
            break;

        }

        switch (choice){
            case 1:
                viewBookRecord();
                return 1;
            case 2:
                viewMovieRecord();
                return 1;

            case 3:
                return 0;
        }

        return 1;
    }

    public void serviceRunning(){

        int loginRs;
        int rs;

        while(true){
            showMenuOption(status);
            if(status==STATUS.loggedOut){
                loginRs = loginProcess();
                if(loginRs==0)
                    return;
            }
            else{
                rs = executeOperation();
                if(rs == 0)
                    return;
            }
        }
    }





}
