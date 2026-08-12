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
class SolutionDivideAndConquer {
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
/*
Time Complexity: O(N*N)
*/

/*
Approach: SLiding Window
Intuition: 
Window slides over the string s and validates each character, Based on certain conditions, the sliding window either expands or shrinks.

The sbustring is valid if each character has atleast k frequency. The main idea is to find all the valid substrings with a different number of unique characters and track the maximum length. 

Algorithm:

1. FInd the number of unique characters in the string s and store the count in variable maxUnique. For s = "aabcbacad", the unique characters are a,b,c,d and maxUnique = 4.
2. Iterate over the string s with the value of currUnique ranging from 1 to maxUnique in each iteration, currUnique is the maximum number of unique characters that must be present in the sliding window.
3. The sliding window starts at index windowStart and ends at index windowEnd and slides over string s until windowEnd reaches the end of string s. At any point, we shrink or expand the window to ensure that the number of unique characters is not greater than currUnique. 
    -  If the number of unique character in the sliding window is less than or equal to currUnique, expand the window from right by adding a character to the end of the window given by windowEnd.
    - Otherwise, shrink the window from left by removing a charcter from the start of the window given by windowStart.
4. Keep track of the number of unique characters in teh current sliding window having atleast k frequency given by countAtLeastK. Update the result if all the characters in the window hasve atleast k frequency.
*/
class Solution {
    public int longestSubstring(String s, int k) {
        char[] str = s.toCharArray();
        int[] freq = new int[26];
        int maxUnique = getMaxUniqueLetters(s);
        int result = 0, n = s.length();

        for(int currUnique = 1; currUnique <=maxUnique; currUnique++){
            Arrays.fill(freq, 0);
            int start = 0, end = 0, idx = 0, unique = 0, countAtLeastK = 0;
            while(end<n){
                if(unique<=currUnique){
                    idx = str[end]-'a';
                    if(freq[idx]==0) unique++;
                    freq[idx]++;
                    if(freq[idx]==k) countAtLeastK++;
                    end++;
                }else{
                    idx = str[start] - 'a';
                    if(freq[idx]==k) countAtLeastK--;
                    freq[idx]--;
                    if(freq[idx]==0) unique--;
                    start++;
                }
                if(unique == currUnique && unique == countAtLeastK){
                    result = Math.max(end-start, result);
                }
            }
        }
        return result;
    }
    
    private int getMaxUniqueLetters(String s){
        boolean[] map = new boolean[26];
        int maxUnique = 0;
        for(int i=0;i<s.length();i++){
            if(!map[s.charAt(i)-'a']){
                maxUnique++;
                map[s.charAt(i)-'a'] = true;
            }
        }
        return maxUnique;
    }
}