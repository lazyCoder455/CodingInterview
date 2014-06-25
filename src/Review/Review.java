package Review;

import Chapter2.Node;
import Chapter4.GraphNode;
import Chapter4.Tree;

import java.util.Stack;

/**
 * Created by faiz on 6/20/14.
 */
public class Review {

    public static void setToZero(int[][] a){
        int rows = a[0].length;
        int cols = a.length;
        int[] set = new int[rows];
        for(int i : set){
            i = -1;
        }
        for(int i = 0; i < rows; i++){
            for(int j = 0; j <cols; j++){
                if(a[j][i] == 0){
                   set[i] = j; //record the column number for
                    //each row to be set to 0
                }
            }
        }
        for(int k = 0; k < rows; k++){
            int column = set[k];
            if(column == -1) continue;
            for(int z = 0; z < cols; z++){
                a[z][k] = 0;
            } //set columns to 0
            for(int z = 0; z < rows; z++){
                a[column][z] = 0;
            }
        }
    }
    //recursive approach
    public static int printKth(int k, Node a){
        if(a == null){
            return 0;
        }
        int elementFromEnd = printKth(k, a.next);
        if(elementFromEnd == k) {
            System.out.println(a.data);
        }
        return ++elementFromEnd;
    }

    //iterative approach
    public static void printKthFromEnd(int k, Node a){
        int counter = 0;
        Node end = a;
        Node kthFrom = a;
        while(end.next != null){
            if(counter >= k){
                kthFrom = kthFrom.next;
            }
            end = end.next;
            counter++;

        }
        System.out.println(kthFrom.data);

    }

    public static Node addReverse(Node a, Node b, int carry){
        if(a == null && b == null) return null;
        int value = a.data + b.data + carry;
        int c = value >= 10 ? 1 : 0;
        value %= 10;
        Node answer = new Node(value);
        Node next = addReverse(a.next, b.next, c);
        answer.next = next;
        return answer;
    }

    public static Stack<Integer> mergeSort(Stack<Integer> input) {
        if(input.size() <= 1){
            return input;
        }
        Stack<Integer> result;
        Stack<Integer> right = new Stack<Integer>();
        Stack<Integer> left = new Stack<Integer>();
        int mid = input.size() / 2;
        while (left.size() < mid){
            left.push(input.pop());
        }
        while(input.size() > 0){
            right.push(input.pop());
        }

        right = mergeSort(right);
        left = mergeSort(left);
        result = merge(right, left);
        return result;
    }

    private static Stack<Integer> merge(Stack<Integer> right, Stack<Integer> left){
        Stack<Integer> temp = new Stack<Integer>();
        Stack<Integer> result = new Stack<Integer>();
        while(right.size() > 0 && left.size() > 0){
            if(right.peek() > left.peek()){
                temp.push(right.pop());
            } else {
                temp.push(left.pop());
            }
        }
        while(right.size() > 0){
            temp.push(right.pop());
        }
        while(left.size() > 0){
            temp.push(left.pop());
        }
        while(temp.size() > 0){
            result.push(temp.pop());
        }
        return result;
    }

    public static boolean isPath(GraphNode a, GraphNode b){
        if(a.adjacencyList.size() == 0) {
            return false;
        }
        for(GraphNode c : a.adjacencyList){
            if(c == b) return true;
            return false || isPath(c, b);
        }
        return false;
    }

    public static boolean isBalanced(Tree a){
        if(a == null) return true;
        return Math.abs(getHeight(a.right) - getHeight(a.left)) <= 1;
    }

    private static int getHeight(Tree root){
        if(root == null) return -1;
        return Math.max(getHeight(root.right), getHeight(root.left)) + 1;
    }
}