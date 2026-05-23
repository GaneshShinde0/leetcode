class Solution {
    private final int MOD = 1_000_000_007;
    public int threeSumMultiInitial(int[] arr, int target) {
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
    
    public int threeSumMulti(int[] arr, int target) {
        int n = arr.length;
        int res = 0;
        int[] hm1 = new int[target+1];
        for(int i=0;i<n;i++){
            if(arr[i]<=target) hm1[arr[i]]++;
            int[] hm = new int[target+1];
            int newTarget = target-arr[i];
            int twoSumRes = 0;
            for(int j=i+1;j<n;j++){
                int temp = newTarget-arr[j];
                if(temp>=0 && temp<=target && hm[temp]>=1) twoSumRes+=hm[temp];
                if(arr[j]>=0 && arr[j]<=target) hm[arr[j]]++;
            }
            res=(res+twoSumRes)%MOD;
        }
        return res;
    }
}