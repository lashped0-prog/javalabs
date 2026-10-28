package org.example;

public class Teacher extends Professional {
    private int students;

    public Teacher(String name, int id, int experience, int students) {
        super(name, id, experience);
        this.students = students;
    }

    public int getStudents() {
        return students;
    }

    public void setStudents(int students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "Teacher{name='" + getName() + "', id=" + getId() +
                ", experience=" + getExperience() + " лет, students=" +
                students + "}";
    }
}