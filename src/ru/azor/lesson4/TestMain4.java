package ru.azor.lesson4;



public class TestMain4 {

    public static void main(String[] args) {
        SimpleLinkedListImpl<Integer> linkedList = new SimpleLinkedListImpl<>();
        fillSimpleLinkedListImpl(linkedList);
        testLinkedList(linkedList);
        testIterator(linkedList);
    }

    private static void testLinkedList(SimpleLinkedListImpl<Integer> linkedList) {
        System.out.println("----------------------------------");
        System.out.println("TestLinkedList:");
        linkedList.display();
        System.out.println("Find 2: " + linkedList.contains(2));
        System.out.println("Find 1: " + linkedList.contains(1));
        System.out.println("Find 4: " + linkedList.contains(4));
        System.out.println("Find 4444: " + linkedList.contains(4444));
        System.out.println("Remove first: " + linkedList.removeFirst());
        System.out.println("Remove 4: " + linkedList.remove(4));
        System.out.println("Remove 10: " + linkedList.remove(10));
        linkedList.display();
        System.out.println("----------------------------------");
    }

    private static void fillSimpleLinkedListImpl(SimpleLinkedListImpl<Integer> linkedList) {
        linkedList.insertFirst(1);
        linkedList.insertFirst(2);
        linkedList.insertFirst(3);
        linkedList.insertFirst(4);
        linkedList.insertFirst(5);
        linkedList.insertFirst(6);
        linkedList.insertFirst(7);
        linkedList.insertFirst(8);
    }

    private static void testIterator(SimpleLinkedListImpl<Integer> linkedList){
        System.out.println("----------------------------------");
        System.out.println("TestIterator");
        linkedList.display();
        System.out.println("Size: " + linkedList.size);
        for (Integer value : linkedList) {
            System.out.println("Value is: " + value);
        }
        for (Integer ignored : linkedList) {
            linkedList.iterator().remove();
        }
        System.out.println("SizeAfterIteratorRemove: " + linkedList.size);
        linkedList.display();
        System.out.print("Remove empty linkedList: ");
        for (Integer ignored : linkedList) {
            linkedList.iterator().remove();
        }
        System.out.println("OK");
        linkedList.display();
        System.out.println("----------------------------------");
    }
}