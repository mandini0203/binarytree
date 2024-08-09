class BinaryTree {
    static class Node {
        int data;
        Node left, right;

        Node(int item) {
            data = item;
            left = right = null;
        }
    }

    Node root;

    // Method to insert a new node in the binary tree
    void insert(int data) {
        root = insertRec(root, data);
    }

    // Recursive method to insert a new node
    Node insertRec(Node root, int data) {
        // If the tree is empty, return a new node
        if (root == null) {
            root = new Node(data);
            return root;
        }

        // If not, recur down the tree
        if (data < root.data) {
            root.left = insertRec(root.left, data);
        } else if (data > root.data) {
            root.right = insertRec(root.right, data);
        }

        // Return the  node pointer not changed
        return root;
    }

    // delete a node
    void delete(int data) {
        root = deleteRec(root, data);
    }

    // Recursive method to delete a node
    Node deleteRec(Node root, int data) {
        // Base case: If the tree is empty
        if (root == null) return root;

        // Otherwise, recur down the tree
        if (data < root.data) {
            root.left = deleteRec(root.left, data);
        } else if (data > root.data) {
            root.right = deleteRec(root.right, data);
        } else {
            // Node with the data found

            // Node with only one child or no child
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;

            // smallest in the right subtree)
            root.data = minValue(root.right);

            // Delete the inorder 
            root.right = deleteRec(root.right, root.data);
        }

        return root;
    }

    // Method to find the smallest value in the given tree
    int minValue(Node root) {
        int minValue = root.data;
        while (root.left != null) {
            minValue = root.left.data;
            root = root.left;
        }
        return minValue;
    }

    // Method to perform pre-order traversal (root, left, right)
    void preOrder() {
        preOrderRec(root);
    }

    // Recursive method for pre-order traversal
    void preOrderRec(Node root) {
        if (root != null) {
            System.out.print(root.data + " ");
            preOrderRec(root.left);
            preOrderRec(root.right);
        }
    }

    // Method to perform in-order traversal (left, root, right)
    void inOrder() {
        inOrderRec(root);
    }

    // Recursive method for in-order traversal
    void inOrderRec(Node root) {
        if (root != null) {
            inOrderRec(root.left);
            System.out.print(root.data + " ");
            inOrderRec(root.right);
        }
    }

    // Method to perform post-order traversal (left, right, root)
    void postOrder() {
        postOrderRec(root);
    }

    // Recursive method for post-order traversal
    void postOrderRec(Node root) {
        if (root != null) {
            postOrderRec(root.left);
            postOrderRec(root.right);
            System.out.print(root.data + " ");
        }
    }

    // Main method to test the binary tree
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        // Insert nodes
        tree.insert(100);
        tree.insert(60);
        tree.insert(40);
        tree.insert(70);
        tree.insert(120);
        tree.insert(110);
        tree.insert(130);

        // Print in-order traversal
        System.out.println("In-order traversal:");
        tree.inOrder(); 
        System.out.println();

        // Print pre-order traversal
        System.out.println("Pre-order traversal:");
        tree.preOrder(); 
        System.out.println();

        // Print post-order traversal
        System.out.println("Post-order traversal:");
        tree.postOrder(); 
        System.out.println();

        // Delete a node
        tree.delete(70);
        System.out.println("In-order traversal after deleting 70:");
        tree.inOrder(); 
        System.out.println();
    }
}
