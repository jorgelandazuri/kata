package com.jalch.kata.algorithm.datastructures;

import java.util.*;

public class IntegerUnbalancedBinarySearchTree {

    Node root = null;

    public void insert(int data) {
        if (root == null) root = new Node(data);
        else root.link(data);
    }

    public boolean contains(int data) {
        return root.hasChildWith(data);
    }

    public Node findFirstWith(int data) {
        return root.getChildWith(data);
    }

    public long size() {
        return getInOrder(this.root).size();
    }

    public List<Integer> getInOrder(Node root) {
        List<Integer> nodeList = new ArrayList<>();

        if (root == null) return nodeList;

        if (root.left != null) nodeList.addAll(getInOrder(root.left));

        nodeList.add(root.value);

        if (root.right != null) nodeList.addAll(getInOrder(root.right));

        return nodeList;
    }

    public List<Integer> getPreOrder(Node root) {
        List<Integer> nodeList = new ArrayList<>();

        nodeList.add(root.value);

        if (root.left != null) nodeList.addAll(getPreOrder(root.left));

        if (root.right != null) nodeList.addAll(getPreOrder(root.right));

        return nodeList;
    }

    public List<Integer> getPostOrder(Node root) {
        List<Integer> nodeList = new ArrayList<>();

        if (root.left != null) nodeList.addAll(getPostOrder(root.left));

        if (root.right != null) nodeList.addAll(getPostOrder(root.right));

        nodeList.add(root.value);

        return nodeList;
    }

    public List<Integer> getBreadthFirstTraversalOrder() {
        Queue<Node> currentLevelToPrint = new LinkedList<>();
        Queue<Node> nextLevel = new LinkedList<>();
        currentLevelToPrint.add(root);
        List<Integer> result = new ArrayList<>();

        while (!currentLevelToPrint.isEmpty()) {
            Node currentNode = currentLevelToPrint.poll();
            result.add(currentNode.value);
            if (currentNode.left != null) nextLevel.add(currentNode.left);
            if (currentNode.right != null) nextLevel.add(currentNode.right);
            if (currentLevelToPrint.isEmpty())
                while (!nextLevel.isEmpty())
                    currentLevelToPrint.add(nextLevel.poll());

        }
        return result;
    }

    public static class Node {
        int value;
        Node left;
        Node right;

        Node(int value) {
            this.value = value;
        }

        void link(int data) {
            if (data <= value) {
                if (left == null) left = new Node(data);
                else left.link(data);
            } else {
                if (right == null) right = new Node(data);
                else right.link(data);
            }
        }

        boolean hasChildWith(int data) {
            if (data == value) return true;
            else if (data <= value) return left.hasChildWith(data);
            else return right.hasChildWith(data);
        }

        Node getChildWith(int data) {
            if (data == value) return this;
            else if (left != null && data <= value) return left.getChildWith(data);
            else if (right != null && data > value) return right.getChildWith(data);
            else return null;
        }

    }
}
