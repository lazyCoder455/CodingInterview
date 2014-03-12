package Chapter3;

/**
 * Created by Faiz-Note on 3/11/14.
 */
public class ThreeStack {
    private int[] data = new int[100];
    private boolean[] occupied = new boolean[100];
    private int[][] stack = new int[3][100];
    private int stackPtr = 0;


    public ThreeStack() {

    }

    public void push(int stackNo, int item) {
        int index = 0;
        int i = 0;
        for (i = index; i < data.length; i++) {
            if (!occupied[i]) {
                index = i;
                break;
            }
        }
        if (i == data.length) throw new StackOverflowError("Stack Full");
        stack[stackNo][stackPtr++] = index;
        data[index] = item;
        occupied[index] = true;

    }

    public int pop(int stackNo) {
        int item = data[stack[stackNo][stackPtr - 1]];
        occupied[stackPtr - 1] = false;
        stackPtr--;
        return item;
    }


}
