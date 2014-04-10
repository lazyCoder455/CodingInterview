package mmh.pre_ch1;

/**
 * Created by habibmostafa on 3/23/2014.
 * Book: CTCI
 * VI Technical Questions: Five Algorithm Approaches
 * Approach I: Examplify
 * Page 52
 *
 */
public class HourAngle {
    private double m; // minutes
    private double h; // hours

    /**
     * Constructor.
     */
    public HourAngle(double h, double m){
        this.h = h;
        this.m = m;
    }

    public double AngleBetweenMand12(){
        return 360.0 * m / 60.0;
    }

    public double AngleBetweenHand12(){
        return 360.0 * (h % 12.0) / 12.0 + 360.0 * (m / 60.0) * (1.0 / 12.0);
    }

    public double AngleBetweenHandM(){
        // (ha.AngleBetweenHand12() - ha.AngleBetweenMand12()) % 360.0
        return (30.0 * h - 5.5 * m) % 360;
    }

    public static void main(String [] args){
        HourAngle ha = new HourAngle(3,27);
        System.out.println(15 % 12);
        System.out.println(ha.AngleBetweenMand12());
        System.out.println(ha.AngleBetweenHand12());
        System.out.println(ha.AngleBetweenHandM());
    }
}
