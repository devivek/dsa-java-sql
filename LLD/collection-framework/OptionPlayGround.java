import java.util.*;
import java.util.stream.*;

public class OptionPlayGround {
    public static void main(String[] args) {

        System.out.println("Hello to Java Collection Framework");
        Optional<List<String>> optionalList1 = Optional.of(Arrays.asList("apple", "banana", "cherry"));
        Optional<List<String>> optionalList2 = Optional.of(Arrays.asList());
        Optional<List<String>> optionalList3 = Optional.empty();
        System.out.println(optionalList1.isPresent());
        System.out.println(optionalList2.isPresent());
        System.out.println(optionalList3.isPresent());


        System.out.println(optionalList1.map(List::stream).orElseGet(Stream::empty).map(x -> x.startsWith("a")).collect(Collectors.toList()));
        System.out.println(optionalList2.map(List::stream).orElseGet(Stream::empty).map(x -> x.startsWith("a")).collect(Collectors.toList()));
        System.out.println(optionalList3.map(List::stream).orElseGet(Stream::empty).map(x -> x.startsWith("a")).collect(Collectors.toList()));
        //System.out.println(optionalList3.stream().flatMap(Collection::stream).map(x -> x.startsWith("a")).collect(Collectors.toList()));
        Integer i = null;
        Boolean a = (i == null);
        System.out.println(a);



    }

}