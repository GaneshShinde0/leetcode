class Solution {
    public int distinctPrimeFactors(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int res = 0;
        for(int curr:nums){
            int temp = curr;
            for(int i=2;i<=Math.sqrt(curr) && temp!=1;i++){
                if(temp%i==0)set.add(i);
                while(temp%i==0){
                    temp = temp/i;
                }
            }
            if(temp!=1) set.add(temp);
        }
        return set.size();
    }
}