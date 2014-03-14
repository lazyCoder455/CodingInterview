package Chapter3;

/**
 * Created by lazyCoder on 3/11/14.
 */
public class ThreeStack {
    private int[] data = new int[100];
    private boolean[] occupied = new boolean[100];
    private int[][] stack = new int[3][100];
    private int[] stackPtr = new int[]{0, 0, 0};


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
        stack[stackNo][stackPtr[stackNo]++] = index;
        data[index] = item;
        occupied[index] = true;

    }

    public int pop(int stackNo) {
        int item = data[stack[stackNo][stackPtr[stackNo] - 1]];
        occupied[stackPtr[stackNo] - 1] = false;
        stackPtr[stackNo]--;
        return item;
    }


}
