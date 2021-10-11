import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int[] point;
	static int[][] dp;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		point = new int[N+1];
		
		for(int i=1; i<=N; i++) {
			point[i] = Integer.parseInt(br.readLine());
		}
		
		dp = new int[N+1][3];
		
		dp[1][0] = dp[1][1] = dp[1][2] = point[1];
		for(int i=2; i<=N; i++) {
			dp[i][0] = dp[i-2][2] + point[i];
			dp[i][1] = dp[i-1][0] + point[i];
			dp[i][2] = Math.max(dp[i][0], dp[i][1]);
		}
		
		System.out.println(dp[N][2]);
	}
}
