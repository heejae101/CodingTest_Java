import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
class Date{
    int year,month,day;
    Date(String s){
        this.year = Integer.parseInt(s.substring(0,4));
        this.month = Integer.parseInt(s.substring(5,7));
        this.day = Integer.parseInt(s.substring(8,10));
    }
    public int exp(){
        return this.year*10000+this.month*100+this.day;
    }
}
class Solution {
     public ArrayList<Integer> solution(String today, String[] terms, String[] privacies) {
        ArrayList<Integer> answer = new ArrayList<>();
        final int maxDay = 28;
        final int maxMonth = 12;

        Date now = new Date(today);
        HashMap<String,Integer> map = new HashMap<>();
        for(String x : terms){
            String type = x.split(" ")[0];
            int term = Integer.parseInt(x.split(" ")[1]);
            map.put(type,term);
        }

        int idx = 1;
        for(String x : privacies){
            Date date = new Date(x.split(" ")[0]);
            int sumMonth = map.get(x.split(" ")[1])+date.month;
            int cnt = 0;
            while (sumMonth > maxMonth){
                sumMonth -= maxMonth;
                cnt++;
            }
            date.year += cnt;
            date.month = sumMonth;
            if(date.exp()<=now.exp()){
                answer.add(idx);
            }
            idx++;
        }
        return answer;
    }
}