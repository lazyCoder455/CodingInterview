package Chapter0;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

/**
 * Created by faiz on 6/19/14.
 */
public class Chapter0 {

    /**
     * Gets the angle between the hour and minute hand for
     * a given time.
     * This is an examplify example.
     * @param hour
     * @param minute
     * @return
     */
    public static int angle(int hour, int minute) {
        //angle for minute = minute * 360 / 60;
        //angle for minute = minute * 6;

        //angle for hour = hour * 360 / 12 + minute * (360 / 12 / 60)
        //angle for hour - angle for minute
        // 30 * hour + 1/2 * minute - 6 * minute

        //get hour in 12hr format
        hour %= 12;
        int angle = (int)Math.abs(30 * hour - 5.5 * minute);
        return angle % 360;
    }

    /**
     * finds the minimum element from a rotated array
     * this is a pattern matching approach with binary search
     * @param list
     * @return
     */
    public static int findMinimumRotated(int[] list){
        int low = 0;
        int high = list.length - 1;
        int mid;
        while(list[low] >= list[high] && low < high){
            //the list is unsorted
            //focus on the unsorted part
            mid = (low + high) / 2;
            if(list[mid] > list[high]){
                //mid is greater than high
                //the right half is unsorted
                low = mid + 1;
            } else {
                //the left half is unsorted
                high = mid;
            }
        }

        return list[low];
    }

    public static boolean canForm(String[] words, String[] magazine){
        HashMap<String, Integer> wordFreq = putInHash(words);
        HashMap<String, Integer> magFreq = putInHash(magazine);
        Set<String> set = wordFreq.keySet();
        for(String w : set){
            if(!magFreq.containsKey(w) || wordFreq.get(w) > magFreq.get(w)){
                return false;
            }
        }
        return true;

    }

    private static HashMap<String, Integer> putInHash(String[] words){
        HashMap<String, Integer> wordFreq = new HashMap<String, Integer>();
        for(String item : words){
            if(!wordFreq.containsKey(item)){
                wordFreq.put(item, 1);
            } else {
                wordFreq.put(item, wordFreq.get(item) + 1);
            }
        }
        return wordFreq;
    }

    /**
     * Gets all the permutations of a string.
     * This is a base case and build example
     * @param str
     * @return
     */
    public static ArrayList<String> getPerm(String str){
        if(str.length() == 1) {
            ArrayList<String> result = new ArrayList<String>();
            result.add(str);
            return result ;
        }
        char addition = str.charAt(str.length() - 1);
        ArrayList<String> temp = getPerm(str.substring(0, str.length() - 1));
        ArrayList<String> result = new ArrayList<String>();
        for(String s : temp){
            result.add(s + addition);
            for(int i = 1; i < s.length(); i++){
                String r = s.substring(0, i) + addition + s.substring(i, s.length());
                result.add(r);
            }
            result.add(addition + s);
        }
        return result;

    }
}
