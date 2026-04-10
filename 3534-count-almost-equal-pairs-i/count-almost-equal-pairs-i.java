class Solution {
    public int countPairs(int[] nums) {
        int res = 0;
        int n = nums.length;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(oneDigitAway(nums[i],nums[j])) res++;
            }
        }
        return res;
    }
    private boolean oneDigitAway(int num1, int num2){
        String s1 = String.valueOf(num1), s2 = String.valueOf(num2);
        int m = s1.length(), n = s2.length();
        int max = Math.max(m,n);
        while(m!=max){
            s1="0"+s1;
            m++;
        }
        while(n!=max){
            s2 = "0"+s2;
            n++;
        }
        int diff = 0;
        int[] freq1 = new int[10],freq2 = new int[10];
        for(int i=0;i<n;i++){
            if(s1.charAt(i)!=s2.charAt(i)){
                diff++;
            }
            freq1[s1.charAt(i)-'0']++;
            freq2[s2.charAt(i)-'0']++;
            if(diff>2)return false;
        }
        return Arrays.equals(freq1,freq2);
    }
}