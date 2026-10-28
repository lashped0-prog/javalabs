package org.example;

import org.w3c.dom.ls.LSOutput;

import java.awt.print.Book;

public class App {
    public static void main(String[] args) {
        Artist[] artists = new Artist[5];

        artists[0] = new Singer("Анна Петрова", 28, "поп", "сопрано");
        artists[1] = new Singer("Игорь Смирнов", 35, "рок", "баритон");
        artists[2] = new Singer("Мария Иванова", 22, "джаз", "альт");

        artists[3] = new Dancer("Олег Кузнецов", 30, "современный", "хип-хоп");
        artists[4] = new Dancer("Елена Соколова", 26, "классический", "балет");

        System.out.println("Все артисты");
        for (Artist a : artists) {
            a.displayInfo();
            a.perform();
            System.out.println();
        }

        System.out.println("Уникальные методы");
        for (Artist a : artists) {
            if (a instanceof Singer) {
                ((Singer) a).singSong();
            } else if (a instanceof Dancer) {
                ((Dancer) a).choreograph();
            }
        }    }
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
