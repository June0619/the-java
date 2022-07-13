package me.june.springdisample;

public class DefaultBookService implements BookService {


    @Override
    public void rent(Book book) {
        System.out.println("rented : " + book.getTitle());
    }
}
