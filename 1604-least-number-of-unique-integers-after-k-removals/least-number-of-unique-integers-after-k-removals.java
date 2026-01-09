class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i=0;i<arr.length;i++){
            hm.put(arr[i], hm.getOrDefault(arr[i],0)+1);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->Integer.compare(a[1],b[1]));
        for(Map.Entry<Integer,Integer> e: hm.entrySet()){
            pq.offer(new int[]{e.getKey(),e.getValue()});
        }
        while(k>0){
            int[] temp = pq.poll();
            if(temp[1]>1){
                temp[1]--;
                pq.offer(temp);
            }
            k--;
        }
        return pq.size();
    }
}