package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ARRAY_SIZE = 10; 

    private K key;
    private V value;
    
    private Object[] keys = new Object[MAX_ARRAY_SIZE];
    private Object[] values = new Object[MAX_ARRAY_SIZE];
    int count = 0;

    public StorageImpl(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public StorageImpl() {
    }

    private int findIndexOfKey(K key) {
        for (int i = 0; i < count; i++) {
            if (keys[i].equals(key)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void put(K key, V value) {
        int index = findIndexOfKey(key);
        if (index != -1) {
            values[index] = value;
        } else {
            keys[count] = key;
            values[count] = value;
            count++;
        }
    }

    @Override
    public V get(K key) {
        int index = findIndexOfKey(key);
        if (index != -1) {
            return (V) values[index];
        }
        return null;
    }

    @Override
    public int size() {
        return count;
    }
}
