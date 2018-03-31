package drezden.auction;
//import java.util.concurrent.*;

public class Hall{
    int threadsCount = 3 ;
    void Main() throws InterruptedException {
        CountDownLatch startLatch = new CountDownLatch( 1 );
        CountDownLatch readyLatch = new CountDownLatch( threadsCount );

        for( int i = 0; i < threadsCount; ++i )
            // создание и активация потоков
            new Thread( new Worker( startLatch, readyLatch ) ).start( );
        doSomething( );

        // делается что-то
        startLatch.countDown( );
        // фактический запуск
         doSomethingYet( );
         // делается что-то еще
         readyLatch.await( );
         // ожидание момента завершения всех потоков
         } //
            // …
     }


//    CyclicBarrier(intparties);
//    CyclicBarrier(intparties, Runnable barrierAction);
//
//    CountDownLatch(int 3);
//
//    void await() throws InterruptedException;
//
//    voidawait(longwait, TimeUnittu) throwsInterruptedException;
//
//    voidcountDown();


}
