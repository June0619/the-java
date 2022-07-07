package me.june;


//애노테이션의 value 필드 값 하나만 줄 때 어떤 필드의 값인지 명시하지 않아도 된다.
@MyAnnotation("Annotation Value")
//여러개를 쓸 때엔 이름을 줘야한다.
//@MyAnnotation(value = "Annotation Value", number = 100)
public class Book {

    private String title = "JAVA book";

    private static String author = "jung jiwoon";

    private static final String subTitle = "Reflection";

    public String place = "book store";

    protected String year = "1999";

    private void sell() {
        System.out.println("sell book");
    }

    public void buy() {
        System.out.println("buy book");
    }

    public int getPrice() {
        return 100;
    }

    public Book() {
    }

    public Book(String title, String place, String year) {
        this.title = title;
        this.place = place;
        this.year = year;
    }
}
