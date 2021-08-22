import java.util.Scanner;

public class Main {
	//팩토리얼
	//https://www.acmicpc.net/problem/10872
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int num = scanner.nextInt();
		int result=1;
		
		while(num>0) {
			result *= num--;
		}
		System.out.println(result);
	}
}
