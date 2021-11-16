import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuffer sb = new StringBuffer();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int i=0; i<T; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			int distance = y-x;
			int result = 0;
			int speed = 1;
			while(true) {
				distance -= speed;
				result++;
				if(distance<=0) break;
				distance -= speed;
				result++;
				if(distance<=0) break;
				speed += 1;
			}
			sb.append(result + "\n");
		}
		System.out.println(sb.toString());
	}
}
