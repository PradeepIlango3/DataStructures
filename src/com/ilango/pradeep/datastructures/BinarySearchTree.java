package com.ilango.pradeep.datastructures;

import javafx.scene.control.cell.ProgressBarTreeTableCell;

import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree<E extends Comparable<E>> {
    Node<E> root;

    class Node<E> {
        E data;
        Node<E> left;
        Node<E> right;

        Node(E data) {
            this.data = data;
        }
    }

    public void insert(E data) {
        root = insertNode(root, data);
    }

    private Node<E> insertNode(Node<E> root, E data) {
        if (root == null) {
            root = new Node<E>(data);
        } else if (data.compareTo(root.data) <= 0) {
            root.left = insertNode(root.left, data);
        } else {
            root.right = insertNode(root.right, data);
        }
        return root;
    }

    public void printInorder() {
        if (root == null) {
            System.out.println("Tree is Empty");
            return;
        }
        printIn(root);
    }

    private void printIn(Node<E> root) {
        if (root == null) {
            return;
        }
        printIn(root.left);
        System.out.println(root.data);
        printIn(root.right);
    }

    public E findMin() {
        if (root == null) {
            throw new IndexOutOfBoundsException("Tree is Empty");
        }
        Node<E> node = root;
        while (node.left != null) {
            node = node.left;
        }
        return node.data;
    }

    public E findMax() {
        if (root == null) {
            throw new IndexOutOfBoundsException("Tree is Empty");
        }
        Node<E> node = root;
        while (node.right != null) {
            node = node.right;
        }
        return node.data;
    }

    public E findMinRecur() {
        return findMinRecursive(root);
    }

    private E findMinRecursive(Node<E> root) {
        if (root == null) {
            throw new IndexOutOfBoundsException("Tree is Empty");
        }
        if (root.left != null) {
            return findMinRecursive(root.left);
        }
        return root.data;
    }

    public int height() {
        return height(root);
    }

    private int height(Node<E> root) {
        if (root == null) {
            return -1;
        }
        return 1 + Math.max(height(root.left), height(root.right));
    }

    public void levelOrderTraversal() {
        if (root == null) {
            System.out.println("Tree is Empty");
        }

        System.out.println("Level Order Traversal");
        Queue<Node<E>> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node<E> node = queue.peek();
            System.out.println(node.data);
            if (node.left  != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
            queue.remove();
        }
    }

    public void preorderTraversal() {
        if (root == null) {
            System.out.println("Tree is Empty");
        }
        System.out.println("Preorder Traversal: ");
        preorderTraversal(root);
    }

    private void preorderTraversal(Node<E> root) {
        if (root != null) {
            System.out.println(root.data);
            preorderTraversal(root.left);
            preorderTraversal(root.right);
        }
    }

    public void postorderTraversal() {
        if (root == null) {
            System.out.println("Tree is Empty");
        }
        System.out.println("Postorder Traversal: ");
        postorderTraversal(root);
    }

    private void postorderTraversal(Node<E> root) {
        if (root != null) {
            postorderTraversal(root.left);
            postorderTraversal(root.right);
            System.out.println(root.data);
        }
    }

    public void inorderTraversal() {
        if (root == null) {
            System.out.println("Tree is Empty");
        }
        System.out.println("Inorder Traversal: ");
        inorderTraversal(root);
    }

    private void inorderTraversal(Node<E> root) {
        if (root != null) {
            preorderTraversal(root.left);
            System.out.println(root.data);
            preorderTraversal(root.right);
        }
    }

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        System.out.println("Height:" + tree.height());
        tree.printInorder();
        tree.insert(5);
        tree.insert(10);
        tree.insert(15);
        System.out.println("Height:" + tree.height());
        tree.printInorder();
        System.out.println("Min: " + tree.findMin());
        System.out.println("Max: " + tree.findMax());
        System.out.println("Min Recursive: " + tree.findMinRecur());
        tree.insert(1);
        tree.insert(2);
        tree.insert(3);
        tree.insert(4);
        tree.insert(5);
        tree.insert(50);
        System.out.println("Height:" + tree.height());
        tree.printInorder();
        System.out.println("Min: " + tree.findMin());
        System.out.println("Min Recursive: " + tree.findMinRecur());
        System.out.println("Max: " + tree.findMax());
        tree.levelOrderTraversal();
        tree.preorderTraversal();
        tree.postorderTraversal();
        tree.inorderTraversal();
    }
}
