package org.example;

public class Table extends Furniture {
    private int seats;

    public Table(String name, String material, double price, int seats) {
        super(name, material, price);
        this.seats = seats;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    @Override
    public String getPurpose() {
        return "Для работы";
    }

    public void use(int hours, String task) {
        System.out.println("Работаю за столом \"" + getName() + "\" " +
                hours + " часов, задача: " + task);
    }

    @Override
    public String toString() {
        return "Table{name='" + getName() + "', material='" + getMaterial() +
                "', price=" + getPrice() + ", seats=" + seats + "}";
    }
}
