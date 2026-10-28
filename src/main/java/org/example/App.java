package org.example;

public class App {
    public static void main(String[] args) {
        System.out.println("Демонстрация ПЕРЕГРУЗКИ (статический полиморфизм)\n");

        Furniture furniture = new Furniture("Шкаф", "ДСП", 350.0);

        furniture.use();
        furniture.use("хранения одежды");
        furniture.use(8);

        System.out.println();

        Table table = new Table("Письменный стол", "Дуб", 500.0, 4);
        table.use();
        table.use("учебы");
        table.use(5);
        table.use(5, "программирование");

        System.out.println();

        Chair chair = new Chair("Офисный стул", "Металл", 150.0, true);
        chair.use();
        chair.use("отдыха");
        chair.use(3);
        chair.use("Иван", 4);

        System.out.println("\nДемонстрация ПЕРЕОПРЕДЕЛЕНИЯ (динамический полиморфизм)\n");

        Furniture[] items = {
                new Furniture("Тумбочка", "ДСП", 80.0),
                new Table("Обеденный стол",  "Стекло", 700.0, 6),
                new Chair("Барный стул", "Кожа", 220.0, false),
                new Table("Компьютерный стол", "Металл", 450.0, 2),
                new Chair("Кресло-стул", "Ткань", 180.0, true)
        };

        for (Furniture item : items) {
            System.out.println(item);
            System.out.println("Назначение: " + item.getPurpose());
            item.use();
            System.out.println();
        }

        System.out.println("Сравнение статического и динамического полиморфизма\n");

        System.out.println("Статический полиморфизм (перегрузка)");
        table.use(2);
        table.use("отдыха");
        table.use();

        System.out.println("\nДинамический полиморфизм (переопределение)");
        Furniture f1 = new Table("Стол", "Дуб", 400.0, 4);
        Furniture f2 = new Chair("Стул", "Пластик", 90.0, false);

        System.out.println("f1.getPurpose() -> " + f1.getPurpose());
        System.out.println("f2.getPurpose() -> " + f2.getPurpose());
    }
}
