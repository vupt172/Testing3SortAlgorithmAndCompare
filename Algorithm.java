import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.*;

public class Algorithm {
    /**
     * Writing the array read from input array arr to file
     *
     * @param fileName The file name of file to write value
     * @param arr      The input float array
     *
     */
    public void writeFile(String fileName, float arr[]) {
        try {
            File newFile = new File(fileName);
            FileOutputStream output = new FileOutputStream(newFile);
            String content = "";
            for (float val : arr) {
                content += val + " ";
            }
            byte buff[] = content.getBytes();
            output.write(buff);
            output.close();
        } catch (Exception e) {
            System.out.println("WriteFile() occurs error :" + e.getMessage());
        }
    }
    /**
     * Writing the array read from input array arr to file
     *
     * @param fileName The file name of file to write value
     * @param arr      The input int array
     *
     */
    public void writeFile(String fileName, int arr[]) {
        try {
            FileOutputStream output = new FileOutputStream(fileName);
            String content = "";
            for (int val : arr) {
                content += val + " ";
            }
            byte buff[] = content.getBytes();
            output.write(buff);
            output.close();

        } catch (Exception e) {
            System.out.println("WriteFile() occurs error :" + e.getMessage());
        }
    }
    /**
     * Writing the array read from input array arr to file
     *
     * @param fileName The file name of file to write value
     * @param msg      The string to write
     *
     */
    public void writeFile(String fileName, String msg) {
        try {
            FileOutputStream output = new FileOutputStream(fileName);
            byte buff[] = msg.getBytes();
            output.write(buff);
            output.close();

        } catch (Exception e) {
            System.out.println("WriteFile() occurs error :" + e.getMessage());
        }
    }

    /**
     * Reading the file then input to the array arr
     * 
     * @param fileName The file name of file to read
     * @return Returning a array read from the file
     */
    public float[] readFile(String fileName) {
        try {
            FileInputStream input = new FileInputStream(fileName);
            byte buff[] = new byte[1024];
            int length = input.read(buff);
            String text = "";
            while (length > 0) {
                text += new String(buff);
                length = input.read(buff);
            }
            String sNumbers[] = text.trim().split(" ");
            int n = sNumbers.length;
            float a[] = new float[n];
            for (int i = 0; i < n; i++) {
                a[i] = Float.parseFloat(sNumbers[i]);
            }
            return a;
        } catch (Exception e) {
            System.out.println("ReadFile() occurs error :" + e.getMessage());
        }

        return null;
    }

    /**
     * Sorting the input array arr using Bubble Sort algorithm.
     * 
     * @param arr Input array using for sorting
     * @param isDisplay whether the result of each sorting step will be display 
     * @return Returning a sorted array by using the Bubble Sort algorithm
     * 
     */

    public float[] bubbleSort(float arr[], boolean isDisplay) {
        int n = arr.length;
        float b[] = Arrays.copyOf(arr, n);
        boolean haveSwap;
        do {
            haveSwap = false;
            for (int i = 0; i < n - 1; i++) {
                if (b[i] > b[i + 1]) {
                    swap(b, i, i + 1);
                    haveSwap = true;
                }
            }
            if (isDisplay) {
                printArr(b);
            }

        } while (haveSwap);
        return b;
    }

    /**
     * Sorting the input array arr using Selection Sort algorithm.
     *
     * @param arr Input array using for sorting
     * @param isDisplay whether the result of each sorting step will be display 
     * @return Returning a sorted array by using the Selection Sort algorithm
     *
     */

    public float[] selectionSort(float arr[], boolean isDisplay) {
        int n = arr.length;
        float b[] = Arrays.copyOf(arr, n);
        for (int i = 0; i < n - 1; i++) {
            float min = b[i];
            int k = i;
            for (int j = i + 1; j < n; j++) {
                if (min > b[j]) {
                    k = j;
                    min = b[j];
                }
            }
            if (k != i){
                swap(b, i, k);
            }
            if (isDisplay) {
                printArr(b);
            }
        }
        return b;
    }

    /**
     * Sorting the input array arr using Insertion Sort algorithm.
     *
     * @param arr Input array using for searching
     * @param isDisplay whether the result of each sorting step will be display 
     * @return Returning a sorted array by using the Insertion Sort algorithm
     *
     */

    public float[] insertionSort(float arr[],boolean isDisplay) {
        int n = arr.length;
        float b[] = Arrays.copyOf(arr, n);
        for (int i = 1; i < n; i++) {
            float key = b[i];
            int j = i;
            while (j > 0 && key < b[j - 1]) {
                b[j] = b[j - 1];
                j--;
            }
            b[j] = key;
            if(isDisplay){
                printArr(b);
            }
        }
        return b;
    }
    /**
     * Sorting the input array arr using Selection Sort algorithm.
     *
     * @param arr Input array using for sorting
     * @param isDisplay whether the result of each sorting step will be display 
     * @return Returning a sorted array with descending order by using the Selection Sort algorithm
     *
     */
   public float[] descendingSelectionSort(float arr[],boolean isDisplay){
       int n=arr.length;
       float b[]=Arrays.copyOf(arr, n);
       for(int i=0;i<n-1;i++){
           float max=b[i];
           int k=i;
           for(int j=i+1;j<n;j++){
             if(max<b[j]){
                k=j;
                max=b[j];
             } 
           }
           if(k!=i)Algorithm.swap(b, i, k);
           if(isDisplay)printArr(b);
       }
       return b;
   }
    /**
     * Searching the indices of elements in array [arr] greater than value. Printing
     * and writing all indices to the console screen and file OUTPUT4.TXT separated
     * by space.
     *
     * @param arr   Input array using for searching
     * @param value The value for searching
     * @return List<Integer> list of founded result,empty with no result
     *
     */

    public List<Integer> linearSearch(float arr[], float value) {

        ArrayList<Integer> indexFounds = new ArrayList<Integer>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > value) {
                indexFounds.add(i);
            }
        }
        return indexFounds;
    }

    /**
     * Searching by using the Binary Search algorithm. Returning the first index of
     * value if it is present in array arr, otherwise, return -1. The index also
     * written to file OUTPUT5.TXT and shown on the console screen.
     *
     * @param arr   Input array using for searching
     * @param left  The left index
     * @param right The right index
     * @param value The value for searching
     * @return The index of the element if found, otherwise, return -1
     *
     * 
     */

    public int binarySearch(float arr[], int left, int right, float value) {
        float sortedArr[] = selectionSort(arr,false);
        int mid;
        while (right >= left) {
            mid = left + (right - left) / 2;
            if (value < sortedArr[mid])
                right = mid - 1;
            else if (value > sortedArr[mid])
                left = mid + 1;
            else if (value == sortedArr[mid])
                return mid;
        }
        return -1;
    }

    public static void swap(float arr[], int i, int j) {
        
        float temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void printArr(float arr[]) {
        for (float val : arr) {
            System.out.print(val + " ");
        }
        System.out.println();
    }

    public static void printArr(int arr[]) {
        for (int item : arr) {
            System.out.print(item + " ");
        }
        System.out.println();
    }
    public static int[] convertListToArray(List<Integer> list ){
        int n=list.size();
        int arr[]=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=list.get(i);
        }
        return arr;
    }
}