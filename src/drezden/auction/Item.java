package drezden.auction;

import java.util.Random;

public class Item {

    // Point 1. Генерируем id лота
    public static int Item() {
        int minimum = 100;
        int maximum = 900;
        Random rn = new Random();
        int n = maximum - minimum + 1;
        int i = rn.nextInt() % n;
        int lot = minimum + i;

        if (lot < 0)
            lot = -lot;

        return lot;
    }
}
