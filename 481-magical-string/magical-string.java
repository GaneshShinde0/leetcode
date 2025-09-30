class Solution {
    public int magicalStringInitial(int n) {
        StringBuilder sb = new StringBuilder();
        sb.append("122");
        int curr = 1;
        for(int i=2;i<n;i++){
            int freq = sb.charAt(i)-'0';
            while(freq>0){
                sb.append(curr);
                freq--;
            }
            curr = curr==1?2:1;
        }
        int res = 0;
        for(int i=0;i<n;i++){
            if(sb.charAt(i)=='1') res++;
        }
        return res;
    }

    static int N = (int)1e5 + 1;
    static int[] prefixSum;

    public int magicalString(int n) {

        if(prefixSum == null){
            int[] nums = new int[N];
            nums[0] = 1;
            nums[1] = 2;
            nums[2] = 2;
            int size = 3, index = 2, x = 2;
            while(size < N){
                x ^= 3;
                int count = nums[index++];
                while(size < N && count-- > 0)
                    nums[size++] = x;
            }

            prefixSum = new int[N];
            for(int i = 0; i < N - 1; ++i)
                prefixSum[i + 1] = prefixSum[i] + 2 - nums[i];
        }
        
        return prefixSum[n];
    }
}