package drezden.auction;
import java.util.concurrent.CountDownLatch;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        int[] itemlot = new int[2];

        int minimum = 10;
        int maximum = 90;


        Random rn = new Random();
        int n = maximum - minimum + 1;
        int i = rn.nextInt() % n;
        int item = minimum + i;
        if (item < 0)
            item = -item;

        itemlot[0] = item;
        itemlot[1] = item + (item * 710);
        int id = itemlot[0];
        int price = itemlot[1];


        System.out.println("\n------------------------------------------------ АУКЦИОН ОТКРЫТ! ------------------------------------------------");
        System.out.println("\t\t\t\t\t\t\t\t(Кол-во людей, которые могут делать ставки: "
                + SemaphoreLot.semaphore.availablePermits() + ")\n");

        SemaphoreLot.auctionThread t1 = new SemaphoreLot.auctionThread("Гость 1");
        t1.start();

        SemaphoreLot.auctionThread t2 = new SemaphoreLot.auctionThread("Гость 2");
        t2.start();

        SemaphoreLot.auctionThread t3 = new SemaphoreLot.auctionThread("Гость 3");
        t3.start();

        System.out.println("________________________________");
        System.out.println("\tЛот " + id + ".  \t\t\t\t\t|");
        System.out.println("________________________________|");
        System.out.println("\t\t" + price + " грн.\t\t\t\t|");
        System.out.println("________________________________|\n");


    }
}
