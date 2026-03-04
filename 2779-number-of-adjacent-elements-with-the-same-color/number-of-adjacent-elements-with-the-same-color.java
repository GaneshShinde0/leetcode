class Solution {
    public int[] colorTheArray(int n, int[][] queries) {
        int[] colors = new int[n];
        int[] result = new int[queries.length];
        int adjacentPairs = 0;
        for(int index = 0; index<queries.length;index++){
            int position = queries[index][0];
            int newColor = queries[index][1];

            if(position>0 && colors[position]>0 && colors[position-1]==colors[position]){
                adjacentPairs--;
            }

            if(position<n-1 && colors[position]>0 && colors[position+1]==colors[position]){
                adjacentPairs--;
            }

            if(position>0 && colors[position-1]==newColor){
                adjacentPairs++;
            }
            if(position<n-1 && colors[position+1]==newColor){
                adjacentPairs++;
            }
            result[index] = adjacentPairs;
            colors[position] = newColor;
        }
        return result;
    }
}