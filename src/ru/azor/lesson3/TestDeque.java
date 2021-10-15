package ru.azor.lesson3;

import ru.azor.lesson4.LinkedDeque;

public class TestDeque {
    public static void main(String[] args) {
//        Deque<Integer> deque = new DequeImpl<>(5);
        LinkedDeque<Integer> linkedDeque = new LinkedDeque<>();
        testRandom(linkedDeque);
//        testRandom(deque);
//        testCirculationDequeLeft(deque);
//        testCirculationDequeRight(deque);
    }

    private static void testRandom(LinkedDeque<Integer> deque) {
        System.out.println("-----------------------------------");
        System.out.println("Random test");
        System.out.println("Clearing the queue: " + deque.removeAll());
        deque.display();
        System.out.println("Right adding an element: " + deque.insertRight(34));
        System.out.println("Right adding an element: " + deque.insertRight(12));
        System.out.println("Right adding an element: " + deque.insertRight(20));
        deque.display();
        System.out.println("Left adding an element: " + deque.insertLeft(16));
        System.out.println("Left adding an element: " + deque.insertLeft(14));
        System.out.println("Left adding an element: " + deque.insertLeft(17));
        deque.display();
        System.out.println("Right deletion of an element: " + deque.removeRight());
        System.out.println("Right deletion of an element: " + deque.removeRight());
        deque.display();
        System.out.println("Left deletion of an element: " + deque.removeLeft());
        System.out.println("Left deletion of an element: " + deque.removeLeft());
        deque.display();
        System.out.println(deque.peekFront());
        System.out.println("Remove all: " + deque.removeAll());
        deque.display();
        System.out.println("-----------------------------------");
    }

    private static void testCirculationDequeRight(Deque<Integer> deque) {
        System.out.println("-----------------------------------");
        System.out.println("Check the circulation of the deque to the right");
        System.out.println("Clearing the queue: " + deque.removeAll());
        deque.display();
        System.out.println("Left adding an element: " + deque.insertLeft(16));
        System.out.println("Left adding an element: " + deque.insertLeft(14));
        System.out.println("Left adding an element: " + deque.insertLeft(29));
        System.out.println("Left adding an element: " + deque.insertLeft(36));
        System.out.println("Left adding an element: " + deque.insertLeft(34));
        deque.display();
        System.out.println("Right deletion of an element: " + deque.removeRight());
        deque.display();
        System.out.println("Left adding an element: " + deque.insertLeft(17));
        deque.display();
        System.out.println("Right deletion of an element: " + deque.removeRight());
        deque.display();
        System.out.println("Left adding an element: " + deque.insertLeft(18));
        deque.display();
        System.out.println("Right deletion of an element: " + deque.removeRight());
        deque.display();
        System.out.println("Left adding an element: " + deque.insertLeft(19));
        deque.display();
        System.out.println("Right deletion of an element: " + deque.removeRight());
        deque.display();
        System.out.println("Left adding an element: " + deque.insertLeft(20));
        deque.display();
        System.out.println("Right deletion of an element: " + deque.removeRight());
        deque.display();
        System.out.println("Left adding an element: " + deque.insertLeft(21));
        deque.display();
        System.out.println("Right deletion of an element: " + deque.removeRight());
        deque.display();
        System.out.println("Left adding an element: " + deque.insertLeft(22));
        deque.display();
        System.out.println("Right deletion of an element: " + deque.removeRight());
        deque.display();
        System.out.println("Left adding an element: " + deque.insertLeft(23));
        deque.display();
        System.out.println("Right deletion of an element: " + deque.removeRight());
        deque.display();
        System.out.println("Left adding an element: " + deque.insertLeft(24));
        deque.display();
        System.out.println("Right deletion of an element: " + deque.removeRight());
        deque.display();
        System.out.println("Left adding an element: " + deque.insertLeft(25));
        deque.display();
        System.out.println("-----------------------------------");
    }

    private static void testCirculationDequeLeft(Deque<Integer> deque) {
        System.out.println("-----------------------------------");
        System.out.println("Check the circulation of the deque to the left");
        System.out.println("Clearing the queue: " + deque.removeAll());
        deque.display();
        System.out.println("Right adding an element: " + deque.insertRight(16));
        System.out.println("Right adding an element: " + deque.insertRight(14));
        System.out.println("Right adding an element: " + deque.insertRight(29));
        System.out.println("Right adding an element: " + deque.insertRight(36));
        System.out.println("Right adding an element: " + deque.insertRight(34));
        deque.display();
        System.out.println("Left deletion of an element: " + deque.removeLeft());
        deque.display();
        System.out.println("Right adding an element: " + deque.insertRight(17));
        deque.display();
        System.out.println("Left deletion of an element: " + deque.removeLeft());
        deque.display();
        System.out.println("Right adding an element: " + deque.insertRight(18));
        deque.display();
        System.out.println("Left deletion of an element: " + deque.removeLeft());
        deque.display();
        System.out.println("Right adding an element: " + deque.insertRight(19));
        deque.display();
        System.out.println("Left deletion of an element: " + deque.removeLeft());
        deque.display();
        System.out.println("Right adding an element: " + deque.insertRight(20));
        deque.display();
        System.out.println("Left deletion of an element: " + deque.removeLeft());
        deque.display();
        System.out.println("Right adding an element: " + deque.insertRight(21));
        deque.display();
        System.out.println("Left deletion of an element: " + deque.removeLeft());
        deque.display();
        System.out.println("Right adding an element: " + deque.insertRight(22));
        deque.display();
        System.out.println("Left deletion of an element: " + deque.removeLeft());
        deque.display();
        System.out.println("Right adding an element: " + deque.insertRight(23));
        deque.display();
        System.out.println("Left deletion of an element: " + deque.removeLeft());
        deque.display();
        System.out.println("Right adding an element: " + deque.insertRight(24));
        deque.display();
        System.out.println("Left deletion of an element: " + deque.removeLeft());
        deque.display();
        System.out.println("Right adding an element: " + deque.insertRight(25));
        deque.display();
        System.out.println("-----------------------------------");
    }
}

