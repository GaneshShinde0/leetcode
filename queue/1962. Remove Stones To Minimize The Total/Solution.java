class Solution {
    public int minStoneSum(int[] piles, int k) {
        int sum = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);
        for(int i:piles) pq.offer(i);
        while(k>0){
            int temp = pq.poll();
            temp = temp-(temp)/2;
            pq.offer(temp);
            k--;
        }
        for(int i:pq) sum+=i;
        return sum;
    }

    public int minStoneSumFastest(int[] piles, int k) {
        int[] vals = new int[10001];
        int sum = 0;
        for (int val : piles) {
            vals[val]++;
            sum += val;
        }
        for (int i = vals.length - 1; i > 1 && k > 0; i--) {
            int cnt = vals[i];
            if (cnt == 0) {
                continue;
            }
            int min = Math.min(k, cnt);
            int div = i / 2;

            vals[i] -= min;
            vals[i - div] += min;
            sum -= min * div;
            k -= min;
        }
        return sum;
    }
}
