import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        int answer = 0;
        boolean[][] map = new boolean[n+1][n+1];
        int[] visited = new int[n+1];
        Queue<Integer> que = new LinkedList<Integer>();
        
        for(int i=0; i<edge.length; i++) {
            int from = edge[i][0];
            int to = edge[i][1];
            map[from][to] = true;
            map[to][from] = true;
        }
        
        visited[1] = 1;
        for(int i=1; i<=n; i++) {
            if(map[1][i]) {
                que.add(i);
                visited[i] = 2;
            }
        }
        
        int num = 0;
        while(!que.isEmpty()) {
            int now = que.poll();
            num = visited[now];
            
            for(int i=1; i<=n; i++) {
                if(map[now][i] && visited[i] == 0) {
                    que.add(i);
                    visited[i] = num+1;
                }
            }
        }
        
        for(int i=1; i<=n; i++) {
            if(visited[i] == num) answer++;
        }
        return answer;
        
    }
}
