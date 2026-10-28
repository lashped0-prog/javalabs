package org.example;

public class Train {
    private String destination;
    private String trainNumber;
    private String departureTime;
    private int count;
    public int getCount() {return this.count;}
    public void setCount(int count) {this.count = count;}
    public Train(String destination, String trainNumber, String departureTime, int count)
    {
        this(destination, trainNumber, departureTime);
        this.count = count;
    }














































    public Train(String destination, String trainNumber, String departureTime) {
        this.destination = destination;
        this.trainNumber = trainNumber;
        this.departureTime = departureTime;
    }

    public String getDestination() {
        return destination;
    }

    public String getTrainNumber() {
        return trainNumber;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void isDelayed(int minutes) {
        String[] parts = departureTime.split(":");
        int hours = Integer.parseInt(parts[0]);
        int mins = Integer.parseInt(parts[1]);

        int totalMinutes = hours * 60 + mins + minutes;
        int newHours = (totalMinutes / 60) % 24;
        int newMins = totalMinutes % 60;

        this.departureTime = String.format("%02d:%02d", newHours, newMins);
    }

    @Override
    public String toString() {
        return "Train{пункт назначения='" + destination + "', номер поезда='" +
                trainNumber + "', время отправления='" + departureTime + "'}";
    }
}