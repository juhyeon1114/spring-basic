package hello.springbasic;

import lombok.*;

import java.util.Objects;

@Getter // getter를 직접 선언하지 않아도 사용할 수 있다.
@Setter // setter를 직접 선언하지 않아도 사용할 수 있다.
//@ToString // toString을 직접 선언하지 않아도, 출력할 때 toString()을 적용해준다.
public class HelloLombok {
    private String name;
    private int age;

    public static void main(String[] args) {
        HelloLombok helloLombok = new HelloLombok();
        helloLombok.setName("wow");

        System.out.println("helloLombok = " + helloLombok);
    }
}