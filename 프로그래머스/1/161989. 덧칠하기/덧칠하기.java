class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        int lt = section[0];
        answer++;
        for(int x : section){
            if(lt + m > x) continue;
            lt = x;
            answer++;
        }
        return answer;
    }
}