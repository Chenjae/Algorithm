package report.day0817;

import java.util.Scanner;

public class Quiz4 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String text = scanner.nextLine();

		for (int i = 0; i<text.length(); i++) {
			char c = (char) (text.charAt(i) + 4);
			if (c > 'z') {
				c = (char) (c - 'z' + 'a');
			}
			System.out.print(c);
		}
	}
}
