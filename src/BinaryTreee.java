public class BinaryTreee {
    Nodee root;
    private Nodee addRecursive(Nodee current, int value) {
        if (current == null) {
            return new Nodee(value);
        }
        if (value < current.value) {
            current.left = addRecursive(current.left, value);
        } else if (value > current.value) {
            current.right = addRecursive(current.right, value);
        } else {
            return current;
        }
        return current;
    }
    public void add(int value) {
        root = addRecursive(root, value);
    }
    private boolean containsNodeRecursive(Nodee current, int value) {
        if (current == null) {
            return false;
        }
        if (value == current.value) {
            return true;
        }
        return value < current.value
                ? containsNodeRecursive(current.left, value)
                : containsNodeRecursive(current.right, value);
    }
    public boolean containsNode(int value) {
        return containsNodeRecursive(root, value);
    }
    private Nodee deleteRecursive(Nodee current, int value) {
        if (current == null) {
            return null;
        }
        if (value == current.value) {
            // Node to delete found
            // ... code to delete the node will go here
        }
        if (value < current.value) {
            current.left = deleteRecursive(current.left, value);
            return current;
        }
        current.right = deleteRecursive(current.right, value);
        return current;
    }
    public void delete(int value) {
        root = deleteRecursive(root, value);
    }
    private void traverseInOrder(Nodee node) {
        if (node != null) {
            traverseInOrder(node.left);
            System.out.print(" " + node.value);
            traverseInOrder(node.right);
        }
    }
    public void traverseInOrder() {
        traverseInOrder(root);
    }
    private void traversePreOrder(Nodee node) {
        if (node != null) {
            System.out.print(" " + node.value);
            traversePreOrder(node.left);
            traversePreOrder(node.right);
        }
    }
    public void traversePreOrder() {
        traversePreOrder(root);
    }
    private void traversePostOrder(Nodee node) {
        if (node != null) {
            traversePostOrder(node.left);
            traversePostOrder(node.right);
            System.out.print(" " + node.value);
        }
    }
    public void traversePostOrder() {
        traversePostOrder(root);
    }
    public static void main(String[] args) {
        BinaryTreee binaryTree = new BinaryTreee();
        binaryTree.add(6);
        binaryTree.add(4);
        binaryTree.add(8);
        binaryTree.add(3);
        binaryTree.add(5);
        binaryTree.add(7);
        binaryTree.add(9);
        binaryTree.traverseInOrder();
        System.out.println();
        binaryTree.traversePreOrder();
        System.out.println();
        binaryTree.traversePostOrder();
        System.out.println();
        System.out.println(binaryTree.containsNode(4));
        System.out.println(binaryTree.containsNode(10));
        if (test.isFullTree(binaryTree.root)) {
            System.out.println("The Binary tree is full");
        } else {
            System.out.println("The Binary tree is not full");
        }
    }

}
