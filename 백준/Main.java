
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	public static LinkedList<Integer> queue = new LinkedList();
	public static boolean[] visited;
	public static int[][] grape;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		String[] data = br.readLine().split(" ");

		int n = Integer.parseInt(data[0]);
		int m = Integer.parseInt(data[1]);
		int v = Integer.parseInt(data[2]);

		grape = new int[n + 1][n + 1];
		visited = new boolean[n + 1];

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());

			grape[s][e] = 1;
			grape[e][s] = 1;
		}

		// 1. DFS : ±íÀÌ ¿ì¼± Å½»ö
		// Stack
		dfs(v);
		System.out.println();
		visited = new boolean[n + 1];

		// 2. BFS : ³ÐÀÌ ¿ì¼± Å½»ö
		// Queue
		bfs(v);

	}

	public static void dfs(int start) {
		System.out.print(start + " ");
		visited[start] = true;
		for (int i = 1; i < visited.length; i++)
			if (!visited[i] && grape[start][i] == 1)
				dfs(i);
	}

	public static void bfs(int start) {
		queue.add(start);
		visited[start]=true;

		while (!queue.isEmpty()) {
			int num = queue.poll();
			System.out.print(num + " ");
			for (int i = 1; i < visited.length; i++) {
				if (!visited[i] && grape[num][i] == 1) {
					queue.add(i);
					visited[i] = true;
				}
			}
		}

	}

}
