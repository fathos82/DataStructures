package org.athos.datastructure.hashtable;

public interface Map<K, E> {
    int size();
    boolean containsKey(K key);
    boolean containsElement();
    boolean isEmpty();
    void put(K key, E element);
    void remove(K key);

    void putAll(Map<? extends K,? extends E> m);
    E get(K key);



}
