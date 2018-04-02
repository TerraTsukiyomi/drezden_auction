package drezden.auction;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class SemaphoreLot {

    static Semaphore semaphore = new Semaphore(1); //Ограничиваем доступ до 1 человек

    static class auctionThread extends Thread {

        String name = "";
        private final CountDownLatch starting;
        private final CountDownLatch finishing;


        auctionThread(String name, CountDownLatch starting, CountDownLatch finishing ) { // опредедяем имя потоков
            this.name = name;
            this.starting = starting;
            this.finishing = finishing;

        }

            public void run() {

            try {

                System.out.println(name + " : пришел на аукуион;");
                System.out.println(name + " : может сделать ставку. (Сейчас свободно "
                        + semaphore.availablePermits() + " место.)");

                semaphore.acquire(); // даёт разрешение
                System.out.println(name + " : будет делать ставку!");

                System.out.println("________________________________________________________________________________________________________________________________");
                System.out.println("\tЛот №" + "id" + ".\t\t  \t\t\t|\t\t\t " + name + "\t\t\t|\t\t\t " + name + " \t\t\t|\t\t\t "+ name + " \t\t\t|");
                System.out.println("________________________________|_______________________________|_______________________________|_______________________________|");
                System.out.println("\t\t" + "price" + " грн.\t\t\t\t|\t\t\t xxx    \t\t\t|\t\t\t xxx    \t\t\t|\t\t\t xxx     \t\t\t|");
                System.out.println("________________________________|_______________________________|_______________________________|_______________________________|");


                try {

                    for (int i = 1; i <= 5; i++) {

                        System.out.println(name + " : делает ставку " + i
                                + ", делать ставки сейчас могут еще: "
                                + semaphore.availablePermits() + " чел.");

                        // sleep 4 second
                        Thread.sleep(4000);

                    }
                    starting.await();
                    finishing.countDown();

                } finally {

                    // функция release() вызывается после успешно выполеной ф-и acquire()
                    System.out.println(name + " : сделал ставку.");
                    semaphore.release(); //освобождает доступ к ресурсу

                    System.out.println(name + " : делать ставки сейчас могут еще: "
                            + semaphore.availablePermits() + " чел.");

                }

            } catch (InterruptedException e) {

                e.printStackTrace();

            }

        }

    }
}
