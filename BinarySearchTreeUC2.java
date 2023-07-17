class Node {
    int data;
    Node left, right;

    public Node(int item) {
        data = item;
        left = right = null;
    }
}

class BinaryTree {
    Node root;

    public BinaryTree() {
        root = null;
    }

    public void insert(int data) {
        root = insertRecursive(root, data);
    }

    private Node insertRecursive(Node root, int data) {
        if (root == null) {
            root = new Node(data);
            return root;
        }

        if (data < root.data) {
            root.left = insertRecursive(root.left, data);
        } else if (data > root.data) {
            root.right = insertRecursive(root.right, data);
        }

        return root;
    }

    public boolean contains(int data) {
        return containsRecursive(root, data);
    }

    private boolean containsRecursive(Node root, int data) {
        if (root == null) {
            return false;
        }

        if (data == root.data) {
            return true;
        }

        if (data < root.data) {
            return containsRecursive(root.left, data);
        } else {
            return containsRecursive(root.right, data);
        }
    }

    public int size() {
        return sizeRecursive(root);
    }

    private int sizeRecursive(Node root) {
        if (root == null) {
            return 0;
        }

        int leftSize = sizeRecursive(root.left);
        int rightSize = sizeRecursive(root.right);

        return leftSize + rightSize + 1;
    }
}

public class BinarySearchTreeUC2 {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();

        // Create the binary tree in a specific order
        binaryTree.insert(3);
        binaryTree.insert(11);
        binaryTree.insert(16);
        binaryTree.insert(22);
        binaryTree.insert(30);
        binaryTree.insert(40);
        binaryTree.insert(50);
        binaryTree.insert(60);
        binaryTree.insert(63);
        binaryTree.insert(65);
        binaryTree.insert(67);
        binaryTree.insert(70);
        binaryTree.insert(95);

        // Check if all elements are added
        int expectedSize = 12;
        int actualSize = binaryTree.size();

        System.out.println("Expected size: " + expectedSize);
        System.out.println("Actual size: " + actualSize);
        System.out.println("All elements added: " + (actualSize == expectedSize));
    }
}