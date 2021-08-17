package report.day0817;

import java.util.Scanner;

public class Quiz2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		Integer[] nums = new Integer[7];
		String[] texts = new String[7];
		int min=0;
		int sum=0;
		boolean findOdd = false;
		
		String text = scanner.nextLine();
		texts = text.split(",");
		
		for(int i=0; i<nums.length; i++) {
			nums[i] = Integer.parseInt(texts[i]);
			if(nums[i]%2 == 1) {
				if(!findOdd) {
					min = nums[i];
					findOdd = true;
				}
				if(nums[i]<min) min = nums[i];
				sum += nums[i];
			}//isOdd
		}//for
		
		if(findOdd) {
			System.out.println(sum);
			System.out.println(min);
		} else {
			System.out.println(-1);
		}

	}

}
