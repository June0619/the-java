package me.june;

import net.bytebuddy.ByteBuddy;
import net.bytebuddy.implementation.FixedValue;

import java.io.File;
import java.io.IOException;

import static net.bytebuddy.matcher.ElementMatchers.named;

public class MagicianApp {
    public static void main(String[] args) {

//        try {
//            new ByteBuddy().redefine(MagicianHat.class)
//                    .method(named("pullOut"))
//                    .intercept(FixedValue.value("Rabbit!"))
//                    .make()
//                    .saveIn(new File("/Users/jjw/workspace/the-java/classloader-sample/target/classes"));
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }

        //바이트코드를 조작 후 빌드를 새로하는것이 아니면 토끼가 나온다.
        System.out.println(new MagicianHat().pullOut());
    }
}
