class Solution {
    public boolean validMountainArray(int[] arr) {
        boolean flag = false;
        if(arr.length<=2) return false;
        if(arr[0]>arr[1]) return false;
        for(int i=0;i<arr.length-1;i++){
            if(!flag && arr[i]<arr[i+1]){
                continue;
            }
            flag = true;
            if(flag && arr[i]>arr[i+1]){
                continue;
            }
            return false;
        }
        return flag;
    }
    public boolean validMountainArrayAlternate(int[] arr) {
        int n = arr.length;
        if (n < 3) return false;
        
        int i = 0;
        
        // Ascend to the peak
        while (i < n - 1 && arr[i] < arr[i + 1]) {
            i++;
        }
        
        // Peak cannot be the first or last element
        if (i == 0 || i == n - 1) return false;
        
        // Descend from the peak
        while (i < n - 1 && arr[i] > arr[i + 1]) {
            i++;
        }
        
        return i == n - 1;
    }

}
