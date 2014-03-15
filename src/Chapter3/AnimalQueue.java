package Chapter3;

import java.util.LinkedList;

/**
 * Created by lazyCoder455 on 3/14/14.
 */
public class AnimalQueue {
    AnimalNode dogList;
    AnimalNode catList;
    AnimalNode totalList;

    public AnimalQueue() {
    }

    public void enqueue(Dog d) {
        if (totalList == null) {
            totalList = new AnimalNode(d);
            dogList = totalList;
        } else {
            dogList.next = new AnimalNode(d);
        }
    }

    public void enqueue(Cat c) {
        if (totalList == null) {
            totalList = new AnimalNode(c);
            catList = totalList;
        } else {
            catList.next = new AnimalNode(c);
        }

    }

    public Animal dequeueAny() {
        return null;
    }

    public Dog dequeueDog() {
        return null;
    }

    public Cat dequeueCat() {
        return null;
    }
}
