import java.io.*;
import java.util.*;

public class MergeSort {
    public static void main(String[] args) {
        int[] numbers = new int[500];
        
       
        try (Scanner scanner = new Scanner(new File("RandNumb.txt"))) {
            for (int i = 0; i < numbers.length && scanner.hasNextInt(); i++) {
                numbers[i] = scanner.nextInt();
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error: RandNumb.txt not found.");
            return;
        }
        
        System.out.println("Before Sorting:");
        printArray(numbers);
        
        long startTime = System.nanoTime(); 
        mergeSort(numbers);
        long endTime = System.nanoTime(); 
        
        long elapsedTime = endTime - startTime;
        double elapsedTimeSecs = elapsedTime / 1_000_000_000.0;
        
        System.out.println("\nAfter Sorting:");
        printArray(numbers);
        
        System.out.println("Merge sort execution time: " + elapsedTimeSecs + " Secs");
        
       
        try (PrintWriter writer = new PrintWriter(new File("SortedNumb.txt"))) {
            for (int num : numbers) {
                writer.println(num);
            }
        } catch (IOException e) {
            System.out.println("Error writing to SortedNumb.txt");
        }
    }

    private static void mergeSort(int[] inputArray) {
        int inputLength = inputArray.length;
        if (inputLength < 2) {
            return;
        }

        int midIndex = inputLength / 2;
        int[] leftHalf = Arrays.copyOfRange(inputArray, 0, midIndex);
        int[] rightHalf = Arrays.copyOfRange(inputArray, midIndex, inputLength);

        mergeSort(leftHalf);
        mergeSort(rightHalf);

        merge(inputArray, leftHalf, rightHalf);
    }

    private static void merge(int[] inputArray, int[] leftHalf, int[] rightHalf) {
        int leftSize = leftHalf.length;
        int rightSize = rightHalf.length;
        int i = 0, j = 0, k = 0;

        while (i < leftSize && j < rightSize) {
            if (leftHalf[i] <= rightHalf[j]) {
                inputArray[k++] = leftHalf[i++];
            } else {
                inputArray[k++] = rightHalf[j++];
            }
        }

        while (i < leftSize) {
            inputArray[k++] = leftHalf[i++];
        }
        while (j < rightSize) {
            inputArray[k++] = rightHalf[j++];
        }
    }

    private static void printArray(int[] numbers) {
        for (int num : numbers) {
            System.out.println(num);
        }
    }
}
