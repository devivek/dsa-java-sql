package concurrent_program;

import java.util.ArrayList;
import java.util.Random;

public class BlockingQueue {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Starting Blocking Queue Opearations");
        BlockingQueue blockingQueue = new BlockingQueue();
        // adder threads
        for(int i=0; i<50; i++){
            new Thread(() -> {
                try {
                    Thread.sleep(1000 + new Random().nextInt(10000));
                    blockingQueue.add(99);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }).start();

        }

        // remover threads
        for(int i=0; i<50; i++){
            new Thread(() -> {
                try {
                    Thread.sleep(9 + new Random().nextInt(1000));
                    blockingQueue.remove();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }).start();

        }

        Thread thread_last = new Thread(() -> {
            try {
                int i =0 ;
                while(i++ < 200 ){
                    System.out.println("CHECKING BLOCKING Q STATUS -> Capacity " + blockingQueue.capacity);
                    Thread.sleep(1000);
                }

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        thread_last.setDaemon(true);
        thread_last.start();
        thread_last.join();
        System.out.println("CHECKING BLOCKING QUQUE STATUS -> Capacity " + blockingQueue.capacity);
        System.out.println("Main thread finished");
    }
    private ArrayList<Integer> list = new ArrayList<>();
    int capacity = 0;
    int MAX_CAPACITY = 10;

    public synchronized void add(int value) throws InterruptedException {
        while(list.size() == MAX_CAPACITY) this.wait();
        list.add(value);
        System.out.println("Added");
        capacity++;
        this.notifyAll();
    }

    public synchronized void remove() throws InterruptedException{
        while(list.size() == 0) this.wait();
        list.remove(list.get(list.size()-1));
        System.out.println("Removed");
        capacity--;
        this.notifyAll();
    }
}
