package Chapter11;

import Chapter4.Tree;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by faiz on 6/5/14.
 */
public class Chapter11 {

    public static void mergeSort(int[] array) {
        int[] temp = new int[array.length];
        mergeSort(array, temp, 0, array.length - 1);
    }

    private static void mergeSort(int[] array, int[] temp, int low, int high) {
        if((low < high)) {
            int mid = (low + high) / 2;
            mergeSort(array, temp, low, mid);
            mergeSort(array, temp, mid + 1, high);
            merge(array, temp, low, mid, high);
        }
    }

    private static void merge(int[] array, int[] temp, int low, int mid, int high) {
        for(int i = low; i <= high; i++) {
            temp[i] = array[i];
        }

        int lowLeft = low;
        int lowRight = mid + 1;
        int current = low;
        while(lowLeft <= mid && lowRight <= high ) {
            array[current++] = temp[lowLeft] <= temp[lowRight] ? temp[lowLeft++] : temp[lowRight++];
        }

        for(; lowLeft <= mid;) {
            array[current++] = temp[lowLeft++];
        }

    }

    public static void quickSort(int[] array, int left, int right) {

        if(left < right) {
            int p = partition(array, left, right);
            quickSort(array, left, p - 1);
            quickSort(array, p + 1, right);
        }

    }

    private static int partition(int[] array, int left, int right) {
        int partitionIndex = medianOfThree(array, left, right);
        int partitionValue = array[partitionIndex];
        swap(array, partitionIndex, right);
        int swapIndex = left;
        for(int i = left; i < right; i++) {
            if(array[i] <= partitionValue){
                swap(array, i, swapIndex);
                swapIndex++;
            }
        }
        swap(array, swapIndex, right);
        return swapIndex;
    }

    private static int medianOfThree(int[] array, int left, int right) {
        int mid = (left + right) / 2;
        int index = array[left] < array[mid] ? mid : left;
        int other = array [left] < array[mid] ? left : mid;
        return index = array[index] < array[right] ? index : array[right] > array[other] ? right : other;
    }

    private static void swap(int[] array, int a, int b) {
        int temp = array[b];
        array[b] = array[a];
        array[a] = temp;
    }

