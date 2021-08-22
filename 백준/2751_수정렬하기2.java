package report.day0821;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//2751번 수 정렬하기2
//https://www.acmicpc.net/problem/2751

public class Quiz5 {
	static int N;
	static int[] list = new int[1000005];
	static int[] sortedList = new int[1000005];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		
		for(int i=0; i<N; i++)  {
			list[i] = Integer.parseInt(br.readLine());
		}
		
		sort(0,N-1);
		
		for(int i=0; i<N; i++)  {
			System.out.println(list[i]);
		}
	}
	
	public static void sort(int start, int end) {
		if(start>=end) return;
		
		int mid = (start+end)/2;
		int lcnt = start;
		int rcnt = mid+1;
		int i=start;
		
		sort(start,mid);
		sort(mid+1,end);
	
	
		while(lcnt<=mid && rcnt<=end) {
			if(list[lcnt] <= list[rcnt]) sortedList[i++] = list[lcnt++];
			else sortedList[i++] = list[rcnt++];
		}
		while(lcnt<=mid) {
			sortedList[i++] = list[lcnt++];
		}
		while(rcnt<=end) {
			sortedList[i++] = list[rcnt++];
		}
		
		for(int j=start; j<=end; j++) {
			list[j] = sortedList[j];
		}
	}
}
