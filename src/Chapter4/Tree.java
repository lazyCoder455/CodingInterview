package Chapter4;

/**
 * Created by lazyCoder on 3/15/14.
 */
public class Tree {
    Tree right;
    Tree left;
    int data;

    public Tree(int a) {
        this.data = a;
    }

    public Tree() {

    }

    public static void addBST(Tree a, Tree add) {
        if (a == null) {
            a = add;
        }
        if (add.data > a.data) {
            addBST(a.right, add);
        }
        if (add.data < a.data) {
            addBST(a.left, add);
        }
        if (a.data == add.data) return;
    }

    public static void addToBST(Tree a, int[] sorted) {
        for (int i = 0; i < sorted.length; i++) {
            addBST(a, new Tree(sorted[i]));
        }
    }

    public static void addToBSTRecurse(Tree a, int[] sorted, int start, int stop) {
        int length = start - stop + 1;
        if (length < 1) {
            return;
        }
        if (a == null) {
            a = new Tree(sorted[length / 2]);
        }
        addToBSTRecurse(a.right, sorted, length / 2 - 1, stop);
        addToBSTRecurse(a.left, sorted, start, length / 2 - 1);
    }
}
