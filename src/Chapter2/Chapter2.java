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

    public static Node partitionAroundValue(Node head, int value) {
        Node less = null;
        Node lessStart = null;
        Node equal = null;
        Node equalStart = null;
        Node more = null;
        Node moreStart = null;
        Node iter = head;
        while(iter.next!= null) {
            if(iter.data > value) {
                if(more == null) {
                    more = iter;
                    moreStart = more;
                } else {
                    more.next = iter;
                    more = more.next;
                }
            } else if(iter.data < value) {
                if(less == null) {
                    less = iter;
                    lessStart = less;
                } else {
                    less.next = iter;
                    less = less.next;
                }
            } else if(iter.data == value) {
                if(equal == null) {
                    equal = iter;
                    equalStart = equal;
                } else {
                    equal.next = iter;
                    equal = less.next;
                }
            }
            iter = iter.next;
        }

        //stitch together
        if(lessStart != null) head = lessStart;
        else if(equalStart != null) {
            head = equalStart;
            if(moreStart != null) equal.next = moreStart;
            return head;
        }
        else if(moreStart != null) {
            head = moreStart;
            return head;
        }

        if(equalStart != null) less.next = equalStart;
        if(moreStart != null) equal.next = moreStart;
        return head;
    }

    public static Node findCorrupt(Node head) {
        Node rate1 = head;
        Node rate2 = head;
        int distance1 = 0;
        int distance2 = 0;
        while (rate1.next != null && rate2.next != null) {
            rate1 = rate1.next;
            rate2 = rate2.next.next;
            distance1++;
            distance2 += 2;
            if (rate1 == rate2) break;
            //if the above is true that means that we have a loop
        }
        // both pointer are now the same distance from the beginning but at
        // different speeds
        while (distance2 != 0) {
            distance1--;
            distance2 -= 1;
        }
        //distance1 is the node that cause the problem
        for (int i = 0; i < distance1; i++) {
            head = head.next;
        }

        return head;
    }

    public static Node fromLast(Node head, int k) {
        Node iter = head;
        int distance = 0;
        while (iter.next != null) {
            iter = iter.next;
            distance++;
        }

        int ret = distance - k;
        iter = head;
        for (int i = 0; i < ret; i++) {
            iter = iter.next;
        }

        return iter;
    }
}
