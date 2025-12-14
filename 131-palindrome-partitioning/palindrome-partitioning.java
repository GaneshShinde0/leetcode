class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        dfs(0, result, new ArrayList<String>(), s);
        return result;
    }

    void dfs(int start, List<List<String>> result, List<String> currentList, String s){
        if(start>=s.length()) result.add(new ArrayList<String>(currentList));
        for(int i = start; i<s.length(); i++){
            if(isPalindrome(s, start, i)){
                currentList.add(s.substring(start, i+1));
                dfs(i+1,result, currentList, s);
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
}