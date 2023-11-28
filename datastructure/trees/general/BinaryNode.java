package org.athos.datastructure.trees.general;

import org.athos.datastructure.trees.GenericNode;

public class BinaryNode<T> extends GenericNode<T, BinaryNode<T>> {

    public BinaryNode(T value) {
        super(value);
    }
}
