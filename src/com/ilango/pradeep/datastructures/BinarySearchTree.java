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
            return;
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

    public boolean isBst(E min, E max) {
        return isBst(root, min, max);
    }

    private boolean isBst(Node<E> root, E min, E max) {
        if (root == null) return true;
        if (root.data.compareTo(min) <= 0) {
            return false;
        }
        if (root.data.compareTo(max) > 0) {
            return false;
        }
        if (!isBst(root.left, min, root.data)) {
            return false;
        }
        if ( !isBst(root.right, root.data, max)) {
            return false;
        }
        return true;
    }

    public void delete(E data) {
         root = delete(root, data);
    }

    private Node<E> delete(Node<E> root, E data) {
        if (root == null) {
            return null;
        }
        if (data.compareTo(root.data) < 0){
            root.left = delete(root.left, data);
        } else if (data.compareTo(root.data) >0) {
            root.right = delete(root.right, data);
        } else {
            if (root.left == null) {
                root = root.right;
            } else if (root.right == null) {
                root = root.left;
            } else {
                Node<E> node = findMax(root.left);
                root.data = node.data;
                root.left = delete(root.left, root.data);
            }
        }
        return root;
    }

    private Node<E> findMax(Node<E> root) {
        while (root.right != null) {
            root = root.right;
        }
        return root;
    }

    public E getSuccessor(E data) {
        Node<E> ancestor = root;
        Node<E> successor = null;
        while (ancestor != null) {
            if (data.compareTo(ancestor.data) < 0) {
                successor = ancestor;
                ancestor = ancestor.left;
            } else if (data.compareTo(ancestor.data) > 0) {
                ancestor = ancestor.right;
            } else {
                if (ancestor.right == null) {
                    if (successor != null) {
                        return successor.data;
                    }
                    return (E) new Integer(-1);
                } else {
                    ancestor = ancestor.right;
                    while (ancestor.left != null) {
                        ancestor = ancestor.left;
                    }
                    return  ancestor.data;
                }
            }
        }
        if (successor != null) {
            return successor.data;
        }
        return (E) new Integer(-1);
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
        System.out.println("BST Tree: " + tree.isBst(Integer.MIN_VALUE, Integer.MAX_VALUE));
        tree.delete(5);
        tree.inorderTraversal();
        System.out.println("Successor: " + tree.getSuccessor(5));
        System.out.println("Successor: " + tree.getSuccessor(50));
        System.out.println("Successor: " + tree.getSuccessor(55));
        System.out.println("Successor: " + tree.getSuccessor(2));
        System.out.println("Successor: " + tree.getSuccessor(3));
    }
}
