package org.example;

public class Furniture {
    private String name;
    private String material;
    private double price;

    public Furniture(String name, String material, double price) {
        this.name = name;
        this.material = material;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void use() {
        System.out.println("Использую мебель \"" + name + "\"");
    }

    public void use(String purpose) {
        System.out.println("Использую \"" + name + "\" для " + purpose);
    }

    public void use(int hours) {
        System.out.println("Использую \"" + name + "\" " + hours + " часов");
    }

    public String getPurpose() {
        return "Неизвестно";
    }

    @Override
    public String toString() {
        return "Furniture{name='" + name + "', material='" + material +
                "', price=" + price + "}";
    }
}
