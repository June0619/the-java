package me.june;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter @EqualsAndHashCode
public class Member {

    String name;

    int age;

    public boolean isSameAge(Member member) {
        return this.age == member.age;
    }

    //boiler plate code
    //getter //setter //equals
}
