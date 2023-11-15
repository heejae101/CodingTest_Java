import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

class Point implements Comparable<Point> {
    int x,y;
    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Point o) {
        if(this.x == o.x) return this.y-o.y;
        else return this.x-o.x;
    }
}
class Solution {
    
    static ArrayList<Point> arr = new ArrayList<>();
    
    public int[] solution(String[] wallpaper) {
        int[] answer = new int[4];
        int len = wallpaper.length;
        for(int i=0; i<len; i++){
            int strLen = wallpaper[i].length();
            for(int j=0; j<strLen; j++){
                if(wallpaper[i].charAt(j) == '#') arr.add(new Point(i,j));
            }
        }
        Collections.sort(arr);
        // 처음 조건 x가 제일 작고 y도 제일 작은수 1, 3
        // 마지막 조건 x가 제일 크고 y도 제일 큰수

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int i=0; i<arr.size(); i++){
            max = Math.max(max, arr.get(i).y);
            min = Math.min(min,arr.get(i).y);
        }

        answer[0] = arr.get(0).x;
        answer[1] = min;
        answer[2] = arr.get(arr.size()-1).x+1;
        answer[3] = max+1;
        return answer;
    }
}