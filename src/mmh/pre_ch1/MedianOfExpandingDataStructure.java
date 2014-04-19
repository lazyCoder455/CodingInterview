package mmh.pre_ch1;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Created by habibmostafa on 4/8/2014.
 *
 */
public class MedianOfExpandingDataStructure {
    // create data structure
    PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(2, Collections.reverseOrder());
    PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(2);

    public MedianOfExpandingDataStructure(){

    }

    /**
     * Add number then make sure it's balanced.
     * @param newNumber
     */
    public void addNumber(int newNumber){
        // if both empty, put in maxHeap.
        // if n <= maxHeap.peek, put in minHeap
        // if n > maxHeap.peek, put in maxHeap
        // if maxHeap.size > minHeap.size, minHeap.add(maxHeap.poll)
        // if maxHeap.size - minHeap.size > 1, maxHeap.add(minHeap.poll)
        // if minHeap.size - maxHeap.size > 1, minHeap.add(maxHeap.poll)

        if(minHeap.isEmpty() && maxHeap.isEmpty()){
            maxHeap.add(newNumber);
        }else if(newNumber <= maxHeap.peek()){
            minHeap.add(newNumber);
        }else if(newNumber > maxHeap.peek()){
            maxHeap.add(newNumber);
        }

        if(minHeap.size() > maxHeap.size()){
            maxHeap.add(minHeap.poll());
        }else if(maxHeap.size() - minHeap.size() > 1){
            minHeap.add(maxHeap.poll());
        }
    }

    /**
     * To calculate the median.
     * If n is odd then Median (M) = value of ((n + 1)/2)th item term.
     * If n is even then Median (M) = value of [((n)/2)th item term + ((n)/2 + 1)th item term ]/2
     *
     */
    public double getMedian(){
        System.out.println(maxHeap.peek());
        System.out.println(minHeap.peek());
        if(maxHeap.size() == minHeap.size()){
            return (maxHeap.poll().doubleValue() + minHeap.poll().doubleValue()) / 2.0;
        }else if(maxHeap.size() > minHeap.size()){
            return maxHeap.poll().doubleValue() / 2.0;
        }else{
            return maxHeap.poll().doubleValue() / 2.0;
        }
    }

    public static void main(String [] args){
        MedianOfExpandingDataStructure mea = new MedianOfExpandingDataStructure();

        mea.addNumber(1);
        mea.addNumber(-20);
        mea.addNumber(-100);
        mea.addNumber(210);
        mea.addNumber(-310);
        mea.addNumber(-200);
        mea.addNumber(200);
        mea.addNumber(165);

        System.out.println(mea.getMedian());
    }
}
