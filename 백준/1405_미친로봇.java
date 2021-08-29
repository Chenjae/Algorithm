import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	//미친 로봇
	//https://www.acmicpc.net/problem/1405
	static int D;
	static double N, S, E, W;
	static double result = 1;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static boolean visited[][] = new boolean[30][30];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		D = Integer.parseInt(st.nextToken());
		E = Double.parseDouble(st.nextToken()) / 100;
		W = Double.parseDouble(st.nextToken()) / 100;
		S = Double.parseDouble(st.nextToken()) / 100;
		N = Double.parseDouble(st.nextToken()) / 100;

		dfs(15, 15, 0, 1);

		System.out.println(result);
	}

	public static void dfs(int x, int y, int depth, double per) {
		if (visited[x][y]) {
			result -= per;
			return;
		}
		if (depth == D) return;
		
		visited[x][y] = true;
		

		for (int i = 0; i < 4; i++) {
			int newX = x + dx[i], newY = y + dy[i];
			if (i == 0) {
				dfs(newX, newY, depth + 1, per * E);
			} else if (i == 1) {
				dfs(newX, newY, depth + 1, per * W);
			} else if (i == 2) {
				dfs(newX, newY, depth + 1, per * S);
			} else {
				dfs(newX, newY, depth + 1, per * N);
			}
		}
        
        visited[x][y] = false;
	}

}
