package ru.azor.lesson5;

public class Exponentiation {
    public static void main(String[] args) {
        System.out.println(numberToPower(6, 14));
    }

    private static long numberToPower(long n, long pow){
       if (pow == 1){
           return n;
       }
        return n*numberToPower(n, pow - 1);
    }
}
