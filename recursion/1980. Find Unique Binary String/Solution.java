class Solution {
    public String findDifferentBinaryString(String[] nums) {
        Set<Integer> set = new HashSet<>();
        for(String s:nums)set.add(Integer.parseInt(s,2));
        int n = nums.length;
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<18;i++){
            if(!set.contains(i)){
                String binaryString = Integer.toBinaryString(i);
                sb.append(binaryString);
                while (sb.length() < n) {
                    sb.insert(0,"0");
                }
                return sb.toString();
            }
        }
        return "";
    }

    public String findDifferentBinaryStringOther(String[] nums) {
        int n= nums[0].length();
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n;i++){
            if(nums[i].charAt(i)=='0') sb.append('1');
            else sb.append('0');
        }        
        return sb.toString();
    }
}
