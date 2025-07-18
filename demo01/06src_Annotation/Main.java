// import java.lang.Math;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

public class Main {
    public static void main(String[] args) {
        @Check(min = 1000, max = 2000, value = 2000)
        int n = 1;
        System.out.println(n);
    }
}

@Target({ElementType.METHOD, ElementType.FIELD, ElementType.LOCAL_VARIABLE})
@interface Check {
    int min() default 1;
    int max() default 100;

    int value() default 50;
}