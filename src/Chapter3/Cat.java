package Chapter3;

/**
 * Created by lazyCoder45s5 on 3/14/14.
 */
public class Cat extends Animal {

    public static final String message = "Meow. I'm a cat. May name is ";

    public Cat(String name) {
        super(name);
    }

    public String toString() {
        return message + name + ".";
    }
}
