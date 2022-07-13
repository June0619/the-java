package me.june.springdisample;

public class BookServiceProxy implements BookService {

    BookService bookService;

    public BookServiceProxy(BookService bookService) {
        this.bookService = bookService;
    }

    @Override
    public void rent(Book book) {
        System.out.println("proxy object");
        bookService.rent(book);
        System.out.println("proxy log");
    }
}
