package Review;

import java.util.ArrayList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by faiz on 6/22/14.
 */
public class SetOfStacks {
    private ArrayList<Stack<Integer>> stacks;
    private int currentStack = 0;
    private static final int CAPACITY = 10;

    public SetOfStacks() {
        stacks = new ArrayList<Stack<Integer>>();
    }

    public void push(int element){
        if(stacks.get(currentStack) != null && stacks.get(currentStack).size() < 10){
            stacks.get(currentStack).push(element);
        } else {
            currentStack++;
            stacks.add(currentStack, new Stack<Integer>());
            stacks.get(currentStack).push(element);
        }

    }

    public int peek() {
        return stacks.get(currentStack).peek();
    }

    public int pop() {
        int result = stacks.get(currentStack).pop();
        if(stacks.get(currentStack).size() == 0){
            stacks.remove(currentStack);
            currentStack--;
        }

        return result;
    }

    public int pop(int stackNo){
        int result = stacks.get(stackNo).pop();
        if(stacks.get(stackNo).size() == 0){
            stacks.remove(stackNo);
            currentStack--;
        } else {
            //shift stacks
            ArrayList<Integer> buffer = new ArrayList<Integer>();
            while(currentStack != stackNo){
                buffer.add(this.pop());
            }

        }

        return result;
    }



}
