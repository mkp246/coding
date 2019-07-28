package org.gfg.array;

/**
 * a node in binary tree
 */
public class Node {
    public int data;
    public Node left;
    public Node right;

    public Node(int data, Node left, Node right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    public Node(int data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Node{" + "data=" + data + ", left=" + left.data + ", right=" + right.data + '}';
    }
}
