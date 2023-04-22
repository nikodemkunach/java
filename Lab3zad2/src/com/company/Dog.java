package com.company;

public class Dog {
    String breed;
    int age;
    String color;

    public Dog(String b, int a, String c){
        breed=b;
        age=a;
        color=c;
    }
    public static void main(String[] args) {
    Dog pies = new Dog("samoyed", 10,"white");
        System.out.println("Barked: ");
        System.out.println(pies.age + "years" +" "+ pies.color+ " " + pies.breed);
        System.out.println("Dog sleeping: ");
        System.out.println(pies.color + " " + pies.breed);
    }
}
