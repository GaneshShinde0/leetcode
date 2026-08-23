class Solution {
    public int[] findPermutation(String s) {
        int[] res = new int[s.length()+1];
        Stack<Integer> stk = new Stack<>();
        int j = 0;
        for(int i=1;i<=s.length();i++){
            stk.push(i);
            if(s.charAt(i-1)=='I'){
                while(!stk.isEmpty()){
                    res[j++]=stk.pop();
                }
            }
        }
        stk.push(s.length()+1);
        while(!stk.isEmpty()){
            res[j++] = stk.pop();
        }
        return res;
    }
}