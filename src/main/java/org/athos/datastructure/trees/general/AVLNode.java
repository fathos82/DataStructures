package org.athos.datastructure.trees.general;

import org.athos.datastructure.trees.GenericNode;

public class AVLNode<T extends Comparable<T>> extends GenericNode<T, AVLNode<T>> {


    private AVLNode<T> parent;
    private int height;
    private int balanceFactor;

    public AVLNode(T element) {
        super(element);
    }

    public void setParent(AVLNode<T> parent) {
        this.parent = parent;
    }

     public void setHeight(int height) {
         this.height = height;
     }



    public AVLNode<T> getParent() {
        return parent;
    }
    public int getHeight() {
        return height;
    }
    private int getHeightOfChild(AVLNode<T> node) {
        return node != null ? node.getHeight() : 0;
    }
    private void updateHeightOfNode() {
        AVLNode<T> left =  this.getLeft();
        AVLNode<T> right =  this.getRight();
        int newHeight = Math.max(getHeightOfChild(left), getHeightOfChild(right)) + 1;
        this.setHeight(newHeight);
    }

    public void updateBalanceFactor() {
       // updateHeightOfNode();
        AVLNode<T> left =  this.getLeft();
        AVLNode<T> right =this.getRight();
        int leftHeight = getHeightOfChild(left);
        int rightHeight = getHeightOfChild(right);
        balanceFactor = leftHeight - rightHeight;
    }

    public int getBalanceFactor() {
        return balanceFactor;
    }

}
