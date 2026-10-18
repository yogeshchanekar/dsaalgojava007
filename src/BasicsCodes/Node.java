package BasicsCodes;

import java.util.ArrayDeque;
import java.util.Queue;

public class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
    }

    // Preorder: Root -> Left -> Right
    static void preorder(Node node) {
        if (node == null) {
            return; // No node here, so return to the parent.
        }
        System.out.print(node.data + " "); // Step 1: Visit the root.
        preorder(node.left);                // Step 2: Traverse the left subtree.
        preorder(node.right);               // Step 3: Traverse the right subtree.
    }

    // Inorder: Left -> Root -> Right
    static void inorder(Node node) {
        if (node == null) {
            return;
        }
        inorder(node.left);                 // Step 1: Traverse the left subtree.
        System.out.print(node.data + " "); // Step 2: Visit the root.
        inorder(node.right);                // Step 3: Traverse the right subtree.
    }

    // Postorder: Left -> Right -> Root
    static void postorder(Node node) {
        if (node == null) {
            return;
        }
        postorder(node.left);               // Step 1: Traverse the left subtree.
        postorder(node.right);              // Step 2: Traverse the right subtree.
        System.out.print(node.data + " "); // Step 3: Visit the root.
    }

    // Level order (breadth-first): Visit each level from left to right.
    static void levelOrder(Node node) {
        if (node == null) {
            return;
        }

        // Step 1: Put the root in a FIFO (first in, first out) queue.
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(node);

        while (!queue.isEmpty()) {
            // Step 2: Remove and visit the oldest queued node.
            Node current = queue.poll();
            System.out.print(current.data + " ");

            // Step 3: Add its children, left first, for later visits.
            if (current.left != null) {
                queue.offer(current.left);
            }
            if (current.right != null) {
                queue.offer(current.right);
            }
            // Step 4: Repeat until every queued node has been visited.
        }
    }

    public static void main(String[] args) {
        // Step 1: Create this binary tree. Each node has up to two children.
        //          1
        //         / \
        //        2   3
        //       / \ / \
        //      4  5 6  7
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        // Step 2: Run each traversal. "Visit" means print the node's value.
        System.out.println("Preorder (Root -> Left -> Right):");
        preorder(root);
        System.out.println("\nSteps: visit 1 -> 2 -> 4 -> 5 -> 3 -> 6 -> 7");

        System.out.println("\nInorder (Left -> Root -> Right):");
        inorder(root);
        System.out.println("\nSteps: visit 4 -> 2 -> 5 -> 1 -> 6 -> 3 -> 7");

        System.out.println("\nPostorder (Left -> Right -> Root):");
        postorder(root);
        System.out.println("\nSteps: visit 4 -> 5 -> 2 -> 6 -> 7 -> 3 -> 1");

        System.out.println("\nLevel order (each level, left to right):");
        levelOrder(root);
        System.out.println("\nSteps: level 0: 1 -> level 1: 2 3 -> level 2: 4 5 6 7");
        // Queue after each visit:
        // Start: [1]
        // Visit 1: [2, 3]
        // Visit 2: [3, 4, 5]
        // Visit 3: [4, 5, 6, 7]
        // Visit 4: [5, 6, 7]
        // Visit 5: [6, 7]
        // Visit 6: [7]
        // Visit 7: [] (finished)
        // 
    }
}
