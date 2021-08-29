import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	//알파벳
	//https://www.acmicpc.net/problem/1987
	
	static char data[][];
	static boolean visited[][];
	static int R, C;
	static boolean checked[] = new boolean[30];
	static int result = Integer.MIN_VALUE;
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		data = new char[R][C];
		visited = new boolean[R][C];
		
		for(int i=0; i<R; i++) {
			char[] input = br.readLine().toCharArray();
			for(int j=0; j<C; j++) {
				data[i][j] = input[j];
			}
		}
		
		dfs(0,0,1);
		
		System.out.println(result);
	}
	
	public static void dfs(int x, int y, int depth) {
		checked[data[x][y]-'A'] = true;
		visited[x][y] = true;
		result = Math.max(result, depth);
		
		
		for(int i=0; i<4; i++) {
			int newX = x+dx[i], newY = y+dy[i];
			if(isVaild(newX, newY))
				dfs(newX, newY, depth+1);
		}
		
		checked[data[x][y]-'A'] = false;
		visited[x][y] = false;
	}
	
	public static boolean isVaild(int x, int y) {
		if(x<0 || y<0 || x>=R || y>=C || visited[x][y] || checked[data[x][y]-'A']) 
			return false;
		return true;
	}
}
