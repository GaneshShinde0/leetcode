/*
Dynamic Programming+ Top Down (Recursion, Memoization)
Time Complexity: O(N^2, N) where N is the length of the string s.
*/
class Solution {
    private Integer memoCuts[][];
    private Boolean memoPalindrome[][];
    public int minCut(String s) {
        int n = s.length();
        memoCuts = new Integer[n][n];
        memoPalindrome = new Boolean[n][n];
        return minimumCut(s,0,n-1,n-1);
    }
    private int minimumCut(String s, int start, int end, int minimumCut){
        if(memoCuts[start][end]!=null) return memoCuts[start][end];
        if(start==end || isPalindrome(s,start,end)) return 0;
        for(int currEndIndex = start; currEndIndex<=end; currEndIndex++){
            if(isPalindrome(s,start,currEndIndex)){
                minimumCut = Math.min(minimumCut, 1+minimumCut(s,currEndIndex+1, end, end-currEndIndex-1));
            }
        }
        memoCuts[start][end] = minimumCut;
        return minimumCut;
    }
    private boolean isPalindrome(String s, int start, int end){
        if(memoPalindrome[start][end]!=null) return memoPalindrome[start][end];
        int startTemp =start, endTemp = end;
        while(start<end){
            if(s.charAt(start++)!=s.charAt(end--)){
                memoPalindrome[startTemp][endTemp] = false;
                return false;
            }
        }
        memoPalindrome[startTemp][endTemp] = true;
        return true;
    }
}
/*
Time Complexity: O(N. 2^N) Where N is the length of string s.
For each string of size N the recursion method will recur for substrings of size N-1, n-2.. n-2... 1

around n times.

Mathematically that comes to 2^N.
Also palindrome check comes to O(N)
Hence total is 2^N.

Space O(N). Recursion Stack
*/
class SolutionN2powN{
    public int minCut(String s) {
        int n = s.length();
        return minimumCut(s,0,n-1,n-1);
    }
    private int minimumCut(String s, int start, int end, int minimumCut){
        if(start==end || isPalindrome(s,start,end)) return 0;
        for(int currEndIndex = start; currEndIndex<=end; currEndIndex++){
            if(isPalindrome(s,start,currEndIndex)){
                minimumCut = Math.min(minimumCut, 1+minimumCut(s,currEndIndex+1, end, minimumCut));
            }
        }
        return minimumCut;
    }
    private boolean isPalindrome(String s, int start, int end){
        while(start<end){
            if(s.charAt(start++)!=s.charAt(end--)) return false;
        }
        return true;
    }
}