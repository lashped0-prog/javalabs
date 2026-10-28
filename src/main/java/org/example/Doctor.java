package org.example;

import java.util.ArrayList;
import java.util.List;

public class Doctor {
    private String name;
    private String specialization;
    private int experience;
    private int rating;
    private List<String> patients;

    public Doctor(String name, String specialization, int experience, int rating)
            throws InvalidDoctorDataException {
        setName(name);
        setSpecialization(specialization);
        setExperience(experience);
        setRating(rating);
        this.patients = new ArrayList<>();
    }

    public void setName(String name) throws InvalidDoctorDataException {
        if (name == null || name.trim().isEmpty()) {
            throw new InvalidDoctorDataException("Имя врача не может быть пустым");
        }
        this.name = name;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public void setExperience(int experience) throws InvalidDoctorDataException {
        if (experience < 0) {
            throw new InvalidDoctorDataException(
                    "Опыт врача не может быть отрицательным: " + experience);
        }
        this.experience = experience;
    }

    public void setRating(int rating) throws InvalidDoctorDataException {
        if (rating < 1 || rating > 5) {
            throw new InvalidDoctorDataException(
                    "Рейтинг должен быть в диапазоне 1-5: " + rating);
        }
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public String getSpecialization() {
        return specialization;
    }

    public int getExperience() {
        return experience;
    }

    public int getRating() {
        return rating;
    }

    public List<String> getPatients() {
        return patients;
    }

    public void makeAppointment(String patient) throws AppointmentException {
        if (patient == null || patient.trim().isEmpty()) {
            throw new AppointmentException("Имя пациента не может быть пустым");
        }
        if (patients.contains(patient)) {
            throw new AppointmentException(
                    "Пациент \"" + patient + "\" уже записан к врачу " + name);
        }
        if (patients.size() >= 10) {
            throw new AppointmentException(
                    "У врача " + name + " нет свободных мест (максимум 10)");
        }
        patients.add(patient);
        System.out.println("Пациент \"" + patient + "\" записан к врачу " + name);
    }

    public void updateRating(int newRating) throws InvalidDoctorDataException {
        if (newRating < 1 || newRating > 5) {
            throw new InvalidDoctorDataException(
                    "Новый рейтинг должен быть в диапазоне 1-5: " + newRating);
        }
        System.out.println("Рейтинг врача " + name + ": " + this.rating + " → " + newRating);
        this.rating = newRating;
    }

    @Override
    public String toString() {
        return "Doctor{name='" + name + "', specialization='" + specialization +
                "', experience=" + experience + ", rating=" + rating +
                ", patients=" + patients.size() + "}";
    }
}
