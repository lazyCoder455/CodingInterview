package mmh.pre_ch1;

import java.util.PriorityQueue;

/**
 * Created by habibmostafa on 4/8/2014.
 *
 */
public class MedianOfExpandingDataStructure {
    // create data structure
    PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
    PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>();

    public MedianOfExpandingDataStructure(){

    }

    /**
     * Add number then make sure it's balanced.
     * @param newNumber
     */
    public void addNumber(int newNumber){
        // if both empty put in minHeap.
        // if <= minHeap.peek, put in minHeap
        // if > minHeap.peek, put in maxHeap
        // if maxHeap.size > minHeap.size, minHeap.add(maxHeap.poll)
        // if minHeap.size - maxHeap.size > 1, maxHeap.add(minHeap.poll)
        if(minHeap.isEmpty() && maxHeap.isEmpty()){
            minHeap.add(newNumber);
        }else if(newNumber <= minHeap.peek()){
            System.out.println(minHeap.peek());
            minHeap.add(newNumber);
        }else if(newNumber > minHeap.peek()){
            System.out.println(minHeap.peek());
            maxHeap.add(newNumber);
        }

        if(maxHeap.size() > minHeap.size()){
            maxHeap.add(maxHeap.poll());
        }else if(minHeap.size() - maxHeap.size() > 1){
            maxHeap.add(minHeap.poll());
        }
    }

    /**
     * To calculate the median.
     * If n is odd then Median (M) = value of ((n + 1)/2)th item term.
     * If n is even then Median (M) = value of [((n)/2)th item term + ((n)/2 + 1)th item term ]/2
     *
     *
     *
     */
    public int getMedian(){
        int [] minArr = new int[minHeap.size()];
        int [] maxArr = new int[maxHeap.size()];

        int i = 0;
        while(!minHeap.isEmpty()){minArr[i++] = minHeap.poll();}
        i=0;
        while(!maxHeap.isEmpty()){maxArr[i++] = maxHeap.poll();}

//        for(int k = 0; i < minArr.length; i++){
//
//        }
        if(minArr.length > minArr.length){
            return maxArr[maxArr.length-1];
        }else if(minHeap.size() > maxHeap.size()){
            return minArr[0];
        }else{
            return ( maxHeap.poll() + minHeap.poll() ) / 2;
        }
    }

    public static void main(String [] args){
        MedianOfExpandingDataStructure mea = new MedianOfExpandingDataStructure();
        mea.addNumber(1);
        mea.addNumber(-20);
        mea.addNumber(-100);
        mea.addNumber(210);
        mea.addNumber(-310);
        mea.addNumber(2);

        System.out.println(mea.getMedian());
    }
}
