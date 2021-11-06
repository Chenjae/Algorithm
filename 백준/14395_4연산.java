import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static long s, t;
	static boolean flag = true;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		s = Integer.parseInt(st.nextToken());
		t = Integer.parseInt(st.nextToken());
		if(s == t) {
			System.out.println(0);
		} else {
			dfs(s);
		}
	}
	
	public static void dfs(long s) {
		LinkedList<String> opStrQue = new LinkedList<String>();
		LinkedList<Long> scoreQue = new LinkedList<Long>();
		
		opStrQue.add("");
		scoreQue.add(s);
		
		while(!scoreQue.isEmpty()) {
			long score = scoreQue.poll();
			String opStr = opStrQue.poll();
			if(score == t) {
				System.out.println(opStr);
				return;
			} else {
				if(score*score <= t && score>1) {
					scoreQue.add(score*score);
					opStrQue.add(opStr+"*");
				}
				if(score+score <= t && score>0) {
					scoreQue.add(score+score);
					opStrQue.add(opStr+"+");
				}
				if(opStr.equals("")) {
					scoreQue.add(1L);
					opStrQue.add("/");
					if(s != 0) {
						scoreQue.add(0L);
						opStrQue.add("-");
					}
				}
			}
		}//while
		System.out.println(-1);
	}//dfs
}
