import java.util.Random;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomNumb {
    public static void main(String[] args) {
        int arraySize = 1000;
        int[] randomArray = new int[arraySize];

        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < arraySize; i++) {
            numbers.add(i);
        }

        Collections.shuffle(numbers, new Random());

        for (int i = 0; i < arraySize; i++) {
            randomArray[i] = numbers.get(i);
        }
	    
        try (FileWriter writer = new FileWriter("RandNumb.txt")) {
            System.out.print("Random array: [");
            for (int i = 0; i < arraySize; i++) {
                writer.write(randomArray[i] + "\n");
                System.out.print(randomArray[i]);
                if (i < arraySize - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println("]");
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }
}
