class Solution {
    public long pickGifts(int[] gifts, int k) {
        long gift = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);
        for(int i:gifts) pq.offer(i);
        while(k>0 && !pq.isEmpty()){
            int temp = pq.poll();
            temp =(int) Math.sqrt(temp);
            pq.offer(temp);
            k--;
        }
        for(int i:pq) gift+=i;
        return gift;
    }


    public long pickGiftsOptimized(int[] gifts, int k) {
                heapify(gifts);
        while (k-- > 0 && gifts[0] > 1) {
            gifts[0] = (int) Math.sqrt(gifts[0]);
            sink(gifts, 0);
        }
        long ans = 0;
        for (int x : gifts) {
            ans += x;
        }
        return ans;
    }
    private void heapify(int[] h) {
        for (int i = h.length/2 - 1; i >= 0; i--) {
            sink(h, i);
        }
    }
    private void sink(int[] h, int i) {
        int n = h.length;
        while (2*i + 1 < n) {
            int j = 2*i + 1;
            if (j+1 < n && h[j] < h[j+1]) {
                j++;
            }
            if (h[i] > h[j]) break;
            swap(h, i, j);
            i = j;
        }
    }
    private void swap(int[] h, int i, int j) {
        int tmp = h[i];
        h[i] = h[j];
        h[j] = tmp;
    }
}
