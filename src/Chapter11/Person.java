package Chapter11;

/**
 * Created by faiz on 6/11/14.
 */
public class Person {
    public int ht;
    public int wt;

    public Person(int ht, int wt) {
        this.ht = ht;
        this.wt = wt;
    }

    public boolean canBeOnTop(Person p) {
        return this.ht >= p.ht && this.wt >= p.wt;
    }
}
