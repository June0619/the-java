package me.june;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//Interface, Class, Enum
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.SOURCE)
public @interface Magic {
}
