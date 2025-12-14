class Solution {
    public List<List<String>> partitionWithoutDP(String s) {
        List<List<String>> result = new ArrayList<>();
        dfs(0, result, new ArrayList<String>(), s);
        return result;
    }

    void dfs(int start, List<List<String>> result, List<String> currentList, String s){
        if(start>=s.length()) result.add(new ArrayList<String>(currentList));
        for(int i = start; i<s.length(); i++){
            if(isPalindrome(s, start, i)){  // Made the right choice for substring(start, i+1);
                currentList.add(s.substring(start, i+1));
                dfs(i+1,result, currentList, s); // Checking Right Choices for substrings.
                currentList.remove(currentList.size()-1);
            }
        }
    }

    boolean isPalindrome(String s, int start, int end){
        while(start<end){
            if(s.charAt(start)!=s.charAt(end)) return false;
            start++;
            end--;
        }
        return true;
    }

    public List<List<String>> partition(String s){
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        List<List<String>> result = new ArrayList<>();
        dfs(result, s, 0, new ArrayList<>(), dp);
        return result;
    }

    void dfs(List<List<String>> result, String s, int start, List<String> currentList, boolean[][] dp){
        if(start>=s.length()) result.add(new ArrayList<>(currentList));
        for(int end = start; end<s.length();end++){
            if(s.charAt(start)==s.charAt(end)&&(end-start<=2 || dp[start+1][end-1])){
                dp[start][end] = true;
                currentList.add(s.substring(start, end+1));
                dfs(result, s, end+1, currentList, dp);
                currentList.remove(currentList.size()-1);
            }
        }
    }
}