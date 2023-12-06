import java.util.*;

class sortOrder implements Comparable<sortOrder>{
    int idx,target;
    sortOrder(int code, int target){
        this.idx = code;
        this.target = target;
    }
    @Override
    public int compareTo(sortOrder o) {
        return this.target - o.target;
    }
}

class Solution {
    public ArrayList<ArrayList<Integer>> solution(int[][] data, String ext, int val_ext, String sort_by) {
        ArrayList<ArrayList<Integer>> answer = new ArrayList<>();
        HashMap<String,Integer> dataSet = new HashMap<>();
        dataSet.put("code",0);
        dataSet.put("date",1);
        dataSet.put("maximum",2);
        dataSet.put("remain",3);

        // 기준 데이터 인덱스
        int tagetIdx = dataSet.get(ext);
        // 정렬 기준 데이터 인덱스
        int sortIdx = dataSet.get(sort_by);
        // 데이터 담을 dataList
        ArrayList<ArrayList<Integer>> dataList = new ArrayList<>();
        // 정렬하려고 우선순위 큐
        PriorityQueue<sortOrder> pQ = new PriorityQueue<>();

        int idx = 0;
        // arr 데이터 담기
        for(int[] x : data) {
            if (val_ext > x[tagetIdx]) {
                ArrayList<Integer> metaData = new ArrayList<>();
                for (int i = 0; i < x.length; i++) metaData.add(x[i]);
                pQ.offer(new sortOrder(idx++, metaData.get(sortIdx)));
                dataList.add(metaData);
            }
        }

        while (!pQ.isEmpty()){
            answer.add(dataList.get(pQ.poll().idx));
        }

        return answer;
    }
}