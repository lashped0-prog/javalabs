package org.example;

import java.util.ArrayList;
import java.util.List;

public class Dancer implements Performer, Awardable {
    private String name;
    private String style;
    private List<String> awards;

    public Dancer(String name, String style) {
        this.name = name;
        this.style = style;
        this.awards = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    @Override
    public void perform() {
        System.out.println(name + " исполняет танец в стиле " + style);
    }

    @Override
    public String getGenre() {
        return style;
    }

    @Override
    public String[] getAwards() {
        return awards.toArray(new String[0]);
    }

    @Override
    public void addAward(String award) {
        awards.add(award);
    }

    @Override
    public int getAwardsCount() {
        return awards.size();
    }

    @Override
    public String toString() {
        return "Dancer{name='" + name + "', style='" + style +
                "', awards=" + awards + "}";
    }
}