class Solution {
    public int lengthOfLIS1(int[] arr) {
        int n = arr.length;
        int[] lisLength = new int[n];
        Arrays.fill(lisLength,1);
        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(arr[i]>arr[j]){
                    lisLength[i] = Math.max(lisLength[j]+1,lisLength[i]);
                }
            }
        }
        int res = Integer.MIN_VALUE;
        for(int i:lisLength){
            res = Math.max(i,res);
        }
        return res;
    }
    public int lengthOfLIS2(int[] arr) {
        int n = arr.length;
        int[] lisLength = new int[n];
        Arrays.fill(lisLength,1);
        for(int i=0; i<n; i++){
            for(int j=i+1;j<n;j++){
                if(arr[i]<arr[j]){
                    lisLength[j] = Math.max(lisLength[j],lisLength[i]+1);
                }
            }
        }
        int res = 0;
        for(int i:lisLength){
            res = Math.max(i,res);
        }
        return res;
    }
    public int lengthOfLISIntelligentlyBuildASubsequence(int[] arr) {
        List<Integer> li = new ArrayList<>();
        li.add(arr[0]);
        for(int i=1;i<arr.length;i++){
            if(li.get(li.size()-1) <arr[i]){
                li.add(arr[i]);
            }else{
                int j=0;
                while(arr[i]>li.get(j)){
                    j+=1;
                }
                // We are making sure to nums[i] in its position... in a sorted array.
                li.set(j,arr[i]);
            }
        }
        return li.size();
    }

    // With Binary Search
    // It will same as previous ... We will use Binary search to get value of j.

    // With this approach we are basically doing following
    // Array : 1 4 8 2 3 4
    // 1 4 8
    // 1 2 8
    // 1 2 3
    // 1 2 3 4
    public int lengthOfLIS(int[] arr){
        List<Integer> li = new ArrayList<>();
        li.add(arr[0]);
        for(int i=1;i<arr.length;i++){
            if(li.get(li.size()-1)<arr[i]){
                li.add(arr[i]);
            }else{
                int j = binarySearch(li,arr[i]);
                li.set(j,arr[i]);
            }
        }
        return li.size();
    }
    private int binarySearch(List<Integer> li, int target){
        int low = 0, high = li.size()-1;
        while(low<high){
            int mid = low + (high-low)/2;
            // if(li.get(mid)==target) return mid;
            if(li.get(mid)<target){
                low = mid+1;
            }else{
                high=mid;
            }
        }
        return low;
    }
}