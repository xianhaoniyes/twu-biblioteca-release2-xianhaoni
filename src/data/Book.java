package data;


public class Book {

    private String bookName;
    private String author;
    private int  publishedYear;
    private int amount;

    public Book(String bookName, String author, int publishedYear, int amount){

        this.bookName = bookName;
        this.author = author;
        this.publishedYear =publishedYear;
        this.amount = amount;

    }

    public String getBookName() {
        return bookName;
    }

    public String getAuthor(){
        return author;
    }

    public int getPublishedYear(){
        return publishedYear;
    }

    public void checkout(){
        amount--;
    }

    public void returnBook(){
        amount++;
    }

    public boolean isAvailable(){
        return amount>0;
    }


}
