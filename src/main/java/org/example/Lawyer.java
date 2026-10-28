package org.example;

public class Lawyer extends Professional {
    private int courtCases;

    public Lawyer(String name, int id, int experience, int courtCases) {
        super(name, id, experience);
        this.courtCases = courtCases;
    }

    public int getCourtCases() {
        return courtCases;
    }

    public void setCourtCases(int courtCases) {
        this.courtCases = courtCases;
    }

    @Override
    public String toString() {
        return "Lawyer{name='" + getName() + "', id=" + getId() +
                ", experience=" + getExperience() + " лет, courtCases=" +
                courtCases + "}";
    }
}