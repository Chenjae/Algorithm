import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int H, W;
	static boolean data[][];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		data = new boolean[W][H];
		for(int i=0; i<W; i++) {
			int height = Integer.parseInt(st.nextToken());
			for(int j=0; j<height; j++) {
				data[i][j] = true;
			}
		}
		int total = 0;
		for(int i=0; i<H; i++) {
			int water = 0;
			boolean flag = false;
			for(int j=0; j<W; j++) {
				if(data[j][i]) flag = true;
				if(flag && !data[j][i]) water++;
				if(flag && data[j][i]) {
					total += water;
					water = 0;
				}
			}
		}
		System.out.println(total);
	}
}
