package report.day0818;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Quiz3 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		int result=0;
		
		String[] score = br.readLine().split(" ");
		String barrier1 = br.readLine();
		String barrier2 = br.readLine();
		
		for(int i=0; i<num; i++) {
			if(barrier1.charAt(i) == barrier2.charAt(i) && barrier1.charAt(i) == 'O')
				result += Integer.parseInt(score[i]);
		}
		
		System.out.println(result);
	}
	
}
