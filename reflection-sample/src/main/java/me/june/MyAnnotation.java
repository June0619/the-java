package me.june;

import java.lang.annotation.*;

//애노테이션은 기본적으로 주석과 같은 취급이기 때문에 바이트코드에는 내용이 남지 않는다.
//RetentionPolicy 를 RUNTIME 으로 주어야 리플렉션으로 값을 조회할 수 있다. (Default=Class)
@Retention(RetentionPolicy.RUNTIME)
//애노테이션을 붙일 수 있는 범위를 지정할 수 있다.
@Target({ElementType.TYPE, ElementType.FIELD})
//Inherited 를 붙이면 해당 애노테이션이 붙은 클래스를 상속을 받는 클래스에서도 사용할 수 있다.
@Inherited
public @interface MyAnnotation {

    String name() default "jwjung";

    int number() default 100;

    //애노테이션의 value 필드는 값을 줄 때 어떤 필드의 값인지 명시하지 않아도 된다.
    String value();
}
