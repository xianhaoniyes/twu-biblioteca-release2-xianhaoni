package Contoller;
import Repository.BookRepository;
import Repository.CustomerRepository;
import Repository.RecordRepository;

import java.util.Scanner;

public class SystemController {

        private CustomerRepository customerRepository;
        private BookRepository bookRepository;
        private RecordRepository recordRepository;
        private Scanner sc;

        public SystemController(){
            customerRepository = new CustomerRepository();
            bookRepository = new BookRepository();
            recordRepository = new RecordRepository();
            sc = new Scanner(System.in);
        }

        private void showMenus(){

            System.out.println("1: Login as a customer");
            System.out.println("2: Quit");
        }


        private int executeOperation(){

            int choice;
            while(true) {
                System.out.print("Please enter your choice: ");
                choice = sc.nextInt();
                int choiceAmount = 2;
                if(choice<1||choice> choiceAmount) {
                    System.out.print("Invalid choice!\n");
                    continue;
                }
                break;
            }


            switch (choice){
                case 1:
                    new CustomerService(customerRepository,bookRepository,recordRepository).serviceRunning();
                    return 1;
                case 2:
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
