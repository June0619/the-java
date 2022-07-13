package me.june.springdisample;

public class DefaultBookService implements BookService {


    @Override
    public void rent(Book book) {
        System.out.println("rented : " + book.getTitle());
    }

    @Override
    public void returnBook(Book book) {
        System.out.println("return : " + book.getTitle());
    }
}
