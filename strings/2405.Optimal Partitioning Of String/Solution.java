import java.util.HashSet;
import java.util.Set;

class Solution {

    // Following approach takes 29 ms
    public int partitionString(String s) {
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
}
