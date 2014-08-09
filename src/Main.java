import Chapter1.Chapter1;
import Chapter2.Chapter2;
import Chapter2.Node;
import Chapter3.QueueFromStack;
import Chapter3.ThreeStack;
import Chapter4.Chapter4;
import Chapter4.GraphNode;
import Chapter4.Tree;
import Chapter7.Chapter7;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

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
        int n = 5;
        System.out.println(Chapter7.kthPrime(n));
        System.out.println(Chapter7.kthPrimeEfficeint(n));


    }
}
