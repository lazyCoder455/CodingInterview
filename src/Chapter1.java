/**
 * Created by Faiz-Note on 3/5/14.
 */
public class Chapter1 {

    public static void main(String[] args) {
        //System.out.println(reverse("Hello, World"));
        System.out.println(addSpace(new char[] {'M','r',' ','J','o','h','n',' ','S','m','i','t','h',' ',' ',' ',' '}, 13));
    }

    public static boolean isUnique(String str) {

        return false;
    }

    public static String reverse(String str) {
        String answer = "";
        char[] characters = str.toCharArray();
        int i = 0;
        int j = characters.length - 1;
        int[] integerRepresentation  = new int[j + 1];
        for(int k = 0; k < j + 1; k++){
            integerRepresentation[k] = (int)characters[k];
        }
        while(i < j) {
            //A XOR B = C
            //C XOR B = A
            //C XOR A = B
            integerRepresentation[i] ^= integerRepresentation[j];
            integerRepresentation[j] ^= integerRepresentation[i];
            integerRepresentation[i] ^= integerRepresentation[j];
            i++;
            j--;
        }

        for(int k = 0; k < characters.length; k++){
            int value = integerRepresentation[k];
            characters[k] = (char)value;
            answer += characters[k];
        }

        return answer;
    }

    public static String addSpace(char[] pattern, int length) {
        int numSpaces = 0, index = 0;
        for(int i = length - 1; i > -1; i--) {
            if(pattern[i] == ' ') {
                numSpaces++;
                index = 1;
            }
        }

        int shift = numSpaces * 2; // the lenght of the replacement pattern - 1
        for(int i = length - 1; i > index - 1; i--) {
            if(pattern[i] == ' ') {
                pattern[i + shift--] = '0';
                pattern[i + shift--] = '2';
                pattern[i + shift] = '%';
            } else {//l
                pattern[i + shift] = pattern[i];
            }
        }
        String answer = "";
        for(int i = 0; i < pattern.length; i++) {
            answer += pattern[i];
        }
        return answer;
    }
}
