package org.athos.datastructure.trees;

import java.util.List;

public abstract class GenericTree<T extends Comparable<T>, Node extends GenericNode<T, Node>> {
    protected Node root;



    public abstract void insert(T element);
    protected abstract void insertNode(Node node, T element);

    public abstract void delete(T element);

    public abstract boolean contains(T element);

    protected abstract Node find(T elment);


    public List<T> traverse(int order) {
        return switch (order) {
            case TreeTraversal.PRE_ORDER -> TreeTraversal.preOrderTraversal(root);
            case TreeTraversal.POST_ORDER -> TreeTraversal.postOrderTraversal(root);
            case TreeTraversal.IN_LEVEL_ORDER -> TreeTraversal.levelOrderTraversal(root);
            default -> TreeTraversal.inOrderTraversal(root);
        };

    }

    protected Node deleteAndReturnNode(T element) {
       if (root == null) {
           return null;
       } else {
           return deleteNode(root, element);
       }
    }
    private Node deleteNode(Node current, T value) {

        Node parent = current;

        while (current != null && value.compareTo(current.getElement()) != 0) {
            parent = current;

            if (value.compareTo(current.getElement()) < 0) {
                current = current.getLeft();
            } else if (value.compareTo(current.getElement()) > 0) {
                current = current.getRight();
            }
        }

        if (current == null) {
            return null;
        }

        int countChildren = 0;

        if (current.getLeft() != null) {
            countChildren++;
        }
        if (current.getRight() != null) {
            countChildren++;
        }

        switch (countChildren) {
            case 0:
                removeWithoutChildren(parent, current);
                break;
            case 1:
                removeWithOneChildren(parent, current);
                break;
            case 2:
                removeWithTwoChildren(current);
                break;
        }
        return current;
    }





    private Node findSuccessor(Node node) {

        Node successor = node.getRight();
        while (successor.getLeft() != null) {
            successor = successor.getLeft();
        }
        return successor;
    }

    protected void removeWithoutChildren(Node parent, Node child) {

        if (child == root) {
            root = null;
        } else {
            if (parent.getLeft() == child) {
                parent.setLeft(null);
            } else {
                parent.setRight(null);
            }
        }
    }

    protected void removeWithOneChildren(Node parent, Node child) {
        Node newChild = (child.getLeft() != null ? child.getLeft() : child.getRight());

        if (parent.getLeft() == child) {
            parent.setLeft(newChild);
        } else {
            parent.setRight(newChild);
        }

    }

    protected void removeWithTwoChildren(Node current) {
        Node successor = findSuccessor(current);
        current.setElement(successor.getElement());
        deleteNode(current.getRight(), successor.getElement());
    }
}
