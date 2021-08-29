import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int M;
	static int[][] data;
	static boolean[][] visited;
	static LinkedList<int[]> queue = new LinkedList<int[]>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		data = new int[N+1][M+1];
		visited = new boolean[N+1][M+1];
		for(int i =0; i<N; i++) {
			String input = br.readLine();
			for(int j=0; j<M; j++) {
				data[i+1][j+1] = input.charAt(j) - '0';
			}
		}
		
		bfs();
		System.out.println(data[N][M]);
	}
	
	public static void bfs() {
		int[] point = {1,1};
		queue.add(point);
		visited[point[0]][point[1]] = true;
		
		while(!queue.isEmpty()) {
			point = queue.poll();
			visited[point[0]][point[1]] = true;
			
			int x = point[0];
			int y = point[1];
			
			if(x-1>0) {
				if(!visited[x-1][y] && data[x-1][y] != 0) {
					queue.add(new int[] {x-1, y});
					visited[x-1][y]=true;
					data[x-1][y] += data[x][y];
				}
			}
			if(y-1>0) {
				if(!visited[x][y-1] && data[x][y-1] != 0) {
					queue.add(new int[] {x, y-1});
					visited[x][y-1]=true;
					data[x][y-1] += data[x][y];
				}
			}
			if(x+1 <= N) {
				if(!visited[x+1][y] && data[x+1][y] != 0) {
					queue.add(new int[] {x+1, y});
					visited[x+1][y]=true;
					data[x+1][y] += data[x][y];
				}
			}
			if(y+1 <= M) {
				if(!visited[x][y+1] && data[x][y+1] != 0) {
					queue.add(new int[] {x, y+1});
					visited[x][y+1]=true;
					data[x][y+1] += data[x][y];
				}
			}
		}
	}
}
