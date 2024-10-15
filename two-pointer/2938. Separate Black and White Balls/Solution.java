class Solution {
    public long minimumStepsTwoPointer(String s) {
        char[] arr = s.toCharArray();
        int n = s.length();
        int i=0,j=n-1;
        long res = 0;
        while(i<j){
            if(arr[i]=='0'){
                i++;
            }
            if(arr[j]=='1'){
                j--;
            }
            if(i<j && arr[j]=='0'&&arr[i]=='1'){
                // swap(arr,i,j); //There is no need to swap as well as we just need the count.
                res+=j-i;
                i++;
                j--;
            }
        }
        return res;
    }

    public void swap(char[] arr,int i, int j){
        char temp = arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }

    // Other Optimized Approach
    public long minimumSteps(String s){
        long totalSwaps =0;
        int blackBallCount=0;
        // Iterate through each ball in the string.
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='0'){
                // Swap with all black balls to its left
                totalSwaps += (long) blackBallCount;
            } else {
                // Increment the count
                blackBallCount++;
            }
        }
        return totalSwaps;
    }
}
