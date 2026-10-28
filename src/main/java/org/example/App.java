package org.example;

public class App {
    public static void main(String[] args) {
        Literature[] library = new Literature[5];

        library[0] = new Novel("Война и мир", "Л. Н. Толстой", 1225, "исторический");
        library[1] = new Novel("Преступление и наказание", "Ф. М. Достоевский", 671, "психологический");
        library[2] = new Novel("Мастер и Маргарита", "М. А. Булгаков", 480, "мистический");

        library[3] = new Textbook("Алгебра 9 класс", "С. А. Теляковский", 320, "Математика");
        library[4] = new Textbook("Общая биология", "Д. К. Беляев", 450, "Биология");

        System.out.println("Полная информация\n");
        for (Literature item : library) {
            item.displayInfo();
        }

        System.out.println("Только жанры");
        for (Literature item : library) {
            System.out.println(item.getTitle() + " - " + item.getGenre());
        }

        // Literature lit = new Literature("Тест", "Автор", 100);
    }
}