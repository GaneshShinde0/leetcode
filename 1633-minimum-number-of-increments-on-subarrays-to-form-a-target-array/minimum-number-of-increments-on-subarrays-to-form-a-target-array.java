class Solution {
    public int minNumberOperations(int[] target) {
       int n = target.length;
       int ans = target[0]; // We will require atleast first value of target(whichever it is)
       for(int i=1;i<n;i++){
            // If curr value is bigger than prev then we will have to add curr-prev to ans... else do nothing.
            // As if curr value is smaller than prev, we will not have to add anything (It has already been taken care in prev ans).
            if(target[i]>target[i-1]) ans+=target[i]-target[i-1];
        
       }
       return ans;
    }
}