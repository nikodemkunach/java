package com.company;

public class Dog {
    private int wiek;
    private String rasa;

    public Dog(int wiek) {
        this.wiek = wiek;
    }

    public int getWiek() {

        return wiek;
    }

    public void setWiek(int wiek) {
        this.wiek = wiek;
    }

    public void bark() {
        System.out.println("Hau hau " + pomoc());
    }

    public void starzejSie() {
        this.wiek++;
    }

    public String pomoc() {
        return wiek + " " + rasa;
    }


    //public - mamy dostep z kazdego miejsca
    //private - mamy dostep z wewnatrz klasy
    //protected - mamy dostep wewnatrz kalsy, lub wewnatrz klasy dziedziczacej
    //[default] (jak nie napiszemy nic) - mamy dostep wewnatrz pakietu

}
