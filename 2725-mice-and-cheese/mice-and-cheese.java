class Solution {
    public int miceAndCheese(int[] reward1, int[] reward2, int k) {
        int n = reward1.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((b,a)->Integer.compare(a[1],b[1]));
        Set<Integer> taken = new HashSet<>();
        int res = 0;
        for(int i=0;i<n;i++){
            pq.add(new int[]{i,reward1[i]-reward2[i]});
            // if(pq.size()>k){
            if(pq.size()>n-k){ // Mouse 1 eats k, result which is mouse 2 will eat n-k elements.
                int[] temp = pq.poll();
                res+=reward1[temp[0]];
            }
            System.out.println(Arrays.toString(pq.peek()));
        }
        while(!pq.isEmpty()){
            int[] temp = pq.poll();
            res+=reward2[temp[0]];
        }
        return res;
    }
}