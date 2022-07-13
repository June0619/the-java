package me.june.springdisample;

import net.bytebuddy.ByteBuddy;
import net.bytebuddy.implementation.InvocationHandlerAdapter;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import static net.bytebuddy.matcher.ElementMatchers.named;
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
                    if (method.getName().equals("rent")) {
                        System.out.println("Dynamic Proxy : " + method.getName());
                        Object invoke = method.invoke(bookService, args);
                        return invoke;
                    }

                    return method.invoke(bookService, args);
                }
            });

    @Test
    public void rent() {

        //CGLib 를 이용하여 Class 기반 Proxy 를 생성하는 방법
        MethodInterceptor handler = new MethodInterceptor() {
            final DefaultBookService bookService = new DefaultBookService();

            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                if (method.getName().equals("rent"))
                    System.out.println("CGLib Proxy : " + method.getName());
                return method.invoke(bookService, objects);
            }
        };

        Book book = new Book("spring");
        bookService.rent(book);
        bookService.returnBook(book);

        //Class Proxy
        DefaultBookService classBookService = (DefaultBookService) Enhancer.create(DefaultBookService.class, handler);
        classBookService.rent(book);
        classBookService.returnBook(book);

    }

    @Test
    public void byteBuddy() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<? extends DefaultBookService> proxyClass = new ByteBuddy().subclass(DefaultBookService.class)
                .method(named("rent")).intercept(InvocationHandlerAdapter.of(new InvocationHandler() {
                    final DefaultBookService defaultBookService = new DefaultBookService();

                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        if (method.getName().equals("rent"))
                            System.out.println("ByteBuddy : " + method.getName());
                        return method.invoke(defaultBookService, args);
                    }
                }))
                .make().load(DefaultBookService.class.getClassLoader()).getLoaded();

        BookService bookService = proxyClass.getConstructor(null).newInstance();

        Book book = new Book("spring");
        bookService.rent(book);
        bookService.returnBook(book);
    }
}