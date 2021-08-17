package report.day0817;

import java.util.Scanner;

public class Quiz3 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String text = scanner.nextLine();
		
		int[] result = new int[10];
		int[] nums = new int[3];
		int value = 1;
		
		
		String[] texts = text.split(",");
		
		for(int i=0; i<texts.length; i++) {
			value *= Integer.parseInt(texts[i]);
		}
		
		//System.out.println("value : " + value);
		
		while(value>0) {
			result[value%10]++;
			value /= 10;
		}
		
		for(int i : result) {
			System.out.println(i);
		}
		
	}
}
