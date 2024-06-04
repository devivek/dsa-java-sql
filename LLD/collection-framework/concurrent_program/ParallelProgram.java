package concurrent_program;


import java.util.Random;

// We can extend Thread or Implement Runnable
public class ParallelProgram implements Runnable{

    private int threadId;
    private long waitingTime;

    public ParallelProgram(int threadId, long wait) {
        this.threadId = threadId;
        this.waitingTime = wait;
    }

    public int getThreadId() {
        return threadId;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            if(i==2) Constants.name = "Aman";
            System.out.println("USER-Thread-"+ threadId + " tictic-" + (i+1) + " " +  Constants.name );
            try {
                int bias  = new Random().nextInt(500) + 1;
                Thread.sleep(waitingTime + bias);
            } catch (InterruptedException e) {
                System.out.println("Interrupted USER-Thread-"+ threadId);
                throw new RuntimeException(e);
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Hello Main!");

        // Accessing Paraller Program using three threads
        for (int i = 0; i < 3; i++) {
            //Thread.sleep(100);
            ParallelProgram p = new ParallelProgram(i+1, 1000);
            Thread thread = new Thread(p);

            // starting concurrent threads
            thread.start();
        }

        // Create a deamon threads -> Runnable is a functional interface
        Thread thread_deamon = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("DEAMON-Thread"+  " tictic-" + (i+1) + " " +  Constants.name );
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    System.out.println("Interrupt DEAMON");
                    throw new RuntimeException(e);
                }
            }
        });
        thread_deamon.setDaemon(true);
        thread_deamon.start();

        System.out.println("Main is done");

    }

}
