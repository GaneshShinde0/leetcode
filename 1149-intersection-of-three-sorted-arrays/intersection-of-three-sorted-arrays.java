class Solution {
    public List<Integer> arraysIntersectionInitial(int[] arr1, int[] arr2, int[] arr3) {
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

    public List<Integer> arraysIntersection(int[] arr1, int[] arr2, int[] arr3) {
        int i=0,j=0,k=0;
        List<Integer> res = new ArrayList<>();
        while(i<arr1.length && j<arr2.length && k <arr3.length){
            int min = Math.min(Math.min(arr1[i],arr2[j]),arr3[k]);
            if(arr1[i]==arr2[j] && arr2[j]==arr3[k]) res.add(arr1[i]);
            if(min==arr1[i]) i++;
            if(min==arr2[j]) j++;
            if(min==arr3[k]) k++;
        }
        return res;
    }
}