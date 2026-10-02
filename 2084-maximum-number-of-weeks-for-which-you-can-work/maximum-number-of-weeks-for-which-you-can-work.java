class Solution{
    public long numberOfWeeks(int[] milestones) {
        int n = milestones.length, max = 0;
        long sum = 0;
        for(int m:milestones){
            sum+=m;
            max = Math.max(m,max);
        }
        if(max>(sum/2)){
            return 2*(sum-max)+1;
        }else{
            return sum;
        }
    }
}
class SolutionOSumOfmilestonesXlogn{
    public long numberOfWeeks(int[] milestones) {
        int n = milestones.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->Integer.compare(b[1],a[1]));
        for(int i=0;i<n;i++){
            pq.add(new int[]{i,milestones[i]});
        }
        int prev = -1, res = 0;
        while(pq.size()>0){
            if(prev==pq.peek()[0]){
                if(pq.size()==1) break;
                int[] temp = pq.poll();
                int[] temp2 = pq.poll();
                temp2[1]--;
                prev = temp2[0];
                if(temp2[1]!=0)pq.add(temp2);
                pq.add(temp);
            }else{
                int[] temp = pq.poll();
                temp[1]--;
                if(temp[1]!=0)pq.add(temp);
                prev=temp[0];
            }
            res++;
        }
        return res;
    }
}