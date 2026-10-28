package org.example;

public class Chair extends Furniture {
    private boolean hasBackrest;

    public Chair(String name, String material, double price, boolean hasBackrest) {
        super(name, material, price);
        this.hasBackrest = hasBackrest;
    }

    public boolean isHasBackrest() {
        return hasBackrest;
    }

    public void setHasBackrest(boolean hasBackrest) {
        this.hasBackrest = hasBackrest;
    }

    @Override
    public String getPurpose() {
        return "Для сидения";
    }

    public void use(String person, int hours) {
        System.out.println(person + " сидит на стуле \"" + getName() +
                "\" " + hours + " часов");
    }

    @Override
    public String toString() {
        return "Chair{name='" + getName() + "', material='" + getMaterial() +
                "', price=" + getPrice() + ", hasBackrest=" + hasBackrest + "}";
    }
}
