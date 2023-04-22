package com.company;

public class Main {

    public static void main(String[] args) {
	Dog burek = new Dog(3);
	burek.starzejSie();
	int wiek = burek.getWiek();
	burek.setWiek(3);
	burek.rasa = "labrador";
	burek.bark();
	burek.starzejSie();
	burek.bark();

	burek.rasa = "tsadadas";
	Dog reksio = new Dog(4);
	reksio.rasa = "dasad";

    }
}
