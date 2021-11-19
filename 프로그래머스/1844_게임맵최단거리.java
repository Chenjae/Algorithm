import java.util.*;

class Solution {
    public class P {
        int x, y, depth;
        public P(int x, int y, int depth) {
            this.x = x;
            this.y = y;
            this.depth = depth;
        }
    }
    static public int[] dx = {-1, 0, 1, 0};
    static public int[] dy = {0, -1, 0, 1};
    public int solution(int[][] maps) {
        int answer = 0;
        answer = bfs(maps);
        return answer;
    }
    
    
    public int bfs(int[][] maps) {
        Queue<P> que = new LinkedList<P>();
        int n = maps.length;
        int m = maps[0].length;
        boolean[][] visited = new boolean[n][m];
        forloop:
        for(int i=0; i<maps.length; i++) {
            for(int j=0; j<maps[0].length; j++) {
                if(maps[i][j] == 1) {
                    que.add(new P(i,j,1));
                    break forloop;
                }
            }
        }
        while(!que.isEmpty()) {
            P now = que.poll();
            if(now.x == maps.length-1 && now.y == maps[0].length-1) {
                return now.depth;
            }
           
            for(int i=0; i<4; i++) {
                int nX = now.x + dx[i];
                int nY = now.y + dy[i];
                if(isVaild(nX, nY, maps, visited)) {
                    visited[nX][nY] = true;
                    que.add(new P(nX,nY,now.depth+1));
                }
            }
        }
        return -1;
    }
    
    public boolean isVaild(int x, int y, int[][] maps, boolean[][] visited) {
        if(x<0 || y<0 || x>=maps.length || y>=maps[0].length || visited[x][y] || maps[x][y]==0) return false;
        return true;
    }
}
