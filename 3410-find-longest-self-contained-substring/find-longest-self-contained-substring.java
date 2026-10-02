class Solution {
    public int maxSubstringLength(String s) {
        // O(n)
        Map<Character, Integer> firstOccurrences = new HashMap<>();
        Map<Character, Integer> lastOccurrences = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!firstOccurrences.containsKey(c)) {
                firstOccurrences.put(c, i);
                lastOccurrences.put(c, i);
            } else {
                lastOccurrences.put(c, i);
            }
        }
        
        int maxL = -1;
        // O(26)
        for (char c1 : firstOccurrences.keySet()) {
            int start = firstOccurrences.get(c1);
            int end = lastOccurrences.get(c1);
            // O(N)
            for (int j = start; j < s.length(); j++) {
                char c2 = s.charAt(j);
                if (firstOccurrences.get(c2) < start) {
                    break;
                }
                end = Math.max(end, lastOccurrences.get(c2));
                
                if (end == j && end - start + 1 != s.length()) {
                    maxL = Math.max(maxL, end - start + 1);
                }
            }
        }

        // total: O(26N)
        return maxL;
    }
}