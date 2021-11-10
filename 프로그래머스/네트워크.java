import java.util.*;

class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        Queue<Integer> que = new LinkedList<Integer>();
        boolean[] visited = new boolean[n];
        
        for(int i=0; i<n; i++) {
            if(!visited[i]) {
                answer++;
                que.add(i);
                while(!que.isEmpty()) {
                    int now = que.poll();
                    visited[now] = true;
                    for(int j=0; j<computers[now].length; j++) {
                        if(computers[now][j] == 1 && now != j && !visited[j]) {
                            que.add(j);
                        }
                    }
                }
            }
        }
        
        return answer;
    }
}
