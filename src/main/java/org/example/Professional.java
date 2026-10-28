package org.example;

public class Professional {
    private String name;
    private int id;
    private int experience;

    public Professional(String name, int id, int experience) {
        this.name = name;
        this.id = id;
        this.experience = experience;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    @Override
    public String toString() {
        return "Professional{name='" + name + "', id=" + id +
                ", experience=" + experience + " лет}";
    }
}