import Chapter1.Chapter1;

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
        try {
            BufferedImage image = ImageIO.read(new File("fb_original.bmp"));
            Chapter1.rotate90(image);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
