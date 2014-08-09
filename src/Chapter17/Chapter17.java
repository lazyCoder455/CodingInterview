package Chapter17;

/**
 * Created by faiz on 6/25/14.
 */
public class Chapter17 {

    public static void swap(int[] a){
        a[0] ^= a[1]; // C = A XOR B;
        a[1] ^= a[0]; // A = B XOR C;
        a[0] ^= a[1];
    }

    public static boolean hasOne(int[][] board, final int symbol){
        boolean result = true;
        return result;
    }

    public static int trailingZeros(int j){
        return (j / 10) * 2;
    }

    public static int max(int a, int b){
        int quote = a / b;
        return quote == 1 ? a : b;
        //return a - b > 0 ? a : b;
    }

    public static void largestSum(int[] a){
        int start = 0;
        int end = 0;
        int currentStart = 0;
        int currentEnd = 0;
        int posSum = a[0] >= 0 ? a[0] : 0;
        int negSum = a[0] < 0 ? a[0] : 0;
        int currentSum = a[0];
        int sum = 0;
        for(int i = 1; i < a.length; i++){
            if(a[i] >= 0){
                posSum += a[i];
            } else {
                negSum += a[i];
            }
            currentEnd = i;
            if(posSum <= -1 * negSum){
                //we have added too many negatives
                //need to reset
                currentStart = currentEnd = i;
                posSum = a[i] >= 0 ? a[i] : 0;
                negSum = a[i] < 0 ? a[i] : 0;
            }
            sum = posSum + negSum;
            //do we save?
            if(currentSum <= sum){
                start = currentStart;
                end = currentEnd;
                sum = currentSum;
            }

        }
        String str = "{";
        for(int i = start; i <= end; i++){
            str += a[i] + ",";
        }
        str += "}";
        System.out.println(str);
    }

    public static void print(int x){
        StringBuilder f = new StringBuilder();
        int power = 1;
        int place = 0;
        int insertionPoint = 0;
        int prevLength = 0;
        String build = "";
        while(x > 0){
            //456
            //get the last digit
            place = x % 10;
            build = getName(place, power);
            insertionPoint = (power % 3 == 2 && place == 1) ? prevLength: 0;
            f.insert(insertionPoint, build);
            //put in string
            x -= place;
            x /= 10;
            prevLength = build.indexOf(' ');
            prevLength = prevLength < 0 ? build.length() - 1 : prevLength;
            power++;
        }
        System.out.println(f.toString());
        //get ones
        //loop
        //get name
    }

    public static String getName(int number, int power){
        String name = "";
        String suffix = "";
        if(power % 3 == 2){
            switch (number) {
                case 0:
                    name = "";
                    break;
                case 1:
                    name = "-teen";
                    return name;
                case 2:
                    name = "twenty";
                    break;
                case 3:
                    name = "thirty";
                    break;
                case 4:
                    name = "forty";
                    break;
                case 5:
                    name = "fifty";
                    break;
                case 6:
                    name = "sixty";
                    break;
                case 7:
                    name = "seventy";
                    break;
                case 8:
                    name = "eighty";
                    break;
                case 9:
                    name = "ninety";
                    break;
            }
        } else {
            switch (number) {
                case 0:
                    name = "";
                    break;
                case 1:
                    name = "one";
                    break;
                case 2:
                    name = "two";
                    break;
                case 3:
                    name = "three";
                    break;
                case 4:
                    name = "four";
                    break;
                case 5:
                    name = "five";
                    break;
                case 6:
                    name = "six";
                    break;
                case 7:
                    name = "seven";
                    break;
                case 8:
                    name = "eight";
                    break;
                case 9:
                    name = "nine";
                    break;
            }
        }
        if(power % 3 == 0) suffix = "hundred ";
        switch (power) {
            case 4:
                suffix += "thousand ";
                break;
            case 7:
                suffix += "million ";
                break;
            case 10:
                suffix += "billion ";
                break;
        }

        return name + " " + suffix;
    }



}
