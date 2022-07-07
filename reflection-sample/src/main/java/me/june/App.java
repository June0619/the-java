package me.june;

import java.lang.reflect.Modifier;
import java.util.Arrays;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) throws ClassNotFoundException {

        /** Class 타입의 인스턴스를 얻기 위한 여러가지 방법 **/
        //1. 클래스 로드시 힙에 저장되는 인스턴스를 바로 가져다 쓴다
        Class<Book> bookClass = Book.class;

        //2. Book 타입 인스턴스에서 가져다 쓸 수도 있다
        Book book = new Book();
        Class<? extends Book> bookClass2 = book.getClass();

        //3. FQCN 을 이용한다
        Class<?> bookClass3 = Class.forName("me.june.Book");

        /** 클래스 정보에 접근 후 얻을 수 있는 정보들 **/
        //1. 필드 정보
        //1-1. Only Public Field
        Arrays.stream(bookClass.getFields()).forEach(System.out::println);
        System.out.println("\n============================================\n");
        //1-2. All Field
        Arrays.stream(bookClass.getDeclaredFields()).forEach(System.out::println);
        System.out.println("\n============================================\n");
        //1-3. Field Value
        Arrays.stream(bookClass.getDeclaredFields()).forEach(f -> {
            try {
                // 접근지시자 무시 가능
                f.setAccessible(true);
                System.out.printf("%s %s\n", f, f.get(book));

                //modifier
                int modifiers = f.getModifiers();

                System.out.println("isPrivate : " + Modifier.isPrivate(modifiers));
                System.out.println("isStatic : " + Modifier.isStatic(modifiers));
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        System.out.println("\n============================================\n");
        //2. 메서드
        Arrays.stream(bookClass.getMethods()).forEach(System.out::println);
        System.out.println("\n============================================\n");

        //3. 생성자
        Arrays.stream(bookClass.getDeclaredConstructors()).forEach(System.out::println);
        System.out.println("\n============================================\n");

        //4. 상위 클래스(상속)
        System.out.println(MyBook.class.getSuperclass());
        System.out.println("\n============================================\n");

        //5. 인터페이스
        Arrays.stream(MyBook.class.getInterfaces()).forEach(System.out::println);
        System.out.println("\n============================================\n");

    }
}
