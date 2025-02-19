import java.io.*;
import java.util.*;

public class QuickSort {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();

      
        try (BufferedReader reader = new BufferedReader(new FileReader("RandNumb.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                try {
                    numbers.add(Integer.parseInt(line.trim()));
                } catch (NumberFormatException e) {
                    System.out.println("Warning: Skipping invalid number - " + line);
                }
            }
        } catch (IOException e) {
            System.out.println("Error: Unable to read the file.");
            return;
        }

       
        int[] numArray = numbers.stream().mapToInt(i -> i).toArray();

        long startTime = System.nanoTime();

       
        quicksort(numArray, 0, numArray.length - 1);

       
        long endTime = System.nanoTime();

       
        double runtimeInSecs = (endTime - startTime) / 1_000_000_000.0;

       
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("SortedNumb.txt"))) {
            for (int num : numArray) {
                writer.write(num + "\n");
            }
            System.out.println("Numbers sorted and written to SortedNumb.txt successfully.");
        } catch (IOException e) {
            System.out.println("Error: Unable to write to the file.");
        }

       
        System.out.println("Time taken to sort the numbers: " + runtimeInSecs + " secs.");
    }

   
    private static void quicksort(int[] array, int low, int high) {
        if (low < high) {
            int partitionIndex = partition(array, low, high);
            quicksort(array, low, partitionIndex - 1);
            quicksort(array, partitionIndex + 1, high);
        }
    }

   
    private static int partition(int[] array, int low, int high) {
        int pivot = array[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (array[j] <= pivot) {
                i++;
                swap(array, i, j);
            }
        }

        swap(array, i + 1, high);
        return i + 1;
    }

   
    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
