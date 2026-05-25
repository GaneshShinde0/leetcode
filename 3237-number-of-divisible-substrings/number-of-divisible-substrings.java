class Solution {
    public int countDivisibleSubstrings(String word) {
        int[] map = {1,1,2,2,2,3,3,3,4,4,4,5,5,5,6,6,6,7,7,7,8,8,8,9,9,9};
        char[] chars = word.toCharArray();
        int res = 0;
        for(int i=0;i<chars.length;i++){
            int len = 1;
            int sum = 0;
            for(int j=i;j<chars.length;j++){
                sum+=map[chars[j]-'a'];
                if(sum%len==0) res++; // (sum%(j-i+1)==0) also works
                len++;
            }
        }
        return res;
    }
}