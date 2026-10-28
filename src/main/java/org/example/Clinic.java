package org.example;

import java.util.ArrayList;
import java.util.List;

public class Clinic {
    private String name;
    private List<Doctor> doctors;

    public Clinic(String name) {
        this.name = name;
        this.doctors = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Doctor> getDoctors() {
        return doctors;
    }

    public void addDoctor(Doctor doctor) {
        doctors.add(doctor);
        System.out.println("В клинику \"" + name + "\" добавлен врач: " + doctor.getName());
    }

    public Doctor findDoctor(String name) throws DoctorNotFoundException {
        for (Doctor d : doctors) {
            if (d.getName().equalsIgnoreCase(name)) {
                return d;
            }
        }
        throw new DoctorNotFoundException("Врач \"" + name + "\" не найден в клинике " + this.name);
    }

    public void makeAppointment(String doctorName, String patient)
            throws DoctorNotFoundException, AppointmentException {
        Doctor doctor = findDoctor(doctorName);
        doctor.makeAppointment(patient);
    }

    public void updateRating(String doctorName, int newRating)
            throws DoctorNotFoundException, InvalidDoctorDataException {
        Doctor doctor = findDoctor(doctorName);
        doctor.updateRating(newRating);
    }

    public void printAllDoctors() {
        System.out.println("\nВрачи клиники \"" + name + "\"");
        for (Doctor d : doctors) {
            System.out.println(d);
        }
    }
}