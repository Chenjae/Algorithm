import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long max = Long.MIN_VALUE;
		
		int K = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		long[] data = new long[K];
		for(int i=0; i<K; i++) {
			data[i] = Long.parseLong(br.readLine());
			max = Math.max(max, data[i]);
		}
		max++;
		long min = 0;
		long mid = 0;
		while(min<max) {
			mid = (min+max)/2;
			
			long count = 0;
			
			for(int i=0; i<data.length; i++) {
				count += (data[i]/mid);
			}
			
			if(count < N) {
				max = mid;
			} else {
				min = mid + 1;
			}
		}
		
		System.out.println(min -1);
 	}
}
