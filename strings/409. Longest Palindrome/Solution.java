class Solution {
    public int longestPalindrome(String s) {
        int[] freq = new int[128];
        for(char c:s.toCharArray()){
            freq[c-'A']++;
        }
        int count =0;
        boolean single = true;
        for(int i:freq){
            if(single && i%2==1){
                single=false;
                count+=i;
            }else if(i%2==1){
                count+=(i-1);
            }
            if(i%2==0){
                count+=i;
            }
        }
        return count;
    }
    public int longestPalindromeOptimized(String s) {
 int[] freq = new int[58];
        int len = 0;
        for(char ch: s.toCharArray()) freq[ch-'A']++;
        for(int data: freq) len += data%2==0?data:data-1;
        return len==s.length()?len:len+1; 
    }

    // Unnecessary Stuff
    // public int longestPalindrome(String s) {
    //     char[] chars = s.toCharArray();
        
    //     for(int i=0;i<s.length();i++){
    //         for(int j=s.length()-1; j>i;j--){
    //             if(isPalindrome(chars,i,j)) return j-i;
    //             System.out.println("i: "+i+", j: "+j);
    //         }
    //     }
    //     return 1;
    // }
    // public boolean isPalindrome(char[] chars,int idx1,int idx2){
    //     while(idx1<idx2){
    //         if(chars[idx1]==chars[idx2]){
    //             idx1++;
    //             idx2--;
    //         }else{
    //             return false;
    //         }
    //     }
    //     return true;
    // }
}
