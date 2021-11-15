import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int N;
	static int[] num = new int[7];
	static boolean[] usedNum = new boolean[10];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		if(bt(0)) print();
		else System.out.println("No Answer");
	}
	
	public static boolean bt(int depth) {
		if(depth == 7) {
			if(sum()) {
				return true;
			} else {
				return false;
			}
		}
		
		for(int i=0; i<=9; i++) {
			if(!usedNum[i]) {
				usedNum[i] = true;
				num[depth] = i;
				if(bt(depth+1)) {
					return true;
				}
				usedNum[i] = false;
			}
		}
		return false;
	}
	
	public static boolean sum() {
		if (num[2] == 0 || num[6] == 0) {
			return false;
		}
		if ((num[0] + num[1] * 1000 + num[2] * 10000 + num[3] * 2 * 10 + num[3] * 100 + num[4] + num[4] * 1000
				+ num[5] * 100 + num[6] * 10000) != N) {
			return false;
		}
		return true;
	}
	
	public static void print() {
		StringBuilder sb = new StringBuilder();
		sb.append("  " + num[2] + num[1] + num[3] + num[3] + num[4] + "\n" + "+ " + num[6] + num[4] + num[5] + num[3]
				+ num[0] + "\n" + "-------\n");
		for (int i = String.valueOf(N).length(); i < 7; i++) {
			sb.append(" ");
		}
		sb.append(String.valueOf(N));
		System.out.println(sb.toString());
	}
}
