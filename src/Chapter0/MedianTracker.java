package Chapter0;

/**
 * Created by faiz on 6/20/14.
 */
public class MedianTracker {
    private Heap min;
    private Heap max;
    private int[] data;
    private int insertionIndex = 0;
    private int capacity = 10;

    public MedianTracker() {
        data = new int[capacity];
        initHeaps();
    }

    public MedianTracker(int capacity){
        this.capacity = capacity;
        data = new int[capacity];
        initHeaps();
    }

    private void initHeaps(){
        min = new MinHeap(capacity);
        max = new MaxHeap(capacity);
    }

    public int getMedian() {
        if(min.size() == max.size()){
            return (max.getRoot() + min.getRoot()) / 2;
        }
        if(max.size() > min.size()){
            return max.getRoot();
        }
        return min.getRoot();
    }

    public void insert(int element){
        data[insertionIndex++] = element;
        if(min.size() < max.size()){
            min.insert(element);
        } else {
            max.insert(element);
        }
    }
}
