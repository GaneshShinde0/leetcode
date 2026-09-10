class Solution {
    public int[][] highFive(int[][] items) {
        Map<Integer,PriorityQueue<Integer>> studentToScores = new TreeMap<>();
        for(int[] item:items){
            PriorityQueue<Integer> scores = studentToScores.computeIfAbsent(item[0],k->new PriorityQueue<>((a,b)->Integer.compare(a,b)));
            scores.add(item[1]);
            if(scores.size()>5)scores.poll();
        }
        // System.out.println(studentToScores);
        int[][] res = new int[studentToScores.size()][2];
        int curr = 0;
        for(Map.Entry<Integer,PriorityQueue<Integer>> e: studentToScores.entrySet()){
            res[curr][0] = e.getKey();
            PriorityQueue<Integer> scores= e.getValue();
            int total = 0;
            while(!scores.isEmpty()){
                total+=scores.poll();
            }
            res[curr][1]=total/5;
            curr++;
        }
        return res;
    }
}