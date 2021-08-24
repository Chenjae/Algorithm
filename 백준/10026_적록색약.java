package report.day0823;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Problem10026 {
	//적록색약
	//https://www.acmicpc.net/problem/10026
	static int N;
	static char[][] data;
	static boolean[][] visited;
	static LinkedList<Integer[]> queue = new LinkedList<Integer[]>();
	static int[] dx = { 0, -1, 0, 1 };
	static int[] dy = { -1, 0, 1, 0 };
	static int result = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		data = new char[N][N];
		visited = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			char[] input = br.readLine().toCharArray();
			for (int j = 0; j < N; j++) {
				data[i][j] = input[j];
			}
		}
		
		bfs(true);
		System.out.print(result + " ");
		visited = new boolean[N][N];
		result = 0;
		bfs(false);
		System.out.print(result);
		
	}
	
	public static void bfs(boolean status) {
		queue.add(new Integer[] { 0, 0 });
		
		while(!queue.isEmpty()) {
			Integer point[] = queue.poll();
			int x = point[0];
			int y = point[1];
			if(!visited[x][y]) {
				result++;
				if(status) dfs(x,y);
				else blindDfs(x,y);
			}
		}
	}

	public static void dfs(int x, int y) {
		visited[x][y] = true;
		char d = data[x][y];

		for (int i = 0; i < 4; i++) {
			int newX = x + dx[i], newY = y + dy[i];
			if (isVaild(newX, newY)) {
				if (data[newX][newY] == d)
					dfs(newX, newY);
				else
					queue.add(new Integer[] { newX, newY });
			} // isVaild
		} // for

	}
	
	public static void blindDfs(int x, int y) {
		visited[x][y] = true;
		char d = data[x][y];

		for (int i = 0; i < 4; i++) {
			int newX = x + dx[i], newY = y + dy[i];
			if (isVaild(newX, newY)) {
				if((data[x][y] == 'G' || data[x][y] == 'R') && (data[newX][newY] == 'G' || data[newX][newY] == 'R')) {
					blindDfs(newX, newY);
				} else	if (data[newX][newY] == d) {
					blindDfs(newX, newY);
				} else {
					queue.add(new Integer[] { newX, newY });
				}
			} // isVaild
		} // for
	}
	
	public static boolean isVaild(int x, int y) {
		if (x < 0 || y < 0 || x >= N || y >= N || visited[x][y])
			return false;
		return true;
	}

}
