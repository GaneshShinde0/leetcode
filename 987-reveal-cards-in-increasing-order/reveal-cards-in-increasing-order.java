// Based on description of problem,
// This is some kind of binary tree stored in array or heap

class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        // We can basically start from sorted array and get to result.
        Arrays.sort(deck);
        Queue<Integer> queueElements = new LinkedList<>();
        Queue<Integer> queueIndices = new LinkedList<>();
        int n = deck.length;
        for(int i=0;i<n;i++){
            queueElements.add(deck[i]);
            queueIndices.add(i);
        }
        int[] res = new int[n];
        while(!queueElements.isEmpty()){
            int first = queueElements.poll();
            res[queueIndices.poll()]=first;
            queueIndices.add(queueIndices.poll());
        }
        return res;
    }
}