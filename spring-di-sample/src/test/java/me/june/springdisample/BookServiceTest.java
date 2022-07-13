package me.june.springdisample;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookServiceTest {

//    BookService bookService = new DefaultBookService();
    //Proxy 객체를 주입해주면 된다.
    BookService bookService = new BookServiceProxy(new DefaultBookService());

    @Test
    public void rent() {
        Book book = new Book("spring");
        bookService.rent(book);
    }

}