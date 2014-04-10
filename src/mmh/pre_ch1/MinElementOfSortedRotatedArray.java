package mmh.pre_ch1;

/**
 * Created by habibmostafa on 3/23/2014.
 * Book: CTCI
 * VI Technical Questions: Five Algorithm Approaches
 * Approach II: Pattern Matching
 * Page 52
 *
 */
public class MinElementOfSortedRotatedArray {

    private int [] sArray;
    public MinElementOfSortedRotatedArray(int [] sArr){
        this.sArray = sArr;
    }

    public int indexOfMinElement(){
        int length = sArray.length;
        int lowIndex = 0;
        //int low = sArray[lowIndex];
        int highIndex = length -1;
        //int high = sArray[highIndex];
        int midIndex = (highIndex - lowIndex) / 2;
        int minIndex = lowIndex;
        if(sArray[highIndex] > sArray[lowIndex]){ // meaning it's not rotated, only sorted
            minIndex = lowIndex;
            return minIndex;
        }

        if(sArray[highIndex] < sArray[lowIndex] && length <= 2){
            minIndex = highIndex;
            return minIndex;
        }

        while(lowIndex < midIndex && midIndex < highIndex) {
            if (sArray[midIndex] < sArray[lowIndex]) {
                minIndex = midIndex;
                highIndex = midIndex;
                midIndex = lowIndex + ((highIndex - lowIndex) / 2);
            }else if (sArray[highIndex] < sArray[midIndex]) {
                minIndex = highIndex;
                lowIndex = midIndex;
                midIndex = lowIndex + ((highIndex - lowIndex) / 2);
            }
        }
        return minIndex;
    }

    public static void main(String [] args){
        int [] sArray = {1,2,3,30,-21,-10};
        MinElementOfSortedRotatedArray mESRA = new MinElementOfSortedRotatedArray(sArray);
        System.out.println(mESRA.indexOfMinElement());
    }
}
