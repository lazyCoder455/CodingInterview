package Chapter11;

import Chapter4.Tree;

/**
 * Created by faiz on 6/11/14.
 */
public class RankTree extends Tree {
    public int rank = 1;

    public RankTree(int a){
        super(a);
    }

    public static void rankAddBST(RankTree a, RankTree add) {
        if (a == null) {
            a = add;
        }
        if (add.data > a.data) {
            add.rank = a.rank + 1;
            if(a.right == null) {
                a.right = add;
                return;
            }
            RankTree.rankAddBST((RankTree)a.right, add);
        }
        if (add.data < a.data) {
            a.rank++;
            if(a.left == null) {
                a.left = add;
                return;
            }
            RankTree.rankAddBST((RankTree)a.left, add);
        }
        if (a.data == add.data){
            a.rank++;
            return;
        }
    }

    public int getRank(int x){
        RankTree node = RankTree.getNode(this, x);

        return node == null ? -1 : node.rank;
    }

    private static RankTree getNode(RankTree a, int x){
        if(a == null) return null;
        if(x > a.data){
            return getNode((RankTree)a.right, x);
        }
        if(x < a.data){
            return getNode((RankTree)a.left, x);
        }
        if(x == a.data) return a;
        return null;
    }

}
