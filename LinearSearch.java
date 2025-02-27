import java.io.*;
import java.util.*;

public class LinearSearch {

    public static int linearSearch(int array[], int x) {
        int n = array.length;
        for (int i = 0; i < n; i++) {
            if (array[i] == x) {
                return i;
            }
        }
        return -1;
    }

    public static int[] readFileToArray(String filename) {
        ArrayList<Integer> list = new ArrayList<>();
        
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] numbers = line.trim().split("\\s+");
                for (String numStr : numbers) {
                    try {
                        list.add(Integer.parseInt(numStr));
                    } catch (NumberFormatException e) {
                        System.out.println("Skipping invalid number: " + numStr);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        int[] array = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            array[i] = list.get(i);
        }
        
        return array;
    }

    public static void main(String[] args) {
        int[] array = readFileToArray("RandNumb.txt");

        System.out.println("Array contents:");
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();

        int searchValue = 8;

        long startTime = System.nanoTime();
        int index = linearSearch(array, searchValue);
        long endTime = System.nanoTime();

        long elapsedTime = endTime - startTime;
        double elapsedTimeSecs = elapsedTime / 1_000_000_000.0;

        if (index != -1) {
            System.out.println("Element " + searchValue + " found at index " + index);
        } else {
            System.out.println("Element " + searchValue + " not found.");
        }

        System.out.println("Linear search execution time: " + elapsedTimeSecs + " Secs");
    }
}
