class Solution {
    public int maxFixedPoints(int[] nums) {
        List<Integer> s = new ArrayList<>();
        List<int[]> difference= new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if(i>=nums[i]){
                difference.add(new int[]{i-nums[i],nums[i]});
            }
        }
        Collections.sort(difference,(a,b)->{
            if(a[0]!=b[0]) return Integer.compare(a[0],b[0]);
            return Integer.compare(a[1],b[1]);
        });

        for(int[] d:difference){
            int x = d[1];
            int left = 0, right = s.size();
            while(left<right){
                int mid = left + (right-left)/2;
                if(s.get(mid)>=x) right = mid;
                else left = mid+1;
            }
            if(left == s.size())  s.add(x);
            else s.set(left,x);
        }
        return s.size();
    }
}