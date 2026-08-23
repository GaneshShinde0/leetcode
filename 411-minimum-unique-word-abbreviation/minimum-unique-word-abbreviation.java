class Solution {

    private int bestMask = 0;
    private int minLen = Integer.MAX_VALUE;
    private int n;
    private List<Integer> diffMasks;
    public String minAbbreviation(String target, String[] dictionary) {
        this.n = target.length();
        this.diffMasks = new ArrayList<>();

        // Filter Dictionary  and Create diffMaks
        for(String word: dictionary){
            if(word.length()!=n) continue;

            int diff = 0;
            for(int i=0;i<n;i++){
                if(target.charAt(i)!=word.charAt(i)){
                    diff |= (1<<(n-1-i));
                }
            }
            diffMasks.add(diff);
        }

        // If No words of the same length, return full abbreviation
        if(diffMasks.isEmpty()) return String.valueOf(n);

        // Step 3: DFS to find bestMask
        dfs(0, 0, 0, false);

        // Step 4: Construct the result using bestmask
        StringBuilder sb = new StringBuilder();
        int zeroCount = 0;

        for(int i=0;i<n;i++){
            // Check if current bit is 1 (keep Character)
            if((bestMask & (1<<(n-1-i)))!=0){
                if(zeroCount>0){
                    sb.append(zeroCount);
                    zeroCount = 0; // Reset zero count
                }
                sb.append(target.charAt(i));
            }else{
                zeroCount++;
            }
        }

        if(zeroCount>0) sb.append(zeroCount);
        return sb.toString();
    }

    private void dfs(int pos, int mask, int len, boolean prevAbbr){
        // Pruning: Stop if current length is already greater than or equal to  minLen Found
        if(len>=minLen) return;
        // Base case: Reached End of String
        if(pos==n){
            // Validate mask against all bitMaks
            for(int diffMask: diffMasks){
                if((mask & diffMask)==0) return; // Invalid Abbreviation
            }
            minLen = len;
            bestMask = mask;
            return;
        }

        // Choice 1: keep the character - set bit to 1
        dfs(pos+1, mask | (1<<(n-1-pos)), len+1, false);

        // Choice 2: Abbreaviate the character - keep bit as 0
        // Length increases  by 1 only if previois char as not abbreviated.
        dfs(pos+1, mask, prevAbbr? len:len+1, true);
    }
}