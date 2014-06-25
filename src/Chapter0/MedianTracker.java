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
        //size req
        if(max.size() == min.size()){
            //go to value req
            if(max.size() == 0) {
                max.insert(element);
                return;
            }
            if(element > max.getRoot()){
                min.insert(element);
                return;
            } else {
                max.insert(element);
                return;
            }
        }
        if(max.size() - min.size() == 1){
            //we cannot add into max yet
            if(element > max.getRoot()){
                min.insert(element);
                return; //we done
                // we didnt have to add to max
            } else {
                min.insert(max.getRoot());
                max.delete(max.getRoot());
                max.insert(element);
                return;
            }
        }
        if(min.size() - max.size() == 1){
            //we cannot add to min yet
            if(element < max.getRoot()){
                max.insert(element);
                return; //we done
            } else {
                max.insert(min.getRoot());
                min.delete(min.getRoot());
                min.insert(element);
                return;
            }
        }

    }

    public String toString() {
        String str = "";
        for(int i = 0; i < insertionIndex; i++){
            str += data[i] + " ";
        }
        return str;
    }
}
