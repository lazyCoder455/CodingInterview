package Chapter4;

import Chapter2.Node;

/**
 * Created by lazyCoder on 3/15/14.
 */
public class Tree {
    public Tree right;
    public Tree left;
    public int data;

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
        int length = stop - start + 1;
        if (length < 1) {
            return;
        }
        if (a == null) {
            a = new Tree(sorted[start + length / 2]);
        }
        addToBSTRecurse(a.right, sorted, stop - (length / 2 - 1), stop);
        addToBSTRecurse(a.left, sorted, start, start + (length / 2 - 1));
    }

    public static boolean checkIsBST(Tree root) {
        if (root == null) return true;
        boolean isBST = false;
        isBST = root.data < root.right.data ? true : false;
        isBST &= root.data >= root.left.data ? true : false;
        if (!isBST) return false;
        else return isBST && checkIsBST(root.right) && checkIsBST(root.left);

    }

    public static boolean isBalanced(Tree root) {
        if (root == null) return true;
        return (Math.abs(getHeight(root.right) - getHeight(root.left)) <= 1);
    }

    public static int getHeight(Tree root) {
        if (root == null) return -1;
        return Math.max(getHeight(root.left), getHeight(root.right)) + 1;

    }

    public static Node[] makeLists(Tree root, int d) {
        Node[] lists = new Node[d];
        addToLinkedList(root, lists, 0);
        return lists;
    }

    private static void addToLinkedList(Tree root, Node[] lists, int depth) {
        if (root == null) return;
        Node toAdd = new Node(root.data);
        if (lists[depth] == null) {
            lists[depth] = toAdd;
        } else {
            Node temp = lists[depth];
            toAdd.next = temp;
            lists[depth] = toAdd;
        }
        addToLinkedList(root.right, lists, depth + 1);
        addToLinkedList(root.left, lists, depth + 1);
    }
}
