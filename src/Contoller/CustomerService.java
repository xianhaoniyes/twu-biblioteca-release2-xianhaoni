package Contoller;

import Repository.BookRepository;
import Repository.CustomerRepository;
import Repository.MovieRepository;
import Repository.RecordRepository;
import data.Book;
import data.Movie;

import java.util.ArrayList;
import java.util.List;
import java.io.Console;
import java.util.Scanner;

public class CustomerService {

    private enum STATUS {loggedOut, readyToView}

    private STATUS status;
    private CustomerRepository customerRepository;
    private BookRepository bookRepository;
    private MovieRepository movieRepository;
    private RecordRepository bookRecordRepository;
    private RecordRepository movieRecordRepository;



    public CustomerService(CustomerRepository custs, BookRepository books, MovieRepository movieRepository,
                           RecordRepository bookRecordRepository,RecordRepository movieRecordRepository){
        this.status = STATUS.loggedOut;
        this.customerRepository = custs;
        this.bookRepository = books;
        this.movieRepository = movieRepository;
        this.bookRecordRepository = bookRecordRepository;
        this.movieRecordRepository = movieRecordRepository;

    }


    private void showMenuOption(STATUS status){

        switch (status){

            case loggedOut:
                System.out.println("1: Please enter your user information");
                break;

            case readyToView:
                System.out.println("1: View books and checkout");
                System.out.println("2: View movies and checkout");
                System.out.println("3: Return books");
                System.out.println("4: Return movies");
                System.out.println("5: View my information");
                System.out.println("6: Logout");

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


            if(customerRepository.login(username,password)<=0){
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


    private void bookCheckout(){

        List<Book> books = bookRepository.bookList();
        ArrayList<String> availableBooks = new ArrayList<>();
        int choice;
        String option;
        int i=1;
        Scanner sc = new Scanner(System.in);

        if(books.size()==0) {
            System.out.println("No book is available, press any button to continue: ");
            sc.nextLine();
            return;
        }

        for (Book book: books) {
            if(book.isAvailable()){
            System.out.printf("%-3s: %-20s, %-20s, %-20s\n",Integer.toString(i), book.getBookName(),book.getAuthor(),book.getPublishedYear());
            availableBooks.add(book.getBookName());
            i++;
            }
        }

        b0:   while(true) {
            System.out.print("Please select the book you want:");
            choice = Integer.parseInt(sc.nextLine());
            if(choice<1||choice>availableBooks.size())
                while(true) {
                    System.out.print("Invalid option, select again?(y/n)");
                    option = sc.nextLine();
                    if(option.equals("y")) continue b0;
                    else if(option.equals("n")) return;

                }
            break;
        }

        //here the choice need to minus 1!!!!!
        bookRepository.bookCheckOut(availableBooks.get(choice-1));
        bookRecordRepository.addRecord(customerRepository.currentCust(),availableBooks.get(choice-1));
        System.out.print("You have successfully checked out a book, please press enter to continue:");
        sc.nextLine();

    }


    private void movieCheckout(){

        List<Movie> movies = movieRepository.movieList();
        ArrayList<String> availableMovies = new ArrayList<>();
        int choice;
        String option;
        int i=1;
        Scanner sc = new Scanner(System.in);

        if(movies.size()==0) {
            System.out.println("No movie is available, press any button to continue: ");
            sc.nextLine();
            return;
        }

        for (Movie movie: movies) {
            if(movie.isAvailable()){
                System.out.printf("%-3s: %-20s, %-20s, %-20s, %-20s\n",Integer.toString(i), movie.getMovieName(),movie.getDirector(),movie.getPublishedYear(),movie.getRate());
                availableMovies.add(movie.getMovieName());
                i++;
            }
        }

        b0:   while(true) {
            System.out.print("Please select the movie you want:");
            choice = Integer.parseInt(sc.nextLine());
            if(choice<1||choice>availableMovies.size())
                while(true) {
                    System.out.print("Invalid option, select again?(y/n)");
                    option = sc.nextLine();
                    if(option.equals("y")) continue b0;
                    else if(option.equals("n")) return;

                }
            break;
        }

        //here the choice need to minus 1!!!!!
        movieRepository.movieCheckOut(availableMovies.get(choice-1));
        movieRecordRepository.addRecord(customerRepository.currentCust(),availableMovies.get(choice-1));
        System.out.print("You have successfully checked out a movie, please press enter to continue:");
        sc.nextLine();


    }

    private void returnBook(){

        String bookName;
        String option;
        Scanner sc = new Scanner(System.in);

        r0: while(true){
            System.out.print("Please enter the book you want to return: ");
            bookName = sc.nextLine();
            if(bookRecordRepository.deleteRecord(customerRepository.currentCust(),bookName)==0){
                while(true) {
                    System.out.print("You didn't burrow this book or the name is incorrect, try again?(y/n)");
                    option = sc.nextLine();
                    if(option.equals("y")) continue r0;
                    else if(option.equals("n")) return;
                }
            }
            else{
                bookRepository.bookReturn(bookName);
                System.out.print("You have successfully returned a book, please press enter to continue:");
                sc.nextLine();
                break;
            }
        }
    }

    private void returnMovie(){

        String movieName;
        String option;
        Scanner sc = new Scanner(System.in);

        r0: while(true){
            System.out.print("Please enter the movie you want to return: ");
            movieName = sc.nextLine();
            if(movieRecordRepository.deleteRecord(customerRepository.currentCust(),movieName)==0){
                while(true) {
                    System.out.print("You didn't burrow this movie or the name is incorrect, try again?(y/n)");
                    option = sc.nextLine();
                    if(option.equals("y")) continue r0;
                    else if(option.equals("n")) return;
                }
            }
            else{
                movieRepository.movieReturn(movieName);
                System.out.print("You have successfully returned a movie, please press enter to continue:");
                sc.nextLine();
                break;
            }
        }
    }

    private int executeOperation(){
        Scanner sc = new Scanner(System.in);
        int choice;
        while(true) {
            System.out.print("Please enter your choice: ");
            choice = sc.nextInt();
            int choiceAmount = 6;
            if(choice<1||choice> choiceAmount) {
                System.out.print("Invalid choice!\n");
                continue;
            }
            break;

        }

        switch (choice){
            case 1:
                bookCheckout();
                return 1;
            case 2:
                movieCheckout();
                return 1;
            case 3:
                returnBook();
                return 1;

            case 4:
                returnMovie();
                return 1;
            case 5:
                customerRepository.printInformation();
            case 6:
                customerRepository.logout();
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
