class Solution {
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