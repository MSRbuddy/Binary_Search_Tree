class Node3 {
    int data;
    Node left, right;

    public Node3(int item) {
        data = item;
        left = right = null;
    }
}

class BinaryTree3 {
    Node root;

    public BinaryTree3() {
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

    public boolean search(int value) {
        return searchRecursive(root, value);
    }

    private boolean searchRecursive(Node root, int value) {
        if (root == null) {
            return false;
        }

        if (root.data == value) {
            return true;
        }

        if (value < root.data) {
            return searchRecursive(root.left, value);
        } else {
            return searchRecursive(root.right, value);
        }
    }
}

public class BinarySearchTreeUC3 {
    public static void main(String[] args) {
        BinaryTree3 binaryTree = new BinaryTree3();

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

        // Search for the value 63
        int searchValue = 63;
        boolean isFound = binaryTree.search(searchValue);

        System.out.println("Value " + searchValue + " found: " + isFound);
    }
}