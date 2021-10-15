package ru.azor.lesson3;


public interface Deque<E> {

    boolean insertLeft(E value);

    boolean insertRight(E value);

    E removeLeft();

    E removeRight();

    boolean removeAll();

    E peekFront();

    int size();

    boolean isEmpty();

    boolean isFull();

    void display();
}
