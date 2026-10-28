package org.example;

public class Textbook extends Literature {
    private String subject;

    public Textbook(String title, String author, int pages, String subject) {
        super(title, author, pages);
        this.subject = subject;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Override
    public String getGenre() {
        return "Учебник";
    }

    @Override
    public String getSummary() {
        return "Краткое содержание учебника \"" + getTitle() +
                "\" по предмету: " + subject;
    }

    @Override
    public void displayInfo() {
        System.out.println("Учебник");
        super.displayInfo();
        System.out.println("Предмет: " + subject);
        System.out.println();
    }
}