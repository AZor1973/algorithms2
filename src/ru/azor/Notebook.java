package ru.azor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.Random;

public class Notebook implements Comparable<Notebook> {
    private final Integer price;
    private final Integer ram;
    private final String manufacturer;
    private static final Random random = new Random();
    private final static ArrayList<String> MANUFACTURERS = new ArrayList<>(Arrays.asList("Lenuvo", "Asos", "MacNote", "Eser", "Xamiou"));
    public static final int ARRAY_SIZE = 5000;

    private Notebook(int price, int ram, String manufacturer) {
        this.price = price;
        this.ram = ram;
        this.manufacturer = manufacturer;
    }

    public static Notebook[] createArrOfNotebooks() {
        Notebook[] arr = new Notebook[ARRAY_SIZE];
        for (int i = 0; i < ARRAY_SIZE; i++) {
            arr[i] = new Notebook(random.nextInt(10, 61) * 50, random.nextInt(1, 7) * 4, MANUFACTURERS.get(random.nextInt(MANUFACTURERS.size())));
        }
        return arr;
    }

    public static void selectionSortNotebooks(Notebook[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j].compareTo(arr[min]) < 0) {
                    min = j;
                }
            }
            if (i == min) {
                continue;
            }
            Notebook temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }
    }

    @Override
    public int compareTo(Notebook notebook) {
        int result = this.price.compareTo(notebook.price);
        if (result == 0) {
            result = this.ram.compareTo(notebook.ram);
        }
        if (result == 0) {
            int indexThis = MANUFACTURERS.indexOf(this.manufacturer);
            int indexO = MANUFACTURERS.indexOf(notebook.manufacturer);
            result = Integer.compare(indexThis, indexO);
        }
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Notebook notebooks = (Notebook) o;
        return price.equals(notebooks.price) && ram.equals(notebooks.ram) && manufacturer.equals(notebooks.manufacturer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(price, ram, manufacturer);
    }

    @Override
    public String toString() {
        return "Notebook: price = " + price +
                ", ram = " + ram +
                ", manufacturer ='" + manufacturer + '\'';
    }
}
