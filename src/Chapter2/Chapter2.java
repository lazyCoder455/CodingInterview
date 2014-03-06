package Chapter2;

/**
 * Created by lazyCoder455 on 3/6/14.
 */
public class Chapter2 {

    public static void removeFromMiddle(Node n) {
        Node iter = n;
        while(iter.next != null) {
            iter.data = iter.next.data;
            if(iter.next.next == null) {
                iter.next = null;
                break;
            } else{
            iter = iter.next;
            }
        }
    }

    public static void partitionAroundValue(Node head, int value) {
        Node less;
        Node equal;
        Node more;

    }
}
