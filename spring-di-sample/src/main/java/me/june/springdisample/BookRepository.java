package me.june.springdisample;

public class BookRepository {

    public Book save(Book book) {
        System.out.println("save : " + book.getTitle());
        return book;
    }
}
