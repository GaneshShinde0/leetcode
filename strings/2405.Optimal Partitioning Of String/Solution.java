import java.util.HashSet;
import java.util.Set;

class Solution {


/* Other Solution
Problem name is Optimal Partition of String.

ab|ac|ab|a

So we start form left and continue partitioning and we just need to check the last partition.

Method 1. Use set or strig to see if elements are repeated.
    Time Complexity: O(n)
    Space Complexity: O(26) => O(1)

Method 2. Instead of set, we can use an array to store and check if the characters have occurred again or not.
- This will be litte bit faster than set.
    Time Complexity: O(n)
    Space Complexity: O(26) => O(1)
    
Method 3. For the same operation to check if the character has occured or not we use bits.
*/


    // Following approach takes 29 ms
    public int partitionString1(String s) {
        Set<Character> seen = new HashSet<>();
        int count = 1;

        for (char c : s.toCharArray()) {
            if (!seen.add(c)) {
                // Character is already in the set, so start a new partition
                seen.clear();  // Clear the set for a new partition
                seen.add(c);   // Add the current character to the new partition
                count++;
            }
        }
        return count;
    }

    // Following takes around 9ms
    public int partitionStringUsingArray(String s){

        int[] lastPositions = new int[26];
        int partitions =0, lastPartitionEnd = 0;

        for(int i=0;i<s.length();i++){
            if(lastPositions[s.charAt(i)-'a']>=lastPartitionEnd){
                partitions++;
                lastPartitionEnd = i+1;
            }
            lastPositions[s.charAt(i)-'a']=i+1;
        }
        return partitions;
    }

    public int partitionString(String s) {
        int count = 1;
        int bitMask = 0;
        byte[] charss = new byte[s.length()];
        s.getBytes(0, s.length(), charss, 0);

        for (byte currentChar : charss) {
            int currentBit = 1 << currentChar;
            if ((currentBit & bitMask) != 0) {
                count++;
                bitMask = currentBit;
            } else {
                bitMask = currentBit | bitMask;
            }
        }
        return count;
    }


}
