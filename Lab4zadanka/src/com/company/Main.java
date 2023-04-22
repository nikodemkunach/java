package com.company;

public class Main {

    public static void main(String[] args) {
	Circle2D kolo1 = new Circle2D();
	Circle2D kolo2 = new Circle2D(1,2,3);
	System.out.println("pole = " + kolo2.getArea(2));
	System.out.println("obwod = " + kolo2.getPerimeter(4));
	kolo2.getPerimeter(4);
	kolo1.setX(1);
	kolo1.setY(1);
	kolo1.setRadius(0.5);

//////////////////////////////////////////////

	Zawodnik zawodnik1 = new Zawodnik("Wariat",2,12);
	zawodnik1.przedstawSie("Wariat ",2,12);

	Random rand = new Random();
	rand.nextInt(10); // liczba wylosowana miedzy 0-9 (wlacznie)
	int liczba = rand.nextInt(10) + 2; // liczba wylosoawan miedzy 2-11 (wlacznie)
    }
}
