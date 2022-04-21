package com.AVLtree;

public class AVLtree {
    private class AVLNODE{
        private int value;
        private int height;
        private AVLNODE leftChild;
        private AVLNODE rightChild;
        public AVLNODE(int value){
             this.value = value;
        }
        @Override
        public String toString(){
            return "Value=" + this.value;
        }
    }

    private AVLNODE root;

    public void insert(int value){
        root = insert(root,value);
    }
    private AVLNODE insert(AVLNODE root,int value){
        if(root == null)
            return root = new AVLNODE(value);

        if(value < root.value)
            root.leftChild = insert(root.leftChild,value);
        else
            root.rightChild = insert(root.rightChild,value);

        //this root.height gets updated when recursion moves upwards.
        setHeight(root);

        return balance(root);
    }
    private AVLNODE balance(AVLNODE root){
        if(isLeftHeavy(root)) {
            if (balanceFactor(root.leftChild) < 0)
                root.leftChild =  rotateLeft(root.leftChild);
            return rotateRight(root);
        }
        else if(isRightHeavy(root)) {
            if (balanceFactor(root.rightChild) > 0)
                root.rightChild = rotateRight(root.rightChild);
            return rotateLeft(root);
        }
        return root;
    }
    private AVLNODE rotateRight(AVLNODE root){
        var newRoot = root.leftChild;
        root.leftChild = newRoot.rightChild;
        newRoot.rightChild = root;
        setHeight(newRoot);
        setHeight(root);
        return newRoot;
    }
    private AVLNODE rotateLeft(AVLNODE root){
        var newRoot = root.rightChild;
        root.rightChild = newRoot.leftChild;
        newRoot.leftChild = root;
        setHeight(newRoot);
        setHeight(root);
        return newRoot;
    }
    private boolean isLeftHeavy(AVLNODE node){
        return balanceFactor(node) > 1;
    }
    private boolean isRightHeavy(AVLNODE node){
        return balanceFactor(node) < -1;
    }
    private  int balanceFactor(AVLNODE node){
        return (node == null) ? 0 : height(node.leftChild) - height(node.rightChild);
    }
     private int height(AVLNODE node){
        return (node == null) ? -1 : node.height;
    }
    private void setHeight(AVLNODE node){
        node.height = Math.max(height(node.leftChild) , height(node.rightChild)) + 1;
    }
}
