class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        int[] freq = new int[101];
        int max = 0;
        int min = Integer.MAX_VALUE;
        for(int i:nums){
            freq[i]++;
            max = Math.max(i,max);
            min = Math.min(i,min);
        }
        List<Integer> li = new ArrayList<>();
        for(int i=min;i<=max;i++){
            if(freq[i]==0) li.add(i);
        }
        return li;
    }
}