class Solution {
    public int lastStoneWeightUsingArraySort(int[] stones) {
        int n = stones.length;
        if(n==1)return stones[0];
        Arrays.sort(stones);
        while(stones[n-2]!=0){
            stones[n-1] -= stones[n-2];
            stones[n-2]=0;
            Arrays.sort(stones);
        }
        return stones[n-1];
    }

    public int lastStoneWeight(int[] stones){
        PriorityQueue<Integer> heap = new PriorityQueue<>((a,b)->b-a);
        for(int each:stones) heap.add(each);
        while(heap.size()>1){
            int top1 = heap.poll();
            int top2 = heap.poll();
            int diff = Math.abs(top1-top2);
            if(diff!=0) heap.add(diff);
        }
        if(heap.size()!=0) return heap.poll();
        else return 0;
    }
}
