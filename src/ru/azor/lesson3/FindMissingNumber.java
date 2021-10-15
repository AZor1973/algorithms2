package ru.azor.lesson3;

import java.util.Arrays;

public class FindMissingNumber {
    private static final int MISSING_NUMBER = 7;

    public static void main(String[] args) {
        int[] arr = new int[10000];
        fillingArray(arr, MISSING_NUMBER);
        System.out.println(Arrays.toString(arr));
        binarySearchMissingNumber(arr);
    }

    private static void fillingArray(int[] arr, int number) {
        for (int i = 0; i < arr.length; i++) {
            if (i >= number - 1){
                arr[i] = i + 2;
            }else {
                arr[i] = i + 1;
            }
        }
    }

    private static void binarySearchMissingNumber(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        int base;
        int i = 0;

        while (end >= start) {
            i++;
            base = (start + end) / 2;
            if (arr[base] == base + 1) {
                start = base + 1;
            } else {
                end = base - 1;
            }
        }
        System.out.println("Кол-во итераций: " + i);
        String result =  start == arr.length ? "Все числа на месте." : "Отсутствующее число: " + (arr[start] - 1);
        System.out.println(result);
    }
}

