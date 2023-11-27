class Solution {
    public int solution(String[][] board, int h, int w) {
        int answer = 0;
        int[] dh = {0, 1, -1, 0};
        int[] dw = {1, 0, 0, -1};
        
        for(int i=0; i<dh.length; i++){
            int h_check = h + dh[i];
            int w_check = w + dw[i];
            if(h_check >= 0 && h_check < board.length && w_check >= 0 && w_check < board.length){
                if(board[h_check][w_check].equals(board[h][w])) answer++;
            }
        }
        return answer;
    }
}