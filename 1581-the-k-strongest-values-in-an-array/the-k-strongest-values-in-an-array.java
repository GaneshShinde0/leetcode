class Solution {
    public int[] getStrongestUsingPQ(int[] arr, int k) {
        Arrays.sort(arr);
        int center = arr[(arr.length-1)/2];
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a,b)->{
            if(Math.abs(a-center)==Math.abs(b-center)) return Integer.compare(a,b);
            return Integer.compare(Math.abs(a-center),Math.abs(b-center));
        });
        for(int num:arr){
            pq.add(num);
            if(pq.size()>k) pq.poll();
        }
        // System.out.println(pq);
        int[] res = new int[k];
        for(int i=0;i<k;i++){
            res[i] = pq.poll();
        }
        return res;
    }
    public int[] getStrongest(int[] arr, int k) {
        Arrays.sort(arr);
        int i = 0, j = arr.length - 1, p = 0;
        int median = arr[(arr.length - 1) / 2];
        int[] res = new int[k];
        while (p < k)
            if (median - arr[i] > arr[j] - median)
                res[p++] = arr[i++];  
            else
                res[p++] = arr[j--];      
        return res;
    }
}