package org.example;

public abstract class Literature {
    private String title;
    private String author;
    private int pages;

    public Literature(String title, String author, int pages) {
        this.title = title;
        this.author = author;
        this.pages = pages;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public abstract String getGenre();

    public abstract String getSummary();

    public void displayInfo() {
        System.out.println("Название: " + title);
        System.out.println("Автор: " + author);
        System.out.println("Страниц: " + pages);
        System.out.println("Жанр: " + getGenre());
        System.out.println("Краткое содержание: " + getSummary());
    }
}
