import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        Person p1 = new Person();
    }
    
    public void check(Person p) {
        Field[] fs = p.getClass().getFields();

        Iterator fsi = Arrays.stream(fs).iterator();

        while (fsi.hasNext()) {
            Field item = (Field)fsi.next();

            Range range = item.getAnnotation(Range.class);

            if(range != null) {
                // Object value = item.get(p);
            }
        }
    }
}

class Person {
    @Range
    public int first = 19;

    @Range
    public int second = 30;

    public String toString() {
        return "first is:" + first + ",second is:" + second;
    }
}

@Target({ElementType.FIELD, ElementType.LOCAL_VARIABLE})
@interface Range{
    int min() default 0;
    int max() default 25;
}