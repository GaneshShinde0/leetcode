class Solution {
    public int edgeScore(int[] edges) {
        long[] score = new long[edges.length];
        int maxNode = 0;
        long maxScore = 0;
        for(int i=0;i<edges.length;i++){
            score[edges[i]]+=i;
            if(score[edges[i]]>=maxScore){
                maxScore = score[edges[i]];
                if(score[maxNode]==maxScore)maxNode = Math.min(edges[i],maxNode);
                else maxNode = edges[i];
            }
        }
        System.out.println(Arrays.toString(score));
        return maxNode;
    }
}