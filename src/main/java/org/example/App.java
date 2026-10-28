package org.example;
import java.util.*;

public class App {
    private static Map<String, Professional> professionals = new LinkedHashMap<>();
    private static List<Club> clubs = new ArrayList<>();

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        initProfessionals();
        initClubs();

        boolean running = true;
        while (running) {
            printMenu();
            System.out.print("выберите пункт: ");
            int choice = readInt();

            switch (choice) {
                case 1:
                    taskProfessionalsShowAll();
                    break;
                case 2:
                    taskProfessionalsFindByName();
                    break;
                case 3:
                    taskClubsShowAll();
                    break;
                case 4:
                    taskClubsRemoveLowRated();
                    break;
                case 5:
                    taskClubsPromote();
                    break;
                case 6:
                    taskClubsPrintByDivision();
                    break;
                case 7:
                    taskClubsSortAndPrint();
                    break;
                case 8:
                    resetClubs();
                    System.out.println("Список клубов восстановлен.");
                    break;
                case 0:
                    running = false;
                    System.out.println("Выход из программы.");
                    break;
                default:
                    System.out.println("Неверный пункт меню.");
            }
            System.out.println();
        }
        scanner.close();
    }

    private static void printMenu() {
        System.out.println("задание 1");
        System.out.println("1 Показать всех профессионалов (ключи и значения)");
        System.out.println("2 Найти профессионала по имени");
        System.out.println("задание 2");
        System.out.println("3 Показать все клубы");
        System.out.println("4 Удалить клубы со средним рейтингом < 3");
        System.out.println("5 Повысить дивизион клубов со средним рейтингом >= 4");
        System.out.println("6 Показать клубы заданного дивизиона");
        System.out.println("7 Отсортировать и вывести клубы (по рейтингу ↓, затем по имени)");
        System.out.println("8 Восстановить исходный список клубов");
        System.out.println("0 - Выход");
    }

    private static void initProfessionals() {
        professionals.put("Иванов Иван", new Doctor("Иванов Иван", 101, 15, "Кардиолог"));
        professionals.put("Петрова Анна", new Doctor("Петрова Анна", 102, 8, "Педиатр"));
        professionals.put("Сидоров Олег", new Doctor("Сидоров Олег", 103, 20, "Хирург"));

        professionals.put("Кузнецова Мария", new Lawyer("Кузнецова Мария", 201, 12, 87));
        professionals.put("Смирнов Дмитрий", new Lawyer("Смирнов Дмитрий", 202, 5, 23));
        professionals.put("Волкова Елена", new Lawyer("Волкова Елена", 203, 18, 145));

        professionals.put("Морозов Алексей", new Teacher("Морозов Алексей", 301, 10, 120));
        professionals.put("Никитина Ольга", new Teacher("Никитина Ольга", 302, 25, 200));
    }

    private static void taskProfessionalsShowAll() {
        System.out.println("\nВсе профессионалы (" + professionals.size() + ")");
        for (Map.Entry<String, Professional> entry : professionals.entrySet()) {
            System.out.println("Ключ: " + entry.getKey());
            System.out.println("Значение: " + entry.getValue());
        }
    }

    private static void taskProfessionalsFindByName() {
        System.out.print("Введите имя для поиска: ");
        String name = scanner.nextLine().trim();

        if (professionals.containsKey(name)) {
            System.out.println("Найден: " + professionals.get(name));
        } else {
            boolean found = false;
            for (Map.Entry<String, Professional> e : professionals.entrySet()) {
                if (e.getKey().toLowerCase().contains(name.toLowerCase())) {
                    System.out.println("Найден: " + e.getValue());
                    found = true;
                }
            }
            if (!found) {
                System.out.println("Профессионал с именем \"" + name + "\" не найден.");
            }
        }
    }

    private static void initClubs() {
        clubs = new ArrayList<>();
        clubs.add(new Club(1, "Динамо", "Футбол", 1, Arrays.asList(5, 4, 5, 4)));
        clubs.add(new Club(2, "Шахтер", "Футбол", 1, Arrays.asList(3, 2, 4, 3)));
        clubs.add(new Club(3, "Барселона", "Футбол", 1, Arrays.asList(5, 5, 5, 4)));
        clubs.add(new Club(4, "Реал", "Футбол", 2, Arrays.asList(4, 4, 3, 5)));
        clubs.add(new Club(5, "Челси", "Футбол", 2, Arrays.asList(2, 2, 3, 2)));
        clubs.add(new Club(6, "Арсенал", "Футбол", 3, Arrays.asList(4, 5, 4, 4)));
        clubs.add(new Club(7, "Ливерпуль", "Футбол", 2, Arrays.asList(1, 2, 1, 2)));
        clubs.add(new Club(8, "Милан", "Футбол", 3, Arrays.asList(3, 4, 4, 4)));
        clubs.add(new Club(8, "илан", "Футбол", 3, Arrays.asList(3, 4, 4, 4)));
    }

    private static void resetClubs() {
        initClubs();
    }

    private static void taskClubsShowAll() {
        System.out.println("\nВсе клубы (" + clubs.size() + ")");
        if (clubs.isEmpty()) {
            System.out.println("Список пуст.");
            return;
        }
        for (Club c : clubs) {
            System.out.println(c);
        }
    }

    private static void taskClubsRemoveLowRated() {
        System.out.println("\nУдаляем клубы со средним рейтингом < 3");
        Iterator<Club> iterator = clubs.iterator();
        boolean any = false;
        while (iterator.hasNext()) {
            Club c = iterator.next();
            if (c.getAverageRating() < 3) {
                System.out.printf("Удалён: %s (средний рейтинг = %.2f)%n",
                        c.getName(), c.getAverageRating());
                iterator.remove();
                any = true;
            }
        }
        if (!any) {
            System.out.println("Нет клубов с рейтингом < 3.");
        }
    }

    private static void taskClubsPromote() {
        System.out.println("\nПовышаем дивизион клубов со средним рейтингом >= 4");
        boolean any = false;
        for (Club c : clubs) {
            if (c.getAverageRating() >= 4) {
                System.out.println(c.getName() + ": дивизион " +
                        c.getDivision() + " → " + (c.getDivision() - 1));
                c.setDivision(c.getDivision() - 1);
                any = true;
            }
        }
        if (!any) {
            System.out.println("Нет клубов с рейтингом >= 4.");
        }
    }

    private static void taskClubsPrintByDivision() {
        System.out.print("Введите дивизион (или -1 для всех): ");
        int division = readInt();
        System.out.println("\nКлубы дивизиона " + division);
        printClubs(clubs, division);
    }

    private static void taskClubsSortAndPrint() {
        System.out.println("\nСортировка: по убыванию рейтинга, затем по названию");
        List<Club> sorted = new ArrayList<>(clubs);
        sorted.sort(
                Comparator.comparingDouble(Club::getAverageRating)
                        .thenComparing(Club::getName).reversed()

        );

        System.out.printf("%-5s %-15s %-10s%n", "ID", "Название", "Ср. рейтинг");
        for (Club c : sorted) {
            System.out.printf("%-5d %-15s %-10.2f%n",
                    c.getId(), c.getName(), c.getAverageRating());
        }
    }

    public static void printClubs(List<Club> clubs, int division) {
        boolean found = false;
        for (Club c : clubs) {
            if (division == -1 || c.getDivision() == division) {
                System.out.println(c);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Клубов с дивизионом " + division + " не найдено.");
        }
    }

    private static int readInt() {
        while (true) {
            try {
                String line = scanner.nextLine().trim();
                return Integer.parseInt(line);
            } catch (NumberFormatException e) {
                System.out.print("Введите корректное число: ");
            }
        }
    }
}