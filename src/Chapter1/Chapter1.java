package Chapter1;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.File;

/**
 * Created by lazyCoder455 on 3/5/14.
 */
public class Chapter1 {

    public static boolean isUnique(String str) {
        int checker = 0;
        for(int i=0; i < str.length(); i++){
            int letterA = 'a';
            int val = str.charAt(i)-letterA;
            int temp = (1 << val);
            if((checker & temp) > 0){
                return false;
            }
            checker |= (1 << val);
            //checker = checker | (1 << val);
        }
        return true;
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

    public static boolean isRotation(String str1, String str2) {
        if(str1.length() != str2.length()) return false;
        String str3 = str1 + str1;
        return str3.contains(str2.subSequence(0, str2.length()));
        //return isSubstring(str3, str2);

    }

    public static void setToZero(int[][] matrix) {
        boolean[] rows = new boolean[matrix.length];
        boolean[] columns = new boolean[matrix[0].length];

        //iterate through the matrix by rows then columns
        for(int j = 0; j < columns.length; j++) {
            for(int i = 0; i < rows.length; i++) {
                if(matrix[i][j] == 0) {
                    rows[i] = true;
                    columns[i] = true;
                }
            }
        }
        //set the rows to zero
        for(int i = 0; i < rows.length; i++) {
            if(rows[i]) {
                for(int j = 0; j < matrix[0].length; j++) {
                    matrix[i][j] = 0;
                }
            }
        }

        for(int i = 0; i < columns.length; i++) {
            if(columns[i]) {
                for(int j = 0; j < matrix.length; j++) {
                    matrix[j][i] = 0;
                }
            }
        }
    }

    // 1.6
    public static int[][] rotate90() throws IOException {
        //BufferedImage originalImage = ImageIO.read(new File("c:\\image\\mypic.jpg"));
        int[][] image = new int[][]{{1, 0, 0}, {0, 1, 0}, {0, 0, 1}};
        int rows = image.length;
        int columns = image[0].length;
        int n = rows -1;
        //indexing will be as:
        // imageInByte[i + j * columns] = img[i][j];
        /*
            what are the rotations?
            img[0][0] -> img[n][0]
            img[n][0] -> img[n][n]
            img[n][n] -> img[0][n]
            img[0][n] -> img[0][0]
            in general
            img[i][j] -> img[n - j][i]
         */
        //iterate through the matrix
        for (int i = 0; i < rows / 2; i++) {
            for (int j = i; j < columns / 2; j++) {
                //do the switching
                //extract for easier use
                //do for each channel
                int a = image[i][j];
                int b = image[n - j][i];
                int c = image[n - i][n - j];
                int d = image[n - n + j][n - i];

                //move b into a and a into b
                a ^= b;
                b ^= a;
                a ^= b;

                // move a into c and c into a
                c ^= a;
                a ^= c;
                c ^= a;

                // move a into d and d into a
                d ^= a;
                a ^= d;
                d ^= a;
                image[i][j] = a;
                image[n - j][i] = b;
                image[n - i][n - j] = c;
                image[n - n + j][n - i] = d;
            }
        }

        return image;

    }
}
