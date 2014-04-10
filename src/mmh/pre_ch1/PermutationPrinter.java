package mmh.pre_ch1;

import java.util.*;

/**
 * Created by habibmostafa on 3/31/2014.
 * Book: CTCI
 * VI Technical Questions: Five Algorithm Approaches
 * Approach II: Simplify and Generalize
 * Page 53
 *
 */
public class PermutationPrinter {
    public PermutationPrinter(){

    }

    public ArrayList<String> getPermutations(String currentStr){
        // if currentString.length == 1, then return 1 permutation with {"currentStr"}
        // else insert lastChar of currentStr in all locations of all permutations of getPermutations(currentStr-1)
        // add return newPermutations
        ArrayList<String> tempPermutations = new ArrayList<String>();
        ArrayList<String> newPermutations = new ArrayList<String>();
        String tempStr;
        String newPermutation;
        int lastIndex = currentStr.length()-1;
        char lastChar = currentStr.charAt(lastIndex);
        String newStr = currentStr.substring(0,lastIndex);
        LinkedList<Character> ll;

        if(currentStr.length() == 1) {
            tempPermutations.add(currentStr);
            return tempPermutations;
        }else{
            tempPermutations = getPermutations(newStr);
            //tempPermSize = tempPermutations.size();
            while(tempPermutations.size() > 0){
                tempStr = tempPermutations.get(0);
                tempPermutations.remove(0);
                ll = new LinkedList<Character>();
                for (int i = 0; i < tempStr.length(); i++) {
                    ll.add(tempStr.charAt(i));
                }
                for (int j = 0; j < ll.size()+1; j++) {
                    ll.add(j, lastChar);
                    newPermutation = "";
                    for (int k = 0; k < ll.size(); k++) {
                        newPermutation += "" + ll.get(k);
                    }
                    ll.remove(j);
                    newPermutations.add(newPermutation);
                }
            }
            return newPermutations;
        }
    }

    public static void main(String [] args){
        PermutationPrinter pp = new PermutationPrinter();

        //String [] str_arr = {"a"};
        ArrayList<String> tempArr = pp.getPermutations("a");
        System.out.println(tempArr.toString());

        tempArr = pp.getPermutations("ab");
        System.out.println(tempArr.toString());

        tempArr = pp.getPermutations("abc");
        System.out.println(tempArr.toString());

        tempArr = pp.getPermutations("abcd");
        System.out.println(tempArr.toString());
        System.out.println(tempArr.size()); // fact(length of current string)
    }
}
