class Solution {
    public int[] findXSumBruteForce(int[] nums, int k, int x) {
        int n = nums.length;
        int[] res = new int[n-k+1];
        for(int i=0;i<=nums.length-k;i++){
            int[][] freq = new int[51][2];
            for(int j=i;j<i+k;j++){
                freq[nums[j]][1]++;
                freq[nums[j]][0]=nums[j];
            }
            Arrays.sort(freq,(a,b)->Integer.compare(a[1],b[1]));
            for(int j=50;j>50-x;j--){
                // System.out.println(Arrays.toString(freq[j]));
                res[i]+=freq[j][0]*freq[j][1];
            }
        }
        return res;
    }
    public int[] findXSum(int[] nums, int k, int x) {
        
        int max = getMax(nums);
        int[] result = new int[nums.length - k + 1];

        for (int i = 0; i <= nums.length - k; i++) {
            int[] freq = new int[max + 1];
            int maxFreq = 0;

            for (int j = i; j < i + k; j++) {
                freq[nums[j]]++;
                maxFreq = Math.max(maxFreq, freq[nums[j]]);
            }

            int sum = 0;
            int include = x;

            while (include > 0 && maxFreq > 0) {

                for (int val = max; val >= 1 && include > 0; val--) {

                    if (freq[val] == maxFreq) {
                        sum += val * freq[val];
                        freq[val] = 0;
                        include--;
                    }
                }
                maxFreq--;
            }
            result[i] = sum;
        }

        return result;
    }

    private int getMax(int[] nums) {

        int max = 0;

        for (int val : nums) {
            max = Math.max(max, val);
        }

        return max;
    }
}