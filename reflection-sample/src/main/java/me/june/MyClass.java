package me.june;

public class MyClass {

    public static String title = "title";

    private String text = "text";

    public MyClass() {
    }

    public MyClass(String text) {
        this.text = text;
    }

    private void voidMethod() {
        System.out.println("played");
    }

    public int sum(int left, int right) {
        return left + right;
    }
}
