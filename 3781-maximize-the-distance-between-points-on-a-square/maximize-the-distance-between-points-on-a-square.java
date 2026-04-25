class Solution {
    public int maxDistance(int side, int[][] points, int k) {
        List<Long> arr = new ArrayList<>();
        for(int[] p:points){
            int x = p[0];
            int y = p[1];
            if(x==0){
                arr.add((long)y);
            }else if(y==side){
                arr.add(side*1l+x);
            }else if(x==side){
                arr.add(side*3l-y);
            }else{
                arr.add(side*4l-x);
            }
        }
        Collections.sort(arr);
        long low = 1;
        long high = side;
        int ans = 0;

        while(low<=high){
            long mid = (low+high)/2;
            if(check(arr,side,k,mid)){
                low = mid+1;
                ans = (int) mid;
            }else{
                high = mid-1;
            }
        }
        return ans;
    }

    private boolean check(List<Long> arr, int side, int k, long limit){
        long perimeter = side*4l;
        for(long start:arr){
            long end = start+perimeter -limit;
            long curr = start;

            for(int i=0;i<k-1;i++){
                int idx = (int) lowerBound(arr, curr+limit);
                if(idx == arr.size() || arr.get(idx)>end){
                    curr = -1;
                    break;
                }
                curr = arr.get(idx);
            }

            if(curr>=0) return true;
        }
        return false;
    }

    private int lowerBound(List<Long> arr, long target){
        int left = 0;
        int right = arr.size();
        while(left<right){
            int mid = left + (right-left)/2;
            if(arr.get(mid)<target){
                left = mid+1;
            }else{
                right = mid;
            }
        }
        return left;
    }
}