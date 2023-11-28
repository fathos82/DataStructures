package org.athos.datastructure.trees;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public abstract class TreeBalancer {

    public static <T extends Comparable<T>, Node extends GenericNode<T, Node>, Tree extends GenericTree<T, Node>> Tree balanceTree(Tree unbalancedTree) {
        try {
            List<T> orderElements = unbalancedTree.traverse(TreeTraversal.IN_ORDER);
            List<T> balancedElements = new ArrayList<>();

            @SuppressWarnings("unchecked") Tree balancedTree = (Tree) unbalancedTree.getClass().getDeclaredConstructor().newInstance();

            while (!orderElements.isEmpty()) {
                T firstElement = orderElements.removeFirst();

                if (!orderElements.isEmpty()) {
                    T nextElement = orderElements.removeFirst();
                    balancedElements.add(nextElement);
                }

                balancedElements.add(firstElement);
            }

            while (!balancedElements.isEmpty()) {
                balancedTree.insertNode(balancedElements.removeFirst());
            }

            return balancedTree;
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException |
                 NoSuchMethodException e) {
            e.printStackTrace();
            return null;
        }
    }
}