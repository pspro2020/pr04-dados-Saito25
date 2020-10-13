package utils;

import java.util.Random;

public class Dice implements Runnable {

    private static int[] diceFaces = new int[6];
    private static int totalRoll;
    private Random randon = new Random();


    @Override
    public void run() {
        synchronized (this) {
            int diceValue = 0;

            for(int i = 0; i < 10; i++) {
               diceValue = randon.nextInt(6) + 1;

               switch (diceValue) {
                   case 1:
                       diceFaces[0] += 1;
                       break;
                   case 2:
                       diceFaces[1] += 1;
                       break;
                   case 3:
                       diceFaces[2] += 1;
                       break;
                   case 4:
                       diceFaces[3] += 1;
                       break;
                   case 5:
                       diceFaces[4] += 1;
                       break;
                   case 6:
                       diceFaces[5] += 1;
                       break;
               }
               totalRoll += 1;
            }
        }
    }

    public int[] getDiceFaces() {
        return diceFaces;
    }

    public int getTotalRoll() {
        return totalRoll;
    }
}
