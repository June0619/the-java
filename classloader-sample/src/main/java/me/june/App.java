package me.june;

/**
 * Hello world!
 *
 */
public class App {

    //이 시점에는 소스를 읽더라도 실제 레퍼런스를 가르키고 있지는 않다.
    Book book = new Book();

    public static void main( String[] args ) {

        ClassLoader classLoader = App.class.getClassLoader();
        System.out.println(classLoader);
        System.out.println(classLoader.getParent());
        //최상위 classLoader 는 native 소스로 구성되어 있기 때문에 그냥 null 로 표현된다.
        System.out.println(classLoader.getParent().getParent());
    }
}
