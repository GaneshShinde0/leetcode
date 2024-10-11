class Solution {
    public List<List<Integer>> groupThePeopleNaive(int[] groupSizes) {
        // Take all indices and then 

        int n = groupSizes.length;
        int[] freq = new int[n+1];
        List<Integer> li = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        for(int i=0;i<n;i++){
            freq[groupSizes[i]]++;
        }
        for(int i=0;i<=n;i++){
            for(int j=0;j<n;j++){
                if(groupSizes[j]==i){
                    li.add(j);
                    // System.out.println(li);
                    // System.out.println("Result: "+result);
                }
                if(li.size()>0 && li.size()==i){
                    result.add(li);
                    li=new ArrayList<>();
                }
            }
            // if(li.size()>0) result.add(li);
            // li = new ArrayList<>();
        }
        return result;
    }

    // Method to group people based on their group sizes
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>> resultGroups = new ArrayList<>();
        Map<Integer, List<Integer>> groupMap = new HashMap<>();

        // Iterate over the groupSizes array
        for (int i = 0; i < groupSizes.length; i++) {
            int size = groupSizes[i];

            // Get or create a group for the current group size
            List<Integer> currentGroup = groupMap.computeIfAbsent(size, key -> new ArrayList<>());
            currentGroup.add(i);

            // When the group reaches the required size, move it to resultGroups
            if (currentGroup.size() == size) {
                resultGroups.add(currentGroup);
                groupMap.remove(size); // Remove from map since it's now full
            }
        }

        return resultGroups;
    }
}
