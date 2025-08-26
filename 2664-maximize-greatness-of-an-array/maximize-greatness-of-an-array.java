class Solution {
    public int maximizeGreatness(int[] nums) {
        int[] temp = Arrays.copyOf(nums,nums.length);
        Arrays.sort(temp);
        int count =0;
        for(int i=1;i<temp.length;i++){
            if(temp[count]<temp[i]) count++;
        }
        return count;
    }
}