package ru.azor.lesson5;

public class ClassicBackpack {
    private static final int MAX_WEIGHT = 5000;

    private static final Thing[] things = {
            new Thing("Телефон", 200, 150),
            new Thing("Гиря", 5000, 30),
            new Thing("Ноутбук", 2000, 500),
            new Thing("Часы", 500, 50),
            new Thing("Тостер", 1000, 50)
    };

    public static void main(String[] args) {
        System.out.println("Максимальная стоимость вещей в рюкзаке: " + stuffBackpack(things.length - 1, MAX_WEIGHT));
    }

    private static int stuffBackpack(int i, int weigth) {
        if (i < 0) {
            return 0;
        }
        if (things[i].getWeight() > weigth) {
            return stuffBackpack(i - 1, weigth);
        } else {
            return Math.max(stuffBackpack(i - 1, weigth), stuffBackpack(i - 1, weigth - things[i].getWeight()) + things[i].getPrice());
        }
    }
}
