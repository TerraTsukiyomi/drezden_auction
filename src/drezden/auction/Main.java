package drezden.auction;

public class Main {
    public static void main(String[] args) {

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
