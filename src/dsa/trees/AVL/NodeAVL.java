package dsa.trees.AVL;

public class NodeAVL {

    int key;
    int height;
    NodeAVL left;
    NodeAVL right;

    public NodeAVL(int key) {
        this.key = key;
    }

    public int getKey() {
        return key;
    }

}
