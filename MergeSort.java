import java.util.Random;

public class MergeSort {
  public static void main(String[] args) {

    Random rand = new Random(); // Create a Random object to generate random numbers
    int[] numbers = new int[10]; // Initialize an array of size 10

    // Populate the array with random integers between 0 and 100
    for (int i = 0; i < numbers.length; i++) {
      numbers[i] = rand.nextInt(100);
    }

    System.out.println("Before:");
    printArray(numbers); // Print the unsorted array

    mergeSort(numbers); // Call mergeSort to sort the array

    System.out.println("\nAfter:");
    printArray(numbers); // Print the sorted array
  }

  // Recursive function to perform merge sort
  private static void mergeSort(int[] inputArray) {
    int inputLength = inputArray.length;
    
    // Base case: if the array has less than 2 elements, it's already sorted
    if (inputLength < 2) {
      return;
    }
    
    int midIndex = inputLength / 2; // Find the middle index of the array
    
    // Create two subarrays: leftHalf and rightHalf
    int[] leftHalf = new int[midIndex];
    int[] rightHalf = new int[inputLength - midIndex];
    
    // Copy elements into leftHalf
    for (int i = 0; i < midIndex; i++) {
      leftHalf[i] = inputArray[i];
    }
    
    // Copy elements into rightHalf
    for (int i = midIndex; i < inputLength; i++) {
      rightHalf[i - midIndex] = inputArray[i];
    }
    
    // Recursively sort both halves
    mergeSort(leftHalf);
    mergeSort(rightHalf);
    
    // Merge the sorted halves back into the original array
    merge(inputArray, leftHalf, rightHalf);
  }

  // Function to merge two sorted subarrays into a single sorted array
  private static void merge(int[] inputArray, int[] leftHalf, int[] rightHalf) {
    int leftSize = leftHalf.length;
    int rightSize = rightHalf.length;
    
    int i = 0, j = 0, k = 0; // Pointers for leftHalf, rightHalf, and inputArray
    
    // Merge elements from leftHalf and rightHalf in sorted order
    while (i < leftSize && j < rightSize) {
      if (leftHalf[i] <= rightHalf[j]) {
        inputArray[k] = leftHalf[i];
        i++;
      } else {
        inputArray[k] = rightHalf[j];
        j++;
      }
      k++;
    }
    
    // Copy any remaining elements from leftHalf (if any)
    while (i < leftSize) {
      inputArray[k] = leftHalf[i];
      i++;
      k++;
    }
    
    // Copy any remaining elements from rightHalf (if any)
    while (j < rightSize) {
      inputArray[k] = rightHalf[j];
      j++;
      k++;
    }
  }

  // Function to print the elements of an array
  private static void printArray(int[] numbers) {
    for (int i = 0; i < numbers.length; i++) {
      System.out.println(numbers[i]);
    }
  }
}
