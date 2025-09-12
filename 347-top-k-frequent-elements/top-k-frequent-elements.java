class Solution {
    public int[] topKFrequentNLogN(int[] nums, int k) {
        int[][] freq = new int[20001][2];
        for(int i=-10000;i<=10000;i++){
            freq[i+10000][0]= i;
        }
        for(int i:nums){
            freq[i+10001][1]++;
        }
        Arrays.sort(freq,(a,b)->Integer.compare(b[1],a[1]));
        int[] res = new int[k];
        for(int i=0;i<k;i++){
            res[i]=freq[i][0]-1;
        }
        return res;
    }

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> counter = new HashMap<>();
        for(int num:nums){
            counter.put(num,counter.getOrDefault(num,0)+1);
        }
        PriorityQueue<Map.Entry<Integer,Integer>> heap = new PriorityQueue<>(
            (a,b)->Integer.compare(b.getValue(), a.getValue())
        );
        for(Map.Entry<Integer,Integer> entry:counter.entrySet()){
            heap.offer(entry);
        }
        int[] res = new int[k];
        for(int i=0;i<k;i++){
            res[i]=heap.poll().getKey(); // Objects.requireNonNull(heap.poll()).getKey();
        }
        return res;
    }
}