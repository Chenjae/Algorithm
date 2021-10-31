import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	public static class Item{
		int W, V;
		Item(int W, int V) {
			this.W = W;
			this.V = V;
		}
	}
	static int N, K;
	static ArrayList<Item> itemList = new ArrayList<Item>();
	static int[] dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		dp = new int[K+1];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int w = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			Item item = new Item(w, v);
			itemList.add(item);
		}
		
		for(int i=0; i<N; i++) {
			Item item = itemList.get(i);
			for(int j=K; j>=item.W; j--) {
				dp[j] = Math.max(dp[j], dp[j - item.W] + item.V);
			}
		}
		
		System.out.println(dp[K]);
	}
}
