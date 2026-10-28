package org.example;

public class App {
    public static void main(String[] args) {
        Train train = new Train("Минск", "5242", "14:30");

        Train train2 = new Train("Минск", "5242", "14:30", 52);

        System.out.println("До задержки: " + train);

        train.isDelayed(30);

        System.out.println("После задержки на 30 минут: " + train);    }
}
