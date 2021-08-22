package report.day0821;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Quiz2 {
	//1065번 한수
	//https://www.acmicpc.net/problem/1065
	
	public static void countHansu(int n) {
		if(n==1000) n=999;
		
		
		int count = 0;
		if(n<=99) System.out.println(n);
		else {
			count = 99;
			for(int i=100; i<=n; i++) {
				int h = i/100;
				int t = i/10 - h*10;
				int o = i%10;
				
				if((h-t) == (t-o)) count++;
			}
			System.out.println(count);
		}
	}
	
	static int N;
	static int count=0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		
		
		countHansu(N);
	}

}
