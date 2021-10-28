package ru.azor.lesson8;

import java.util.ArrayList;
import java.util.List;

public class CloseAddressHashTable<K, V> implements HashTable<K, V> {
    static class Item<K, V> implements Entry<K, V> {
        private final K key;
        private V value;

        public Item(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }

        @Override
        public void setValue(V value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Item{" + "key=" + key + ", value=" + value + '}';
        }

    }

    private final Item<K, V>[] data;
    private final List<Item<K, V>>[] lists;
    private int size;

    public CloseAddressHashTable(int initialCapacity) {
        this.data = new Item[initialCapacity * 2];
        this.lists = new List[initialCapacity * 2];
    }

    public CloseAddressHashTable() {
        this(16);
    }

    @Override
    public boolean put(K key, V value) {
        if (size() == data.length) {
            return false;
        }
        int index = hashFunc(key);
        if (data[index] != null && lists[index] != null) {
            lists[index].add(new Item<>(key, value));
            size++;
        }else if (data[index] != null && lists[index] == null){
            List<Item<K, V>> items = new ArrayList<>();
            items.add(data[index]);
            items.add(new Item<>(key, value));
            lists[index] = items;
            size++;
        }else {
            data[index] = new Item<>(key, value);
            size++;
        }
        return true;
    }

    private int hashFunc(K key) {
        return Math.abs(key.hashCode()) % data.length;
    }

    @Override
    public V get(K key) {
        if (size() == 0) {
            return null;
        }
        int index = hashFunc(key);
        if (data[index] != null && lists[index] != null){
            for (int i = 0; i < lists[index].size(); i ++) {
                if (lists[index].get(i).getKey().equals(key)){
                    return lists[index].get(i).getValue();
                }
            }
        }else  if (data[index] != null && lists[index] == null){
            if (data[index].getKey().equals(key))
            return data[index].getValue();
        }
        return null;
    }

    @Override
    public V remove(K key) {
        if (size() == 0) {
            return null;
        }
        V temp;
        int index = hashFunc(key);
        if (data[index] != null && lists[index] != null){
            for (int i = 0; i < lists[index].size(); i ++) {
                if (lists[index].get(i).getKey().equals(key)){
                    temp = lists[index].get(i).getValue();
                    lists[index].remove(i);
                    if (data[index].getKey().equals(key)){
                        data[index].setValue(null);
                        data[index] = lists[index].get(0);
                    }
                    if (lists[index].size() == 1){
                        lists[index] = null;
                    }
                    size--;
                    return temp;
                }
            }
        }else  if (data[index] != null && lists[index] == null){
            temp = data[index].getValue();
            data[index].setValue(null);
            size--;
            return temp;
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size != 0;
    }

    @Override
    public void display() {
        System.out.println("--------------------------");
        for (int i = 0; i < data.length; i++) {
            if (lists[i] == null){
                System.out.printf("%d = [%s]%n", i, data[i]);
            }else {
                System.out.printf("%d = [%s]%n", i, lists[i]);
            }
        }
        System.out.println("--------------------------");
    }
}
