package com.AVLtree;

public class Main {
    //I think they are not strictly self balancing.
    public static void main(String[] args) {
            var avlTree = new AVLtree();
            avlTree.insert(10);
            avlTree.insert(20);
            avlTree.insert(30);
            avlTree.insert(15);
            avlTree.insert(55);
            avlTree.insert(45);
            avlTree.insert(50);
            avlTree.insert(5);
            avlTree.insert(4);
            avlTree.insert(7);
            avlTree.insert(2);
        System.out.println("done");
    }
}
