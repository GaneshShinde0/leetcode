/*
Input: heights = [4,2,7,6,9,14,12], bricks = 5, ladders = 1

needed = 5
pq = [5]

i = 4
needed = 3
pq = [3,5]

bricks> pq.peek()
bricks = 2, ladder => 1
pq = [5]

i = 5
needed = 5


*/
class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int n = heights.length;
        for(int i=1;i<heights.length;i++){
            int needed = heights[i]-heights[i-1];            
            if(needed>0){
                pq.add(needed);
                if(pq.size()>ladders){
                    bricks-=pq.poll();
                }
                if(bricks<0) return i-1;
            }
        }
        return n-1;
    }
}