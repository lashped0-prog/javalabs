package org.example;

import java.io.*;
import java.util.Random;
import java.util.Scanner;

public class App {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Random random = new Random();

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            printMenu();
            System.out.print("Выберите задание: ");
            int choice = readInt();

            switch (choice) {
                case 1:
                    task1();
                    break;
                case 2:
                    task2();
                    break;
                case 3:
                    task3();
                    break;
                case 4:
                    task4();
                    break;
                case 5:
                    task5();
                    break;
                case 0:
                    running = false;
                    System.out.println("Выход.");
                    break;
                default:
                    System.out.println("Неверный пункт меню.");
            }
            System.out.println();
        }
        scanner.close();
    }

    private static void printMenu() {
        System.out.println("Меню:");
        System.out.println("1 - Питомец (файл pet.txt)");
        System.out.println("2 - 10 целых чисел, полные квадраты");
        System.out.println("3 - Разделение чисел по чётности последней цифры");
        System.out.println("4 - 15 значений частоты, средняя частота");
        System.out.println("5 - 10 чисел, количество больше 100");
        System.out.println("0 - Выход");
    }

    private static void task1() {
        String fileName = "pet.txt";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write("Кличка: Блек");
            writer.newLine();
            writer.write("Порода: Сфинкс");
            writer.newLine();
            writer.write("Возраст: 9 лет");
            writer.newLine();
            writer.write("Вид: Кот");
            writer.newLine();
            writer.write("Особенность: Бесшёрстная порода");
            writer.newLine();
            System.out.println("Данные о питомце записаны в файл: " + fileName);
        } catch (IOException e) {
            System.out.println("Ошибка записи: " + e.getMessage());
        }

        File file = new File(fileName);
        System.out.println("\nИнформация о файле:");
        System.out.println("Имя: " + file.getName());
        System.out.println("Путь: " + file.getAbsolutePath());
        System.out.println("Существует: " + file.exists());
        System.out.println("Размер: " + file.length() + " байт");
        System.out.println("Читаемый: " + file.canRead());
        System.out.println("Записываемый: " + file.canWrite());

        System.out.println("\nСодержимое файла:");
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Ошибка чтения: " + e.getMessage());
        }
    }

    private static void task2() {
        String fileName = "f2.txt";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            System.out.println("Введите 10 целых чисел:");
            for (int i = 0; i < 10; i++) {
                System.out.print("Число " + (i + 1) + ": ");
                int num = readInt();
                writer.write(String.valueOf(num));
                writer.newLine();
            }
            System.out.println("Числа записаны в файл " + fileName);
        } catch (IOException e) {
            System.out.println("Ошибка записи: " + e.getMessage());
        }

        int countSquares = 0;
        System.out.println("\nЧисла из файла:");
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                int num = Integer.parseInt(line.trim());
                System.out.println(num);
                if (num >= 0) {
                    int root = (int) Math.round(Math.sqrt(num));
                    if (root * root == num) {
                        countSquares++;
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Ошибка чтения: " + e.getMessage());
        }
        System.out.println("Количество полных квадратов: " + countSquares);
    }

    private static void task3() {
        String fileF = "f3.txt";
        String fileG = "g3.txt";
        String fileH = "h3.txt";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileF))) {
            System.out.println("Файл f: случайные числа");
            for (int i = 0; i < 15; i++) {
                int num = random.nextInt(200) - 100;
                writer.write(String.valueOf(num));
                writer.newLine();
                System.out.print(num + " ");
            }
            System.out.println();
        } catch (IOException e) {
            System.out.println("Ошибка записи f: " + e.getMessage());
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(fileF));
             BufferedWriter writerG = new BufferedWriter(new FileWriter(fileG));
             BufferedWriter writerH = new BufferedWriter(new FileWriter(fileH))) {

            String line;
            while ((line = reader.readLine()) != null) {
                int num = Integer.parseInt(line.trim());
                int lastDigit = Math.abs(num) % 10;
                if (lastDigit % 2 == 0) {
                    writerG.write(String.valueOf(num));
                    writerG.newLine();
                } else {
                    writerH.write(String.valueOf(num));
                    writerH.newLine();
                }
            }
            System.out.println("Данные распределены в " + fileG + " и " + fileH);
        } catch (IOException e) {
            System.out.println("Ошибка обработки: " + e.getMessage());
        }

        System.out.println("\nФайл g (оканчиваются на чётную цифру):");
        printFile(fileG);
        System.out.println("\nФайл h (оканчиваются на нечётную цифру):");
        printFile(fileH);
    }

    private static void task4() {
        String fileName = "frequency.txt";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            System.out.println("Введите 15 значений частоты:");
            for (int i = 0; i < 15; i++) {
                System.out.print("Частота " + (i + 1) + ": ");
                double freq = readDouble();
                writer.write(String.valueOf(freq));
                writer.newLine();
            }
            System.out.println("Данные записаны в файл " + fileName);
        } catch (IOException e) {
            System.out.println("Ошибка записи: " + e.getMessage());
        }

        double sum = 0;
        int count = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                double freq = Double.parseDouble(line.trim());
                System.out.println("Частота: " + freq);
                sum += freq;
                count++;
            }
        } catch (IOException e) {
            System.out.println("Ошибка чтения: " + e.getMessage());
        }

        if (count > 0) {
            System.out.printf("Средняя частота: %.4f%n", sum / count);
        } else {
            System.out.println("Файл пуст.");
        }
    }

    private static void task5() {
        String fileName = "f5.txt";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            System.out.println("Числа в файле:");
            for (int i = 0; i < 10; i++) {
                int num = random.nextInt(300);
                writer.write(String.valueOf(num));
                writer.newLine();
                System.out.print(num + " ");
            }
            System.out.println();
        } catch (IOException e) {
            System.out.println("Ошибка записи: " + e.getMessage());
        }

        int count = 0;
        System.out.println("\nЧисла больше 100:");
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                int num = Integer.parseInt(line.trim());
                if (num > 100) {
                    System.out.println(num);
                    count++;
                }
            }
        } catch (IOException e) {
            System.out.println("Ошибка чтения: " + e.getMessage());
        }
        System.out.println("Количество чисел больше 100: " + count);
    }

    private static void printFile(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.print(line + " ");
            }
            System.out.println();
        } catch (IOException e) {
            System.out.println("Ошибка чтения: " + e.getMessage());
        }
    }

    private static int readInt() {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.print("Введите корректное целое число: ");
            }
        }
    }

    private static double readDouble() {
        while (true) {
            try {
                return Double.parseDouble(scanner.nextLine().trim().replace(',', '.'));
            } catch (NumberFormatException e) {
                System.out.print("Введите корректное число: ");
            }
        }
    }
}
