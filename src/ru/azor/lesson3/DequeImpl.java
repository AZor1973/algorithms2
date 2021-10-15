package ru.azor.lesson3;

public class DequeImpl<E> implements Deque<E> {
    private final E[] data;
    private int size;

    private int tail;
    private int head;

    private final int HEAD_DEFAULT = 0;
    private final int TAIL_DEFAULT = -1;

    public DequeImpl(int maxSize) {
        this.data = (E[]) new Object[maxSize];
        head = HEAD_DEFAULT;
        tail = TAIL_DEFAULT;
    }

    @Override
    public E peekFront() {
        return data[head];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean isFull() {
        return size == data.length;
    }

    @Override
    public void display() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        if (head <= tail && size != 0) {
            for (int i = head; i <= tail; i++) {
                sb.append(data[i]);
                if (i != tail) {
                    sb.append(", ");
                }
            }
        } else if (size != 0){
            for (int i = head; i < data.length; i++) {
                sb.append(data[i]);
                if (i != tail) {
                    sb.append(", ");
                }
            }
            for (int i = 0; i <= tail; i++) {
                sb.append(data[i]);
                if (i != tail) {
                    sb.append(", ");
                }
            }
        }
        sb.append("]");
        return sb.toString();
    }

    @Override
    public boolean insertLeft(E value) {
        if (isFull()) {
            System.out.println("The deque is full");
            return false;
        }
        if (isEmpty()){
            tail = data.length - 1;
        }
        if (head == HEAD_DEFAULT) {
            head = data.length - 1;
            data[head] = value;
        } else {
            data[--head] = value;
        }
        size++;
        return true;
    }

    @Override
    public boolean insertRight(E value) {
        if (isFull()) {
            System.out.println("The deque is full");
            return false;
        }
        if (tail == data.length - 1) {
            tail = TAIL_DEFAULT;
        }
        data[++tail] = value;
        size++;
        return true;
    }

    @Override
    public E removeLeft() {
        if (isEmpty()) {
            System.out.println("The deque is empty");
            return null;
        }
        E value;
        if (head == data.length - 1) {
            value = data[head];
            head = HEAD_DEFAULT;
        } else {
            value = data[head++];
        }
        size--;
        if (isEmpty()){
            head = HEAD_DEFAULT;
            tail = TAIL_DEFAULT;
        }
        return value;
    }

    @Override
    public E removeRight() {
        if (isEmpty()) {
            System.out.println("The deque is empty");
            return null;
        }
        E value;
        if (tail == 0) {
            value = data[tail];
            tail = data.length - 1;
        } else {
            value = data[tail--];
        }
        size--;
        if (isEmpty()){
            head = HEAD_DEFAULT;
            tail = TAIL_DEFAULT;
        }
        return value;
    }

    @Override
    public boolean removeAll() {
        if (isEmpty()){
            System.out.println("The deque is empty");
            return false;
        }
        head = HEAD_DEFAULT;
        tail = TAIL_DEFAULT;
        size = 0;
        return true;
    }
}

