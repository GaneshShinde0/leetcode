class Solution {

    public boolean isPossible(int[] target) {
        
        // Handle the n = 1 case.
        if (target.length == 1) {
            return target[0] == 1;
        }
        
        long totalSum = 0;
        
        PriorityQueue<Long> pq = new PriorityQueue<Long>(Collections.reverseOrder());
        for (int num : target) {
            totalSum+=num;
            pq.add((long)num);
        }
        
        while (pq.element() > 1) {
            long largest = pq.remove();
            long rest = totalSum - largest;
            
            // This will only occur if n = 2.
            if (rest == 1) {
                return true;
            }
            long x = largest % rest;
            
            // If x is now 0 (invalid) or didn't
            // change, then we know this is impossible.
            if (x == 0 || x == largest) {
                return false;
            }
            pq.add(x);
            totalSum = totalSum - largest + x;
        }
        
        return true; 
    }
    public boolean isPossibleOlder(int[] target) {
        int n = target.length;
        TreeMap<Integer, Integer> targetMap = new TreeMap<>();
        for(int i:target) targetMap.put(i, targetMap.getOrDefault(i,0)+1);
        int currSum = n;
        HashMap<Integer, Integer> sourceMap = new HashMap<>();
        sourceMap.put(1,n);
        while(!sourceMap.isEmpty()){
            if(!targetMap.containsKey(currSum)){
                Map.Entry<Integer, Integer> floor = targetMap.floorEntry(currSum);
                if(floor==null) return false;
            }
            targetMap.put(currSum,targetMap.getOrDefault(currSum,0)-1);
            if(targetMap.get(currSum)<=0)targetMap.remove(currSum); 
            currSum = currSum*2-1;
            sourceMap.put(1,sourceMap.getOrDefault(1,0)-1);
            sourceMap.put(currSum,1);
        }
        return true;
    }
}