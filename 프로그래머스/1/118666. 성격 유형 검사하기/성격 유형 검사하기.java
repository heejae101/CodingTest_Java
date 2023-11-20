import java.util.HashMap;
class Solution {
    public String solution(String[] survey, int[] choices) {
        StringBuilder answer = new StringBuilder();

        final int size = 4;
        final String s1 = "RCJA";
        final String s2 = "TFMN";

        // 성격 유형
        HashMap<Character,Integer> map1 = new HashMap<>();
        HashMap<Character,Integer> map2 = new HashMap<>();
        for(int i=0; i<size; i++) map1.put(s1.charAt(i),i);
        for(int i=0; i<size; i++) map2.put(s2.charAt(i),i);

        // 점수
        int[] sc1 = new int[size];
        int[] sc2 = new int[size];

        // 판별기 앞이 비동의 뒤가 동의 매우 동의가 7 매우 비동이 1
        for(int i=0; i<choices.length; i++){
            char select;
            if(choices[i] > 3){
                select = survey[i].charAt(1);
            }else select = survey[i].charAt(0);
            if(map1.containsKey(select)){
                sc1[map1.get(select)] += Math.abs(choices[i]-4);
            }else sc2[map2.get(select)] += Math.abs(choices[i]-4);
        }

        // 결과
        for(int i=0; i<size; i++){
            if(sc1[i] > sc2[i]){
                answer.append(s1.charAt(i));
            }else if(sc1[i] < sc2[i]){
                answer.append(s2.charAt(i));
            }else answer.append(s1.charAt(i));
        }

        return answer.toString();
    }
}