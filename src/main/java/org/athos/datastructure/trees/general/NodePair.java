package org.athos.datastructure.trees.general;


import org.athos.datastructure.trees.GenericNode;

public record NodePair<T extends Comparable<T>, Node extends GenericNode<T, Node>>(Node parent, Node child) {

}
