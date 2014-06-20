package Chapter7;

import java.util.ArrayList;

/**
 * Created by faiz on 5/28/14.
 */
public class Line {
    public double m;
    public double b;
    public ArrayList<Point> points = new ArrayList<Point>();

    public Line(double slope, double intercept) {
        this.m = slope;
        this.b = intercept;
    }

    public Line(Point a, Point c) {
        m = (a.y - c.y) / (a.x - c.x);
        b = -(m * a.x - a.y);
    }

    public void addPoint(Point a) {
        if(onLine(a) && !points.contains(a)) points.add(a);
    }

    public boolean onLine(Point a) {
        return a.y <= m * a.x + b + 0.05 && a.y >= m * a.x + b - 0.05;
    }

    @Override
    public String toString() {
        return "y = " + m + "x" + " + " + b;
    }

    @Override
    public boolean equals(Object c) {
        Line b;
        if(c instanceof Line) {
            b = (Line)c;
        } else {
            return false;
        }
        return this.m == b.m && this.b == b.b;
    }
}
