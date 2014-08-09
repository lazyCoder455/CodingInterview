package Chapter9;

import java.util.ArrayList;

/**
 * Created by faiz on 5/29/14.
 */
public class Chapter9 {

    public static void addParentheses(int r, int l, int n, char[] answer, int index) {
        if(r == n && l == n) {
            String out = String.copyValueOf(answer);
            System.out.println(out);
        }

        if(l < n) {
            answer[index] = '(';
            addParentheses(r, l + 1, n, answer, index + 1);
        }

        if(r < l) {
           answer[index] = ')';
            addParentheses(r + 1, l, n, answer, index + 1);
        }
    }

    public static void changeColor(int[][] image, boolean[][] modified, int x, int y, int color){
        int xlength = image.length;
        int ylength = image[0].length;
        if(x == xlength && y == ylength || x < 0 && y < 0) return;
        image[x][y] = color;
        modified[x][y] = true;

        if(x < xlength - 1 && !modified[x + 1][y]) {
            changeColor(image, modified, x + 1, y, color);
        }
        if(y < ylength - 1 && !modified[x][y + 1]) {
            changeColor(image, modified, x, y + 1, color);
        }
        if(x < xlength - 1 && y < ylength - 1 &&
                !modified[x + 1][y + 1]) {
            changeColor(image, modified, x + 1, y + 1, color);
        }


        if(x > 0 && !modified[x - 1][y]){
            changeColor(image, modified, x - 1, y, color);
        }
        if(y > 0 && !modified[x][y - 1]) {
            changeColor(image, modified, x, y - 1, color);
        }
        if(x > 0 && y > 0 &&
                !modified[x - 1][y - 1]) {
            changeColor(image, modified, x - 1, y - 1, color);
        }
    }

    public static int makeChange(int n) {
        int[] denoms = new int[] {10, 5, 1};
        return makeChange(n, denoms, 0);
    }

    private static int makeChange(int amount, int[] denoms, int index) {
        if(index >= denoms.length - 1) return 1;
        int denomAmount = denoms[index];
        int ways = 0;
        for(int i = 0; i * denomAmount <= amount; i++) {
            int amountRemaining = amount - i * denomAmount;
            ways += makeChange(amountRemaining, denoms, index + 1);
        }
        return ways;
    }

    public static void placeQueens(int row, int[] columns, ArrayList<Integer[]> result) {
        if(row == 8) {
            Integer[] cast = new Integer[columns.length];
            for(int i = 0; i < columns.length; i++) {
                cast[i] = columns[i];
            }
            result.add(cast);
        }

        for(int i = 0; i < 8; i++) {
            if(valid(row, i, columns)) {
                columns[row] = i;
                placeQueens(row + 1, columns, result);
            }

        }

    }

    private static boolean valid(int row, int column, int[] columns){
        for(int i = 0; i < row; i++) {
            int col = columns[i];
            if(col == columns[row]) return false;
            if(row - i == Math.abs(column - columns[row])) return false;
        }

        return true;
    }

    public static int parenthesize(String exp, int s, int e, boolean result) {
        if(s == e) {
            if(exp.charAt(s) == '1' && result) {
                return 1;
            } else if(exp.charAt(s) == '0' && !result) {
                return 1;
            }
            return 0;
        }
        int c = 0;
        if(result) {
            for (int i = s + 1; i <= e; i += 2) {
                char op = exp.charAt(i);
                if (op == '&') {
                    c += parenthesize(exp, s, i - 1, true) * parenthesize(exp, i + 1, e, true);
                } else if (op == '|') {
                    c += parenthesize(exp, s, i - 1, false) * parenthesize(exp, i + 1, e, true);
                    c += parenthesize(exp, s, i - 1, true) * parenthesize(exp, i + 1, e, false);
                    c += parenthesize(exp, s, i - 1, true) * parenthesize(exp, i + 1, e, true);
                } else if (op == '^') {
                    c += parenthesize(exp, s, i - 1, false) * parenthesize(exp, i + 1, e, true);
                    c += parenthesize(exp, s, i - 1, true) * parenthesize(exp, i + 1, e, false);
                }
            }
        } else {
            for (int i = s + 1; i <= e; i += 2) {
                char op = exp.charAt(i);
                if (op == '&') {
                    c += parenthesize(exp, s, i - 1, false) * parenthesize(exp, i + 1, e, false);
                    c += parenthesize(exp, s, i - 1, false) * parenthesize(exp, i + 1, e, true);
                    c += parenthesize(exp, s, i - 1, true) * parenthesize(exp, i + 1, e, false);
                } else if (op == '|') {
                    c += parenthesize(exp, s, i - 1, false) * parenthesize(exp, i + 1, e, false);
                } else if (op == '^') {
                    c += parenthesize(exp, s, i - 1, false) * parenthesize(exp, i + 1, e, false);
                    c += parenthesize(exp, s, i - 1, true) * parenthesize(exp, i + 1, e, true);
                }
            }
        }

        return c;
    }

    public static ArrayList<Box> tallStack(Box[] boxes, int start) {
        int currentHeight = 0;
        int maxHeight = 0;
        Box bottom = boxes[start];
        ArrayList<Box> maxStack = null;
        for(int i = 0; i < boxes.length; i++) {
            if(i == start) continue;
            if(!boxes[i].isLarger(bottom)) {
                ArrayList<Box> newStack = tallStack(boxes, i);
                currentHeight = Chapter9.getHeight(newStack);
                if(currentHeight > maxHeight) {
                    maxHeight = currentHeight;
                    maxStack = newStack;
                }
            }

        }

        if(maxStack == null) {
            maxStack = new ArrayList<Box>();
        }

        maxStack.add(0, bottom);

        return maxStack;


    }

    private static int getHeight(ArrayList<Box> stack) {
        int height = 0;
        for(Box b: stack) {
            height += b.height;
        }
        return height;
    }

}
