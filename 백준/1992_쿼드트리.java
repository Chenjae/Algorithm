package report.day0822;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Quiz1 {
	//1992번 쿼드트리
	//https://www.acmicpc.net/problem/1992
	static int N;
	static int[][] data;
	static StringBuilder result = new StringBuilder();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		data = new int[N][N];
		
		for(int i=0; i<N; i++) {
			String input = br.readLine();
			for(int j=0; j<N; j++) {
				data[i][j] = input.charAt(j)-'0';
			}
		}
		
		
		quadTree(0,0,N);
		
		System.out.println(result);
	}
	
	static public void quadTree(int x, int y, int size) {
		if(isPossible(x,y,size)) {
			result.append(data[x][y]);
			return;
		}
		
		int s = size/2;
		
		result.append('(');
		
		quadTree(x, y, s);
		quadTree(x, y+s, s);
		quadTree(x+s, y, s);
		quadTree(x+s, y+s, s);
		
		result.append(')');
	}
	
	static boolean isPossible(int x, int y, int size) {
		int value = data[x][y];
		
		for(int i=x; i<x+size; i++) {
			for(int j=y; j<y+size; j++) {
				if(value != data[i][j])
					return false;
			}
		}
		
		return true;
	}

}
