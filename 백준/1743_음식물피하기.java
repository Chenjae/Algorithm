package report.day0823;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Problem1743 {
	//음식물 피하기
	//https://www.acmicpc.net/problem/1743
	static int N, M, K;
	static boolean[][] data;
	static boolean[][] visited;
	static LinkedList<int[]> queue = new LinkedList<int[]>();
	
	static int[] dx = {0, -1, 0, 1};
	static int[] dy = {-1, 0, 1, 0};
	static int result = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		data = new boolean[N+1][M+1];
		visited = new boolean[N+1][M+1];
		
		for(int i=0; i<K; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			data[x][y] = true;
			queue.add(new int[] {x,y});
		}
		
		while(!queue.isEmpty()) {
			int temp = result;
			result = 0;
			int[] point = queue.poll();
			int x = point[0], y = point[1];
			dfs(x, y);
			result = Math.max(temp, result);
		}
		
		System.out.println(result);
	}
	
	
	public static void dfs(int x, int y) {
		result++;
		
		visited[x][y] = true;
		for(int i=0; i<4; i++) {
			int newX = x+dx[i];
			int newY = y+dy[i];
			if(isVaild(newX, newY)) {
				dfs(newX, newY);
			}
		}
	}
	
	public static boolean isVaild(int x, int y) {
		if(x<1 || y<1 || x>N || y>M || visited[x][y] || !data[x][y])  
			return false;
		return true;
	}

}
