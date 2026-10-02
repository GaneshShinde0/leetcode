class Solution {
    public int maximumTripletValue(int[] nums) {
        // store element before `j`
        TreeSet<Integer> tree = new TreeSet<>(); 

        int n = nums.length;

        //maximum value stored for each `k`
        int[] maxSoFar = new int[n];
        for(int k = n-2; k>=0; k--) {
            maxSoFar[k]=Math.max(nums[k+1], maxSoFar[k+1]);
        }


        int answer = 0;
        for(int j = 0;j < n; j++) {

            //pick the largest value less than nums[j]-1
            Integer floor = tree.floor(nums[j]-1);
            if(floor!=null && nums[j]<maxSoFar[j]) {
                answer = Math.max(floor-nums[j]+maxSoFar[j], answer);
            }
            tree.add(nums[j]);
        }
        return answer;
    }
}