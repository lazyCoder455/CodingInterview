package Chapter2;

import sun.net.www.content.audio.aiff;

/**
 * Created by lazyCoder455 on 3/6/14.
 */
public class Chapter2 {

    // 2.3
    public static void removeFromMiddle(Node n) {
        Node iter = n;
        if(iter.next == null) {
            iter = null;
        }
        while(iter.next != null) {
            iter.data = iter.next.data;
            if(iter.next.next == null) {
                //iter.next = null;
                iter = iter.next;
                iter = null;
                break;
            } else{
                iter = iter.next;
            }
        }
    }

    // 2.3 book ans
    public static void removeFromMiddleBook(Node n) {
       // n.next = n.next.next;
        if(n == null || n.next == null) {
            return;
        }
        Node next = n.next;
        n.data = next.data;
        n.next = next.next;
    }

    public static Node partitionAroundValue(Node head, int value) {
        Node less = null;
        Node lessStart = null;
        Node equal = null;
        Node equalStart = null;
        Node more = null;
        Node moreStart = null;
        Node iter = head;
        while(iter != null) {
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
        if(more != null)more.next = null;
        if(less != null)less.next = null;
        if(equal != null)equal.next = null;
        Node end = new Node(5);
        if(lessStart != null){
            head = lessStart;
            end = less;
            if(equalStart != null) {
                end.next = equalStart;
                end = equal;
            }
            if(moreStart != null) {
                end.next = moreStart;
                end = more;
                end.next = null;
                return  head;
            }
        } else if(equalStart != null) {
            head = equalStart;
            end = equal;
            if(moreStart != null) {
                equal.next = moreStart;
                end = more;
                end.next = null;
            }
            return  head;
        } else if(moreStart != null) {
            head = moreStart;
            end = more;
            end.next = null;
            return head;
        }
        return null;

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
            distance2--;
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

    public static Node addReverse(Node a, Node b) {
        Node heada = a;
        Node headb = b;
        Node answer = new Node(0);
        Node iter = answer;
        //must assume list of same lenght or the answer will be wrong
        int sum = 0;
        int carry = 0;
        while (heada.next != null && headb.next != null) {
            sum = (heada.data + headb.data) + carry;
            carry = sum >= 10 ? 1 : 0;
            sum %= 10;
            iter.next = new Node(sum);
            iter = iter.next;
            heada = heada.next;
            headb = headb.next;
        }


        return answer;
    }

    public static Node addForward(Node a, Node b) {

        return null;

    }
}
