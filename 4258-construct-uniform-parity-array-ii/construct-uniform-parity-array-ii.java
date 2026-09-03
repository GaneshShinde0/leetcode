class Solution {
    public boolean uniformArray(int[] nums) {
        int minOdd = Integer.MAX_VALUE, minEven = Integer.MAX_VALUE;
        int odds = 0;
        for(int i:nums){
            if(i%2==0){
                minEven = Math.min(i, minEven);
            }else{
                odds++;
                minOdd = Math.min(minOdd, i);
            }
        }
        if(odds==0 || odds==nums.length) return true;
        else if(minOdd<minEven) return true;
        else return false;
    }
}