import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static char[] word;
	static char[] list;
	static int L, C;
	static StringBuffer sb = new StringBuffer();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		word = new char[L];
		list = new char[C];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<C; i++) {
			list[i] = st.nextToken().toCharArray()[0];
		}
		Arrays.sort(list);
		
		bf(word, 0, 0, 0, 0);
		System.out.println(sb.toString());
	}
	
	public static void bf(char[] word, int idx, int depth, int mo, int ja){
		if(depth == L) {
            if(mo>=1 && ja>=2) {
			    for(int i=0; i<L; i++) sb.append(word[i]);
			    sb.append("\n");
            }
			return;
		}
		if(idx == C) return;
		
		int moem = mo;
		int jaem = ja;
		if(list[idx] == 'a' || list[idx] == 'e' || list[idx] == 'i' || list[idx] == 'o' || list[idx] == 'u') {
			moem = mo + 1;
		} else {
			jaem = ja + 1;
		}
		word[depth] = list[idx];
		bf(word, idx+1, depth+1, moem, jaem);
		bf(word, idx+1, depth, mo, ja);
	}
	
}
