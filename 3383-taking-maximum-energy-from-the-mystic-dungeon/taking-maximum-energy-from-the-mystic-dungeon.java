class Solution {
    public int maximumEnergy(int[] energy, int k) {
        int[] sumK = new int[k];
        for(int i=0;i<energy.length;i++){
            sumK[i%k]=Math.max(energy[i],sumK[i%k]+energy[i]);
        }
        int res = Integer.MIN_VALUE;
        for(int i:sumK){
            res = Math.max(res,i);
        }
        return res;
    }
}