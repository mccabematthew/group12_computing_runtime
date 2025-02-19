import java.io.*;
import java.util.*;

public class BubbleSort {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        
        try (BufferedReader reader = new BufferedReader(new FileReader("RandomNumb.txt"))) {
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
        
        bubbleSort(numbers);
        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("SortedNumb.txt"))) {
            for (int num : numbers) {
                writer.write(num + "\n");
            }
            System.out.println("Numbers sorted and written to SortedNumb.txt successfully.");
        } catch (IOException e) {
            System.out.println("Error: Unable to write to the file.");
        }

    }
    
    public static void bubbleSort(List<Integer> numbers) {
        int n = numbers.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (numbers.get(j) > numbers.get(j + 1)) {
                    int temp = numbers.get(j);
                    numbers.set(j, numbers.get(j + 1));
                    numbers.set(j + 1, temp);
                }
            }
        }
    }
}
