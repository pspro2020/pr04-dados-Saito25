package main;

import utils.Dice;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        final int totalThreads = 10;
        Thread[] workerThreads = new Thread[totalThreads];
        Dice dice = new Dice();

        for(int i = 0; i < totalThreads; i++) {
            workerThreads[i] = new Thread(dice);
        }

        for(int i = 0; i < totalThreads; i++) {
            workerThreads[i].start();
        }

        for(int i = 0; i < totalThreads; i++) {
            workerThreads[i].join();
        }

        int i = 1;
        for (int diceFace : dice.getDiceFaces()) {
            System.out.printf("La cara %d ha salido %d veces\n", i++, diceFace);
        }

        System.out.println("El total de dados lanzados ha sido: " + dice.getTotalRoll());
    }
}
