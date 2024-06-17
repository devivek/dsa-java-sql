import java.util.ArrayList;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class StreamJava {
    public static void main(String[] args) {
        System.out.println("Java Stream API");
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1); list.add(2); list.add(3); list.add(4); list.add(5);
        // list.stream().filter((data) -> data % 2 == 0).forEach(System.out::println);

        list.stream().filter((data) -> data % 2 == 0).map(x -> x+1).forEach(x -> System.out.println(x));
        /* list.stream().filter((data) -> data % 2 == 0).forEach(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println(integer);
            }
        });   */

        // Get 1 to 10 functionally
        Stream.iterate(1, x -> x+1).limit(10).forEach(System.out::println);
        list.stream().flatMap()
    }
}
