import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class BinarySearch {

    // Method to perform binary search on a sorted array
    public static int binarySearch(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // Check if the target is present at mid
            if (array[mid] == target) {
                return mid;
            }

            // If target is greater, ignore the left half
            if (array[mid] < target) {
                left = mid + 1;
            } else {
                // If target is smaller, ignore the right half
                right = mid - 1;
            }
        }

        // Target is not present in the array
        return -1;
    }

    public static void main(String[] args) {
        try {
            // Read all lines from the file
            String content = new String(Files.readAllBytes(Paths.get("SortedNumb.txt")));
            // Split the content by whitespace and parse into an array of integers
            int[] array = Arrays.stream(content.split("\\s+"))
                                .mapToInt(Integer::parseInt)
                                .toArray();
            // Sort the array to ensure binary search works correctly
            Arrays.sort(array);

            int target = 10; // Example target value
            int result = binarySearch(array, target);

            if (result == -1) {
                System.out.println("Element not present in the array");
            } else {
                System.out.println("Element found at index " + result);
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file.");
            e.printStackTrace();
        }
    }
}
