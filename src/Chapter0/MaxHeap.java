package Chapter0;

/**
 * Created by faiz on 6/20/14.
 */
public class MaxHeap extends Heap{

    public MaxHeap() {
        super();
    }

    public MaxHeap(int capacity){
        super(capacity);
    }

    public void delete(int element){
        int i = super.remove(element);
        if(i < 0) return;
        if(heap[i] > heap[getParent(i)]){
            siftUp(i);
        } else if (heap[i] < heap[getRight(i)] || heap[i] < heap[getLeft(i)]){
            siftDown(i);
        }
    }

    protected void siftUp(int child) {
        int parent = getParent(child);
        while(parent >= 0 && heap[child] > heap[parent]){
            swap(child, parent);
            child = parent;
            parent = getParent(child);
        }

    }

    protected void siftDown(int parent) {
        int right = getRight(parent);
        int left = getLeft(parent);
        while(right < insertionIndex && left < insertionIndex) {
            if(right < insertionIndex && left < insertionIndex){
                //both children valid
                if(heap[parent] < heap[right] || heap[parent] < heap[left]){
                    if(heap[right] > heap[left]){
                        swap(parent, right);
                        parent = right;
                    } else {
                        swap(parent, left);
                        parent = left;
                    }
                }
            } else if(right < insertionIndex && left >= insertionIndex){
                if(heap[parent] < heap[right]){
                    swap(parent, right);
                    parent = right;
                }
            }
            right = getRight(parent);
            left = getLeft(parent);
            if(heap[parent] >= heap[left] && (right >= insertionIndex || heap[parent] >= heap[right]))break;
        }

    }
}
