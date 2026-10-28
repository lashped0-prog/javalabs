package org.example;

public class App {
    public static void main(String[] args) {
        Clinic clinic = new Clinic("Здоровье+");
        System.out.println("Создание врачей");

        Doctor d1 = null, d2 = null, d3 = null;
        try {
            d1 = new Doctor("Иванов Иван", "Кардиолог", 15, 5);
            d2 = new Doctor("Петрова Анна", "Педиатр", 8, 4);
            d3 = new Doctor("Сидоров Олег", "Хирург", 20, 5);
        } catch (InvalidDoctorDataException e) {
            System.out.println("Ошибка создания врача: " + e.getMessage());
        }

        try {
            Doctor bad = new Doctor("Плохой Врач", "Терапевт", -5, 3);
        } catch (InvalidDoctorDataException e) {
            System.out.println("Ожидаемая ошибка: " + e.getMessage());
        }

        try {
            Doctor bad2 = new Doctor("Плохой Рейтинг", "Терапевт", 5, 10);
        } catch (InvalidDoctorDataException e) {
            System.out.println("Ожидаемая ошибка: " + e.getMessage());
        }

        if (d1 != null) clinic.addDoctor(d1);
        if (d2 != null) clinic.addDoctor(d2);
        if (d3 != null) clinic.addDoctor(d3);

        clinic.printAllDoctors();

        System.out.println("\nЗапись пациентов");

        try {
            clinic.makeAppointment("Иванов Иван", "Смирнов А.");
            clinic.makeAppointment("Иванов Иван", "Кузнецова М.");
            clinic.makeAppointment("Петрова Анна", "Морозов Д.");
            clinic.makeAppointment("Сидоров Олег", "Волкова Е.");
        } catch (DoctorNotFoundException | AppointmentException e) {
            System.out.println("Ошибка записи: " + e.getMessage());
        }

        try {
            clinic.makeAppointment("Иванов Иван", "Смирнов А.");
        } catch (DoctorNotFoundException | AppointmentException e) {
            System.out.println("Ожидаемая ошибка: " + e.getMessage());
        }

        try {
            clinic.makeAppointment("Неизвестный Врач", "Тестов Т.");
        } catch (DoctorNotFoundException | AppointmentException e) {
            System.out.println("Ожидаемая ошибка: " + e.getMessage());
        }

        try {
            clinic.makeAppointment("Петрова Анна", "");
        } catch (DoctorNotFoundException | AppointmentException e) {
            System.out.println("Ожидаемая ошибка: " + e.getMessage());
        }

        System.out.println("\nОбновление рейтинга");

        try {
            clinic.updateRating("Петрова Анна", 5);
        } catch (DoctorNotFoundException | InvalidDoctorDataException e) {
            System.out.println("Ошибка обновления рейтинга: " + e.getMessage());
        }

        try {
            clinic.updateRating("Сидоров Олег", 7);
        } catch (DoctorNotFoundException | InvalidDoctorDataException e) {
            System.err.println("Ожидаемая ошибка: " + e.getMessage());
        }

        try {
            clinic.updateRating("Никто Никто", 4);
        } catch (DoctorNotFoundException | InvalidDoctorDataException e) {
            System.out.println("Ожидаемая ошибка: " + e.getMessage());
        }

        clinic.printAllDoctors();
    }
}