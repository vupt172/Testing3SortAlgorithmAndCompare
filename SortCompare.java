import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class SortCompare {
    public static final int MAX_ARRAY_LENGH = 100000;

    Algorithm algorithm = new Algorithm();
  
    public static void main(String[] args) {
        Algorithm algorithm = new Algorithm();
        SortCompare sortCompare = new SortCompare();
        float randomData[] = new float[MAX_ARRAY_LENGH];
        String next = "";
        long end,begin;
        Scanner sc = new Scanner(System.in);
        Random rd = new Random();
        for (int i = 0; i < MAX_ARRAY_LENGH; i++) {
            randomData[i] = rd.nextFloat() * 100;
        }
        float ascendingSortedData[] = algorithm.insertionSort(randomData, false);
        float descendingSortedData[] = algorithm.descendingSelectionSort(randomData, false);

        System.out.println("*----------------------------------------------------------------------*");
        System.out.printf("|#%-69s|\n", "SO SANH 3 THUAT TOAN SAP XEP VOI " + MAX_ARRAY_LENGH + " PHAN TU");
        System.out.println("*----------------------------------------------------------------------*");
        System.out.println();
        System.out.println("*----------------------------------------------------------------------*");
        System.out.printf("|#%-69s|\n", "1.SAP XEP VOI DU LIEU NGAU NHIEN");
        System.out.println("*----------------------------------------------------------------------*");
        begin=Calendar.getInstance().getTimeInMillis();
        algorithm.bubbleSort(randomData, false);
        end=Calendar.getInstance().getTimeInMillis();
        System.out.printf("|%-30s|%-39s|\n","BubbleSort",(end-begin)+ "ms");

        begin=Calendar.getInstance().getTimeInMillis();
        algorithm.selectionSort(randomData, false);
        end=Calendar.getInstance().getTimeInMillis();
        System.out.printf("|%-30s|%-39s|\n","SelectionSort",(end-begin)+ "ms");
      
        begin=Calendar.getInstance().getTimeInMillis();
        algorithm.insertionSort(randomData, false);
        end=Calendar.getInstance().getTimeInMillis();
        System.out.printf("|%-30s|%-39s|\n","InsertSort",(end-begin)+ "ms");

        System.out.println("*----------------------------------------------------------------------*");
        System.out.printf("|#%-69s|\n", "2.SAP XEP VOI DU LIEU DA SAP XEP [TANG DAN]");
        System.out.println("*----------------------------------------------------------------------*");
        begin=System.nanoTime();
        algorithm.bubbleSort(ascendingSortedData, false);
        end=System.nanoTime();
        System.out.printf("|%-30s|%-39s|\n","BubbleSort",(double)(end-begin)/1000000+ "ms");

        begin=Calendar.getInstance().getTimeInMillis();
        algorithm.selectionSort(ascendingSortedData, false);
        end=Calendar.getInstance().getTimeInMillis();
        System.out.printf("|%-30s|%-39s|\n","SelectionSort",(end-begin)+ "ms");

        begin=System.nanoTime();
        algorithm.insertionSort(ascendingSortedData, false);
        end=System.nanoTime();
        System.out.printf("|%-30s|%-39s|\n","InsertSort",(double)(end-begin)/1000000+ "ms");
     
      
        System.out.println("*----------------------------------------------------------------------*");
        System.out.printf("|#%-69s|\n", "3.SAP XEP VOI DU LIEU DA SAP XEP [GIAM DAN]");
        System.out.println("*----------------------------------------------------------------------*");
        begin=Calendar.getInstance().getTimeInMillis();
        algorithm.bubbleSort(descendingSortedData, false);
        end=Calendar.getInstance().getTimeInMillis();
        System.out.printf("|%-30s|%-39s|\n","BubbleSort",(end-begin)+ "ms");

        begin=Calendar.getInstance().getTimeInMillis();
        algorithm.selectionSort(descendingSortedData, false);
        end=Calendar.getInstance().getTimeInMillis();
        System.out.printf("|%-30s|%-39s|\n","SelectionSort",(end-begin)+ "ms");

        begin=Calendar.getInstance().getTimeInMillis();
        algorithm.insertionSort(descendingSortedData, false);
        end=Calendar.getInstance().getTimeInMillis();
        System.out.printf("|%-30s|%-39s|\n","InsertSort",(end-begin)+ "ms");
        System.out.println("*----------------------------------------------------------------------*");
    }


}
