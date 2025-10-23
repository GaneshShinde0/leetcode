/*

Algorithm:
1. Increment index i until we find first mismatch.
2. From there, keep going if characters alternate s1[i]==s2[i+1] && s1[i+1]==s2[i].
    - If we reach the last character, sensor readings are ambiguous, return -1.
3. If s1[i]==s2[i+1] first sensor is faulty
    - Else Second sensor is faulty
*/

class Solution {
    public int badSensor(int[] s1, int[] s2) {
        int i = 0, n = s1.length;
        while(i<n && s1[i]==s2[i]) i++;
        while(i+1<n && s1[i]==s2[i+1] && s1[i+1]==s2[i]) i++;
        return i>=n-1?-1:s1[i]==s2[i+1]?1:2;
    }
}