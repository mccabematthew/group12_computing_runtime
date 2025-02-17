package bubblesort;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] numbers = {4, 7, 24, 19, 1, 33};//creates an array of type int
        
        System.out.print("Array before being sorted: ");
        System.out.println(Arrays.toString(numbers)); // Displays the array before sorting
        
        bubbleSort(numbers); //calls the method
        
        System.out.print("Array after being sorted: ");
        System.out.println(Arrays.toString(numbers)); // Displays the array after being sorted
    }

    public static void bubbleSort(int[] numbers) {
        int x = numbers.length;
        //i loop is the numbers of passes through the array, ensuring the largest element moves to its correct spot after each pass
        for (int i = 0; i < x - 1; i++) { 
        	//j loop will swap the numbers if needed, will only swap the largest element to its correct spot
            for (int j = 0; j < x - i - 1; j++) { 
                if (numbers[j] > numbers[j + 1]) {
                    // Swap numbers if true
                    int temp = numbers[j];
                    numbers[j] = numbers[j + 1];
                    numbers[j + 1] = temp;

                    // Print the swap process
                    System.out.println("Swapping: " + numbers[j] + " with " + numbers[j + 1]);
                }
            }
        }
    }
}

