package report.day0821;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

import javax.sound.sampled.DataLine;

public class Quiz3 {
	//6603번 로또
	//https://www.acmicpc.net/problem/6603
	static int[] data;
	static boolean[] checked;
	static int k;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		whileLoop:
		while(true) {
			String[] st = br.readLine().split(" ");
			
			k = Integer.parseInt(st[0]);
			if(k==0) break whileLoop;
			
			data = new int[k];
			checked = new boolean[k];
			for(int i=0; i<k; i++) {
				data[i] = Integer.parseInt(st[i+1]);
			}
			
			dfs(0, 0);
			System.out.println();
		}
	}
	
	public static void dfs(int depth, int start) {
		if(depth == 6) {
			for(int i=0; i<k; i++) {
				if(checked[i]) 
					System.out.print(data[i] + " ");
			}
			System.out.println();
		}
		
		for(int i=start; i<k; i++) {
			checked[i] = true;
			dfs(depth+1, i+1);
			checked[i] = false;
		}
	}
}

