package org.athos.datastructure.trees;

import org.athos.datastructure.trees.general.AVLTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
//        BinaryTree<Integer> tree = new BinaryTree<>();
//        List<Integer> listToRemove = new ArrayList<>();
//
//        Random random = new Random();
//
//        for (int i = 0; i < 20; i++) {
//            int value = random.nextInt(100);
//            tree.insert(value);
//            if (i < 5){
//                listToRemove.add(value);
//            }
//        }
//
//
//        System.out.println("Antes de Remover: ");
//
//        System.out.print("in_level:  ");
//        print(tree.traverse(TreeTraversal.IN_LEVEL_ORDER));
//
//        System.out.print("pre_order: ");
//        print(tree.traverse(TreeTraversal.PRE_ORDER));
//
//        System.out.print("post_order: ");
//        print(tree.traverse(TreeTraversal.POST_ORDER));
//
//        System.out.print("in_order:  ");
//        print(tree.traverse(TreeTraversal.IN_ORDER));
//
//       // Deletando elementos da arvores:
//        for (Integer i : listToRemove) {
//            tree.delete(i);
//        }
//
//
//        System.out.println("depois da remoção:");
//
//        System.out.print("in_level:  ");
//       print(tree.traverse(TreeTraversal.IN_LEVEL_ORDER));
//
//        System.out.print("pre_order: ");
//       print(tree.traverse(TreeTraversal.PRE_ORDER));
//
//        System.out.print("por_order: ");
//       print(tree.traverse(TreeTraversal.POST_ORDER));
//
//        System.out.print("in_oder:  ");
//       print(tree.traverse(TreeTraversal.IN_ORDER));


        AVLTree<Integer> tree = new AVLTree<Integer>();


        Integer[] valuesToInsert ={4,3,9,1,5,45,11,55,7,41,22,77};
        // 22,77
        for (int i = 0; i < valuesToInsert.length; i++) {
            tree.insert(valuesToInsert[i]);
        }

        Random rand = new Random();

//        for (int i = 0; i < 100; i++) {
//            tree.insert(rand.nextInt());
//        }
        ArrayList<Integer> list = (ArrayList<Integer>) tree.traverse(TreeTraversal.PRE_ORDER);

        print(list);

        System.out.println("----------");
        tree.delete(22);
        tree.delete(77);
        tree.delete(4);
        tree.delete(45);
        tree.delete(11);


        ArrayList<Integer> list2 = (ArrayList<Integer>) tree.traverse(TreeTraversal.PRE_ORDER);
        System.out.println("-------");
        print(list2);

//
//


    }

    public static void print(List<Integer> list) {
        list.forEach((element) -> System.out.print(element+","));
        System.out.println();
    }
}