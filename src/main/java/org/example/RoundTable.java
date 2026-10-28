package org.example;

public class RoundTable {
    private double diameter;
    private Materials material;

    public RoundTable(double diameter, Materials material) {
        this.diameter = diameter;
        this.material = material;
    }

    public double area() {
        double radius = diameter / 2.0;
        return Math.PI * radius * radius;
    }

    public double getDiameter() {
        return diameter;
    }

    public Materials getMaterial() {
        return material;
    }

    @Override
    public String toString() {
        return "RoundTable{diameter=" + diameter + ", material=" + material + "}";
    }
}