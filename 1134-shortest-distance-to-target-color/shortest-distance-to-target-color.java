class Solution {
    public List<Integer> shortestDistanceColor(int[] colors, int[][] queries) {
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