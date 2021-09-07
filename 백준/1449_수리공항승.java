import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

	static ArrayList<Integer> points = new ArrayList<Integer>();
	static int size;
	static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		size = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			points.add(Integer.parseInt(st.nextToken()));
		}
		
		Collections.sort(points);
		
		int first = points.get(0);
		int result = 1; //첫번째 구멍 막은 테이프
		for(int i=1; i<N; i++) {
			if(points.get(i)-first+1 > size) { //테이프보다 거리가 크면
				result++;
				first = points.get(i);
			} 
		}
		
		System.out.println(result);
	}
}
