package drezden.auction;
import java.util.concurrent.CountDownLatch;

public class Hall implements Runnable {
    private final CountDownLatch starting;
    private final CountDownLatch finishing;

    Hall( CountDownLatch starting, CountDownLatch finishing )
    {
        this.starting = starting;
        this.finishing = finishing;
    }

    public void run()
    {
        try
        {
            starting.await();
            doWork();
            finishing.countDown();
}
        catch ( InterruptedException ex ){ } return;
                }

                void doWork()
    {
        // ...
    }
}
