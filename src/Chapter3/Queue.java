package Chapter3;

import Chapter2.Node;

/**
 * Created by Faiz-Note on 3/11/14.
 */
public class Queue {
    Node first, last;

    public void enqueue(int data) {
        if (first == null) {
            last = new Node(data);
            first = last;
        } else {
            last.next = new Node(data);
            last = last.next;
        }
    }

    public int dequeue() throws Exception {
        if (first != null) {
            int item = first.data;
            first = first.next;
            return item;
        }
        throw new Exception("Empty queue!!");
    }
}
