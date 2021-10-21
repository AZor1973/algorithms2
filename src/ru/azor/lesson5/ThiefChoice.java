package ru.azor.lesson5;

import java.util.*;

public class ThiefChoice {
    private static final int MAX_WEIGHT = 5000;
    private int bestPrice;
    private List<Thing> backpack = new ArrayList<>();
    private final List<Thing> things = new ArrayList<>();
    private List<Thing> flat = new ArrayList<>();

    public static void main(String[] args) {
        ThiefChoice choice = new ThiefChoice();
        choice.fillingFlat();
        choice.stuffBackpack();
        choice.showBackpackContents();
    }

    private void stuffBackpack() {
        findOptions(flat);
        System.out.println("Стоимость вещей в рюкзаке: " + getSumCost(backpack));
        System.out.println("----------------------");
    }

    private int getSumWeight(List<Thing> list) {
        int sum = 0;
        for (Thing thing : list) {
            sum += thing.getWeight();
        }
        return sum;
    }

    private int getSumCost(List<Thing> list) {
        int sum = 0;
        for (Thing thing : list) {
            sum += thing.getPrice();
        }
        return sum;
    }

    private void bestSet(List<Thing> list) {
        int sum = getSumCost(list);
        int weight = getSumWeight(list);
        if (sum > bestPrice && weight < MAX_WEIGHT){
            bestPrice = sum;
            backpack = list;
        }
    }

    private void findOptions(List<Thing> list) {
        if (list.isEmpty()) {
            return;
        }
        bestSet(list);
        for (int i = 0; i < list.size(); i++) {
            List<Thing> copy = new ArrayList<>(list);
            copy.remove(i);
            findOptions(copy);
        }
    }

    private void fillingFlat() {
        Thing phone = new Thing("Телефон", 200, 150);
        Thing dumbbell = new Thing("Гиря", 5000, 30);
        Thing notebook = new Thing("Ноутбук", 2000, 500);
        Thing watch = new Thing("Часы", 500, 50);
        Thing toaster = new Thing("Тостер", 1000, 50);
        flat = List.of(phone, dumbbell, notebook, watch, toaster);
    }

    private void showBackpackContents() {
        for (Thing thing : backpack) {
            System.out.println(thing);
        }
    }
}
