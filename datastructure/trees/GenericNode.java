package org.athos.datastructure.trees;

public abstract class GenericNode<T, N extends GenericNode<T, N>> {
    protected T element;
    protected GenericNode<T, N> left;
    protected GenericNode<T, N> right;

    public GenericNode(T value){
        this.element = value;
    }

    public void setRight(GenericNode<T, N> node) {
        right = node;
    }

    public void setLeft(GenericNode<T, N> node) {
        left = node;
    }

    public void setElement(T element) {
        this.element = element;
    }

    @SuppressWarnings("unchecked")

    public N getRight() {
        return  (N) right;
    }


    @SuppressWarnings("unchecked")
    public N getLeft() {
        return  (N) left;
    }

    public T getElement() {
        return element;
    }

}
