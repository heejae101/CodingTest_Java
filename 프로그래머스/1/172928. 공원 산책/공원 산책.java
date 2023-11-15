class Solution {
    public int[] solution(String[] park, String[] routes) {
        int[] answer = {};
        int[] startPoint = new int[2];
        boolean flag = false;

        for(int i=0; i<park.length; i++){
            for(int j=0; j<park[i].length(); j++){
                if(park[i].charAt(j) == 'S'){
                    startPoint[0] = i;
                    startPoint[1] = j;
                    flag = true;
                    break;
                }
            }
            if(flag)break;
        }

        for(String x : routes){
            String direction = x.split(" ")[0];
            int move = Integer.parseInt(x.split(" ")[1]);
            int dx = startPoint[0], dy = startPoint[1];

            if(direction.equals("E")) dy += move;
            else if(direction.equals("W")) dy -= move;
            else if(direction.equals("N")) dx -= move;
            else dx += move;

            if(dx >= 0 && dx < park.length && dy >=0 && dy < park[0].length()){
                boolean freeze = false;
                if(direction.equals("E") || direction.equals("W")){
                    for(int j=Math.min(startPoint[1], dy); j<=Math.max(startPoint[1], dy); j++){
                        if(park[startPoint[0]].charAt(j) == 'X'){
                            freeze = true;
                            break;
                        }
                    }
                }
                else{
                    for(int i=Math.min(startPoint[0], dx); i<=Math.max(startPoint[0], dx); i++){
                        if(park[i].charAt(startPoint[1]) == 'X'){
                            freeze = true;
                            break;
                        }
                    }
                }
                if(!freeze){
                    startPoint[0] = dx;
                    startPoint[1] = dy;
                }
            }
        }
        answer = startPoint.clone();
        return answer;
    }
}