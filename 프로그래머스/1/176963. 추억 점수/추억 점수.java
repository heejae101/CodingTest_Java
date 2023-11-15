import java.util.HashMap;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        // answer 초기화 
        int[] answer = new int[photo.length];
        // map 초기화
        HashMap<String,Integer> map = new HashMap<>();
        
        // map 이름 : index 저장
        for(int i=0; i<name.length; i++) map.put(name[i],i);
        
        
        for(int i=0; i<photo.length; i++){
            int sum = 0;
            for(int j=0; j<photo[i].length; j++){
                if(map.get(photo[i][j]) != null){
                    int index = map.get(photo[i][j]);
                    sum += yearning[index];
                }
            }
            answer[i] = sum;
        }
        return answer;
    }
}