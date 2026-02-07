class Solution {

    public int minimumDeletions(String s){
        int n = s.length();
        Stack<Character> charStack = new Stack<>();
        int deleteCount = 0;
        // Iterate through each character in the string
        for(int i=0;i<n;i++){
            // If stack is not empty, top of stack is 'b', and current char is 'a'
            if(!charStack.isEmpty() && charStack.peek()=='b' && s.charAt(i)=='a'){
                charStack.pop();
                deleteCount++;
            }else{
                charStack.push(s.charAt(i));
            }
        }
        return deleteCount;
    }
    public int minimumDeletionsO1Space(String s){
        int n = s.length();
        int aCount = 0;

        // First pass: Count the number of a's 
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='a') aCount++;
        }
        int bCount = 0;
        int minDeletions = n;
        // Second pass: iterate through the string to compute minimum deletions.
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='a') aCount--;
            minDeletions = Math.min(minDeletions, aCount+bCount);
            if(s.charAt(i)=='b') bCount++;
        }
        return minDeletions;
    }
    public int minimumDeletionsTwoPass(String s){
        int n = s.length();
        int[] countA = new int[n];
        int aCount = 0;

        // First Pass: Compute countA which stores the number of 'a' characters to the right of the current position
        for(int i=n-1;i>=0;i--){
            countA[i] = aCount;
            if(s.charAt(i)=='a') aCount++;
        }

        int minDeletions = n;
        int bCount = 0;
        for(int i=0;i<n;i++){
            minDeletions = Math.min(countA[i]+bCount, minDeletions);
            if(s.charAt(i)=='b') bCount++;
        }
        return minDeletions;
    }
    public int minimumDeletionsThreePass(String s) {
        int n = s.length();
        int[] countA = new int[n];
        int[] countB = new int[n];
        int bCount = 0, aCount = 0;

        // First pass: Compute countB which stores the number of b characters to the left of the current position.
        for(int i=0;i<n;i++){
            countB[i] = bCount;
            if(s.charAt(i)=='b') bCount++;
        }

        for(int i=n-1;i>=0;i--){
            countA[i] = aCount;
            if(s.charAt(i)=='a') aCount++;
        }

        int minDeletion = n;
        // Third pass: iterate throught the string to find the minimum deletion
        for(int i=0;i<n;i++){
            minDeletion = Math.min(minDeletion,countA[i]+countB[i]);
        }
        return minDeletion;
    }

    public int minimumDeletionsDP(String s) {
        int n = s.length();
        int[] dp = new int[n+1];
        int bCount = 0;

        // dp[i]: The number of deletions required to balance substring s[0,i)
        for(int i = 0;i<n;i++){
            if(s.charAt(i)=='b'){
                dp[i+1] = dp[i];
                bCount++;
            }else{
                dp[i+1] = Math.min(dp[i]+1,bCount);
                //                 minDeletions = Math.min(minDeletions + 1, bCount);
            }
        }
        return dp[n];
    }
}