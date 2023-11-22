import java.util.Arrays;
import java.util.Stack;
class Solution {
    public int solution(int[] ingredient) {
        int answer = 0;
        // 스택에서 빼는 순서
        int[] order = {1,3,2,1};
        Stack<Integer> stack = new Stack<>();

        for (int x : ingredient){
            stack.push(x);
            if(x == 1 && stack.size() > 3){
                int[] now = new int[4];
                for(int i=0; i<4; i++){
                    if(order[i] == stack.peek()){
                        now[i] = stack.pop();
                    }else{
                        now[i] = stack.pop();
                        for(int j=i; j>=0; j--){
                            stack.push(now[j]);
                        }
                        break;
                    }
                }
                if(Arrays.equals(now, order)) answer++;
            }
        }
        return answer;
    }
}