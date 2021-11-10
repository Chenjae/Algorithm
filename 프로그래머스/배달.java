class Solution {
    public int solution(int N, int[][] road, int K) {
        int[][] map = new int[N+1][N+1];
        int answer = 0;
        
        for(int i=1; i<=N; i++) {
            for(int j=1; j<=N; j++) {
                if(i==j) {
                    map[i][j] = 0;
                    continue; 
                }
                map[i][j] = 500001;
            }
        }
        
        for(int i=0; i<road.length; i++) {
            int from = road[i][0];
            int to = road[i][1];
            int val = road[i][2];
            
            if(map[from][to] < val) continue;
            map[from][to] = val;
            map[to][from] = val;
        }
        
        for(int k=1; k<=N; k++) {
            for(int i=1; i<=N; i++) {
                for(int j=1; j<=N; j++) {
                    if(i==j) continue;
                    if(map[i][j] > map[i][k]+map[k][j])
                        map[i][j] = map[i][k]+map[k][j];
                }
            }
        }
        
        for(int i=1; i<=N; i++) {
            if(map[1][i] <= K) answer++;
        }
        
        return answer;
    }
}
