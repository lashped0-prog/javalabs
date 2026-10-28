package org.example;

public class Novel extends Literature {
    private String genre;

    public Novel(String title, String author, int pages, String genre) {
        super(title, author, pages);
        this.genre = genre;
    }

    public String getGenreField() {
        return genre;
    }

    public void setGenreField(String genre) {
        this.genre = genre;
    }

    @Override
    public String getGenre() {
        return "Роман (" + genre + ")";
    }

    @Override
    public String getSummary() {
        return "Краткое содержание романа \"" + getTitle() + "\"";
    }

    @Override
    public void displayInfo() {
        System.out.println("Роман");
        super.displayInfo();
        System.out.println("Поджанр: " + genre);
        System.out.println();
    }
}
