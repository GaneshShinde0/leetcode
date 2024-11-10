class Solution {
    public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        Set<Integer> set3 = new HashSet<>();
        Set<Integer> set4 = new HashSet<>();
        
        for(int i:nums1){
            set1.add(i);
        }
        for(int i:nums2){
            set2.add(i);
        }
        for(int i:nums3){
            set3.add(i);
        }
        for(int i=0;i<101;i++){
            if((set1.contains(i)&&set2.contains(i))||(set1.contains(i)&&set3.contains(i)||set2.contains(i)&&set3.contains(i))){
                set4.add(i);
            }
        }
        return new ArrayList<>(set4);
        
    }

    public  List<Integer> twoOutOfThreeWithoutSet(int[] nums1, int[] nums2, int[] nums3) {
        boolean[] b1 = new boolean[101];
        boolean[] b2 = new boolean[101];
        boolean[] b3 = new boolean[101];

        for (int num : nums1) b1[num] = true;
        for (int num : nums2) b2[num] = true;
        for (int num : nums3) b3[num] = true;

        List<Integer> res = new ArrayList<>();

        for (int i = 1; i <= 100; i++){
            if((b1[i] || b2[i]) && (b2[i] || b3[i]) && (b3[i] || b1[i]))
                res.add(i);
        }
        return res;
    }
}
