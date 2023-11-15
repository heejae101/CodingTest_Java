import java.util.HashMap;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        String[] answer = {};
        
        // map에 데이터 넣기
        HashMap<String,Integer> map = new HashMap<>();
        for(int i=0; i<players.length; i++){
            map.put(players[i],i);
        }
        
        for(String x : callings){
            int index = map.get(x);
            if(index>0){
                String temp = players[index];
                map.put(players[index-1], map.get(players[index-1])+1);
                players[index] = players[index-1];
                players[index-1] = temp;
                map.put(temp,index-1);
            }
        }
        answer = players;
        return answer;
    }
}