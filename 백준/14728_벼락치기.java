import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] dp;
	static Chepter[] data;
	static int T;
	public static class Chepter {
		int time;
		int point;
		public Chepter(int time, int point) {
			this.time = time;
			this.point = point;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		dp = new int[N+1][T+1];
		data = new Chepter[N+1];
		
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			int t = Integer.parseInt(st.nextToken());
			int p = Integer.parseInt(st.nextToken());
			data[i] = new Chepter(t, p);
		}
		
		for(int i=1; i<=N; i++) {
			Chepter c = data[i];
			for(int j=1; j<=T; j++) {
				if(j < c.time) {
					dp[i][j] = dp[i-1][j];
				} else {
					dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-c.time]+c.point);
				}
				
			}
		}
		
		System.out.println(dp[N][T]);
	}
}
