import java.util.HashMap;
class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        // 게시판 불량 이용자를 신고하고 처리 결과를 메일로 발송하는 시스템을 개발 하려고 한다.
        // 각 유저는 한 번에 한 명의 유저를 신고할 수 있고, 신고 횟수의 제한이 없다. 한 유저를 여러 번 신고할 수도 있다.
        // 동일한 유저에 대한 신고 횟수는 1회로 처리한다.
        // k 번 이상 신고된 유저는 게시판 이용이 정지 해당 유저를 신고한 유저에게 정지사실을 메일로 발송한다.
        // 유저가 신고한 모든 내용을 취합하여 마지막에 한꺼번에 게시판 이용 정지를 시키면서 정지 메일을 발송합니다.
        // id_list 는 사용자들 report 앞은 신고한 사람 뒤는 신고 당한 사람 K는 정지 기준 (신고 횟수) result는 사용자가 통보 메일을 받는 횟수
        
        // 사용자 총 인원 수
        int size = id_list.length;
        // 사용자 고유 id 이메일 발송횟수
        int[] answer = new int[size];
        // 신고 먹은 횟수 
        int[] reportNum = new int[size]; 
        
        // 누가 누굴 신고햇는지 x가 신고한 사람 y 신고당한사람 
        int[][] reportArr = new int[size][size];

        // 사용자의 인덱스를 보관하는 map 이유: for문 처리를 덜하기 위해서 O(n)
        HashMap<String,Integer> idMap = new HashMap<>();
        for(int i=0; i<id_list.length; i++) idMap.put(id_list[i],i);

        // 신고명단 탐색
        for(String x : report){
            String reporter = x.split(" ")[0];
            String reportedPerson = x.split(" ")[1];
            if(reportArr[idMap.get(reporter)][idMap.get(reportedPerson)] == 0){
                reportArr[idMap.get(reporter)][idMap.get(reportedPerson)] = 1;
                reportNum[idMap.get(reportedPerson)] += 1;
            }
        }
        
        // 신고 먹은사람의 횟수 체크 해서 있으면 신고자를 체크
        for(int i=0; i<size; i++){
            if(reportNum[i] >= k){
                for(int j=0; j<size; j++){
                    if(reportArr[j][i] == 1){
                        answer[j] += 1;
                    }
                }
            }
        }
        
        return answer;
    }
}