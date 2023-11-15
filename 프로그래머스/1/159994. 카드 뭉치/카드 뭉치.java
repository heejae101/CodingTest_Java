import java.util.HashMap;
class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "";
        // 영어 단어 적힌 카드 뭉치 2개 다음과 같은 규칙으로 원하는 순서의 단어 배열을 만들자
        // 원하는 카드 뭉치에서 카드를 순서대로 한장씩 사용, 한번 사용한 카드는 다시 사용 X
        // 카드를 사용하지 않고 다음 카드로 못넘어감
        // 기존에 주어진 카드 뭉치의 단어 순설는 바꿀 수 없음
        HashMap<String,Integer> map1 = new HashMap<>();
        HashMap<String,Integer> map2 = new HashMap<>();
        
        for(int i=0; i<cards1.length; i++) map1.put(cards1[i],i);
        for(int i=0; i<cards2.length; i++) map2.put(cards2[i],i);
        
        int idx1 = 0, idx2 = 0;
        boolean isPoss = true;
        for(String x : goal){
            if(map1.containsKey(x) && map1.get(x) == idx1) idx1++;
            else if(map2.containsKey(x) && map2.get(x) == idx2) idx2++;
            else {
                isPoss = false;
                break;
            }
        }
        answer = isPoss ? "Yes" : "No";
        
        return answer;
    }
}