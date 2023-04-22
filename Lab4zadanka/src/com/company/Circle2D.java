package com.company;

public class Circle2D {
    private double x;
    private double y;
    private double radius;

    public Circle2D() {
        this.x = getX();
        this.y = getY();
        this.radius = getRadius();
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public Circle2D (double x, double y, int radius) {
        System.out.println(x + "," + y + " " + "srednica = " + radius*2);
    }

    public double getArea(double radius) {
        return radius * radius * Math.PI;
    }

    public double getPerimeter(double radius) {
        return radius * 2 * Math.PI;
    }
}
