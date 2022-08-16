import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
	//https://www.acmicpc.net/problem/2667
	
	static int N;
	static int map[][];
	static boolean visited[][];
	static int dx[] = {-1, 0, 1, 0}, 
				dy[] = {0, -1, 0, 1};
	static int cnt = 0;
	static ArrayList<Integer> result = new ArrayList<Integer>();
	
	static class P {
		int x, y;
		public P(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visited = new boolean[N][N];
		
		for(int i=0; i<N; i++) {
			String st = br.readLine();
			for(int j=0; j<N; j++) {
				map[i][j] = st.charAt(j)-'0';
			}
		}
		
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(isVaild(i,j)) {
					cnt = 1;
					dfs(i,j);
					result.add(cnt);
				}
			}
		}
		
		Collections.sort(result);
		System.out.println(result.size());
		for(int i : result) System.out.println(i);
	}
	
	public static void dfs(int x, int y) {
		visited[x][y] = true;
		for(int i=0; i<4; i++) {
			int nX = x+dx[i],
				nY = y+dy[i];
			if(isVaild(nX, nY)) {
				cnt++;
				dfs(nX, nY);
			}
		}
	}
	
	public static boolean isVaild(int x, int y) {
		if(x<0 || y<0 || x>=N || y>=N || map[x][y]==0 || visited[x][y]) return false;
		return true;
	}

}
