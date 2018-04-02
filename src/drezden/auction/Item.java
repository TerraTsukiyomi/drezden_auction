package drezden.auction;

import java.util.Random;

public class Item {

    // Point 1. Генерируем id лота
    static class Lot {

        int[] itemlot = new int[2];

        Lot(int[] itemlot) {
            this.itemlot = itemlot;
        }

        int minimum = 10;
        int maximum = 90;

        public void Random() {

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

        }
    }
}


