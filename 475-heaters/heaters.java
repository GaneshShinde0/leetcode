class Solution {
    public int findRadius(int[] houses, int[] heater) {
        Arrays.sort(houses);
        Arrays.sort(heater);
        int radius = 0;
        for(int h:houses){
            int left = 0, right = heater.length-1;
            while(left<right){
                int mid = (left+right)/2;
                if(heater[mid]<h){
                    left = mid+1;
                }else{
                    right = mid;
                }
            }
            int dist = Math.abs(heater[left]-h);
            if(left>0) dist = Math.min(dist, Math.abs(heater[left-1]-h));
            radius = Math.max(radius, dist);
        }
        return radius;

    }
    public int findRadiusUsingTreeSet(int[] houses, int[] heater) {
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