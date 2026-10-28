package org.example;

import org.w3c.dom.ls.LSOutput;

import java.awt.print.Book;

public class App {
    public static void main(String[] args) {
        Bookstore store1 = new Bookstore("город книжных чрвкв", 15000, 12);
        Bookstore store2 = new Bookstore("ОБЖОРА", 8500, 7);
        Bookstore store3 = new Bookstore("5", 22000, 18);
        Bookstore store4 = new Bookstore("МинскКнига", 5000, 4);

        System.out.println("Созданные магазины:");
        System.out.println(store1);
        System.out.println(store2);
        System.out.println(store3);
        System.out.println(store4);

        System.out.println();
        System.out.println("Всего магазинов: " + Bookstore.getTotalStores());
        System.out.println("Всего книг: " + Bookstore.getTotalBooks());
        System.out.printf("Среднее число книг на магазин: %.2f%n", Bookstore.getAverageBooks());
        Bookstore.print(store1);
    }
}
        Train train = new Train("Минск", "5242", "14:30");

        Train train2 = new Train("Минск", "5242", "14:30", 52);

        System.out.println("До задержки: " + train);

        train.isDelayed(30);

        System.out.println("После задержки на 30 минут: " + train);    }
}
