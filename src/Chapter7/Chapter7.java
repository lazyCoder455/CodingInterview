package Chapter7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by faiz on 5/27/14.
 */
public class Chapter7 {

    //performs m*n using additions
    public static int multiply(int m, int n) {
        int product = 0;

        if( m < 0 && n < 0) {
            for(int i = 1; i <= Math.abs(m); i++) {
                product += Math.abs(n);
            }
            return product;
        }

        if(m < 0) {
            for(int i = 1; i <= n; i++) {
                product += m;
            }

            return product;
        }


        for(int i = 1; i <= m; i++) {
            product += n;
        }

        return product;
    }

    //performs m-n using additions
    public static int subtract(int m, int n) {
        return m + negate(n);
    }

    private static int negate(int a) {
        int neg = 0;
        int incr = a < 0 ? 1 : -1;
        while(a != 0) {
            neg += incr;
            a += incr;
        }

        return neg;
    }

    //performs m/n using additions
    public static int divide(int m, int n) {
        if(n == 0) throw new ArithmeticException("divide by 0");
        int am = Math.abs(m);
        int an = Math.abs(n);
        int increment = an;
        int counter = 1;

        while(an < am) {
            an += increment;
            counter++;
        }

        return m < 0 ^ n < 0 ? negate(counter) : counter;

    }

    public static int kthPrime(int k) {
        int result = 0;
        if(k == 0) return result;
        Queue<Integer> list = new LinkedList<Integer>();
        addNumbers(list, 1);
        for(int i = 1; i <= k; i++) {
            result = Collections.min(list);
            list.remove(result);
            addNumbers(list, result);
        }

        return result;
    }

    private static void addNumbers(Queue<Integer> q, int multiple) {
        q.add(multiple * 3);
        q.add(multiple * 5);
        q.add(multiple * 7);
    }

    private static void addNumbers(Queue<Integer> q, int multiple, int base){
        q.add(multiple * base);
    }

    public static int kthPrimeEfficeint(int k) {
        int result = 0;
        if(k == 0) return result;
        Queue<Integer> list3 = new LinkedList<Integer>();
        Queue<Integer> list5 = new LinkedList<Integer>();
        Queue<Integer> list7 = new LinkedList<Integer>();
        addNumbers(list3, 1, 3);
        addNumbers(list5, 1, 5);
        addNumbers(list7, 1, 7);

        for(int i = 1; i <=k; i++) {
            int result3 = list3.peek();
            int result5 = list5.peek();
            int result7 = list7.peek();

            result = Math.min(result3, Math.min(result5, result7));

            if(result == result3){
                list3.remove();
                addNumbers(list3, result, 3);
                addNumbers(list5, result, 5);
                addNumbers(list7, result, 7);
            } else if(result == result5) {
                list5.remove();
                addNumbers(list5, result, 5);
                addNumbers(list7, result, 7);
            } else {
                list7.remove();
                addNumbers(list7, result, 7);
            }
        }


        return result;
    }

    public static void lineAndPoints(Point ... a) {
        ArrayList<Line> lines = new ArrayList<Line>();

        //generate all possible lines
        for(int i = 0; i < a.length; i++) {
            Point start = a[i];
            for(int j = i + 1; j < a.length; j++) {
                Line e = new Line(start, a[j]);
                if(!lines.contains(e)){
                    e.addPoint(start);
                    e.addPoint(a[j]);
                    lines.add(e);
                } else {
                    Line t = lines.get(lines.indexOf(e));
                    t.addPoint(start);
                    t.addPoint(a[j]);
                }
            }
        }

        int maxIndex = 0;
        int maxCount = 0;
        for(int i = maxIndex; i < lines.size(); i++) {
            if (maxCount < lines.get(i).points.size()){
                maxCount = lines.get(i).points.size();
                maxIndex = i;
            }
        }

        System.out.println(lines.get(maxIndex).toString());
        System.out.println(maxCount);



    }
}
