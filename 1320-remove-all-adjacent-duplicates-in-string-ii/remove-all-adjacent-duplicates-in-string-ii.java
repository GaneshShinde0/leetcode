class Solution {
    public String removeDuplicates(String s, int k) {
        int i=0, n= s.length();
        int[] count = new int[n];
        char[] stk = s.toCharArray();
        for(int j=0;j<n;j++,i++){
            stk[i]=stk[j]; // Keeping current chars
            count[i] = i>0 && stk[i-1]==stk[j]?count[i-1]+1:1;
            if(count[i]==k) i-=k;
        }
        return new String(stk,0,i);
    }
}