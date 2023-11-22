import java.util.*;

class location{
    int x,y;
    location(int x, int y){
        this.x = x;
        this.y = y;
    }
}
class Solution {
    public String solution(int[] numbers, String hand) {
        StringBuilder answer = new StringBuilder();
        // 왼손과 오른손 엄지로만 이용
        // 1, 4, 7 왼쪽 3, 6, 9 오른쪽
        // 처음에는 * # 에서 시작 엄지는 상하좌우로만 이동이 가능
        // 가운데 열 4개의 숫자는 현재 키패드의 위치에서 더 가까운 엄지 손가락 사용
        // 1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5
        // right
        // L R L L L R L L R R L

        // 휴대폰 자판
        HashMap<Integer, location> numMap = new HashMap<>();
        int num = 1;
        for(int i=0; i<4; i++){
            for(int j=0; j<3; j++) numMap.put(num++,new location(i,j));
        }
        numMap.put(0,new location(3,1));

        // 시작 위치
        location leftLoc = new location(3,0);
        location rightLoc = new location(3,2);

        // set
        Set<Integer> leftSet = new HashSet<>(Arrays.asList(1, 4, 7));
        Set<Integer> rightSet = new HashSet<>(Arrays.asList(3, 6, 9));

        for(int x : numbers){
            location target = numMap.get(x);
            if(leftSet.contains(x)){
                leftLoc = target;
                answer.append('L');
            }else if (rightSet.contains(x)){
                rightLoc = target;
                answer.append('R');
            }else{
                int leftDis = Math.abs(target.x-leftLoc.x)+Math.abs(target.y-leftLoc.y);
                int rightDis = Math.abs(target.x-rightLoc.x)+Math.abs(target.y-rightLoc.y);
                if(leftDis > rightDis){
                    rightLoc = target;
                    answer.append('R');
                }else if(leftDis < rightDis){
                    leftLoc = target;
                    answer.append('L');
                }else{
                    if(hand.equals("left")){
                        leftLoc = target;
                        answer.append('L');
                    }else{
                        rightLoc = target;
                        answer.append('R');
                    }
                }
            }
        }
        
        return answer.toString();
    }
}