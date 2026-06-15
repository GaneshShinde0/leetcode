class Solution {
    public int[] advantageCount(int[] nums1, int[] nums2) {
        int n = nums1.length;
        Arrays.sort(nums1);
        // 2. Create and sort indices based on nums2 descending
        Integer[] indices = new Integer[n];
        for(int i=0;i<n;i++){
            indices[i] = i;
        }
        Arrays.sort(indices, (i,j)->Integer.compare(nums2[j], nums2[i]));

        int[] result = new int[n];
        int left = 0, right = n-1;
        for(int i:indices){
            if(nums1[right]>nums2[i]){
                result[i] = nums1[right];
                right--;
            }else{
                result[i] = nums1[left];
                left++;
            }
        }
        return result;
    }
    public int[] advantageCountInitial(int[] nums1, int[] nums2) {
        int n = nums1.length;
        TreeMap<Integer,Integer> tm = new TreeMap<>();
        for(int num:nums1){
            tm.put(num, tm.getOrDefault(num,0)+1);
        }
        int[] res = new int[n];
        Arrays.fill(res,-1);
        for(int i=0;i<n;i++){
            Map.Entry<Integer,Integer> e = tm.higherEntry(nums2[i]);
            if(e!=null){
                res[i] = e.getKey();
                if(e.getValue()>1) tm.put(res[i],e.getValue()-1);
                else tm.remove(e.getKey());
            }
        }
        for(int i=0;i<n;i++){
            if(res[i]==-1){
                Map.Entry<Integer,Integer> e = tm.firstEntry();
                res[i] = e.getKey();
                if(e.getValue()>1) tm.put(res[i],e.getValue()-1);
                else tm.remove(e.getKey());
            }
        }
        return res;
    }
}