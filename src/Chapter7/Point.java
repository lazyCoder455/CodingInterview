package Chapter7;

/**
 * Created by faiz on 5/28/14.
 */
public class Point {
    public int x;
    public int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public boolean equals(Object o) {
        if(!(o instanceof Point)) return  false;
        Point other = (Point)o;
        return this.x == other.x && this.y == other.y;
    }
}
