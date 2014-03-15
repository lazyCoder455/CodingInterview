package Chapter3;

import java.util.*;
import java.util.Stack;

/**
 * Created by lazyCoder455 on 3/14/14.
 */
public class SetOfStacks {
    private int currentStack = 0;
    private static final int LIMIT = 5;
    ArrayList<java.util.Stack<Integer>> stacks;

    public SetOfStacks() {
        stacks = new ArrayList<java.util.Stack<Integer>>();
    }

    public void push(int a) {
        if (stacks.get(currentStack).size() < LIMIT) {
            stacks.get(currentStack).push(a);
        } else {
            stacks.add(new Stack<Integer>());
            stacks.get(++currentStack).push(a);
        }
    }

    public int pop() {
        int ret = stacks.get(currentStack).pop();
        if (stacks.get(currentStack).empty()) {
            stacks.remove(currentStack--);
        }

        return ret;
    }

    public int popAt(int stack) {
        int ret = stacks.get(stack).pop();
        if (stacks.get(stack).empty()) {
            stacks.remove(stack);
            if (currentStack > 0) currentStack--;
        }
        return ret;
    }
}
