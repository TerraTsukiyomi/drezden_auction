package drezden.auction;

public class Main {
    public static void main(String[] args) {

        System.out.println("Всего свободных доступов : "
                + SemaphoreLot.semaphore.availablePermits());

        SemaphoreLot.auctionThread t1 = new SemaphoreLot.auctionThread("Гость 1");
        t1.start();

        SemaphoreLot.auctionThread t2 = new SemaphoreLot.auctionThread("Гость 2");
        t2.start();

        SemaphoreLot.auctionThread t3 = new SemaphoreLot.auctionThread("Гость 3");
        t3.start();

        SemaphoreLot.auctionThread t4 = new SemaphoreLot.auctionThread("Гость 4");
        t4.start();

        SemaphoreLot.auctionThread t5 = new SemaphoreLot.auctionThread("Гость 5");
        t5.start();

        SemaphoreLot.auctionThread t6 = new SemaphoreLot.auctionThread("Гость 6");
        t6.start();




        Item lot = new Item();

        int item[] = new int[2];
        item[0] = lot.Item();
        item[1] = lot.Item() + (lot.Item()*710);

        System.out.println("АУКЦИОН ОТКРЫТ!\n");
        System.out.println("________________________________________________________________");
        System.out.println("Лот №" + item[0] + ".\t  \t|\t Гость 1\t|\t Гость 2\t|\t Гость 3" + " \t|");
        System.out.println("________________|_______________|_______________|_______________|");
        System.out.println("\t" + item[1] + " грн.\t|\t xxx    \t|\t xxx    \t|\t xxx     \t|");
        System.out.println("________________|_______________|_______________|_______________|");



    }
}
