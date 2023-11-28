package org.athos.datastructure.trees.general;

import org.athos.datastructure.trees.GenericTree;


public class BinaryTree<T extends Comparable<T>> extends GenericTree<T, BinaryNode<T>> {


    @Override
    public boolean contains(T element) {
        BinaryNode<T> current = root;
        while (current != null) {
            if (element.compareTo(current.getElement()) < 0) {
                current = current.getLeft();
            } else if (element.compareTo(current.getElement()) > 0) {
                current = current.getRight();
            } else {
                return true;
            }
        }
        return false;
    }

    @Override
    protected BinaryNode<T> find(T elment) {
        return null;
    }

    @Override
    public void insert(T element) {
        if (root == null) {
            root = new BinaryNode<>(element);
        } else {
            insertNode(root, element);
        }
    }

    @Override
    protected void insertNode(BinaryNode<T> node, T element) {
        BinaryNode<T> parent;

        while (node != null) {
            parent = node;
            int comparisonResult = element.compareTo(node.getElement());

            if (comparisonResult < 0) {
                node = node.getLeft();
                if (node == null) {
                    parent.setLeft(new BinaryNode<>(element));
                }
            } else if (comparisonResult > 0) {
                node = node.getRight();
                if (node == null) {
                    parent.setRight(new BinaryNode<>(element));
                }
            } else {
                break;
            }
        }

    }

    @Override
    public void delete(T element) {
        deleteAndReturnNode(element);
    }
}

