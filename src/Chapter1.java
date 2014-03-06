import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * Created by Faiz-Note on 3/5/14.
 */
public class Chapter1 {

    public static void main(String[] args) {
        //System.out.println(reverse("Hello, World"));
        System.out.println(addSpace(new char[] {'M','r',' ','J','o','h','n',' ','S','m','i','t','h',' ',' ',' ',' '}, 13));
    }

    public static boolean isUnique(String str) {
        //add it, mostafa
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

    public static boolean isRotation(String str1, String str2) {
        if(str1.length() == str2.length()) return false;
        String str3 = str1 + str2;
        //return isSubstring(str3, str2);
        return false;

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

    public static void rotate90(BufferedImage img) throws IOException {
        //BufferedImage originalImage = ImageIO.read(new File("c:\\image\\mypic.jpg"));
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(img, "jpg", baos);
        baos.flush();
        byte[] imageInByte = baos.toByteArray();
        baos.close();
        //rows must = columns
        int rows = img.getHeight();
        int columns = img.getWidth();
        int n = rows - 1;
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
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < columns; j++) {
                //do the switching
                //extract for easier use
                int a = imageInByte[i + j * columns];
                int b = imageInByte[(n - j) + i * columns];
                int c = imageInByte[n - i + (n - j) * columns];
                int d = imageInByte[(n - n + j) + (n - i) * columns];
            }
        }
    }
}
