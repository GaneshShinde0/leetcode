// Based on description of problem,
// This is some kind of binary tree stored in array or heap

class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        // We can basically start from sorted array and get to result.
        Arrays.sort(deck);
        Queue<Integer> queueIndices = new LinkedList<>();
        int n = deck.length;
        for(int i=0;i<n;i++){
            queueIndices.add(i);
        }
        int i = 0;
        int[] res = new int[n];
        while(i<n){
            int processIndex = queueIndices.poll();
            queueIndices.add(queueIndices.poll());
            res[processIndex]=deck[i];
            i++;
        }
        return res;
    }
}