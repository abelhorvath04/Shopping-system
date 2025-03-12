package org.lecture.Shopping;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class User {
    private String name;
    private String email;
    private String address;

    public User(String name, String email, String address) {
        this.name = name;
        this.email = email;
        this.address = address;
    }
}
