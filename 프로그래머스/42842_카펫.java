import java.util.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = {};
        int total = brown + yellow;
        int x, y;
        
        for(int i=2; i<total; i++) {
            if(total % i == 0) {
                x = total/i;
                y = i;
                
                if((brown == 2*(x+y-2)) && (yellow == (x-2)*(y-2))) {
                    answer = new int[] {x, y};
                    break;
                }
            }
        }
        return answer;
    }
}

