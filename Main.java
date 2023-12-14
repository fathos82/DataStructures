package org.athos.datastructure;

import org.athos.datastructure.trees.general.AVLTree;

import java.util.List;

import static org.athos.datastructure.trees.TreeTraversal.IN_ORDER;

public class Main {
    public static void main(String[] args) {
        AVLTree<Student> tree = new AVLTree<>();
        for (int i = 0; i < 31; i++) {
            tree.insert(Student.createRandomStudent());
        }

        System.out.println("Antes de Remover: ");
        List<Student> list = tree.traverse(IN_ORDER);
        for (Student student : list) {
            System.out.println(student);
        }

        for (int i = 0; i < 10; i++) {
            tree.delete(list.get(i));

        }


        System.out.println("\n\nDepois de Remover: ");
        list = tree.traverse(IN_ORDER);
        for (Student student : list) {
            System.out.println(student);
        }


    }

    public static class Student implements Comparable<Student> {
        int ID;
        private String name;
        private int age;
        private String course;


        public Student(String name, int age, String course) {
            ID = this.hashCode();
            this.name = name;
            this.age = age;
            this.course = course;
        }

        public static Student createRandomStudent() {
            String[] names = {"João", "Maria", "José", "Ana", "Pedro", "Paulo", "Carlos", "Cristina", "Mariana", "Mário, José", "Antônio", "Francisco", "Luiz", "Luiza", "Fernanda", "Fernando", "Rafael", "Rafaela", "Rafaelo", "Rafaeli", "Rafaelu","Mario",
                    "Joana", "Miriam", "Mariana", "Mariano", "Mariane", "Marianu", "Mariani", "Bernardo","Bernarda", "Bernardu", "Bernardi", "Bernarda", "Bernardina", "Bernardi"};
                    String[] courses = {"Ciência da Computação", "Engenharia da Computação", "Sistemas de Informação", "Engenharia de Software", "Matemática", "Física", "Química", "Biologia", "Geografia", "História"};
            return new Student(names[(int) (Math.random() * names.length)], (int) (Math.random() * 100), courses[(int) (Math.random() * courses.length)]);
        }


        @Override
        public int compareTo(Student o) {
           // return this.ID - o.ID;
        //   return this.name.compareTo(o.name);
        return this.age - o.age;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "ID=" + ID +
                    ", name='" + name + '\'' +
                    ", age=" + age +
                    ", course='" + course + '\'' +
                    '}';
        }
    }
}
