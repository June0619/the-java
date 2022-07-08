package me.june;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class AppTwo {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {

        Class<?> myClass = Class.forName("me.june.MyClass");

        /*클래스 타입으로 인스턴스를 생성하는 방법*/

        //더 이상 사용하지 않는다.
//        myClass.newInstance();

        //생성자를 통한 방법
//        Constructor<?> constructor = myClass.getConstructor();
        Constructor<?> constructor = myClass.getConstructor(String.class);
        MyClass myClassInstance = (MyClass) constructor.newInstance("myClass");

        System.out.println(myClassInstance);
        System.out.println("\n============================================\n");

        /* 필드 조작 */
        Field title = myClass.getDeclaredField("title");
        System.out.println(title.get(null));
        System.out.println("\n============================================\n");

        // 필드의 값을 수정할 수도 있음
        title.set(null, "new title");
        System.out.println(title.get(null));
        System.out.println("\n============================================\n");

        // Static 필드가 아니라면 특정 인스턴스를 통해야 가져올 수 있음
        Field text = myClass.getDeclaredField("text");
        // private field 이기 때문에 accessible 값을 설정해주어야 함
        text.setAccessible(true);
        text.set(myClassInstance, "new text");
        System.out.println(text.get(myClassInstance));
        System.out.println("\n============================================\n");

        // 메서드 호출 - void
        Method voidMethod = myClass.getDeclaredMethod("voidMethod");
        voidMethod.setAccessible(true);
        voidMethod.invoke(myClassInstance);

        // 메서드 호출 - return
        Method sum = myClass.getDeclaredMethod("sum", int.class, int.class);
        int invoke = (int) sum.invoke(myClassInstance, 1, 2);
        System.out.println(invoke);


    }
}
