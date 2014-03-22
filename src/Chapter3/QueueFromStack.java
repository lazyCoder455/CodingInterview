package Chapter3;

import java.util.*;
import java.util.Stack;

/**
 * Created by Faiz-Note on 3/14/14.
 */
public class QueueFromStack {
    java.util.Stack<Integer> stackin;
    java.util.Stack<Integer> stackout;
    boolean useIn;

    public QueueFromStack() {
        stackin = new Stack<Integer>();
        stackout = new Stack<Integer>();
        useIn = true;
    }

    public void enqueue(int a) {
        if (!useIn) {
            while (!stackout.empty()) {
                stackin.push(stackout.pop());
            }
            useIn = true;
        }
        stackin.push(a);
    }

    public Integer dequeue() {
        if (useIn) {
            while (!stackin.empty()) {
                stackout.push(stackin.pop());
            }
            useIn = false;
        }
        return stackout.pop();
    }
}
