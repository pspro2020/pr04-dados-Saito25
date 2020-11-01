package testing;

import java.util.Arrays;
import java.util.Random;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        final int numberOfThread = 10;
        final Thread[] threads = new Thread[10];
        Marcador marcador = new Marcador();

        for(int i = 0; i < numberOfThread; i++) {
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    Random random = new Random();
                    int value;
                    for(int i = 0; i < 10000; i++) {
                        value = random.nextInt(6) + 1;

                        switch (value) {
                            case 1:
                                marcador.setDiceValues(0);
                                break;
                            case 2:
                                marcador.setDiceValues(1);
                                break;
                            case 3:
                                marcador.setDiceValues(2);
                                break;
                            case 4:
                                marcador.setDiceValues(3);
                                break;
                            case 5:
                                marcador.setDiceValues(4);
                                break;
                            case 6:
                                marcador.setDiceValues(5);
                                break;
                        }
                        marcador.addTotalRoll();
                    }
                }
            });
        }

        for(int i = 0; i < threads.length; i++) {
            threads[i].start();
        }

        for(int i = 0; i < threads.length; i++) {
            threads[i].join();
        }

        System.out.println(Arrays.toString(marcador.getDiceValues()));
        System.out.println(marcador.getTotalRolls());
    }
}
