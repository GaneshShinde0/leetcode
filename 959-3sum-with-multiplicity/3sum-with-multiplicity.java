class Solution {
    private final int MOD = 1_000_000_007;
    public int threeSumMulti(int[] arr, int target) {
        int n = arr.length;
        int res = 0;
        HashMap<Integer, Integer> hm1 = new HashMap<>();
        for(int i=0;i<n;i++){
            hm1.put(arr[i],hm1.getOrDefault(arr[i],0)+1);
            HashMap<Integer, Integer> hm = new HashMap<>();
            int newTarget = target-arr[i];
            int twoSumRes = 0;
            for(int j=i+1;j<n;j++){
                if(hm.containsKey(newTarget-arr[j])) twoSumRes+=hm.get(newTarget-arr[j]);
                hm.put(arr[j],hm.getOrDefault(arr[j],0)+1);
            }
            res=(res+twoSumRes)%MOD;
        }
        return res;
    }
}