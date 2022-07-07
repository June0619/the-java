package me.june;

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
