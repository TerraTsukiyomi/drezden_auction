package drezden.auction;

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
            // ожидание разрешения работать
            doWork();

            // выполнение работы
            finishing.countDown();
            // отметка, что поток завершился
        }
        catch ( InterruptedException ex )
        {

        } return;
    } void doWork()
    {
       // ...
    }
}

