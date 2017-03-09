package com.example.garima.myapplication;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Garima on 3/7/17.
 */
class  Node{
    int val;
    Node left;
    Node right;
    public Node(int val){
        this.val = val;
    }
}
public class BSTtoLL {
    static Node root;
    static Node head;
    static Node tail;

    public static int[] convertBSTtoLL(){

        Node root = new Node(4);
        root.left = new Node(2);
        root.right = new Node(6);
        root.left.left = new Node(1);
        root.left.right = new Node(3);
        root.right.left = new Node(5);
        root.right.right = new Node(7);
        inOrder(root);
        int[] out = new int[7];
        int i =0;
        Node curr = head;
        while(i<7){
            out[i] = curr.val;
            curr = curr.right;
            i++;
        }
        return out;

    }



    public static void inOrder(Node root){
        if(root == null)
            return ;
        inOrder(root.left);

        root.left = tail;
        if(tail == null)
            head = root;
        else
            tail.right = root;

        Node right = root.right;
        root.right = head;
        head.left = root;

        tail = root;
        inOrder(right);

    }

//    public static void main(String[] args){
//        Node root = new Node(4);
//        root.left = new Node(2);
//        root.right = new Node(6);
//        root.left.left = new Node(1);
//        root.left.right = new Node(3);
//        root.right.left = new Node(5);
//        root.right.right = new Node(7);
//        BSTtoLL b = new BSTtoLL();
//        b.convertBSTtoLL(root);
//        Node curr = b.head;
//        while(curr != b.tail){
//            System.out.print(curr.val+"-->");
//            curr = curr.right;
//        }
//        System.out.println(curr.val);
//    }
}

