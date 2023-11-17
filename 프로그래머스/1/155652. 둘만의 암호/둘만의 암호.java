import java.util.ArrayList;
class Solution {
    public String solution(String s, String skip, int index) {
        StringBuilder answer = new StringBuilder();
        ArrayList<Character> list = new ArrayList<>();

        for(int i=97; i<=122; i++) list.add((char)i);
        for(Character x : skip.toCharArray()) list.remove(x);
        for(char x : s.toCharArray()){
            int idx = list.indexOf(x);
            idx = (idx + index) % list.size();
            answer.append(list.get(idx));
        }

        return answer.toString();
    }
}