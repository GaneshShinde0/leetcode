class Solution {
    public long maxKelementsBFTLE(int[] nums, int k) {
        long score = 0;
        Arrays.sort(nums);
        int i = nums.length-1;
        while(k>0){
            score+=nums[i];
            nums[i]=(int)Math.ceil(nums[i]/3.0);
            Arrays.sort(nums);
            k--;
        }
        return score;
    }
    public long maxKelements(int[] nums, int k) {
        long score = 0;
        // Arrays.sort(nums);
        // PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder()); Calling Collections.reverseOrder() explicitly slows down whole process by 40 ms
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);
        for(int i:nums){
            pq.offer(i);
        }
        while(k>0){
            int temp = pq.poll();
            score+=temp;
            // pq.offer((int) Math.ceil(temp/3.0)); is bit slower
            pq.offer((temp + 2)/ 3);
            k--;
        }
        return score;
    }
}
