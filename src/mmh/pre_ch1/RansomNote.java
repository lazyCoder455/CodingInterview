package mmh.pre_ch1;

import java.util.Hashtable;

/**
 * Created by habibmostafa on 3/28/2014.
 * Book: CTCI
 * VI Technical Questions: Five Algorithm Approaches
 * Approach II: Simplify and Generalize
 * Page 53
 *
 */
public class RansomNote {

    private String ransomNote;
    public RansomNote(String ransomNote){
        this.ransomNote = ransomNote;
    }

    public boolean canBeFormedFromMagCharactersOnly(String magazine){
        boolean canBeFormed = false;
        Hashtable<Integer,Integer> rn_letters = new Hashtable<Integer,Integer>();
        char[] rn_array = ransomNote.toCharArray();
        for(char c : rn_array){
            if(rn_letters.containsKey((int)c)){
                int temp = rn_letters.remove((int)c);
                rn_letters.put((int)c,++temp);
            }else{
                rn_letters.put((int)c,1);
            }
        }

        for(int i=0; i< magazine.length(); i++) {
            int rn_val = (int) magazine.charAt(i);
            if(rn_letters.containsKey(rn_val)){
                int temp = rn_letters.get(rn_val);
                if(temp > 0) {
                    rn_letters.remove(rn_val);
                    rn_letters.put(rn_val,--temp);
                }
            }
        }

        for(int i: rn_letters.keySet()){
            if(rn_letters.get(i) > 0){
                canBeFormed = false;
                break;
            }else{
                canBeFormed = true;
            }
        }
        return canBeFormed;
    }

    public boolean canBeFormedFromMag(String magazine){
        boolean canBeFormed = false;
        Hashtable<String,Integer> rn_words = new Hashtable<String,Integer>();
        String [] rn_words_arr = ransomNote.split(" ");
        for(String s: rn_words_arr){
            rn_words.put(s,1);
        }

        String [] mag_arr = magazine.split(" ");
        for(String str: mag_arr) {
            if (rn_words.containsKey(str)) {
                int temp = rn_words.get(str);
                if (temp > 0) {
                    rn_words.remove(str);
                    rn_words.put(str, --temp);
                }
            }
        }

        for(String str: rn_words.keySet()){
            if(rn_words.get(str) > 0){
                canBeFormed = false;
                break;
            }else{
                canBeFormed = true;
            }
        }

        return canBeFormed;
    }

    public static void main(String [] args){
        // character count
//        RansomNote rn = new RansomNote("swag time"); // should return true
//        RansomNote rn2 = new RansomNote("abcdefghijklmnopqrstuvwxyz");
//        String magazine = "Hi, I am a Magazine. Has a ransom note been written using me?";
//        System.out.println(rn.canBeFormedFromMagCharactersOnly(magazine));
//        System.out.println(rn2.canBeFormedFromMagCharactersOnly(magazine));

        // string count
        String magazine = "Hi, I am a Magazine. Has a ransom note been written using me?";
        RansomNote rn3 = new RansomNote("been ransom am magazine"); // should return false
        RansomNote rn4 = new RansomNote("been ransom am Magazine. Hi,"); // should return true
        RansomNote rn5 = new RansomNote("a bc def ghi jklmn opq rst uv wx y z"); // should return false
        System.out.println(rn3.canBeFormedFromMag(magazine));
        System.out.println(rn4.canBeFormedFromMag(magazine));
        System.out.println(rn5.canBeFormedFromMag(magazine));
//
//        for(int i = 0; i<letters.length; i++) {
//            System.out.print(letters[i] + ", ");
//        }
       // System.out.println(rn.canBeFromMag(magazine));
    }

}
