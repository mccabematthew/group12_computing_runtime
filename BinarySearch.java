import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class BinarySearch {

    public static int binarySearch(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (array[mid] == target) {
                return mid;
            }

            if (array[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        try {
            String content = new String(Files.readAllBytes(Paths.get("SortedNumb.txt")));

            int[] array = Arrays.stream(content.split("\\s+"))
                                .mapToInt(Integer::parseInt)
                                .toArray();
            Arrays.sort(array);

            int target = 10;

            long startTime = System.nanoTime();
            int result = binarySearch(array, target);
            long endTime = System.nanoTime();

            long elapsedTime = endTime - startTime;
            double elapsedTimeSecs = elapsedTime / 1_000_000_000.0;

            if (result == -1) {
                System.out.println("Element not present in the array");
            } else {
                System.out.println("Element found at index " + result);
            }

            System.out.println("Binary search execution time: " + elapsedTimeSecs + " secs");

        } catch (IOException e) {
            System.out.println("An error occurred while reading the file.");
            e.printStackTrace();
        }
    }
}
