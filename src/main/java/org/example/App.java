package org.example;

public class App {
    public static void main(String[] args) {
        RoundTable table = new RoundTable(1.2, Materials.WOOD);
        System.out.println("Стол: " + table);
        System.out.printf("Площадь стола: %.4f м2 %n", table.area());

        Planet[] planets = {
                new Planet("Меркурий", 4879, 57.9),
                new Planet("Венера", 12104, 108.2),
                new Planet("Земля", 12742, 149.6),
                new Planet("Марс", 6779, 227.9),
                new Planet("Юпитер", 139820, 778.6),
                new Planet("Сатурн", 116460, 1433.5)
        };
        Planet maxDiameter = planets[0];
        Planet maxDistance = planets[0];
        for (Planet p : planets) {
            if (p.getDiameter() > maxDiameter.getDiameter()) {
                maxDiameter = p;
            }
            if (p.getDistanceFromSun() > maxDistance.getDistanceFromSun()) {
                maxDistance = p;
            }
        }
        System.out.println("Планета с максимальным диаметром: " + maxDiameter);
        System.out.println("Планета с максимальным расстоянием от Солнца: " + maxDistance);
        Employee[] employees = {
                new Employee("Иван Иванов", Education.PHD),
                new Employee("Канье Вест", Education.MASTER),
                new Employee("Алексей Грудино", Education.BACHELOR),
                new Employee("Валерий Альбертович", Education.PHD),
                new Employee("Олег Тигр", Education.SCHOOL)
        };

        System.out.println("Сотрудники с образованием PHD:");
        for (Employee e : employees) {
            if (e.getEducation() == Education.PHD) {
                System.out.println(e);
            }
        }
    }
}