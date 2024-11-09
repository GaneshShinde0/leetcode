class Solution {

    
    public List<List<Integer>> findMatrixInitialDoesNotWork(int[] nums) {
        HashMap<Integer,List<Integer>> hm= new HashMap<>();
        List<List<Integer>> li = new ArrayList<>();
        int[] freq = new int[nums.length];
        int maxFreq = Integer.MIN_VALUE;
        for(int i:nums){
            freq[i]++;
            if(freq[i]>maxFreq) maxFreq = freq[i];
        }
        Arrays.sort(nums);
        int i=0;
        li.add(new ArrayList<>());
        for(int j:nums){
            if(!li.get(i).contains(j)){
                li.get(i).add(j);
            }else{
                li.add(new ArrayList<>());
                i++;
            }
        }
        
        return li;
    }
    public List<List<Integer>> findMatrix(int[] nums) {
        // Algo: first get frequency of all elements.
        // Sort: Elements based on their frequency;
        int n =nums.length+1;
        int[] freq = new int[n];
        for(int i:nums){
            freq[i]++;
        }
        Integer[][] temp = new Integer[n][2];
        for(int i=0;i<n;i++){
            temp[i][0]=i;
            temp[i][1]=freq[i];
        }
        Arrays.sort(temp,(a,b)->b[1]-a[1]);
        n = temp[0][1];
        List<List<Integer>> res = new ArrayList<>();
        for(int i=0;i<n;i++){
            List<Integer> li = new ArrayList<>();
            int j=0;
            while(temp[j][1]>0){
                li.add(temp[j][0]);
                temp[j][1]--;
                j++;
            }
            res.add(li);
        }  
        return res; 
    }

    public List<List<Integer>> findMatrixOptimized(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int[] count = new int[nums.length + 1];

        for (final int num : nums){
            if (++count[num] > ans.size()) ans.add(new ArrayList<>());
            ans.get(count[num] - 1).add(num);
        }

        return ans;
    }
}
