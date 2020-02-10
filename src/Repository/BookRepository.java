package Repository;

import data.Book;

import java.util.ArrayList;
import java.util.List;

public class BookRepository {

    private ArrayList<Book> books;

    public BookRepository(){

        books = new ArrayList<Book>();
        books.add(new Book("Family Teacher", "sakura Tzu",2001,1 ));
        books.add(new Book("XH and LQM", "Xianhao Ni", 2020,1));
        books.add(new Book("Duma Key", "Stephen King", 2008,1));
        books.add(new Book("Lord of the Flies", "William Golding",1963,1));
        books.add(new Book("Harry Potter","J.K Rowling", 1996,1));
    }


    public void bookCheckOut(String bookName){

        books.stream().filter(book -> book.getBookName().equals(bookName)).findFirst().ifPresent(Book::checkout);

    }

    public void bookReturn(String bookName){
        books.stream().filter(book -> book.getBookName().equals(bookName)).findFirst().ifPresent(Book::returnBook);
    }


    public List<Book> bookList(){
        return books;
    }

}
