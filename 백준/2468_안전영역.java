import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	//2468번 안전영역
	//https://www.acmicpc.net/problem/2468
	
	static int N;
	static int[][] data;
	static boolean[][] visited;
	static int result = 0;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, -1, 0, 1};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		data = new int[N][N];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				data[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		//level
		for(int l=0; l<101; l++) {
			int temp = result;
			result = 0;
			visited = new boolean[N][N];
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(isVaild(i,j,l)) {
						dfs(i,j,l);
						result++;
					}
				}
			}
			result = Math.max(temp, result);
		}
		
		System.out.println(result);
	}
	
	public static void dfs(int x, int y, int level) {
		visited[x][y] = true;
		
		for(int i=0; i<4; i++) {
			int newX = x+dx[i];
			int newY = y+dy[i];
			if(isVaild(newX, newY, level)) {
				dfs(newX, newY, level);
			}
		}
	}
	
	public static boolean isVaild(int x, int y, int level) {
		if(x<0 || y<0 || x>=N || y>=N || data[x][y] <= level || visited[x][y]) return false;
		return true;
	}
}
