class Solution {
    public int[] maximumBeautyTLE(int[][] items, int[] queries) {
        int[] result = new int[queries.length];
        Arrays.sort(items, (a, b) -> (a[0] - b[0]));
        // We have sorted items according to their price ... For every price we have to take maximum beuty.
        int[] maxBeuty = new int[items.length];
        int max = Integer.MIN_VALUE;
        for(int i=0;i<items.length;i++){
            max = Math.max(max, items[i][1]);
            items[i][1]=max;
        }
        for(int i=0;i<queries.length;i++){
            for(int j=0;j<items.length;j++){
                if(items[j][0]<=queries[i]){
                    result[i]=items[j][1];
                }else{
                    break;
                }

            }
        }
        return result;
    }

    public int[] maximumBeautyUsingBinarySearch(int[][] items, int[] queries){
        int[] ans = new int[queries.length];
        Arrays.sort(items,(a,b)->a[0]-b[0]);
        int max = items[0][1];
        for(int i=0;i<items.length;i++){
            max = Math.max(max,items[i][1]);
            items[i][1]=max;
        }

        for(int i=0;i<queries.length;i++){
            ans[i]=binarySearch(items,queries[i]);
        }
        return ans;
    }

    private int binarySearch(int[][] items, int targetPrice){
        int l=0;
        int r = items.length-1;
        int maxBeuty = 0;

        while(l<=r){
            int mid = l+(r-l)/2;
            if(items[mid][0]>targetPrice){
                r=mid-1;
            }else{
                maxBeuty = Math.max(maxBeuty,items[mid][1]);
                l=mid+1;
            }
        }
        return maxBeuty;
    }

    public int[] maximumBeautySortingItemsQueries(int[][] items, int[] queries){
        int[] ans = new int[queries.length];
        Arrays.sort(items,(a,b)->a[0]-b[0]);
        int[][] queriesWithIndices = new int[queries.length][2];
        for(int i=0; i<queries.length;i++){
            queriesWithIndices[i][0]=queries[i];
            queriesWithIndices[i][1]=i;
        }

        Arrays.sort(queriesWithIndices,(a,b)->a[0]-b[0]);
        int itemIndex = 0;
        int maxBeuty = 0;
        for(int i=0;i<queries.length;i++){
            int query = queriesWithIndices[i][0];
            int originalIndex = queriesWithIndices[i][1];

            while(itemIndex<items.length && items[itemIndex][0]<=query){
                maxBeuty = Math.max(maxBeuty, items[itemIndex][1]);
                itemIndex++;
            }
            ans[originalIndex] = maxBeuty;
        }
        return ans;
    }

    // Using TreeMap
    public int[] maximumBeauty(int[][] items, int[] queries){
        int[] result = new int[queries.length];
        Arrays.sort(items, (a,b)->(a[0]-b[0]));

        TreeMap<Integer, Integer> map = new TreeMap<>(){{put(0,0);}};
        System.out.println(map);
        int currMax = 0;
        for(int[] item: items){
            currMax = Math.max(currMax, item[1]);
            map.put(item[0],currMax);
        }

        for(int i=0;i<queries.length;i++){
            result[i]=map.floorEntry(queries[i]).getValue();
        }
        return result;
    }
}
