import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello to Java Collection Framework");


        System.out.println("Iterator");
        // MyGenericList -> Iterator
        MyGenericList<Integer> myGenericList = new MyGenericList();
        myGenericList.add(5);
        myGenericList.add(55);
        myGenericList.add(6);
        myGenericList.add(66);

        for(int x: myGenericList){
            System.out.println(x);
        }
        System.out.println(myGenericList);

        // List -> ArrayList, Vector and Linked List
        System.out.println("\n\nList Interface");

        List<Integer> arrayList = new ArrayList<>();
        arrayList.add(9);
        arrayList.add(10);
        arrayList.add(1111);
        arrayList.addAll(arrayList);
        arrayList.remove(0);
        System.out.println("arrayList -> " +  arrayList);

        // Convert ArrayList to array
        Integer[] arr = arrayList.toArray(new Integer[0]);
        System.out.println("arr" +  arr.toString());


        // Using LinkedList as List
        List<Integer> linkedList2 = new LinkedList<>(arrayList);
        linkedList2.add(99);
        System.out.println(linkedList2);

        ListIterator<Integer> listIterator = linkedList2.listIterator();
        System.out.println(listIterator.next());
        System.out.println(listIterator.previous());

        // Using LinkedList as Queue -> FIFO
        System.out.println("Using LinkedList as Queue");
        Queue<Integer> queue = (Queue<Integer>) linkedList2;
        System.out.println(queue);
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.isEmpty());

        // Using LinkedList as DeQueue
        System.out.println("Using LinkedList as Deque");
        Deque<Integer> deque = (Deque<Integer>) linkedList2;
        deque.offerFirst(9);
        deque.offerLast(999);
        System.out.println(deque);
        System.out.println(deque.pollFirst());
        System.out.println(deque.pollLast());
        System.out.println(deque);

        // Stack -> LIFO
        System.out.println("Stack");
        Stack<Integer> stack1 = new Stack<>();
        stack1.push(1); stack1.push(2);
        System.out.println(stack1.pop());






    }
}
