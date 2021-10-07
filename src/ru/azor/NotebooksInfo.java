package ru.azor;

public class NotebooksInfo {
    private static Long time;
    private static final Notebook[] notebooks = Notebook.createArrOfNotebooks();

    public static void main(String[] args) {
        System.out.println("Number of laptops: " + notebooks.length);
        showNotebooks();
        startTime();
        Notebook.selectionSortNotebooks(notebooks);
        endTime();
        System.out.println("----------------------------------------------");
        showNotebooks();
        System.out.println("Sort time: " + time + " mls");
    }

    private static void showNotebooks(){
        for (int i = 0; i < Notebook.ARRAY_SIZE; i++) {
            System.out.println(notebooks[i]);
        }
    }

    private static void startTime() {
        time = System.currentTimeMillis();
    }

    private static void endTime() {
        time = System.currentTimeMillis() - time;
    }
}
