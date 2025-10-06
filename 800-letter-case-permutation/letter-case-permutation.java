class Solution {
    Set<String> set;
    public List<String> letterCasePermutation(String s) {
        set = new HashSet<>();
        char[] arr = s.toLowerCase().toCharArray();
        List<String> res = new ArrayList<>();
        int curr = 0, n = s.length();
        res = helper(res,arr,curr,n);
        if(res.size()==0) res.add(s);
        return res;
    }

    public List<String> helper(List<String> res,char[] arr, int curr, int n){
        if(curr>=n) return res;
        if(arr[curr]>='a'&&arr[curr]<='z'){
            if(!set.contains(new String(arr))){
                res.add(new String(arr));
                set.add(new String(arr));
            }
            arr[curr]-=32;
            if(!set.contains(new String(arr))){
                res.add(new String(arr));
                set.add(new String(arr));
            }
            helper(res,arr,curr+1,n);
            arr[curr]+=32;
        }
        return helper(res,arr,curr+1,n);        
    }
}