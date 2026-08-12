/*
Approach: Divide and Conquer

Divide and Conquer works in 2 phases.
- Divide the problems into subproblems (Divide Phase).
- Repeatedly Solve each subproblem independently and combine the result to solve the original problem. (Conquer Phase).

We could apply this strategy by recursively splitting the string into substrings and combine the result to find the longest substring that satisfies the given condition. The longest substring for a string startign at index start and ending at index end can be given by,

longestSubstring(start, end) = max(longestSubstring(start, mid), longestSubstring(mid+1, end))

Finding the split position (mid)
The string would be split only when we find an invalid character. An invalid character is the one with a frequency of less than k. As we know, the invalid character cannot be part of result, we split the string at the index where we find the invalid character, recursively check for each split, and combine the result.

Algorithm:
- Build the freq with the frequency of each character in the string s.
- Find the position for mid index by iterating over the string. The mid index would be the first invalid character in the string.
- Split the string into 2 substrings at the mid index and recursively find the result.

To Make this more efficient, we ignore all the invalid characters after the mid index as well thereby reducing the number of recursive calls.
*/
class Solution {
    public int longestSubstring(String s, int k) {
        return longestSubstringUtil(s, 0, s.length(), k);
    }
    
    int longestSubstringUtil(String s, int start, int end, int k){
        if(end<k) return 0;
        int[] freq = new int[26];
        
        // Update the freq with the count of each character
        for(int i= start; i<end; i++) freq[s.charAt(i)-'a']++;
        for(int mid = start;mid<end;mid++){
            if(freq[s.charAt(mid)-'a']>=k) continue;
            int midNext = mid+1;
            while(midNext<end && freq[s.charAt(midNext)-'a']<k) midNext++; // 
            return Math.max(longestSubstringUtil(s, start, mid, k),
                longestSubstringUtil(s, midNext, end, k));
        }
        return (end-start);
    }
}