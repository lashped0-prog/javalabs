package org.example;

public interface Performer {
    void perform();

    String getGenre();

    static void printHeader() {
        System.out.println("Выступление артиста");
    }
}