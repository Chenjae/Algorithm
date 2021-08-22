package report.day0821;

public class Brute {
	//brute-force 알고리즘
	//모든 부분 집합을 출력
	static String data[] = {"a", "b", "c", "d"};
	static boolean visited[] = new boolean[4];
	
	static void go(int depth) {
		if(depth == data.length) {
			for(int i=0; i<visited.length; i++) {
				if(visited[i])
					System.out.print(data[i]);
			}
			System.out.println();
			return;
		}
		visited[depth] = true;
		go(depth+1);
		visited[depth] = false;
		go(depth+1);
	}
	
	public static void main(String[] args) {
		go(0);
	}
}
