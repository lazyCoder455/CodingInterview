package Chapter0;

/**
 * Created by faiz on 6/20/14.
 */
public abstract class Heap {
    protected int[] heap;
    protected int capacity = 10;
    protected int insertionIndex = 0;

    public Heap() {
        heap = new int[capacity];
    }

    public Heap(int capacity){
        this.capacity = capacity;
        heap = new int[capacity];
    }

    public void insert(int element){
        if(insertionIndex == capacity){
            insertionIndex++;
            int[] newheap = new int[capacity * 2];
            for(int i = 0; i < capacity; i ++){
                newheap[i] = heap[i];
            }
            capacity *= 2;
            heap = newheap;
        }
        heap[insertionIndex] = element;
        siftUp(insertionIndex++);
    }

    protected int remove(int element){
        if(insertionIndex == 0) return -1;
        int i = 0;
        for(; i < heap.length; i++){
            if(heap[i] == element) break;
        }
        if(i == insertionIndex - 1){
            insertionIndex--;
            return -1;
        }
        swap(i, insertionIndex - 1);
        insertionIndex--;
        return i;
    }

    public abstract void delete(int element);

    protected abstract void siftUp(int child);

    protected abstract void siftDown(int parent);

    protected void swap(int a, int b){
        int temp = heap[b];
        heap[b] = heap[a];
        heap[a] = temp;
    }

    public int size() {
        return insertionIndex;
    }

    public int getRoot(){
        return heap[0];
    }

    protected int getParent(int child){
        return (child - 1) / 2;
    }

    protected int getRight(int root){
        return root * 2 + 2;
    }

    protected int getLeft(int root){
        return root * 2 + 1;
    }

    public String toString() {
        String str = "";
        for(int i = 0; i < insertionIndex; i++){
            str += heap[i] + " ";
        }
        return str;
    }
}
