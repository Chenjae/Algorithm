import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static class P implements Comparable<P> {
		int node, distance;
		public P(int node, int distance) {
			this.node = node;
			this.distance = distance;
		}
		@Override
		public int compareTo(P o) {
			return this.distance - o.distance;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		PriorityQueue<P> que = new PriorityQueue<P>();
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		List<List<P>> map = new ArrayList<>();
		boolean[] visited = new boolean[N+1];
		int[] result = new int[N+1];
		Arrays.fill(result, 100000 * (N-1));
		
		for(int i=0; i<=N; i++) {
			map.add(new ArrayList<P>());
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			map.get(s).add(new P(e,v));
		}
		
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());

		result[start] = 0;
		que.add(new P(start,0));

		while(!que.isEmpty()) {
			P now = que.poll();
			int current = now.node;
			int distance = now.distance;
			
			if(!visited[current]) {
				visited[current] = true;
				for(P p : map.get(current)) {
					int nextDistance = distance + p.distance;
					if(!visited[p.node] && nextDistance < result[p.node]) {
						result[p.node] = nextDistance;
						que.add(new P(p.node, nextDistance));
					}
				}
			}
		}	
		
		System.out.println(result[end]);
	}
}
