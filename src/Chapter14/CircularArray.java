package Chapter14;

import java.util.Iterator;

/**
 * Created by faiz on 6/18/14.
 */
public class CircularArray<T> implements Iterable<Object>, Iterator<Object> {
    private int offset = 0;
    private int size = 10;
    int currentIndex = 0;
    int iterationIndex = 0;
    private Iterator<Object> iter;
    private Object[] elements;

    public CircularArray() {
        elements = new Object[size];
        this.initialize();
    }

    public CircularArray(int size){
        this.size = size;
        elements = new Object[size];
        this.initialize();
    }

    private void initialize(){
        for(int i = 0; i < size; i++){
            elements[i] = i;
        }
    }

    public Object get(int index){
        return elements[calculateIndex(index)];
    }

    public String toString() {
        String str = "";
        for(int i = 0; i < size; i++){
            str += elements[calculateIndex(i)].toString() + " ";
        }
        return str;
    }

    public int length() {
        return this.size;
    }

    private int calculateIndex() {
        return calculateIndex(currentIndex);
    }

    private int calculateIndex(int i){
        int index = (i + offset) % size;
        return index < 0 ? index + size : index;
    }

    public void pseudoRotateRight(int x) {
        offset -= x;
    }

    public void pseudoRotateLeft(int x){
        offset =+ x;
    }

    public Iterator<Object> iterator() {
        iterationIndex = 0;
        return this;
    }

    public boolean hasNext() {
        return iterationIndex < size;
    }

    @Override
    public Object next() {
        Object e;
        do {
            e = elements[calculateIndex(iterationIndex)];
            iterationIndex++;
        } while(e == null);
        return e;
    }

    @Override
    public void remove() {
        elements[calculateIndex(iterationIndex)] = null;
        size--;
        Object e;
        do {
            e = elements[calculateIndex(iterationIndex)];
            iterationIndex--;
        } while (e == null);
    }
}
