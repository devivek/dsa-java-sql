package lld.multithreading;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Hello Main!");
        for (int i = 0; i < 3; i++) {
            //Thread.sleep(100);
            ParallelProgram p = new ParallelProgram(i+1, 1000);
            Thread thread = new Thread(p);

            // starting concurrent threads
            thread.start();
        }

        // Create a deamon thread

        Thread thread_deamon = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("DEAMON-Thread"+  " tictic-" + (i+1) + " " +  Constants.name );
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        thread_deamon.setDaemon(true);
        thread_deamon.start();


        System.out.println("Main is done");

    }
}