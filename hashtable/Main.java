package org.athos.datastructure.hashtable;

public class Main {
    public static void main(String[] args) {
        HashTable<Integer, Integer> table = new HashTable<>();
        table.put(1,2);
        table.put(2,3);
        table.put(3,4);
        table.put(4,5);
        table.put(5,6);
        table.put(6,7);
        table.put(7,8);
        table.put(8,9);
        table.put(8,10);
        table.put(9,0);
        table.put(11,2);
        table.put(12,3);
        table.put(13,4);
        table.put(14,5);
        table.put(15,6);
        table.put(16,7);
        table.put(17,8);
        table.put(18,9);
        table.put(19,10);
        table.put(20,0);

        System.out.println(table.get(1));
        System.out.println(table.get(2));
        System.out.println(table.get(3));
        System.out.println(table.get(4));
        System.out.println(table.get(5));
        System.out.println(table.get(6));
        System.out.println(table.get(7));
        System.out.println(table.get(8));
        System.out.println(table.get(9));
        System.out.println(table.get(10));

        System.out.println(table.get(11));
        System.out.println(table.get(12));
        System.out.println(table.get(13));
        System.out.println(table.get(14));
        System.out.println(table.get(15));
        System.out.println(table.get(16));
        System.out.println(table.get(17));
        System.out.println(table.get(18));
        System.out.println(table.get(19));
        System.out.println(table.get(20));


    }
}
