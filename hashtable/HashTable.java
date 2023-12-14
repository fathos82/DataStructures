package org.athos.datastructure.hashtable;

public class HashTable<K, E> implements Map<K, E> {
    float loadFactor;
    int threshold;
    private Node<K, E>[] table;
    private int size;

    @SuppressWarnings("unchecked")
    public HashTable(int initialCapacity, float loadFactor) {
        if (initialCapacity <= 0) {
            throw new IllegalArgumentException("Error: the initial capacity can't be smaller or equals 0");
        }
        if (loadFactor < 0) {
            throw new IllegalArgumentException("Error: the load factor can't be smaller 0");
        }
        this.loadFactor = loadFactor;
        this.threshold = (int) (initialCapacity * loadFactor);
        this.table = (Node<K, E>[]) new Node[initialCapacity];
    }

    public HashTable(int initialCapacity) {
        this(initialCapacity  , 0.75f);

    }

    public HashTable() {
        this(11, 0.75f);
    }

    public HashTable(Map<K, E> map) {
        this(map.size(), 0.75f);
    }

    @Override
    public void put(K key, E element) {
        int hash = key.hashCode();
        int index = hash % table.length;
        Node<K, E> current = table[index];
        while (current != null) {
            if (current.key.equals(key) && current.hash == hash) {
                current.element = element;
                return;
            }
            current = current.next;
        }
        addNode(hash, key, element, index);
    }

    private void addNode(int hash, K key, E element, int index) {
        Node<K, E>[] tab = this.table;
        if (size >= threshold) {
            reshape();
            tab = this.table;
            index = hash % tab.length;
        }
        Node<K, E> oldNode = tab[index];
        tab[index] = new Node<>(hash, key, element, oldNode); // caso seja nulo, apenas aponta para nul, senão, para o node anterior
        size++;
    }

    @SuppressWarnings("unchecked")
    private void reshape() {
        Node<K, E>[] oldTable = table;
        int newCapacity = (oldTable.length << 1) +1 ;
        Node<K, E>[] newTable = (Node<K, E>[]) new Node[newCapacity];
        table = newTable;
        for (int i = 0; i < oldTable.length; i++) {
            Node<K, E> currentNode = oldTable[i];
            while (currentNode != null) {
                Node<K, E> currentNodeCopy = currentNode;
                // Caso colida ja esta pegando o proximo:
                currentNode = currentNode.next;
                int newIndex = currentNodeCopy.hash % newCapacity;
                currentNodeCopy.next = newTable[newIndex];
                newTable[newIndex] = currentNodeCopy;
            }
        }
        threshold += (int) (threshold * loadFactor);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean containsKey(K key) {
        return false;
    }


    @Override
    public boolean containsElement() {
        return false;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void remove(K key) {
        Node<K, E>[] tab = table;
        int hash = key.hashCode();
        int index = hash % tab.length;
        Node<K, E> currentNode = tab[index];
        Node<K, E> lastNode = currentNode;
        while (currentNode != null) {
            if (currentNode.hash == hash && currentNode.key.equals(key)) {
                if (currentNode == lastNode) {
                    tab[index] = currentNode.next;
                } else {
                    lastNode.next = currentNode.next;
                }
                size--;
                return;
            }
            lastNode = currentNode;
            currentNode = currentNode.next;
        }
    }

    @Override
    public void putAll(Map<? extends K, ? extends E> m) {

    }

    @Override
    public E get(K key) {
        if (key == null) {
            throw new IllegalArgumentException("the key can't be null");
        }
        Node<K, E>[] tab = table;
        int hash = key.hashCode();
        int index = hash % tab.length;
        Node<K, E> currentNode = tab[index];
        while (currentNode != null) {
            if ( currentNode.hash == hash && currentNode.key.equals(key)) {
                return currentNode.element;
            }
            currentNode = currentNode.next;
        }
        return  null;
    }

    private static class Node<K, E> {
        final int hash;
        final K key;
        E element;

        Node<K, E> next;

        protected Node(int hash, K key, E element, Node<K, E> next) {
            this.hash = hash;
            this.key = key;
            this.element = element;
            this.next = next;
        }
    }

}
