package me.june.springdisample;

public class DefaultBookService implements BookService {

    BookRepository bookRepository;

    public DefaultBookService() {
        this.bookRepository = null;
    }

    public DefaultBookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public void rent(Book book) {
        System.out.println("rent : " + book.getTitle());
    }

    @Override
    public void returnBook(Book book) {
        System.out.println("return : " + book.getTitle());
    }

    public void save(Book book) {
        bookRepository.save(book);
    }
}
