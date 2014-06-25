package Chapter5;

import java.util.ArrayList;

/**
 * Created by faiz on 6/24/14.
 */
public class Chapter5 {
    private static final int ODD_MASK = 0xaaaaaaaa;
    private static final int EVEN_MASK = 0x55555555;

    public int insert(int n, int m, int i, int j) {
        int mask = -1 << (i + j);
        int mask2 = 1;
        int count = j;
        while(count > 0){
            mask2 = mask2 << 1;
            mask |= 1;
            count--;
        }
        mask |= mask2;
        n &= mask;
        m = m << (i + j);
        n |= m;
        return n;
    }

    public static String decimal(double num){
        if(num >= 1) return null;

        StringBuilder number = new StringBuilder();
        number.append("0.");
        double fraction = .5;
        while(num > 0){
            if(number.length() > 32) {
                System.out.println("ERROR");
                throw new ArithmeticException();
            }
            if(num - fraction >= 0) {
                number.append("1");
                num -= fraction;
            } else {
                number.append("0");
            }
            fraction /= 2;
        }
        return number.toString();
    }

    public static String aboveBelow(int num) {
        int[] high = new int[32];
        int[] low = new int[32];
        for(int i = 0; i < 32; i++){
            high[i] = low[i] = (num >> i) & 1;
        }
        //generate the lower number
        int first = -1;
        for(int i = 31; i >= 0; i--){
            if(low[i] == 1){
                first = i;
            } else if(first != -1 && low[i] == 0){
                low[i] = 1;
                low[first] = 0;
                break;
            }
        }
        //generate the higher number
        first = -1;
        for(int i = 0; i < 32; i ++){
            if(high[i] == 1){
                first = i;
            } else if (first != -1 && high[i] == 0){
                high[i] = 1;
                high[first] = 0;
                break;
            }
        }
        StringBuilder builder = new StringBuilder();
        builder.append("Low:\n");
        double lowNum = 0;
        double highNum = 0;
        for(int i = 0; i < 32; i++){
            lowNum += low[i] * Math.pow(2, i);
            highNum += high[i] * Math.pow(2, i);
        }
        builder.append(lowNum);
        builder.append('\n');
        builder.append("High\n");
        builder.append(highNum);
        return builder.toString();
    }

    public static String aboveBelowBits(int n){
        int low = 0;
        int high = 0;
        int first = -1;
        for(int i = 0; i < 32; i++){
            if((n & (1 << i)) == (1 << i)){
                first = i;
            } else if(first != -1 && (~n & (1 << i)) == (1 << i)){
                //cancel out the lowest one (right most)
                int mask = -1;
                for(int j = 0; j <= first; j++){
                    mask = (mask << j + 1);
                }
                high = n & mask;
                //replace the next 0 with 1
                mask = (1 << i);
                high |= mask;
                break;
            }
        }
        first = -1;
        for(int i = 32; i >= 0; i--){
            if((n & (1 >> i)) == (1 >> i)){
                first = i;
            } else if(first != -1 && (~n & (1 >> i)) == (1 >> i)) {
                //cancel out the highest one (leftmost)
                int mask = -1;
                for(int j = 0; j <= (32 - first); j++){
                    mask = (mask << j + 1);
                }
                low = n & mask;
                //replace the next 0 with 1
                mask = (1 << 32 - i);
                low |= mask;
                break;
            }
        }
        return "High:" + high + "\n" + "Low:" + low + "\n";
    }

    public static int hamming(int a, int b){
        int xor = a ^ b;
        int count = 0;
        for(int i = 0; i < 32; i++){
            if((xor & (1 << i)) == (1 << i))count++;
        }
        return count;
    }

    public static int swap(int a){
        int even = (EVEN_MASK & a);
        int odd = (ODD_MASK & a);
        return (odd >> 1) | (even << 1);
    }

    public static int findMissing(int[] a){
        int missing = 0;
        int number = 0;
        for(int i = 0; i < a.length; i++){
            number = 0;
            for(int j = 32; j >= 0; j--){
                number |=  (getJthBit(a[i], j) << j);
            }
            missing |= 1 << number;
        }
        missing = ~missing;
        int count = 0;
        while((missing & 1) != 1){
            missing = missing >> 1;
            count++;
        }

        return count;
    }

    private static int getJthBit(int a, int j){
        return ((a >>j) & 1) == 1 ? 1 : 0;
    }

    public static void drawHorizontal(byte[] screen, int width, int x1, int x2, int y){
        int height = (screen.length / width);
        int startBitNo = ((x1 + y * width) % 8);
        int startByteNo = (startBitNo / 8);//(bitNo / 8));
        screen[startByteNo] = (byte)(0xFF >> (startBitNo));
        int endBitNo = ((x2 + y * width) % 8);
        int endByteNo = (endBitNo / 8);
        screen[endByteNo] = (byte)(0xFF << (8 - endByteNo));
        if(endByteNo - startByteNo > 1){
            while (startByteNo < endByteNo){
                screen[++startByteNo] = (byte)0xFF;
            }
        }
    }

    public static int findMissing(int[] a, int v){
        //if n is even there are equal 0s and 1s
        //else there are more 1s
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int num : a){
            list.add(num);
        }
        return findMissing(list, 0);
    }

    private static int findMissing(ArrayList<Integer> list, int col) {
        if(col >= 8) return 0;
        ArrayList<Integer> evens = new ArrayList<Integer>();
        ArrayList<Integer> odds = new ArrayList<Integer>();
        for(int i = 0; i < list.size(); i++){
            if(getJthBit(list.get(i), col) == 0) {
                evens.add(list.get(i));
            } else {
                odds.add(list.get(i));
            }
        }
        if(evens.size() > odds.size()){
            int v = findMissing(list, col + 1);
            return (v << 1) | 1;
        }
        int v = findMissing(list, col + 1);
        return (v << 1) | 0;
    }
}
