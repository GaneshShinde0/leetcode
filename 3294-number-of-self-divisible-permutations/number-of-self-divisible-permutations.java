class Solution {
    private int res;
    private int n;
    public int selfDivisiblePermutationCount(int n) {
        this.res = 0;
        this.n = n;
        int[] li = new int[n];
        for(int i=1;i<=n;i++) li[i-1]=i;
        recurse(0,li);
        return res;
    }
    private void recurse(int start, int[] li){
        if(start==n){
            // System.out.println(Arrays.toString(li));
            for(int i=0;i<n;i++){
                if(gcd(i+1,li[i])!=1) return;
            }
            res++;
        }else{
            for(int i=start;i<n;i++){
                if(gcd(li[i],start+1)==1){
                    swap(i, start, li);
                    recurse(start+1,li);
                    swap(i, start, li);
                }
            }
        }
    }
    private void swap(int i, int j, int[] arr){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    private int gcd(int a, int b){
        return b==0?a:gcd(b,a%b);
    }
}