class Solution {
    public long minOperations(int[][] queries) {
        long res = 0;
        for(int[] q : queries){
            long count1 = get(q[1]);
            long count2 = get(q[0]-1);
            res+=(count1-count2+1)/2;
        }
        return res;
    }

    private long get(int num){
        long count = 0;
        int i = 1;
        int base = 1;
        while(base<=num){
            int end = Math.min(base*2-1,num);
            count += (long) ((i+1)/2)*(end-base+1);
            i++;
            base *= 2;
        }
        return count;
    }
}