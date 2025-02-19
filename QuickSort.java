import java.io.*;
import java.util.*;

public class QuickSort {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();

        // Read numbers from file
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

        // Convert List to Array for Quick Sort
        int[] numArray = numbers.stream().mapToInt(i -> i).toArray();

        // Measure start time in nanoseconds
        long startTime = System.nanoTime();

        // Sort using Quick Sort
        quicksort(numArray, 0, numArray.length - 1);

        // Measure end time in nanoseconds
        long endTime = System.nanoTime();

        // Calculate runtime in seconds
        double runtimeInSecs = (endTime - startTime) / 1_000_000_000.0;

        // Write sorted numbers to sortedNum.txt
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("SortedNumb.txt"))) {
            for (int num : numArray) {
                writer.write(num + "\n");
            }
            System.out.println("Numbers sorted and written to SortedNumb.txt successfully.");
        } catch (IOException e) {
            System.out.println("Error: Unable to write to the file.");
        }

        // Print out the time taken in seconds
        System.out.println("Time taken to sort the numbers: " + runtimeInSecs + " secs.");
    }

    // Quick Sort Algorithm
    private static void quicksort(int[] array, int low, int high) {
        if (low < high) {
            int partitionIndex = partition(array, low, high);
            quicksort(array, low, partitionIndex - 1);
            quicksort(array, partitionIndex + 1, high);
        }
    }

    // Partition function for Quick Sort
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

    // Swap function
    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
