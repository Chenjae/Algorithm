import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main{
	public static void main(String[] args) {
		ArrayList <Integer> heights = new ArrayList<Integer>();
		Scanner scanner = new Scanner(System.in);
		
		int total = 0;
		
		for(int i=0; i<9; i++) {
			int height = scanner.nextInt();
			heights.add(height);
			total += height;
		}
		
		
		for(int i=0; i<9; i++) {
			for(int j=i+1; j<9; j++) {
				if(total - heights.get(i) - heights.get(j) == 100) {
					heights.set(i, Integer.MAX_VALUE);
					heights.set(j, Integer.MAX_VALUE);
					Collections.sort(heights);
					break;
				}
			}
		}
		
		for(int i=0; i<7; i++) {
			System.out.println(heights.get(i) + " ");
		}
	
	}
}
