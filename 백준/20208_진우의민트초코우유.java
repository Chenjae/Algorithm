import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	public static class Point {
		int x, y;
		Point(int x, int y) {
			this.x = x; this.y = y;
		}
	}

	static int N, M, H;
	static int data[][];
	static int result = 0;
	static Point home;	
	static ArrayList<Point> milk = new ArrayList<Point>();
	static boolean[] visited;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, -1, 0, 1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		data = new int[N+1][N+1];
		
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<=N; j++) {
				data[i][j] = Integer.parseInt(st.nextToken());
				if(data[i][j]==1) home = new Point(i,j);
				if(data[i][j]==2) milk.add(new Point(i,j));
			}
		}
		visited = new boolean[milk.size()];
		for(int i=0; i<milk.size(); i++) {
			Point p = milk.get(i);
			int dist = Math.abs(p.x-home.x) + Math.abs(p.y-home.y);
			
			if(dist<=M) {
				solve(p, i, M+H-dist, 1);
			}
		}
		System.out.println(result);
	}
	
	static void solve(Point now, int idx, int h, int cnt) {
        visited[idx] = true;
        for (int i = 0; i < milk.size(); i++) {
            if (!visited[i]) {
                Point next = milk.get(i);
                int dist = Math.abs(now.x - next.x) + Math.abs(now.y - next.y);

                if (dist <= h)
                    solve(next, i, h - dist + H, cnt + 1);
            }
        }
        int dist = Math.abs(now.x - home.x) + Math.abs(now.y - home.y);
        if (dist <= h) {
            result = Math.max(result, cnt);
        }
        visited[idx] = false;
    }
}
