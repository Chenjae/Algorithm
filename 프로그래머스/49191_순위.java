import java.util.*;

class Solution {
    public int solution(int n, int[][] results) {
        int answer = 0;
        
        List<Set<Integer>> data = new ArrayList<Set<Integer>>();
        for(int i=0; i<=n; i++) {
            data.add(new HashSet<Integer>());
        }
        
        for(int i=0; i<results.length; i++) {
            int winner = results[i][0];
            int loser = results[i][1];
            
            data.get(winner).add(loser);
            data.get(loser).add(-winner);
        }
        
        for(int i=1; i<=n; i++) {
            Object[] now = data.get(i).toArray();
            for(int j=0; j<now.length; j++) {
                int idx = (int)(now[j]);
                if(idx > 0) {
                    Object [] winList = data.get(idx).toArray();
                    for(int l=0; l<winList.length; l++) {
                        int idxWin = (int)(winList[l]);
                        if(idxWin>0) {
                            data.get(i).add(idxWin);
                            data.get(idxWin).add(-i);
                        }
                    }
                } else {
                    Object [] loseList = data.get(-idx).toArray();
                    for(int l=0; l<loseList.length; l++) {
                        int idxLose = (int)(loseList[l]);
                        if(idxLose<0) {
                            data.get(i).add(idxLose);
                            data.get(-idxLose).add(i);
                        }
                    }
                }
            }
        }
        
        
        System.out.println(data);
        
        for(int i=1; i<=n; i++) {
            if(data.get(i).size() == n-1) answer++;
        }
        
        return answer;
        
    }
}
