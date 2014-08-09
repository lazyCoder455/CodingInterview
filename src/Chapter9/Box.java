package Chapter9;

/**
 * Created by faiz on 6/2/14.
 */
public class Box {
    public int height;
    public int width;
    public int depth;

    public Box(int width, int height, int depth) {
        this.width = width;
        this.height = height;
        this.depth = depth;
    }

    public boolean isLarger(Box other) {
        return this.width * this.height * this.depth
                >= other.width * other.height * other.depth;
    }
}
