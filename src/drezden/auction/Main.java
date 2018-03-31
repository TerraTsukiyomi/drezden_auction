package drezden.auction;
import java.util.concurrent.*;

public class Main {

    int threadsCount = 3;
    void masterMain() throws InterruptedException {

        CountDownLatch startLatch = new CountDownLatch( 1 );
        CountDownLatch readyLatch = new CountDownLatch( threadsCount );

        for( int i = 0; i < threadsCount; ++i )
            // создание и активация потоков
            new Thread( new Worker( startLatch, readyLatch ) ).start( );
        doSomething();

        startLatch.countDown( );

        doSomethingYet();

        readyLatch.await( );
    }
    // …

    public static void main(String[] args) {
        // write your code here
    }
}
