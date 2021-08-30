import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	//균형잡힌 세상
	//https://www.acmicpc.net/problem/4949
	
	static Stack<Character> stack = new Stack<Character>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			 String input = br.readLine();
			 if(input.equals(".")) break;
			 
			 if(isBalance(input)) System.out.println("yes");
			 else System.out.println("no");
			 stack = new Stack<Character>();
		}
	}
	
	static boolean isBalance(String str) {
		char data[] = str.toCharArray();
		for(char c:data) {
			if(c == '(' || c =='[') {
				stack.add(c);
			} else if(c == ')'){
				if(stack.isEmpty()) return false;
				else {
					char out = stack.pop();
					if(out != '(') return false;
				}
			}else if(c==']') {
				if(stack.isEmpty()) return false;
				else {
					char out = stack.pop();
					if(out != '[') return false;
				}
			}
		}
		if(!stack.isEmpty()) return false;
		return true;
	}

}
