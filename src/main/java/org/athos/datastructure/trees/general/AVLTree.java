package org.athos.datastructure.trees.general;

import org.athos.datastructure.trees.GenericTree;

public class AVLTree<T extends Comparable<T>> extends GenericTree<T, AVLNode<T>> {


    @Override
    public void insert(T element) {
        if (root == null) {
            root = new AVLNode<>(element);
        } else {
            insertNode(root, element);
        }
    }
    @Override
    protected void insertNode(AVLNode<T> current, T element) {
        AVLNode<T> node = new AVLNode<>(element);
        AVLNode<T> parent = null;

        while (current != null) {

            parent = current;
            int comparisonResult = element.compareTo(current.getElement());

            if (comparisonResult < 0) {
                current = current.getLeft();
                if (current == null) {
                    parent.setLeft(node);
                }
            } else if (comparisonResult > 0) {
                current = current.getRight();
                if (current == null) {
                    parent.setRight(node);
                }
            } else {
                break;
            }
        }
        node.setParent(parent);

        rebalanceTree(node);
    }

    @Override
    public void delete(T element) {
        AVLNode<T> node = deleteAndReturnNode(element);
        rebalanceTree(node);
    }




    @Override
    public boolean contains(T element) {
        return false;
    }

    @Override
    protected AVLNode<T> find(T elment) {
        return null;
    }



    private void rebalanceTree(AVLNode<T> current) {
        while (current != null) {
            current.updateBalanceFactor();
            if (Math.abs(current.getBalanceFactor()) > 1) {
                current = performRotation(current);
            }
            current = current.getParent();
        }
    }

    private AVLNode<T> performRotation(AVLNode<T> currentNode) {
        int balanceFactor = currentNode.getBalanceFactor();
        int balanceFactorChild;
        AVLNode<T> returnNode;

        if (balanceFactor > 1) {
            balanceFactorChild = (currentNode.getLeft()).getBalanceFactor();

            if (balanceFactorChild < 0) {
                returnNode = doubleRotationInRight(currentNode);
            } else {
                returnNode = singleRotationInRight(currentNode);

            }
        } else {
            balanceFactorChild = (currentNode.getRight()).getBalanceFactor();
            if (balanceFactorChild > 0) {

                returnNode = doubleRotationInLeft(currentNode);
            } else {
                returnNode = singleRotationInLeft(currentNode);
            }
        }
        return returnNode;
    }

    private AVLNode<T> singleRotationInLeft(AVLNode<T> currentNode) {
        AVLNode<T> pivot = currentNode.getRight();
        // update parent of pivot
        updateParentReference(pivot);

        // perform rotation
        currentNode.setRight(pivot.getLeft());
        (currentNode.getRight()).setParent(currentNode);
        pivot.setLeft(currentNode);
        currentNode.setParent(pivot);


        // update balance factor
        currentNode.updateBalanceFactor();
        pivot.updateBalanceFactor();
        return pivot;
    }

    private AVLNode<T> singleRotationInRight(AVLNode<T> root) {
        AVLNode<T> pivot = root.getLeft();

        // update parent of pivot
        updateParentReference(pivot);

        // perform rotation
        root.setLeft(pivot.getRight());
        (root.getLeft()).setParent(root);
        pivot.setRight(root);
        root.setParent(pivot);

        // update balance factor
        root.updateBalanceFactor();
        pivot.updateBalanceFactor();
        return pivot;
    }

    private AVLNode<T> doubleRotationInRight(AVLNode<T> currentNode) {
        currentNode.setLeft(singleRotationInLeft(currentNode.getLeft()));
        return singleRotationInRight(currentNode);
    }

    private AVLNode<T> doubleRotationInLeft(AVLNode<T> currentNode) {
        currentNode.setRight(singleRotationInRight(currentNode.getRight()));
        return singleRotationInLeft(currentNode);
    }

    private void updateParentReference(AVLNode<T> node) {
        AVLNode<T> granFather = node.getParent().getParent();
        if (granFather == null) {
            this.root = node;
        } else if (granFather.getLeft() == node.getParent()) {
            granFather.setLeft(node);
        } else {
            granFather.setRight(node);
        }
    }
}
