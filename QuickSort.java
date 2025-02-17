import java.util.Random;

public class QuickSort {

  public static void main(String[] args) {
    Random rand = new Random(); // Create a Random object to generate random numbers
    int[] numbers = new int[10]; // Initialize an array of size 10

    // Populate the array with random integers between 0 and 99
    for (int i = 0; i < numbers.length; i++) {
      numbers[i] = rand.nextInt(100);
    }

    System.out.println("Before:");
    printArray(numbers); // Print the unsorted array

    quicksort(numbers); // Call quicksort to sort the array

    System.out.println("\nAfter:");
    printArray(numbers); // Print the sorted array
  }

  // Wrapper method to call quicksort with the full array
  private static void quicksort(int[] array) {
    quicksort(array, 0, array.length - 1);
  }

  // Recursive quicksort function
  private static void quicksort(int[] array, int lowIndex, int highIndex) {
    
    if (lowIndex >= highIndex) { // Base case: if the section has one or no elements, return
      return;
    }

    // Choose a pivot randomly and move it to the end
    int pivotIndex = new Random().nextInt(highIndex - lowIndex) + lowIndex;
    int pivot = array[pivotIndex];
    swap(array, pivotIndex, highIndex);

    // Partition the array and get the pivot’s final position
    int leftPointer = partition(array, lowIndex, highIndex, pivot);

    // Recursively sort the left and right subarrays
    quicksort(array, lowIndex, leftPointer - 1);
    quicksort(array, leftPointer + 1, highIndex);
  }

  // Partition function to rearrange elements around the pivot
  private static int partition(int[] array, int lowIndex, int highIndex, int pivot) {
    int leftPointer = lowIndex;
    int rightPointer = highIndex - 1;

    while (leftPointer < rightPointer) {
      // Move left pointer until an element greater than the pivot is found
      while (array[leftPointer] <= pivot && leftPointer < rightPointer) {
        leftPointer++;
      }

      // Move right pointer until an element smaller than the pivot is found
      while (array[rightPointer] >= pivot && leftPointer < rightPointer) {
        rightPointer--;
      }

      // Swap out-of-place elements
      swap(array, leftPointer, rightPointer);
    }
    
    // Final swap to place the pivot in its correct position
    if(array[leftPointer] > array[highIndex]) {
      swap(array, leftPointer, highIndex);
    }
    else {
      leftPointer = highIndex;
    }
    
    return leftPointer; // Return the final pivot position
  }

  // Function to swap two elements in an array
  private static void swap(int[] array, int index1, int index2) {
    int temp = array[index1];
    array[index1] = array[index2];
    array[index2] = temp;
  }

  // Function to print the elements of an array
  private static void printArray(int[] numbers) {
    for (int i = 0; i < numbers.length; i++) {
      System.out.println(numbers[i]);
    }
  }
}
