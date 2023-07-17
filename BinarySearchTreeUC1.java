class MyBinaryNode1<K extends Comparable<K>> {
    private K key;
    private MyBinaryNode1<K> left;
    private MyBinaryNode1<K> right;

    public MyBinaryNode1(K key) {
        this.key = key;
        this.left = null;
        this.right = null;
    }

    public K getKey() {
        return key;
    }

    public MyBinaryNode1<K> getLeft() {
        return left;
    }

    public MyBinaryNode1<K> getRight() {
        return right;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public void setLeft(MyBinaryNode1<K> left) {
        this.left = left;
    }

    public void setRight(MyBinaryNode1<K> right) {
        this.right = right;
    }
}

public class BinarySearchTreeUC1 {
    private MyBinaryNode1<Integer> root;

    public BinarySearchTreeUC1() {
        this.root = null;
    }

    public void insert(int key) {
        root = insertNode(root, key);
    }

    private MyBinaryNode1<Integer> insertNode(MyBinaryNode1<Integer> currentNode, int key) {
        if (currentNode == null) {
            return new MyBinaryNode1<>(key);
        }

        if (key < currentNode.getKey()) {
            currentNode.setLeft(insertNode(currentNode.getLeft(), key));
        } else if (key > currentNode.getKey()) {
            currentNode.setRight(insertNode(currentNode.getRight(), key));
        }

        return currentNode;
    }

    public void inOrderTraversal(MyBinaryNode1<Integer> node) {
        if (node != null) {
            inOrderTraversal(node.getLeft());
            System.out.print(node.getKey() + " ");
            inOrderTraversal(node.getRight());
        }
    }

    public static void main(String[] args) {
        BinarySearchTreeUC1 bst = new BinarySearchTreeUC1();

        bst.insert(56);
        bst.insert(30);
        bst.insert(70);

        System.out.println("In-order traversal of the BST:");
        bst.inOrderTraversal(bst.root);
    }
}