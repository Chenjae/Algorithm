package report.day0822;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	//https://www.acmicpc.net/problem/1780
	//1780번 종이의 개수 
	
	public static int N;
	public static int[][] data;
	public static int[] result = new int[3];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		data = new int[N][N];
		
		for(int i=0; i<N; i++) {
			String input = br.readLine();
			st = new StringTokenizer(input);
			for(int j=0; j<N; j++) {
				data[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		cutting(0,0,N);
		
		for(int i : result) {
			System.out.println(i);
		}
	}
	
	static public void cutting(int x, int y, int size) {
		if(isPossible(x,y,size)) {
			if(data[x][y] == -1) result[0]++;
			else if(data[x][y]==0) result[1]++;
			else result[2]++;
			
			return;
		}
		
		int s = size/3;
		
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				cutting(x+s*i,y+s*j,s);
			}
		}
	}
	
	static boolean isPossible(int x, int y, int size) {
		int value = data[x][y];
		
		for(int i=x; i<x+size; i++) {
			for(int j=y; j<y+size; j++) {
				if(data[i][j] != value) return false;
			}
		}
		
		return true;
	}
}
