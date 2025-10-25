class Solution {
    public List<Integer> arraysIntersection(int[] arr1, int[] arr2, int[] arr3) {
        int[] freq = new int[2001];
        for(int i=0;i<arr1.length;i++) freq[arr1[i]]++;
        for(int i=0;i<arr2.length;i++) freq[arr2[i]]++;
        for(int i=0;i<arr3.length;i++) freq[arr3[i]]++;
        List<Integer> res = new ArrayList<>();
        for(int i=0;i<2001;i++){
            if(freq[i]==3) res.add(i);
        }
        return res;
    }
}