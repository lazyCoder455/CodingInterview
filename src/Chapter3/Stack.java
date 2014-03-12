package Chapter3;

import Chapter2.Node;

/**
 * Created by lazyCoder455 on 3/11/14.
 */
public class Stack {
    Node top;
    Node min;

    public int pop() throws Exception {
        if (top != null) {
            int item = top.data;
            top = top.next;
            return item;
        }
        throw new Exception("Empty Sack!!");
    }

    public void push(int item) {
        Node t = new Node(item);
        t.next = top;
        top = t;
        if (min == null || top.data < min.data) min = top;
    }

    public int peek() {
        return top.data;
    }
}
