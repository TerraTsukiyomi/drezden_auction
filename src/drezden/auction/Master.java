package drezden.auction;
import java.util.concurrent.CountDownLatch;

public class Master {

    int threadsCount = 3;
    void masterMain() throws InterruptedException {

        CountDownLatch startLatch = new CountDownLatch( 1 );
        CountDownLatch readyLatch = new CountDownLatch( threadsCount );

        for( int i = 0; i < threadsCount; ++i )
            // создание и активация потоков
            new Thread( new Hall( startLatch, readyLatch ) ).start( );

        startLatch.countDown( );



        readyLatch.await( );
    }
}
