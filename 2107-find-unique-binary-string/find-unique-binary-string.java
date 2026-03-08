class Solution {
    public String findDifferentBinaryString(String[] nums) {
        Set<String> set = new HashSet<>();
        for(String num:nums) set.add(num);
        StringBuilder sb = new StringBuilder();
        return backtrack(0,nums[0].length(), sb,set);
    }

    private String backtrack(int index, int n, StringBuilder sb, Set<String> set){
        if (index == n) {
            String candidate = sb.toString();
            if (!set.contains(candidate)) {
                return candidate; // FOUND IT! Return it up the chain.
            }
            return null; // This path failed, return null.
        }
        // Try '0'
        sb.append('0');
        String res = backtrack(index + 1, n, sb, set);
        if (res != null) return res; // If found in this branch, stop and return!
        sb.deleteCharAt(sb.length() - 1); 
        sb.append('1');
        res = backtrack(index + 1, n, sb, set);
        if (res != null) return res; // If found, return!
        sb.deleteCharAt(sb.length() - 1);
        
        return null; // Neither '0' nor '1' worked here
    }
}