class N634MaxDistanceInArrays {
    public int maxDistancePasses85TestCases(List<List<Integer>> arrays) {
        List<Integer> arr1 = arrays.get(0);
        int min1 = arr1.get(0), max1 = arr1.get(arr1.size()-1);
        List<Integer> arr2 = arrays.get(1);
        int min2 = arr2.get(0), max2 = arr2.get(arr2.size()-1);
        int maxDiff = Math.max(Math.abs(min1-max2),Math.abs(max1-min2));
        if(min1<min2) min2=min1;
        if(max1>max2) max2=max2;
        for(int i=2;i<arrays.size();i++){
            int currMin = arrays.get(i).get(0);
            int currMax = arrays.get(i).get(arrays.get(i).size()-1);
            // Should have taken max of maxDiff  and =
            maxDiff = Math.max(Math.abs(currMax-min2),Math.abs(currMin-max2));
            if (currMin<min2) min2 = currMin;
            if(currMax>max2)max2= currMax;
        }
        return maxDiff;
    }

    public int maxDistance(List<List<Integer>> arrays) {
        // Initialize min and max from the first array
        int minVal = arrays.get(0).get(0);
        int maxVal = arrays.get(0).get(arrays.get(0).size() - 1);
        
        // Initialize the maximum distance
        int maxDiff = 0;
        
        // Iterate over the arrays starting from the second array
        for (int i = 1; i < arrays.size(); i++) {
            int currMin = arrays.get(i).get(0);
            int currMax = arrays.get(i).get(arrays.get(i).size() - 1);
            
            // Calculate the max difference using the current array and the best min/max so far
            maxDiff = Math.max(maxDiff, Math.max(Math.abs(currMax - minVal), Math.abs(currMin - maxVal)));
            
            // Update min and max based on the current array's values
            minVal = Math.min(minVal, currMin);
            maxVal = Math.max(maxVal, currMax);
        }
        
        return maxDiff;
    }

}
