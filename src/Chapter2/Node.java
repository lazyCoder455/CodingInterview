package Chapter2;

/**
 * Created by lazyCoder455 on 3/6/14.
 */
public class Node {
    public Node next = null;
    public int data = 0;

    public Node(int data){
        this.data = data;
    }

    public Node(Node next, int data) {
        this(data);
        this.next = next;
    }

    public static Node createList(int... args){
        Node head = new Node(args[0]);
        Node iter = head;
        for(int i = 1; i < args.length; i++) {
            iter.next = new Node(args[i]);
            iter = iter.next;
        }
        return head;
    }

    public static String toString(Node head) {
        String answer = "";
        while(head.next != null) {
            answer += head.data + " ";
            head = head.next;
        }
        return answer;
    }
}
