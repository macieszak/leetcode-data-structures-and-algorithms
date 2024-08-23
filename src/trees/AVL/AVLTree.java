package trees.AVL;

public class AVLTree {

    private NodeAVL root;

    public NodeAVL find(int key) {
        NodeAVL current = root;
        while (current != null) {
            if (current.key == key) {
                break;
            }
            current = current.key < key ? current.right : current.left;
        }
        return current;
    }

    public void insert(int key) {
        root = insert(root, key);
    }

    public void delete(int key) {
        root = delete(root, key);
    }

    public NodeAVL getRoot() {
        return root;
    }

    public int height() {
        return root == null ? -1 : root.height;
    }

    private NodeAVL insert(NodeAVL root, int key) {
        if (root == null) {
            return new NodeAVL(key);
        } else if (root.key > key) {
            root.left = insert(root.left, key);
        } else if (root.key < key) {
            root.right = insert(root.right, key);
        } else {
            throw new RuntimeException("duplicate Key!");
        }
        return rebalance(root);
    }

    private NodeAVL delete(NodeAVL node, int key) {
        if (node == null) {
            return node;
        } else if (node.key > key) {
            node.left = delete(node.left, key);
        } else if (node.key < key) {
            node.right = delete(node.right, key);
        } else {
            if (node.left == null || node.right == null) {
                node = (node.left == null) ? node.right : node.left;
            } else {
                NodeAVL mostLeftChild = mostLeftChild(node.right);
                node.key = mostLeftChild.key;
                node.right = delete(node.right, node.key);
            }
        }
        if (node != null) {
            node = rebalance(node);
        }
        return node;
    }

    private NodeAVL mostLeftChild(NodeAVL node) {
        NodeAVL current = node;
        /* loop down to find the leftmost leaf */
        while (current.left != null) {
            current = current.left;
        }
        return current;
    }

    private NodeAVL rebalance(NodeAVL z) {
        updateHeight(z);
        int balance = getBalance(z);
        if (balance > 1) {
            if (height(z.right.right) > height(z.right.left)) {
                z = rotateLeft(z);
            } else {
                z.right = rotateRight(z.right);
                z = rotateLeft(z);
            }
        } else if (balance < -1) {
            if (height(z.left.left) > height(z.left.right)) {
                z = rotateRight(z);
            } else {
                z.left = rotateLeft(z.left);
                z = rotateRight(z);
            }
        }
        return z;
    }

    private NodeAVL rotateRight(NodeAVL y) {
        NodeAVL x = y.left;
        NodeAVL z = x.right;
        x.right = y;
        y.left = z;
        updateHeight(y);
        updateHeight(x);
        return x;
    }

    private NodeAVL rotateLeft(NodeAVL y) {
        NodeAVL x = y.right;
        NodeAVL z = x.left;
        x.left = y;
        y.right = z;
        updateHeight(y);
        updateHeight(x);
        return x;
    }

    private void updateHeight(NodeAVL n) {
        n.height = 1 + Math.max(height(n.left), height(n.right));
    }

    private int height(NodeAVL n) {
        return n == null ? -1 : n.height;
    }

    public int getBalance(NodeAVL n) {
        return (n == null) ? 0 : height(n.right) - height(n.left);
    }

}
