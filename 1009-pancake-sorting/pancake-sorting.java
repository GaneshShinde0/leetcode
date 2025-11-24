class Solution {
    public List<Integer> pancakeSort(int[] arr) {
        List<Integer> res = new ArrayList<>();
        for(int i=arr.length;i>0;i--){
            int idx = findIdx(arr,i);
            if(idx!=0){
                res.add(idx+1);
                flip(arr,idx+1);
            }
            res.add(i);
            flip(arr,i);
        }
        return res;
    }
    private void flip(int[] arr, int k){
        int i=0;
        while(i<k/2){
            int temp = arr[i];
            arr[i]=arr[k-i-1];
            arr[k-i-1]=temp;
            i++;
        }
    }
    private int findIdx(int[] arr, int target){
        for(int i=0;i<arr.length;i++){
            if(arr[i]==target) return i;
        }
        return -1;
    }
}