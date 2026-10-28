package org.example;

public class App {
    public static void main(String[] args) {
        Performer[] performers = new Performer[5];

        Singer singer1 = new Singer("Анна Петрова", "поп");
        Singer singer2 = new Singer("Игорь Смирнов", "рок");
        Singer singer3 = new Singer("Мария Иванова", "джаз");

        Dancer dancer1 = new Dancer("Олег Кузнецов", "хип-хоп");
        Dancer dancer2 = new Dancer("Елена Соколова", "балет");

        performers[0] = singer1;
        performers[1] = singer2;
        performers[2] = singer3;
        performers[3] = dancer1;
        performers[4] = dancer2;

        singer1.addAward("Грэмми 2052");
        singer1.addAward("Золотой скибидон");

        singer2.addAward("MTV Europe Music Award");

        singer3.addAward("Премия Муз-ТВ");
        singer3.addAward("Russian Music Award");
        singer3.addAward("Песня года");

        dancer1.addAward("Чемпионат мира по хип-хопу");

        dancer2.addAward("Золотая маска");
        dancer2.addAward("Приз Большого театра");

        Performer.printHeader();
        for (Performer p : performers) {
            p.perform();
            System.out.println("Жанр/стиль: " + p.getGenre());
        }

        System.out.println();
        System.out.println("Награды артистов");
        for (Performer p : performers) {
            Awardable a = (Awardable) p;
            String name = (p instanceof Singer)
                    ? ((Singer) p).getName()
                    : ((Dancer) p).getName();
            System.out.println(name + " - награды (" + a.getAwardsCount() + "):");
            for (String award : a.getAwards()) {
                System.out.println("   - " + award);
            }
        }
    }
}