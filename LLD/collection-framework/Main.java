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


        // Priority Queue
        System.out.println("Priority Queue");

        //using class own comparable
        PriorityQueue<StudentMarks> priorityQueue1 = new PriorityQueue<>();
        // using compator
        PriorityQueue<StudentMarks> priorityQueue2 = new PriorityQueue<>(new CustomComparator());
        // using lambda compator
        PriorityQueue<StudentMarks> priorityQueue3 = new PriorityQueue<>( (o1,o2) -> {
            int t1 = o1.getChemistryMarks() + o1.getMathsMarks() + o1.getChemistryMarks();
            int t2 = o2.getChemistryMarks() + o2.getMathsMarks() + o2.getChemistryMarks();
            return t2-t1;
        });

        priorityQueue1.add(new StudentMarks("Vivek", 20, 70, 10));
        priorityQueue1.add(new StudentMarks("Aman", 70, 70, 100));
        priorityQueue1.add(new StudentMarks("Raj", 10, 70, 20));
        priorityQueue1.add(new StudentMarks("Karan", 90, 70, 90));
        priorityQueue2.add(new StudentMarks("Vivek", 20, 70, 10));
        priorityQueue2.add(new StudentMarks("Aman", 70, 70, 100));
        priorityQueue2.add(new StudentMarks("Raj", 10, 70, 20));
        priorityQueue2.add(new StudentMarks("Karan", 90, 70, 90));
        priorityQueue3.add(new StudentMarks("Vivek", 20, 70, 10));
        priorityQueue3.add(new StudentMarks("Aman", 70, 70, 100));
        priorityQueue3.add(new StudentMarks("Raj", 10, 70, 20));
        priorityQueue3.add(new StudentMarks("Karan", 90, 70, 90));

        System.out.println(priorityQueue1.poll());
        System.out.println(priorityQueue2.poll());
        System.out.println(priorityQueue3.poll());

        // Set
        System.out.println("Set");
        Set<Integer> hashSet = new HashSet<>();
        hashSet.add(10); hashSet.add(10); hashSet.add(100); hashSet.add(20); hashSet.add(1);
        System.out.println(hashSet);
        System.out.println(hashSet.contains(20));

        Set<StudentMarks> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add(new StudentMarks("Vivek", 20, 70, 10));
        linkedHashSet.add(new StudentMarks("Vivek", 20, 70, 10));
        System.out.println(linkedHashSet);

    }
}
