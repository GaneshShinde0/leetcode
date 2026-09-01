class Solution {
    public int maxLength(List<String> arr) {
        int n = arr.size();
        List<Integer> li = new ArrayList<>();
        for(int i=0;i<n;i++){
            int temp = 0;
            for(char c:arr.get(i).toCharArray()){
                int shift = c-'a';
                if(((1<<shift) & temp) >0){
                    temp = 0;
                    break;
                }
                temp = (1<<shift)|temp;
            }
            if(temp!=0) li.add(temp);
        }
        int bitLength = li.size();
        int res = 0;
        // This for loop is for all the strings, if ith bit from left is 1 we will consider that string.
        for(int i=0;i<(1<<bitLength);i++){
            int curr = 0;
            int mask = i;
            for(int currBit = 0; currBit<bitLength;currBit++){
                if(((1<<currBit) & mask)>0){
                    int currWord = li.get(currBit);
                    if((currWord & curr)>0){
                        curr=0;
                        break;
                    }
                    curr |= currWord;
                }
            }
            res = Math.max(res, Integer.bitCount(curr));
        }
        return res;
    }
}

class SolutionUsingString {
    public int maxLength(List<String> arr) {
        // Initialize results with an empty string
        // from which to build all future results
        List<String> results = new ArrayList<>();
        results.add("");
        int best = 0;
        for (String word : arr) {
            // We only want to iterate through results
            // that existed prior to this loop
            int resultsLen = results.size();
            for (int i = 0; i < resultsLen; i++) {
                // Form a new result combination and
                // use a set to check for duplicate characters
                String newRes = results.get(i) + word;
                Set<Character> newResSet = new HashSet<>();
                for (char c : newRes.toCharArray())
                    newResSet.add(c);
                if (newRes.length() != newResSet.size())
                    continue;

                // Add valid options to results and
                // keep track of the longest so far
                results.add(newRes);
                best = Math.max(best, newRes.length());
            }
        }
        return best;
    }
}