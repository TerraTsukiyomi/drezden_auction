package drezden.auction;

import java.util.concurrent.Semaphore;

public class SemaphoreLot {
    // максимально могут иметь доступ 4 человека
    static Semaphore semaphore = new Semaphore(4); //Ограничиваем доступ только 4-ьом патокам

    static class auctionThread extends Thread {

        String name = "";

        auctionThread(String name) { // опредедяем имя потоков
            this.name = name;
        }

        public void run() {

            try {

                System.out.println(name + " : фиксация блокировки");
                System.out.println(name + " : сейчас свободных доступов: "
                        + semaphore.availablePermits());

                semaphore.acquire(); // даёт разрешение
                System.out.println(name + " : получил разрешение!");

                try {

                    for (int i = 1; i <= 5; i++) {

                        System.out.println(name + " : выполняет операцию " + i
                                + ", доступный Семафор может разрешить сейчас дуступ: "
                                + semaphore.availablePermits());

                        // sleep 3 second
                        Thread.sleep(3000);

                    }

                } finally {

                    // функция release() вызывается после успешно выполеной ф-и acquire()
                    System.out.println(name + " : освободил доступ.");
                    semaphore.release(); //освобождает доступ к ресурсу
                    System.out.println(name + " : сейчас свободных доступов: "
                            + semaphore.availablePermits());

                }

            } catch (InterruptedException e) {

                e.printStackTrace();

            }

        }

    }
}
