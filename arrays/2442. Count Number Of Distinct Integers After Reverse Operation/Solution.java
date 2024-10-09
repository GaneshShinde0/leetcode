class Solution {
    public int countDistinctIntegers(int[] nums) {
        Set<Integer> hashSet = new HashSet<>();
        for(int i:nums){
            hashSet.add(i);
            hashSet.add(getReverse(i));
        } 
        return hashSet.size();
    }
    public int getReverse(int i){
        int rev=0;
        while(i>0){
            rev=rev*10+i%10;
            i=i/10;
        }
        return rev;
    }
}
