package ru.azor.lesson5;

import java.util.*;

public class ThiefChoice {
    private static final int MAX_WEIGHT = 5000;
    private final Set<List<Thing>> options = new LinkedHashSet<>();
    private final Set<List<Thing>> matches = new LinkedHashSet<>();
    private final List<Thing> backpack = new ArrayList<>();
    private final List<Thing> things = new ArrayList<>();
    private List<Thing> flat = new ArrayList<>();

    public static void main(String[] args) {
        ThiefChoice choice = new ThiefChoice();
        choice.fillingFlat();
        choice.stuffBackpack();
        choice.showBackpackContents();
    }

    private void stuffBackpack() {
        options.clear();
        findOptions(flat.size());
        checkWeight();
        fillingBackpack();
        System.out.println("Стоимость вещей в рюкзаке: " + getSumCost(backpack));
        System.out.println("----------------------");
    }

    private void fillingBackpack() {
        int max = matches.stream().map(this::getSumCost).max(Comparator.naturalOrder()).get();
        for (List<Thing> match : matches) {
            if (getSumCost(match) == max) {
                backpack.addAll(match);
            }
        }
    }

    private void checkWeight() {
        for (List<Thing> option : options) {
            if (getSumWeight(option) <= MAX_WEIGHT) {
                matches.add(option);
            }
        }
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

    private void findOptions(int length) {
        if (length == 0) {
            return;
        }
        for (int k = 0; k <= length; k++) {
            for (int i = 0; i <= length; i++) {
                findOptions(length - 1);
                enumeration(length);
            }
        }
    }

    private void enumeration(int length) {
        things.clear();
        for (int j = flat.size() - length; j < flat.size(); j++) {
            things.add(flat.get(j));
            if (getSumWeight(things) < MAX_WEIGHT)
            options.add(List.copyOf(things));
        }
        things.clear();
        for (int i = 0; i < flat.size(); i++) {
            if (i == flat.size() - length) {
                continue;
            }
            things.add(flat.get(i));
            if (getSumWeight(things) < MAX_WEIGHT)
            options.add(List.copyOf(things));
        }
        things.clear();
        for (int i = 0; i < flat.size(); i++) {
            things.add(flat.get(i));
            for (int j = i + 1; j < flat.size(); j++) {
                things.add(flat.get(j));
                if (getSumWeight(things) < MAX_WEIGHT)
                options.add(List.copyOf(things));
                things.clear();
                things.add(flat.get(i));
            }
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
