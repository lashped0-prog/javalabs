package org.example;

import java.util.ArrayList;
import java.util.List;

public class Singer implements Performer, Awardable {
    private String name;
    private String genre;
    private List<String> awards;

    public Singer(String name, String genre) {
        this.name = name;
        this.genre = genre;
        this.awards = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public void perform() {
        System.out.println(name + " поет песню в жанре " + genre);
    }

    @Override
    public String getGenre() {
        return genre;
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
        return "Singer{name='" + name + "', genre='" + genre +
                "', awards=" + awards + "}";
    }
}
