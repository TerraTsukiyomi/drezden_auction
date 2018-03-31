package drezden.auction;
import java.util.concurrent.*;

public class Worker implements Runnable {
    private final CountDownLatch starting;
    private final CountDownLatch finishing;

    Worker( CountDownLatch starting, CountDownLatch finishing )
    {
        // конструктор
         this.starting = starting; this.finishing = finishing;
    } public void run()
    {
        try
        {
            starting.await();
            doWork();
            finishing.countDown();
        }
        catch ( InterruptedException ex )
        {

        } return;
    }
    void doWork()
    {
       // ...
    }
}

