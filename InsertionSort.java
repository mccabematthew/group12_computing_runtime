import java.util.Random;

public class InsertionSort {

	public static void main(String[] args) {
		Random rand = new Random(); // Create a Random object to generate random numbers
		int[] numbers = new int[5]; // Initialize an array with 5 elements

		// Populate the array with random integers between 0 and 50
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = rand.nextInt(50);
		}
		System.out.println("Before:");
		printArray(numbers); // Print the unsorted array

		insertionSort(numbers); // Sort the array using insertion sort

		System.out.println("\nAfter:");
		printArray(numbers); // Print the sorted array
	}
	// Function to perform insertion sort on an array
	private static void insertionSort(int[] inputArray) {
		for (int i = 1; i < inputArray.length; i++) {
			
			int currentValue = inputArray[i]; // Store the current value to be inserted in sorted order
			int j = i - 1;

			// Shift elements that are greater than currentValue to the right
			while (j >= 0 && inputArray[j] > currentValue) {
				inputArray[j + 1] = inputArray[j];
				j--;
			}
			// Insert the currentValue at its correct position
			inputArray[j + 1] = currentValue;
		}
	}
	// Function to print the elements of an array
	private static void printArray(int[] numbers) {
		for (int i = 0; i < numbers.length; i++) {
			System.out.println(numbers[i]);
		}
	}
}