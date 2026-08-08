class Solution {

    public int[] validSequence(String word1, String word2) {
        int lastMatch = -1;
        int m = word1.length(), n = word2.length(), i=0, j=0;
        int[] res = new int[n];

        int[] rightMatch = new int[n];
        i = m-1; j = n-1;
        while(i>=0 && j>=0){
            if(word1.charAt(i)==word2.charAt(j)){
                rightMatch[j]=i;
                j--;
            }
            i--;
        }
        i=0;
        j=0;
        boolean changed = false;
        while(i<m && j<n){
            if(word1.charAt(i)==word2.charAt(j)){
                res[j] = i;
                j++;
            }else if(!changed && (j==n-1 || rightMatch[j+1]>i)){ // If we have not changed and (its last index of word 2 or next character on right is still available in future)
                changed = true;
                res[j] = i;
                j++;
            }

            i++;
        }
        if(j==n) return res;
        else return new int[]{};
    }

}