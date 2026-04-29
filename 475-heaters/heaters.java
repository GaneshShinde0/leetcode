class Solution {
    public int findRadius(int[] houses, int[] heater) {
        if(houses.length==0) return 0;
        TreeSet<Integer> set = new TreeSet<>();
        int res = 0;
        for(int h:heater) set.add(h);
        for(int h:houses){
            Integer floor = set.floor(h);
            Integer ceil = set.ceiling(h);
            if(floor!=null && ceil==null){
                res = Math.max(h-floor,res);
            }else if(floor==null && ceil!=null){
                res = Math.max(ceil-h,res);
            }else{
                res = Math.max(res,Math.min(ceil-h,h-floor));
            }
            
        }
        return res;
    }
}