    public static void selectionSort(int[] array) {
        int minIndex;
        //for all elements
        for(int i = 0; i < array.length; i++) {
            minIndex = i;
            //find smallest
            for(int j = i + 1; j < array.length; j++) {
                //if smaller save index
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            swap(array, minIndex, i);
        }
    }

    public static void bubbleSort(int[] array){
        boolean swap = false;
        do {
            swap = false;
            for(int i = 0; i < array.length - 1; i++) {
                if(array[i] > array[i + 1]) {
                    swap(array, i, i + 1);
                    swap = true;
                }
            }
        } while (swap);
    }

    public static void insertionSort(int[] array) {
        for(int i = 0; i < array.length; i++) {
            int x = array[i];
            int j = i;
            while(j > 0 && array[j - 1] > x) {
                array[j] = array[--j];
            }
            array[j] = x;
        }
    }

    public static void heapSort(int[] array) {
        heapify(array);
        int end = array.length - 1;
        while(end >= 0) {
            swap(array, 0, end);
            end--;
            siftDown(array, 0, end);
        }

    }

    private static void heapify(int[] array) {
        int start = (array.length - 2) / 2;
        while(start >= 0) {
            siftDown(array, start, array.length - 1);
            start--;
        }
    }

    private static void siftDown(int[] array, int root, int end) {

        while(leftChild(root) <= end) {
            int left = leftChild(root);
            int right = rightChild(root);
            int swap = root;
            if(array[root] < array[left]) {
                swap = left;
            }
            if(right <= end && array[swap] < array[right]){
                swap = right;
            }
            if(swap != root) {
                swap(array, swap, root);
                root = swap;
            } else return;
        }

    }

    private static int leftChild(int index) {
        return 2 * index + 1;
    }

    private static int rightChild(int index) {
        return 2 * index + 2;
    }

    private static int getParent(int index) {
        return (index - 1) / 2;
    }

    public static void mergeTwo(int[] a, int[] b, int enda) {
        int endb = b.length - 1;
        int endFull = a.length - 1;
        while(enda >= 0 && endb >= 0) {
            a[endFull--] = a[enda] > b[endb] ? a[enda--] : b[endb--];
        }
        while(endFull >= 0 && endb >= 0) {
            a[endFull--] = b[endb--];
        }
    }

    public static int binarySearch(int[] array, int find) {
        int mid = 0;
        int start = 0;
        int end = array.length - 1;
        while(end >= start) {
            mid = (start + end) / 2;
            if(array[mid] < find){
                start = mid + 1;
            } else if(array[mid] > find) {
                end = mid - 1;
            } else if(array[mid] == find) return mid;
        }
        return -1;
    }

    public static int binarySearch(int[] array, int find, int start, int end) {
        int mid = 0;
        while(end > start) {
            mid = (start + end) / 2;
            if(array[mid] < find){
                start = mid + 1;
            } else if(array[mid] > find) {
                end = mid - 1;
            } else if(array[mid] == find) return mid;
        }
        return -1;
    }

    public static int searchRotated(int[] array, int x){
        int start = 0;
        int end = array.length - 1;
        if(x > array[start] && x < array[end]){
            // no rotation
            return binarySearch(array, x);
        }
        if(x < array[start] && x < array[end]){
            while(array[start] > array[start++]){
                if(array[start] == x) return start;
            }
            return binarySearch(array, x, start, end);
        }
        if(x > array[start] && x > array[end]) {
            while(array[end] > array[end--]){
                if(array[end] == x) return start;
            }
            return binarySearch(array, x, start, end);
        }
        if(x == array[start]) return start;
        if(x == array[end]) return end;
        return -1;
    }

    public static void rotate(int[] array, int direction) {
        if(direction == 0 || direction == array.length) return;
        if(direction > 0) {
            for (int i = 0; i < direction; i++) {
                int temp = array[0];
                for (int j = array.length - 1; j >= 0; j--) {
                    array[(j + 1) % array.length] = array[j];
                }
                array[1] = temp;
            }
        }
        if(direction < 0) {
            direction = Math.abs(direction);
            for(int i = 0; i < direction; i++){
                int temp = array[array.length - 1];
                for(int j = 0; j < array.length; j++) {
                    int index = ((j - 1) % array.length) >= 0 ? ((j - 1) % array.length) : array.length + ((j - 1) % array.length);
                    array[index] = array[j];
                }
                array[array.length - 2] = temp;
            }
        }
    }

    class AnagramCompare implements Comparator<String> {

        public int compare(String a, String b) {
            if(isAnagram(a, b)) return 0;
            return a.compareTo(b);
        }

        private boolean isAnagram(String a, String b) {
            char[] array = a.toCharArray();
            char[] barray = b.toCharArray();
            Arrays.sort(array);
            Arrays.sort(barray);
            String x = new String(array);
            String y = new String(barray);
            return x.compareTo(y) == 0;
        }
    }

    public static int search(String[] array, String find) {
        int start = 0;
        int end = array.length - 1;
        int mid = 0;
        while(end >= start) {
            mid = (start + end) / 2;
            if(array[mid].equals("")){
                int tempRight = mid;
                while(tempRight < end && array[tempRight].equals("")){
                    tempRight++;
                }
                if(array[tempRight].equals(find))return tempRight;
                int tempLeft = mid;
                while(tempLeft > start && array[tempLeft].equals("")){
                    tempLeft--;
                }
                if(array[tempLeft].equals(find))return tempLeft;
                if(array[tempLeft].compareTo(find) < 0 && array[tempRight].compareTo(find) > 0) return -1;
                if(array[tempLeft].compareTo(find) > 0) end = tempLeft;
                if(array[tempRight].compareTo(find) < 0) start = tempRight;
                continue;
            }
            if(array[mid].compareTo(find) < 0){
                start = mid + 1;
            } else if(array[mid].compareTo(find) > 0) {
                end = mid - 1;
            } else if(array[mid].equals(find)) return mid;
        }
        return -1;
    }

    public static int[] search(int[][] mat, int find) {
        int row, column;
        column = 0;
        int end = mat.length - 1;
        int start = 0;
        int mid = 0;
        while(end >= start) {
            mid = (start + end) / 2;
            if(mat[mid][column] < find){
                start = mid + 1;
            } else if(mat[mid][column] > find) {
                end = mid - 1;
            } else if(mat[mid][column] == find) return new int[] {mid, column};
        }
        row = mid;
        start = 0;
        end = mat[0].length - 1;
        while(end >= start) {
            mid = (start + end) / 2;
            if(mat[row][mid] < find){
                start = mid + 1;
            } else if(mat[row][mid] > find) {
                end = mid - 1;
            } else if(mat[row][mid] == find) return new int[] {row, mid};
        }

        return new int[] {-1, -1};
    }

    public static ArrayList<Person> maxTower(Person[] p, int start) {
        int max_height = 0;
        int current_height = 0;
        Person bottom = p[start];
        ArrayList<Person> maxTower = null;
        for(int i = 0; i < p.length; i++) {
            if(i == start) continue;
            if(bottom.canBeOnTop(p[i])){
                ArrayList<Person> newTower = maxTower(p, i);
                current_height = Chapter11.getHeight(newTower);
                if(current_height > max_height) {
                    max_height = current_height;
                    maxTower = newTower;
                }
            }
        }

        if(maxTower == null) {
            maxTower = new ArrayList<Person>();
        }

        maxTower.add(0, bottom);
        return maxTower;

    }

    public static int getHeight(ArrayList<Person> ppl){
        int ht = 0;
        for(Person p : ppl){
            ht += p.ht;
        }
        return ht;
    }

    public static RankTree readInts(int[] file){
        RankTree r = new RankTree(file[0]);
        for(int i = 1; i < file.length; i++) {
            RankTree t = new RankTree(file[i]);
            RankTree.rankAddBST(r, t);
        }
        return r;
    }

}
