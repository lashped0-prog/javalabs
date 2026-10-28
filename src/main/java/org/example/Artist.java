package org.example;

public class Artist {
    private String name;
    private int age;
    private String genre;

    public Artist(String name, int age, String genre) {
        this.name = name;
        this.age = age;
        this.genre = genre;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void perform() {
        System.out.println(name + " выступает на сцене");
    }

    public void displayInfo() {
        System.out.println("Имя: " + name + ", возраст: " + age + ", жанр: " + genre);
    }

    @Override
    public String toString() {
        return "Artist{name='" + name + "', age=" + age + ", genre='" + genre + "'}";
    }
}