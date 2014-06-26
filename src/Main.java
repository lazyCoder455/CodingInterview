import Chapter0.Chapter0;
import Chapter1.Chapter1;
import Chapter11.Chapter11;
import Chapter11.RankTree;
import Chapter14.CircularArray;
import Chapter17.Chapter17;
import Chapter2.Chapter2;
import Chapter2.Node;
import Chapter3.QueueFromStack;
import Chapter3.ThreeStack;
import Chapter4.Chapter4;
import Chapter4.GraphNode;
import Chapter4.Tree;
import Chapter7.Chapter7;
import Chapter9.Chapter9;
import Chapter0.MaxHeap;
import Chapter0.MinHeap;
import Chapter0.MedianTracker;
import Review.Review;
import Review.Tower;
import com.sun.jdi.connect.spi.TransportService;
import com.sun.org.apache.xml.internal.security.utils.CachedXPathFuncHereAPI;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;

/**
 * Created by lazyCoder455 on 3/6/14.
 */
public class Main {

    public static void main(String[] args) {
//        try {
//            System.out.println(Chapter1.isRotation("fazquraishi","quraishifaz"));
//            // Chapter1.rotate90();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        Node a = Node.createList(10, 4, 0, 16, 26, 9, 3);
//        a = Chapter2.partitionAroundValue(a, 15);
//        Node habib = Chapter2.fromLast(a, 2);
//        Chapter2.removeFromMiddleBook(habib);
//        Node b = Node.createList(111);
//        Node c = Node.createList(111);
//        System.out.println(Node.toString(a));
//        ThreeStack a = new ThreeStack();
//        a.push(0, 1);
//        a.push(0, 2);
//        a.push(0, 3);
//        a.push(1, 7);
//        a.push(2, 9);
//        System.out.println(a.pop(0)); //3
//        System.out.println(a.pop(0)); //2
//        System.out.println(a.pop(1)); //7
//        System.out.println(a.pop(0)); //1
//        System.out.println(a.pop(2)); //9

        /*
        QueueFromStack q = new QueueFromStack();
        q.enqueue(7);
        q.enqueue(8);
        q.enqueue(-6);
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
        q.enqueue(-5);
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
        */

//        System.out.println("Hello: I am a number!!   5 ");
//        Tree t = new Tree(3);
//        t.left = new Tree(4);
//        t.left.left = new Tree(5);
//        System.out.println("Hello: I am NOT a number!!");
//
//        System.out.println(Tree.isBalanced(t));
//        GraphNode g = new GraphNode(8);
//        GraphNode temp = null;
//        for(int i = 0; i < 10; i++) {
//            g.addChild(temp = new GraphNode(i));
//        }
//        GraphNode h = new GraphNode(66);
//        h.addChild(temp = new GraphNode(2309432));
//        g.addChild(h);
//        System.out.println(Chapter4.isRoute(h, temp));

        //System.out.println(Chapter7.multiply(5, 4));
        //System.out.println(Chapter7.subtract(4, -5));
        //System.out.println(Chapter7.divide(-20, -5));
//        int n = 5;
//        System.out.println(Chapter7.kthPrime(n));
//        System.out.println(Chapter7.kthPrimeEfficeint(n));

//        Chapter9.addParentheses(0, 0, 3, new char[2 * 3], 0);
//        int[][] image = new int[][] {{1, 1, 1}, {2, 2, 2}, {4, 4, 4}};
//        Chapter9.changeColor(image, new boolean[3][3], 1, 1, 5);

//        System.out.println(Chapter9.makeChange(5));
//        int[] array = new int[] {108, 7, 78, 9};
//        int[] array2 = new int[]{108, 7, 78, 9};
        //Chapter11.mergeSort(array);

        //Chapter11.quickSort(array, 0, array.length - 1);
        //Chapter11.bubbleSort(array2);
        //Chapter11.heapSort(array2);
        //int[] b = new int[] {1, 2, 4, 6, 8, 10, 12, 14};
        //int[] a = new int[] {0, 3, 5, 7, 9, 11, 13, 15, 0, 0, 0, 0, 0, 0, 0, 0};
        //Chapter11.mergeTwo(a, b, 7);
        //System.out.print(Chapter11.binarySearch(array2, 9));
        //Chapter11.rotate(array, 1);
//        String[] ab = new String[] {"a", "", "", "b", "", "", "c", "", "", "d"};
//        System.out.println(Chapter11.search(ab, "d"));
        //int[] a = new int[] {8, 6, 0, 2, 3};
//        RankTree r = Chapter11.readInts(a);
//        System.out.println(r.getRank(9));
//        CircularArray<Integer> g = new CircularArray<Integer>();
//        for(Object o : g){
//            String result = o.toString();
//            System.out.println(result);
//        }
//        ArrayList<String> h = Chapter0.getPerm("abc");
//        for(String k : h){
//            System.out.println(k);
//        }
//        MaxHeap j = new MaxHeap();
//        j.insert(8);
//        j.insert(10);
//        j.insert(12);
//        j.insert(6);
//        j.delete(6);
//        System.out.print(j.toString());
//        MedianTracker mt = new MedianTracker(20);
//        mt.insert(1);
//        mt.insert(2);
//        mt.insert(3);
//        mt.insert(4);
//        mt.insert(5);
//        System.out.println(mt.getMedian());
        //Node a = Node.createList(1, 1, 1);
        //Node result = Review.addReverse(a, a, 0);
        //Review.printKthFromEnd(2, a);
        //System.out.print(Node.toString(result));
//        Random r = new Random();
//        Stack<Integer> j = new Stack<Integer>();
//        for(int i = 0; i < 10; i++){
//            j.push(r.nextInt(200));
//        }
//        Stack<Integer> result = Review.mergeSort(j);
//        System.out.println(result.toString());
//        Tower source = new Tower(0);
//        Tower buffer = new Tower(1);
//        Tower destination = new Tower(3);
//        for(int i = 3; i > 0; i--){
//           source.addDisks(i);
//        }
//        Tower.move(source.getSize(), source, buffer, destination);
//        System.out.println(destination.toString());
        Chapter17.print(7700416);

    }
}
