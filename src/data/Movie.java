package data;

public class Movie {

    private String movieName;
    private String director;
    private int  publishedYear;
    private String rate;
    private int amount;


    public Movie(String movieName, String director, int publishedYear, String rate, int amount){

        this.movieName = movieName;
        this.director = director;
        this.publishedYear = publishedYear;
        this.rate =rate;
        this.amount = amount;

    }

    public String getMovieName() {
        return movieName;
    }

    public String getDirector(){
        return director;
    }

    public int getPublishedYear(){
        return publishedYear;
    }

    public String getRate(){
        return rate;
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
