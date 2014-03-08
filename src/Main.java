import Chapter1.Chapter1;
import Chapter2.Chapter2;
import Chapter2.Node;
import com.sun.org.apache.xml.internal.security.utils.CachedXPathFuncHereAPI;

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
        Node a = Node.createList(10, 4, 0, 16, 26, 9, 3);
        a = Chapter2.partitionAroundValue(a, 15);
//        Node habib = Chapter2.fromLast(a, 2);
//        Chapter2.removeFromMiddleBook(habib);
        Node b = Node.createList(111);
        Node c = Node.createList(111);
        System.out.println(Node.toString(a));
    }
}
