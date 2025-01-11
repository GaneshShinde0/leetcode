class Solution {
    public int[] minBitwiseArrayBruteForce(List<Integer> nums) {
        int[] res = new int[nums.size()];
        for(int j=0;j<nums.size();j++){
            res[j]=-1;
            for(int i=0;i<nums.get(j);i++){
                if(((i|(i+1))==nums.get(j))){
                    res[j]=i;
                    break;
                }
            }
        }
        return res;
    }

    public int[] minBitwiseArray(List<Integer> A) {
        int n = A.size(), res[] = new int[n];
        for (int i = 0; i < n; i++) {
            int a = A.get(i);
            if (A.get(i) % 2 == 0) {
                res[i] = -1;
            } else {
                res[i] = a - ((a + 1) & (-a - 1)) / 2;
            }
        }
        return res;        
    }

    public int[] minBitwiseArrayTemp(List<Integer> nums) {
        int[] res = new int[nums.size()];
        for(int i=0;i<nums.size();i++){
            res[i]=getOr(nums.get(i));
        }
        return res;
    }

    public int getOr(int x){
        int y = x+1;
        int res = 0;
        while(y>0){
            res = res+(y%2|x%2);
            y/=2;
            x/=2;
        }
        return res;
    }
}
