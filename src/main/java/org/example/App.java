package org.example;

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
}
