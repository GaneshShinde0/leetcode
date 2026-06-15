class Solution {
    public List<Integer> shortestDistanceColor(int[] colors, int[][] queries){
        int n = colors.length;
        int[] rightMost = {0,0,0};
        int[] leftMost = {n-1,n-1,n-1};
        int[][] distance = new int[3][n];

        for(int i=0;i<3;i++){
            Arrays.fill(distance[i],-1);
        }

        // Looking forward;
        for(int i=0;i<n;i++){
            int color = colors[i]-1;
            for(int j= rightMost[color];j<i+1;j++){
                distance[color][j] = i-j;
            }
            rightMost[color] = i+1;
        }
        // Loocking backward
        for(int i=n-1;i>=0;i--){
            int color = colors[i]-1;
            for(int j=leftMost[color];j>i-1;j--){
                if(distance[color][j]==-1||distance[color][j]>j-i){
                    distance[color][j] = j-i;
                }
            }
            leftMost[color] = i-1;
        }
        List<Integer> queryResults = new ArrayList<>();
        for(int i=0;i<queries.length;i++){
            queryResults.add(distance[queries[i][1]-1][queries[i][0]]);
        }
        return queryResults;
    }





    public List<Integer> shortestDistanceColorInitial(int[] colors, int[][] queries) {
        List<Integer> result = new ArrayList<>();
        HashMap<Integer, List<Integer>> hm = new HashMap<>();
        for(int i=0;i<colors.length;i++){
            hm.computeIfAbsent(colors[i],x->new ArrayList<Integer>()).add(i);
        }
        for(int[] query:queries){
            if(!hm.containsKey(query[1])){
                result.add(-1);
                continue;
            }
            List<Integer> li = hm.get(query[1]);
            int upper = upper(li, query[0]);
            int lower = lower(li, query[0]);
            result.add(Math.abs(Math.min(upper-query[0],query[0]-lower)));
        }
        return result;
    }
    private int upper(List<Integer> li, int target){
        int left=0, right = li.size()-1;
        while(left<right){
            int mid = (left+right)/2;
            if(li.get(mid)>=target){
                right = mid;
            }else{
                left = mid+1;
            }
        }
        return li.get(right);
    }
    private int lower(List<Integer> li, int target){
        int left=0, right = li.size()-1;
        while(left<right){
            int mid = (left+right+1)/2;
            if(li.get(mid)<=target){
                left = mid;
            }else{
                right = mid-1;
            }
        }
        return li.get(left);
    }
    
}