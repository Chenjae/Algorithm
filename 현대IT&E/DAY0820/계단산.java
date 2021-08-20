package report.day0820;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Quiz1 {
	public static void main(String[] args) throws IOException {
		LinkedList stack = new LinkedList();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String data = br.readLine();
		int mul = 1;
		int result = 0;
		
		for(int i=0; i<data.length(); i++) {
			char c = data.charAt(i);
			if(c == '(') {
				stack.push(c);
				result += stack.size() * mul;
			} else if(c == '#') {
				if(mul == 1)
					mul = 2;
				else mul = 1;
			}
			else if(c == ')') {
				result += stack.size() * mul;
				stack.pop();
			}
		}
		
		System.out.println(result);
	}

}
