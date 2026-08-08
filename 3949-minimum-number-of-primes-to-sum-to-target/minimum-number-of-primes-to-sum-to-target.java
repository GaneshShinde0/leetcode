class Solution {
    private static List<Integer> primes = getPrimes();
    public int minNumberOfPrimes(int n, int m) {
        int[] minNums = new int[Math.max(n + 1, 8000)];
        Arrays.fill(minNums,10000);
        minNums[0]=0;
        for(int k=0;k<m;k++){
            int p = primes.get(k);
            minNums[p] = 1;
            for(int i=p;i<=n;i++){
                minNums[i] = Math.min(minNums[i-p]+1, minNums[i]);
            }
        }
        return minNums[n]==10000?-1:minNums[n];
    }

    private static List<Integer> getPrimes(){
        boolean[] temp = new boolean[10000];
        for(int i=2;i<=1000;i++){
            int curr = 2*i;
            while(curr<temp.length){
                temp[curr] = true;
                curr+=i;
            }
        }
        List<Integer> li = new ArrayList<>();
        for(int i=2;i<10000;i++){
            if(!temp[i]) li.add(i);
        }
        return li;

    }
}