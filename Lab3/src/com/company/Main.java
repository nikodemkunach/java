package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Podaj 1 liczbe: ");
        int x = scan.nextInt();
        System.out.println("Podaj 2 liczbe: ");
        int y = scan.nextInt();

        if(y>x) {
            System.out.println("1");
        } else if(x==y) {
            System.out.println("0");
        }
        else{
                System.out.println("-1");
            }
        }
    }
