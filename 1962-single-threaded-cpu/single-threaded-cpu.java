class Solution {
    public int[] getOrder(int[][] tasks) {
        int[][] taskWithId = new int[tasks.length][3];
        for(int i=0;i<taskWithId.length;i++){
            taskWithId[i][0] = tasks[i][0];
            taskWithId[i][1] = tasks[i][1];
            taskWithId[i][2] = i;
        }
        Arrays.sort(taskWithId,(a,b)->Integer.compare(a[0],b[0]));

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->{
            if(a[1]==b[1]) return Integer.compare(a[2],b[2]);
            else return Integer.compare(a[1],b[1]);
        });
        int[] res = new int[tasks.length];
        long currTime = 0;
        int i = 0;
        int ansIndex = 0;
        while(i<tasks.length||!pq.isEmpty()){
            if(pq.isEmpty() && currTime<taskWithId[i][0]){
                currTime = taskWithId[i][0];
            }

            while(i<tasks.length && currTime>=taskWithId[i][0]){
                pq.add(taskWithId[i]);
                i++;
            }
            int processTime = pq.peek()[1];
            int index = pq.peek()[2];
            pq.poll();

            currTime +=processTime;
            res[ansIndex++]=index;
        }
        return res;
    }
}