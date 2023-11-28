package org.athos.datastructure.trees;

import java.util.*;

public final class TreeTraversal {

    public final static int IN_ORDER = 1;
    public final static int PRE_ORDER = 2;
    public final static int POST_ORDER = 3;
    public final static int IN_LEVEL_ORDER = 4;

    public static  <T, N extends GenericNode<T, N>> List<T>  inOrderTraversal(N root) {
        if (root == null) {
            return new ArrayList<>();
        }
        N current = root;
        Stack<N> stack = new Stack<>();
        List<T> elements = new ArrayList<>();
        while (current != null || !stack.empty()) {
            while (current != null) {
                stack.push(current);
                current = current.getLeft();
            }
            current = stack.pop();
            elements.add(current.getElement());
            current = current.getRight();
        }

        return elements;
    }
    public static <T, N extends GenericNode<T, N>> List<T> preOrderTraversal(N root) {
        if (root == null) {
            return new ArrayList<>();
        }
        N current;
        Stack<N> stack = new Stack<>();
        List<T> elements = new ArrayList<>();

        stack.push(root);

        while (!stack.empty()) {
            current = stack.pop();
            elements.add(current.getElement());
            if (current.getRight() != null) {
                stack.push(current.getRight());
            }
            if (current.getLeft() != null) {
                stack.push(current.getLeft());
            }
        }

        return elements;
    }

    public static <T, N extends GenericNode<T, N>> List<T> postOrderTraversal(N root) {
        if (root == null) {
            return new ArrayList<>();
        }

        Stack<N> stack = new Stack<>();
        stack.push(root);

        List<T> elements = new ArrayList<>();

        while (!stack.isEmpty()) {
            N current = stack.pop();
            elements.add(0, current.getElement()); // Adiciona no início da lista para inverter a ordem

            if (current.getLeft() != null) {
                stack.push(current.getLeft());
            }
            if (current.getRight() != null) {
                stack.push(current.getRight());
            }
        }

        return elements;
    }

    public static <T, N extends GenericNode<T, N>> List<T> levelOrderTraversal(N root) {
        if (root == null) {
            return new ArrayList<>();
        }
        Queue<N> queue = new LinkedList<>();
        queue.add(root);
        N current;
        List<T> elements = new ArrayList<>();

        while (!queue.isEmpty()){
            current = queue.poll();
            elements.add(current.getElement());
            if (current.getLeft() != null) {
                queue.add(current.getLeft());
            }
            if (current.getRight() != null) {
                queue.add(current.getRight());
            }
        }
        return elements;
    }
}
