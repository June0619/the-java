package me.june.springdisample;

import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import static org.junit.jupiter.api.Assertions.*;

class BookServiceTest {

//    BookService bookService = new DefaultBookService();
    //Proxy 객체를 직접 주입 (컴파일 타임)
//    BookService bookService = new BookServiceProxy(new DefaultBookService());
    //Proxy 객체를 런타임 시점에 주입
    BookService bookService =
        //자바의 다이나믹 프록시는 무조건 인터페이스 기반으로 작성되어야 한다.
        (BookService) Proxy.newProxyInstance(BookService.class.getClassLoader(), new Class[]{BookService.class}, new InvocationHandler() {
            final BookService bookService = new DefaultBookService();
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                //특정 메서드에만 프록시를 적용하고 싶은 경우
                if(method.getName().equals("rent")) {
                    System.out.println("Invoked " + method.getName());
                    Object invoke = method.invoke(bookService, args);
                    return invoke;
                }

                return method.invoke(bookService, args);
            }
        });

    @Test
    public void rent() {
        Book book = new Book("spring");
        bookService.rent(book);
        bookService.returnBook(book);
    }

}