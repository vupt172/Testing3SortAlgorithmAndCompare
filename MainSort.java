import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainSort {
    Scanner sc = new Scanner(System.in);
    Algorithm algorithm = new Algorithm();
    float a[];

    public static void main(String[] args) {
        MainSort ms = new MainSort();

        int option;
        while (true) {
            option = ms.getMenuOption();
            switch (option) {
                case 0:
                    return;
                case 1:
                    ms.inputtArrayFromUserToFile();
                    break;
                case 2:
                    ms.getArrayFromFileAndDisplay();
                    break;
                case 3:
                    ms.bubbleSortAndWriteToFile();
                    break;
                case 4:
                    ms.selectionSortAndWriteToFile();
                    break;
                case 5:
                    ms.insertionSortAndWriteToFile();
                    break;
                case 6:
                    ms.linearSearchAndWriteToFile();
                    break;
                case 7:
                    ms.binarySearchAndWriteToFile();
                    break;
                default:
                    System.out.println("Khong co chuc nang thu " + option + "!");
            }
        }
    }

    public int getMenuOption() {
        int option;
        System.out.println("*----------------------------------------------------------------------*");
        System.out.printf("|#%-69s|\n", "MENU");
        System.out.println("*----------------------------------------------------------------------*");
        System.out.printf("|%-70s|\n", "1.Input");
        System.out.printf("|%-70s|\n", "2.Output");
        System.out.printf("|%-70s|\n", "3.Bubble sort");
        System.out.printf("|%-70s|\n", "4.Selection sort");
        System.out.printf("|%-70s|\n", "5.Insert sort");
        System.out.printf("|%-70s|\n", "6.Linear Search > value");
        System.out.printf("|%-70s|\n", "7.Binary Search = vale");
        System.out.printf("|%-70s|\n", "0.Exit");
        System.out.println("*----------------------------------------------------------------------*");
        System.out.print("->Choose option :");
        option = Integer.parseInt(sc.nextLine());
        return option;
    }

    public void inputtArrayFromUserToFile() {
        System.out.print("->Nhap so phan tu :");
        int n = Integer.parseInt(sc.nextLine());
        System.out.println("Nhap danh sach");
        float arr[] = new float[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Float.parseFloat(sc.nextLine());
        }
        algorithm.writeFile("input.txt", arr);

    }

    public void getArrayFromFileAndDisplay() {
        this.a = algorithm.readFile("input.txt");
        System.out.print("Array a:");
        Algorithm.printArr(a);
        System.out.println();
    }

    public void bubbleSortAndWriteToFile() {
        System.out.println("Bubble Sort");
        float res[] = algorithm.bubbleSort(this.a, true);
        algorithm.writeFile("output1.txt", res);
    }

    public void selectionSortAndWriteToFile() {
        System.out.println("Selection Sort");
        float res[] = algorithm.selectionSort(this.a, true);
        algorithm.writeFile("output2.txt", res);
    }

    public void insertionSortAndWriteToFile() {
        System.out.println("Insertion Sort");
        float res[] = algorithm.insertionSort(this.a, true);
        algorithm.writeFile("output3.txt", res);
    }

    public void linearSearchAndWriteToFile() {
        System.out.println("Linear Seach > value");
        System.out.print("Input value: ");
        float key = Float.parseFloat(sc.nextLine());
        List<Integer> indexFounds = algorithm.linearSearch(this.a, key);
        if (indexFounds.isEmpty()) {
            System.out.println("Khong co ket qua nao phu hop.");
            return;
        } else {
            int res[] = Algorithm.convertListToArray(indexFounds);
            System.out.print("Chi so cua cac phan tu >" + key + " la :");
            algorithm.printArr(res);
            algorithm.writeFile("output4.txt", res);
        }
    }

    public void binarySearchAndWriteToFile() {
        System.out.println("Binary Search = value");
        System.out.print("Input value :");
        float key = Float.parseFloat(sc.nextLine());
        int res = algorithm.binarySearch(this.a, 0, this.a.length - 1, key);
        if (res == -1) {
            System.out.println("Khong co ket qua nao phu hop");
        } else {
            System.out.println("Index of first element in sorted array :" + res);
            algorithm.writeFile("output5.txt", "" + res);
        }
    }

}
