class Solution {
    public boolean isNStraightHandWithGroups(int[] hand, int groupSize) {
        int n = hand.length;
        if (n % groupSize != 0) return false;
        
        Arrays.sort(hand);
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < n; i++) {
            hm.put(hand[i], hm.getOrDefault(hand[i], 0) + 1);
        }
        
        int i = 0;
        int total = 0; // Tracks total cards successfully grouped
        
        while (i < n) {
            int curr = hand[i];
            // Get current count from map; if 0, it means this card was already used in a previous group
            int currFreq = hm.getOrDefault(curr, 0);
            
            if (currFreq == 0) {
                i++;
                continue;
            }

            // --- Visualization Logic Start ---
            // Construct the group that is about to be formed
            List<Integer> currentGroup = new ArrayList<>();
            for (int k = 0; k < groupSize; k++) {
                currentGroup.add(curr + k);
            }
            // Print this group 'currFreq' times because we are processing that many batches
            for (int k = 0; k < currFreq; k++) {
                System.out.println("Group found: " + currentGroup);
            }
            // --- Visualization Logic End ---

            // Process the group(s)
            for (int j = 0; j < groupSize; j++) {
                int card = curr + j;
                // Check if the sequence card exists and has enough count
                if (!hm.containsKey(card) || hm.get(card) < currFreq) {
                    System.out.println("Failed to complete group starting with " + curr);
                    return false;
                }
                
                // Deduct the count
                hm.put(card, hm.get(card) - currFreq);
                total += currFreq; // Add number of cards processed
            }
            i++;
        }
        
        return total == n;
    }

    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n = hand.length;
        if(n%groupSize!=0) return false;
        Arrays.sort(hand);
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i=0;i<n;i++){
            hm.put(hand[i],hm.getOrDefault(hand[i],0)+1);
        }
        int i=0;
        int total = 0;
        while(i<n){
            int curr = hand[i];
            int currFreq = hm.get(hand[i]);
            if(currFreq==0){
                i++;
                continue;
            }
            for(int j=0;j<groupSize;j++){
                if(!hm.containsKey(curr+j)||hm.get(curr+j)<currFreq) return false;
                hm.put(curr+j,hm.get(curr+j)-currFreq);
                total+=currFreq;
            }
            i++;
        }
        return total==n;
    }
}