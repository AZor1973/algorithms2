package ru.azor.lesson5;

public class ClassicBackpack {
    private static final int MAX_WEIGHT = 80;

    private static final Things[] things = {
            new Things(15, 30),
            new Things(30, 90),
            new Things(50, 100),
            new Things(50, 120)
    };

    public static void main(String[] args) {
        System.out.println("Максимальная стоимость вещей в рюкзаке: " + stuffBackpack(things.length - 1, MAX_WEIGHT));
    }

    private static int stuffBackpack(int i, int weigth) {
        if (i < 0) {
            return 0;
        }
        if (things[i].getWeight() > weigth) {
            return stuffBackpack(i-1, weigth);
        }
        else {
            return Math.max(stuffBackpack(i-1, weigth), stuffBackpack(i-1, weigth - things[i].getWeight()) + things[i].getPrice());
        }
    }
}
