package Chapter3;

import java.util.LinkedList;

/**
 * Created by lazyCoder455 on 3/14/14.
 */
public class AnimalQueue {
    AnimalNode dogList = new AnimalNode();
    AnimalNode catList = new AnimalNode();
    AnimalNode totalList = new AnimalNode();

    AnimalNode dogTail;
    AnimalNode catTail;
    AnimalNode tail;

    public AnimalQueue() {
        dogTail = dogTail;
        catTail = catList;
        tail = totalList;
    }

    public void enqueue(Dog d) {
        if (totalList.animal == null) {
            totalList.next = new AnimalNode(d);
            dogList.next = totalList;
            dogTail = dogList.next;
            tail = dogTail;
        } else {
            dogTail.next = new AnimalNode(d);
            dogTail = dogTail.next;
        }
    }

    public void enqueue(Cat c) {
        if (totalList.animal == null) {
            totalList.next = new AnimalNode(c);
            catList.next = totalList;
            catTail = catList.next;
            tail = catTail;
        } else {
            catTail.next = new AnimalNode(c);
            catTail = catTail.next;
        }
    }

    public Animal dequeueAny() {
        Animal a = totalList.next.animal;
        if (totalList == dogList) {
            dogList.next = dogList.next.next;
        }
        if (catList == totalList) {
            catList.next = catList.next.next;
        }
        totalList.next = totalList.next.next;
        return a;
    }

    public Dog dequeueDog() {
        Dog d = (Dog) dogList.next.animal;
        if (totalList == dogList) {
            totalList.next = totalList.next.next;
        }
        return d;
    }

    public Cat dequeueCat() {
        Cat c = (Cat) catList.next.animal;
        if (totalList == catList) {
            totalList.next = totalList.next.next;
        }
        return c;
    }
}
