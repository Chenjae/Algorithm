import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static int[] visited = new int[100005];
	static LinkedList<Integer> queue = new LinkedList<Integer>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
	
		if(N==K) System.out.println(0);
		else bfs(N, K);
	}

	public static void bfs(int N, int K) {
		queue.add(N);
		visited[N] = 1;

		while (!queue.isEmpty()) {
			int index = queue.poll();
			
			for (int i = 0; i < 3; i++) {
				int next;
				if (i == 0) {
					next = index + 1;
				} else if (i == 1) {
					next = index - 1;
				} else {
					next = index * 2;
				}
				if (next == K) {
					System.out.println(visited[index]);
					return;
				}
				if (next >= 0 && next < visited.length && visited[next] <= 0) {
					queue.add(next);
					visited[next] = visited[index] + 1;
				}
			}//for
		}//while
	}//bfs
}
