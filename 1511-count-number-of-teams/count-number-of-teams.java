class Solution {
    public int numTeams(int[] rating) {
        int n = rating.length;
        int totalTeams = 0;
        
        // Iterate through each element treating it as the middle soldier (j)
        for (int j = 0; j < n; j++) {
            int leftSmaller = 0, rightGreater = 0;
            int leftGreater = 0, rightSmaller = 0;
            
            // Scan the left side of j (from 0 to j-1)
            for (int i = 0; i < j; i++) {
                if (rating[i] < rating[j]) {
                    leftSmaller++;
                } else if (rating[i] > rating[j]) {
                    leftGreater++;
                }
            }
            
            // Scan the right side of j (from j+1 to n-1)
            for (int k = j + 1; k < n; k++) {
                if (rating[k] > rating[j]) {
                    rightGreater++;
                } else if (rating[k] < rating[j]) {
                    rightSmaller++;
                }
            }
            
            // Number of increasing teams: (left smaller * right greater)
            // Number of decreasing teams: (left greater * right smaller)
            totalTeams += (leftSmaller * rightGreater) + (leftGreater * rightSmaller);
        }
        
        return totalTeams;
    }
}