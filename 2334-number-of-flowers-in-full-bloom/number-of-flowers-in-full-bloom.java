class Solution {
    public int[] fullBloomFlowers(int[][] flowers, int[] people) {
        List<Integer> starts = new ArrayList();
        List<Integer> ends = new ArrayList();
        
        for (int[] flower: flowers) {
            starts.add(flower[0]);
            ends.add(flower[1] + 1);
        }
        
        Collections.sort(starts);
        Collections.sort(ends);
        int[] ans = new int[people.length];
        
        for (int index = 0; index < people.length; index++) {
            int person = people[index];
            int i = binarySearch(starts, person);
            int j = binarySearch(ends, person);
            ans[index] = i - j;
        }
        
        return ans;
    }
    
    public int binarySearch(List<Integer> arr, int target) {
        int left = 0;
        int right = arr.size();
        while (left < right) {
            int mid = (left + right) / 2;
            if (target < arr.get(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        
        return left;
    }
    public int[] fullBloomFlowersInitial(int[][] flowers, int[] people) {
        int max = 0;
        for(int[] arr:flowers){
            max = Math.max(arr[1],max);
        }
        int[] prefixSum = new int[max+2];
        for(int[] arr:flowers){
            prefixSum[arr[0]]+=1;
            prefixSum[arr[1]+1]-=1;
        }
        for(int i=1;i<max+2;i++){
            prefixSum[i]+=prefixSum[i-1];
        }
        int[] res = new int[people.length];
        for(int i=0;i<people.length;i++){
            if(people[i]>max) continue;
            res[i] = prefixSum[people[i]];
        }
        return res;
    }
}