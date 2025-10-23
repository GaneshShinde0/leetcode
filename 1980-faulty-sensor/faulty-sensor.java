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
        while(i<n && s1[i]==s2[i])i++;
        // We know there is defect in atmost one sensor. 
        // As only one sensor has defect we can stop incrementing i whenever there is mismatch.
        while(i+1<n&&s1[i]==s2[i+1] && s2[i]==s1[i+1]) i++;
        // As mismatch happened, If it happened at last we won't be able to tell. If it happeded before we will tell based on values in each sensor.
        return i>=n-1?-1:s1[i]==s2[i+1]?1:2; 
    }
}