import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	//토마토
	//https://www.acmicpc.net/problem/7576
	
	static int M, N;
	static int[][] data;
	static int[][] visited;
	static LinkedList<Integer[]> queue = new LinkedList<Integer[]>();
	
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};
	static int day = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		data = new int[N][M];
		visited = new int[N][M];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				data[i][j] = Integer.parseInt(st.nextToken(" "));
				if(data[i][j] == 1) {
					visited[i][j] = 1;
					queue.add(new Integer[]{i, j});
				}
				else if(data[i][j] == -1) {
					visited[i][j] = -1;
				}
			}
		}
		bfs();
		System.out.println(day-1);
	}
	
	static public void bfs() {
		while(!queue.isEmpty()) {
			Integer[] point = queue.poll();
			int x = point[0], y = point[1];
			
			if(visited[x][y]>=0) {
				day = visited[x][y];
			}
			
			for(int i=0; i<4; i++) {
				int newX = x+dx[i], newY = y+dy[i];
				
				if(isVaild(newX, newY)) {
					visited[newX][newY] = day+1;
					queue.add(new Integer[] {newX, newY});
				}
			}
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(visited[i][j] == 0) {
					day = 0;
					return;
				}
			}
		}
	}
	
	static boolean isVaild(int x, int y) {
		if(x<0 || y<0 || x>=N || y>=M || visited[x][y]!=0)
			return false;
		return true;
	}
}
