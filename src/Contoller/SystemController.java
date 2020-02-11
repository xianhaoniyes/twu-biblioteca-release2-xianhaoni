package Contoller;
import Repository.*;

import java.util.Scanner;

public class SystemController {

        private CustomerRepository customerRepository;
        private LibrarianRepository librarianRepository;
        private BookRepository bookRepository;
        private MovieRepository movieRepository;
        private RecordRepository bookRecordRepository;
        private RecordRepository movieRecordRepository;
        private Scanner sc;

        public SystemController(){
            customerRepository = new CustomerRepository();
            librarianRepository = new LibrarianRepository();
            bookRepository = new BookRepository();
            movieRepository = new MovieRepository();
            bookRecordRepository = new RecordRepository();
            movieRecordRepository = new RecordRepository();
            librarianRepository = new LibrarianRepository();
            sc = new Scanner(System.in);
        }

        private void showMenus(){

            System.out.println("1: Login as a customer");
            System.out.println("2: Login as a Librarian");
            System.out.println("3: Quit");
        }


        private int executeOperation(){

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
                    new CustomerService(customerRepository,bookRepository,movieRepository, bookRecordRepository,movieRecordRepository).serviceRunning();
                    return 1;
                case 2:
                    new LibrarianService(librarianRepository,bookRecordRepository,movieRecordRepository).serviceRunning();
                    return 1;

                case 3:
                    return 0;
            }

            return 1;
        }

        public void service(){

            System.out.println("/////////////////////////////////////////");
            System.out.println("Welcome to our biblioteca library!");
            System.out.println("/////////////////////////////////////////");

            int rs = 1;
            while(true){
                showMenus();
                rs =executeOperation();
                if(rs==0)
                    break;
            }



        }



}
