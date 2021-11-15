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
		int to, val;
		public P(int to, int val) {
			this.to = to;
			this.val = val;
		}
		@Override
		public int compareTo(P o) {
			return Integer.compare(this.val, o.val);
		}
	}
	
	static PriorityQueue<P> que = new PriorityQueue<P>();
	static int[] result;
	static boolean[] visited;
	static List<List<P>> map = new ArrayList<List<P>>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(br.readLine());
		
		for(int i=0; i<=V; i++) {
			map.add(new ArrayList<P>());
		}
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			map.get(u).add(new P(v,w));
		}
		
		result = new int[V+1];
		int maxVal = 10*V+1;
		Arrays.fill(result, maxVal);
		visited = new boolean[V+1];
		
		que.add(new P(K, 0));
		result[K] = 0;
		
		while(!que.isEmpty()) {
			P now = que.poll();
			int current = now.to;
			int distance = now.val;
			
			if(result[current]<distance || visited[current]) continue;
			visited[current] = true;
			
			for(P post : map.get(current)) {
				int nextDistance = distance + post.val;
				if(nextDistance < result[post.to]) {
					result[post.to] = nextDistance;
					que.add(new P(post.to, nextDistance));	
				}
			}
		}
		for(int i=1; i<result.length; i++) {
			if(result[i] == maxVal) {
				System.out.println("INF");
			} else {
				System.out.println(result[i]);
			}
		}
	}
}
