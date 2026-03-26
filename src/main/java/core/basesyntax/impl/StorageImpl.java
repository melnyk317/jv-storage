package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private K key;
    private V value;

    public StorageImpl(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public StorageImpl() {
    }

    StorageImpl[] storage = new StorageImpl[10];
    int count = 0;

    @Override
    public void put(K key, V value) {
        for (StorageImpl st : storage) {
            if (st.key.equals(key)) {
                st.value = value;
                return;
            }
        }
        storage[count] = new StorageImpl<K, V>(key, value);
        count++;
    }

    @Override
    public V get(K key) {
        for (StorageImpl st : storage) {
            if (st.key.equals(key)) {
                return (V) st.value;
            }
        }
        return null;
    }

    @Override
    public int size() {
        return count;
    }
}
