import java.util.*;
class Solution {
    public int solution(int[][] board, int[] move){
        int n = board.length;
        int result = 0;
        Stack<Integer> stack = new Stack<>();
        for(int x : move){
            for(int i=0; i<n; i++){
                int target = board[i][x-1];
                board[i][x-1] = 0;
                if(target != 0){
                    if(!stack.isEmpty()){
                        if(stack.peek() == target){
                            result++;
                            stack.pop();
                            result++;
                        }else stack.add(target);
                    }else stack.add(target);
                    break;
                }
            }
        }
        return result;
    }
}