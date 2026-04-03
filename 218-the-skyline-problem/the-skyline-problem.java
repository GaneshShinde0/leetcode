class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> result = new ArrayList<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->{
            if(a[0]==b[0]) return Integer.compare(a[1],b[1]); // Compare by height
            else return Integer.compare(a[0],b[0]); // Compare by start/end
        });
        for(int[] building:buildings){
            pq.add(new int[]{building[0],building[2],0});
            pq.add(new int[]{building[1],building[2],1});
        }

        TreeMap<Integer,Integer> queue = new TreeMap<>();
        queue.put(0,1);
        int prevMaxHeight = 0;
        while(!pq.isEmpty()){
            
            int currentX = pq.peek()[0]; // Check all the elements with current start/end

            while(!pq.isEmpty() && pq.peek()[0]==currentX){
                int[] curr = pq.poll();
                if(curr[2]==0){
                    queue.put(curr[1],queue.getOrDefault(curr[1],0)+1);
                }else{
                    queue.put(curr[1],queue.getOrDefault(curr[1],0)-1);
                    if(queue.get(curr[1])==0) queue.remove(curr[1]);
                }
            }
            int currMaxHeight = queue.lastKey();
            if(prevMaxHeight!=currMaxHeight){
                result.add(List.of(currentX,currMaxHeight));
                prevMaxHeight = currMaxHeight;
            }
        }
        return result;
    }
}