import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	//유기농 배추 
	//https://www.acmicpc.net/problem/1012
	static int[][] data;
	static boolean[][] visited;
	static int M, N, K;
	static StringBuffer sb = new StringBuffer();
	static int result;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, -1, 0, 1};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for(int l=0; l<T; l++) {
			st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			data = new int[M][N];
			visited = new boolean[M][N];
			
			for(int i=0; i<K; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				data[x][y] = 1;
			}
			
			for(int i=0; i<M; i++) {
				for(int j=0; j<N; j++) {
					if(isVaild(i,j)) {
						result++;
						dfs(i,j);
					}
				}
			}
			sb.append(result+System.lineSeparator());
			result=0;
		}
		System.out.println(sb.toString());
	}
	
	static void dfs(int x, int y) {
		visited[x][y] = true;
		for(int i=0; i<4; i++) {
			int newX = x + dx[i], newY = y + dy[i];
			if(isVaild(newX, newY)) {
				dfs(newX, newY);
			}
		}
	}
	
	static boolean isVaild(int x, int y) {
		if(x<0 || y<0 || x>=M || y>=N || visited[x][y] || data[x][y] == 0) return false;
		return true;
	}
}
