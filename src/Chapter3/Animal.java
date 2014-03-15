package Chapter3;

/**
 * Created by lazyCoder455 on 3/14/14.
 */
public abstract class Animal {
    protected String name;

    public Animal(String name) {
        this.name = name;
    }

    public abstract String toString();
}
