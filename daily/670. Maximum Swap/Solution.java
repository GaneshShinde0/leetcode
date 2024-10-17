public class Solution {

    // Even if following solution is O(n^2) it shuld run in max 8 * 8 times as n is number of digits and not the actual num.
    public int maximumSwapUsingTwoForLoops(int num){
        char[] chars = Integer.toString(num).toCharArray();
        int n = chars.length;
        int maxNum = num;
        
        // Try swapping every pair of digits
        for (int i = 0; i < n-1; i++) {
            for (int j = i + 1; j < n; j++) {
                // Swap digits at i and j
                char temp = chars[i];
                chars[i] = chars[j];
                chars[j] = temp;
                
                // Convert the swapped character array back to an integer
                int swappedNum = Integer.parseInt(new String(chars));
                // Update maxNum if the swapped number is greater
                maxNum = Math.max(maxNum, swappedNum);
                
                // Swap back to restore original order for next iteration
                chars[j] = chars[i];
                chars[i] = temp;
            }
        }
        
        return maxNum;
    }

    public int maximumSwapTwoPointer(int num) {
        // Convert the number to a character array
        char[] digits = Integer.toString(num).toCharArray();
        int n = digits.length;
        
        // Create an array to keep track of the rightmost occurrence of each digit
        int[] rightMaxIndex = new int[n];
        rightMaxIndex[n - 1] = n - 1;
        
        // Fill the rightMaxIndex array with the indices of the largest digits on the right
        for (int i = n - 2; i >= 0; i--) {
            if (digits[i] > digits[rightMaxIndex[i + 1]]) {
                rightMaxIndex[i] = i;
            } else {
                rightMaxIndex[i] = rightMaxIndex[i + 1];
            }
        }
        
        // Try to find the first position where a swap can increase the number
        for (int i = 0; i < n; i++) {
            if (digits[i] != digits[rightMaxIndex[i]]) {
                // Swap the digits[i] with digits[rightMaxIndex[i]]
                char temp = digits[i];
                digits[i] = digits[rightMaxIndex[i]];
                digits[rightMaxIndex[i]] = temp;
                break;
            }
        }
        
        // Convert the char array back to an integer
        return Integer.parseInt(new String(digits));
    }

    // Greedy Two Pass
    public int maximumSwapGreedyTwoPass(int num){
        char[] numArr = Integer.toString(num).toCharArray();
        int n = numArr.length;
        int[] maxRightIndex = new int[n];
        maxRightIndex[n-1] = n-1;
        for(int i=n-2;i>=0;i--){
            maxRightIndex[i]=(numArr[i]>numArr[maxRightIndex[i+1]])?i:maxRightIndex[i+1];
        }

        for(int i=0; i<n; i++){
            if(numArr[i]<numArr[maxRightIndex[i]]){
                char temp = numArr[i];
                numArr[i]=numArr[maxRightIndex[i]];
                numArr[maxRightIndex[i]] = temp;
                return Integer.parseInt(new String(numArr));
            }
        }
        return num;
    }

    // Suboptimial Greedy.
    public int maximumSwapSuboptimalGreedy(int num){
        String numStr = Integer.toString(num);
        int n = numStr.length();
        int[] lastSeen = new int[10]; // Store the last occurence of each digit
        // Record the last occurence of each digit
        for(int i= 0;i<n;++i){
            lastSeen[numStr.charAt(i)-'0'] = i;
        }

        // Trave the String to find the first digit that can be swapped with a larger oe
        for(int i=0; i<n; i++){
            for(int d=9; d>numStr.charAt(i)-'0'; d--){
                if(lastSeen[d]>i){
                    // Perform the swap
                    char[] arr = numStr.toCharArray();
                    char temp = arr[i];
                    arr[i] = arr[lastSeen[d]];
                    arr[lastSeen[d]] = temp;
                    numStr = new String(arr);

                    return Integer.parseInt(numStr); // Return the new number immediately after the swap
                }
            }
        }

        return num; // Return the original number if no swap can maximize it
    }

    // Two pointer without extra array
    public int maximumSwap(int num) {
        // Convert the number to a character array
        char[] digits = Integer.toString(num).toCharArray();
        int n = digits.length;
        
        // Variables to track the best swap position
        int maxIndex = n - 1;  // The index of the maximum digit seen so far
        int swapFrom = -1, swapTo = -1;  // Indices of digits to swap
        
        // Traverse the digits from right to left
        for (int i = n - 2; i >= 0; i--) {
            // If current digit is smaller than the largest digit on the right
            if (digits[i] < digits[maxIndex]) {
                // Mark this as a candidate for swap
                swapFrom = i;
                swapTo = maxIndex;
            } 
            // Update maxIndex if we find a larger digit
            else if (digits[i] > digits[maxIndex]) {
                maxIndex = i;
            }
        }
        
        // If a swap candidate was found, perform the swap
        if (swapFrom != -1) {
            char temp = digits[swapFrom];
            digits[swapFrom] = digits[swapTo];
            digits[swapTo] = temp;
        }
        
        // Convert the char array back to an integer
        return Integer.parseInt(new String(digits));
    }
}
