class Solution {
    public int numberOfPoints(List<List<Integer>> nums) {
        boolean[] arr = new boolean[101];
        for(List<Integer> li:nums){
            for(int i=li.get(0);i<=li.get(1);i++){
                arr[i]=true;
            }
        }
        int count=0;
        for(boolean b:arr){
            if(b)count++;
        }
        return count;
    }

    public int numberOfPointsONSolution(List<List<Integer>> nums) {
       int[] freq = new int[102];
        for(List<Integer> l: nums){
            int start = l.get(0);
            int end = l.get(1);
            freq[start]++;
            freq[end+1]--;
        }
        int ans = 0;
        for(int i=1;i<102;i++){
            freq[i] += freq[i-1];
            if(freq[i]>0){
                ans++;
            }
        }
        return ans;
    }
}
