package main;

import java.util.Random;
import java.io.FileWriter;
import java.io.IOException;

public class RandomNumb {
	public static void main(String[] args) {
		int array = 1000;
		int [] randomArray = new int[array];
		
		Random random = new Random();
		
		for (int i = 0; i < array; i++) {
			randomArray[i] = random.nextInt(1000);
		}
		
		try (FileWriter writer = new FileWriter("RandNumb.txt")) {
            System.out.print("Random array: [");
            for (int i = 0; i < array; i++) {
                writer.write(randomArray[i] + "\n");
                System.out.print(randomArray[i]);
                if (i < array - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println("]");
		} catch (IOException e) {
			
		}
	
	}
}
