/*
Dynamic Programming: Bottom Up (Tabulation)
There is yet another technique to implement DP problems
*/

class Solution{
    private Boolean memoPalindrome[][];
    private Integer memoCuts[];
    public int minCut(String s) {
        int n = s.length();
        memoPalindrome = new Boolean[n][n];
        memoCuts = new Integer[n+1];
        for(int i=0;i<=n;i++) memoCuts[i]=i;
        for(int i=0;i<=n-1;i++){
            for(int j=i;j<=n-1;j++){
                if(isPalindrome(s,i,j)){
                    if(i>0)memoCuts[j]=Math.min(memoCuts[j], 1+memoCuts[i-1]);
                    else memoCuts[j] = 0;
                }
            }
        }
        return memoCuts[n-1];
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
Dynamic Programming - Top Down (Optimized Space)
In Approach 2, We used a 2D array for memoCuts, on careful observation, we notice that when we update or access the stored values to or from memoCuts, the value of the variable end always remains the same.

Thus, we only need to track and update the start index when finding the minimum number of cuts. The memoCuts[start] will determine the minimum number of cuts. The memoCuts[start] will determine the minimum number of cuts for substring starting at index start and ending at length(s-1).


Time and Space
N^3 and N^2
*/
class SolutionDPTopDownOptimizedSpace{
    private Boolean memoPalindrome[][];
    private Integer memoCuts[];
    public int minCut(String s) {
        int n = s.length();
        memoPalindrome = new Boolean[n][n];
        memoCuts = new Integer[n];
        return minimumCuts(s,0, n-1, n-1);
    }
    private int minimumCuts(String s, int start, int end, int minimumCuts){
        if(memoCuts[start]!=null) return memoCuts[start];
        if(start==end||isPalindrome(s,start,end)) return 0;
        for(int currEndIndex = start; currEndIndex<=end; currEndIndex++){
            if(isPalindrome(s,start,currEndIndex)){
                minimumCuts = Math.min(minimumCuts, 1+minimumCuts(s,currEndIndex+1, end, minimumCuts));
            }
        }
        memoCuts[start] = minimumCuts;
        return minimumCuts;
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
Dynamic Programming+ Top Down (Recursion, Memoization)
Time Complexity: O(N^2, N) where N is the length of the string s.
Every Sub result is calculated once.
We know that size N has N^2 possible substrings. Thus worst case time complexity of the recursive method findMinimumCut is O(N^2)

Additionally, within each recursive call, we are also checking if a substring is palindrome or not. The worst case time complexity for isPalindrome is O(N/2). This gives us the total time complexity as O(N^2) . O(N/2) = O(N^3)

Space N^2... 
*/
class SolutionTopDownDP {
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