package org.example;

public class Doctor extends Professional {
    private String specialization;

    public Doctor(String name, int id, int experience, String specialization) {
        super(name, id, experience);
        this.specialization = specialization;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    @Override
    public String toString() {
        return "Doctor{name='" + getName() + "', id=" + getId() +
                ", experience=" + getExperience() + " лет, specialization='" +
                specialization + "'}";
    }
}