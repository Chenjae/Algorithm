import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] input = br.readLine().toCharArray();
		boolean isTag = false;
		StringBuffer sb = new StringBuffer();
		Stack<Character> stack = new Stack<Character>();
		
		for(char c : input) {
			if(c=='<') {
				while(!stack.isEmpty()) {
					sb.append(stack.pop());
				}
				isTag = true;
			}
			else if(c=='>') {
				isTag = false;
			}
			else if(c==' ') {
				while(!stack.isEmpty()) {
					sb.append(stack.pop());
				}
			}
			else {
				if(!isTag) {
					stack.add(c);
					continue;
				}
			}
			sb.append(c);
		}
		
		while(!stack.isEmpty()) {
			sb.append(stack.pop());
		}
		
		System.out.println(sb.toString());
	
	}

}
