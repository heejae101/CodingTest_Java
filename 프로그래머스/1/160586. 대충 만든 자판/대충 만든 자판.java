import java.util.HashMap;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];

        HashMap<Character,Integer> map = new HashMap<>();

        for(String x : keymap){
            char[] keys = x.toCharArray();
            for(int i=0; i<keys.length; i++){
                if(map.containsKey(keys[i])) map.put(keys[i],Math.min(map.get(keys[i]),i+1));
                else map.put(keys[i],i+1);
            }
        }

        for(int i=0; i<targets.length; i++){
            int sum = 0;
            boolean flag = true;
            for(char key : targets[i].toCharArray()){
                if(map.containsKey(key)) sum += map.get(key);
                else{
                    flag = false;
                    break;
                }
            }
            answer[i] = flag ? sum : -1;
        }
        return answer;
    }
}