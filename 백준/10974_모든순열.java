package report.day0820;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Quiz2 {
	//10974번 모든순열
	//https://www.acmicpc.net/problem/10974
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());

		for (int i = 1; i <= num; i++) {
			find(i, num, new ArrayList<Integer>());
		}

	}

	static void find(int start, int num, ArrayList<Integer> list) {
		list.add(start);
		
		if(list.size() != num) {
			for(int i=1; i<=num; i++) {
				if(!list.contains(i)) {
					find(i, num, list);
					list.remove(Integer.valueOf(i));
				}
			}
		}else {
			for(int i : list)
				System.out.print(i + " ");
			System.out.println();
		}
	}
}
