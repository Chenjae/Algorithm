import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n,m;
	static int[][] data;
	static int[][] visited;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, -1, 0, 1};
	
	public static class Point {
		int x, y, t;
		public Point(int x, int y, int t) {
			this.x = x;
			this.y = y;
			this.t = t;
		}
	}
	
	public static void main(String[] args) throws IOException {
		Point start = null;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		data = new int[n+1][m+1];
		visited = new int[n+1][m+1];
		
		for(int i=1; i<=n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<=m; j++) {
				data[i][j] = Integer.parseInt(st.nextToken());
				if(data[i][j] == 2) {
					start = new Point(i,j,0);
				} else if(data[i][j] == 1) {
					visited[i][j] = -1;
				}
			}
		}
		bfs(start);
	}
	
	public static void bfs(Point start) {
		Queue<Point> que = new LinkedList<Point>();
		que.add(start);
		
		while(!que.isEmpty()) {
			Point p = que.poll();
			for(int i=0; i<4; i++) {
				int newX = p.x + dx[i], newY = p.y + dy[i];
				if(isVaild(newX,newY)) {
					que.add(new Point(newX, newY, p.t+1));
					visited[newX][newY] = p.t+1;
				}
			}
		}
		printResult();
	}
	
	public static boolean isVaild(int x, int y) {
		if(x<=0 || y<=0 || x>n || y>m || visited[x][y]>-1 || data[x][y]==0)
			return false;
		return true;
	}
	
	public static void printResult() {
		StringBuilder sb = new StringBuilder();
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=m; j++) {
				sb.append(visited[i][j] + " ");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
}
