class Solution {
    
    public int find(int[] numbers, int target, int sum, int level) {
        if(numbers.length == level) {
            if(target == sum) {
                return 1;
            } else {
                return 0;
            }
        }
        int n=0;
        n += find(numbers, target, sum+numbers[level], level+1);
        n += find(numbers, target, sum-numbers[level], level+1);
        
        return n;
    }
    
    
    public int solution(int[] numbers, int target) {
        int answer = 0;
        
        answer = find(numbers, target, 0, 0);
        
        return answer;
    }
}
