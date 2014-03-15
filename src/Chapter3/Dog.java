package Chapter3;

/**
 * Created by lazyCoder455 on 3/14/14.
 */
public class Dog extends Animal {

    private static final String message = "Wowf! I am a  dog! My name is ";

    public Dog(String name) {
        super(name);
    }

    public String toString() {
        return message + name + ".";
    }
}
