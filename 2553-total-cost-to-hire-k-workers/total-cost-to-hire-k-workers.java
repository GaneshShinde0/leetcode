class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        PriorityQueue<Integer> headWorkers = new PriorityQueue<>();
        PriorityQueue<Integer> tailWorkers = new PriorityQueue<>();

        // Headworkers stores the first k workers.
        // TailWorkers stores atmost k workers without anyne from first k.
        for(int i=0;i<candidates;i++){
            headWorkers.add(costs[i]);
        }
        for(int i= Math.max(candidates,costs.length-candidates); i<costs.length;i++){
            tailWorkers.add(costs[i]);
        }

        long answer = 0;
        int nextHead = candidates;
        int nextTail = costs.length-candidates-1;
        for(int i=0;i<k;i++){
            if(tailWorkers.isEmpty()||!headWorkers.isEmpty()&&headWorkers.peek()<=tailWorkers.peek()){
                answer +=headWorkers.poll();
                if(nextHead<=nextTail){
                    headWorkers.add(costs[nextHead]);
                    nextHead++;
                }
            }else{
                answer+=tailWorkers.poll();
                // Only refill the queue if there are workers outside two queues.
                if(nextHead<=nextTail){
                    tailWorkers.add(costs[nextTail]);
                    nextTail--;
                }
            }
        }
        return answer;
    }
}