package lld.multithreading;


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
            if(i==1) Constants.name = "Aman";
            System.out.println("USER-Thread-"+ threadId + " tictic-" + (i+1) + " " +  Constants.name );
            try {
                Thread.sleep(waitingTime);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
