class Solution {

    private int[] getKMaxElements(int[] nums, int k){
        Stack<Integer> stk = new Stack<>();
        int n = nums.length;
        int canBeRemoved = n - k;
        for(int i=0;i<n;i++){
            while(!stk.isEmpty() && stk.peek()<nums[i] && canBeRemoved>0){
                stk.pop();
                canBeRemoved--;
            }
            stk.push(nums[i]);
        }
        while(stk.size()>k) stk.pop();
        int[] res = new int[k];
        for(int i=k-1;i>=0;i--){
            res[i] = stk.pop();
        }
        return res;
    }

    private boolean greater(int[] a, int i, int[] b, int j) {
        int n = a.length, m = b.length;
        while (i < n && j < m) {
            if (a[i] != b[j]) return a[i] > b[j];
            i++; j++;
        }
        return (n - i) > (m - j);//else the one with the more length will be considered as greater 
    }

    private int[] merge(int[] a, int[] b, int k) {
        int[] res = new int[k];
        int i = 0, j = 0, r = 0;
        while (r < k) {
            if (greater(a, i, b, j)) {
                res[r++] = a[i++];
            } else {
                res[r++] = b[j++];
            }
        }
        return res;
    }

    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int n1 = nums1.length;
        int n2 = nums2.length;

        int[] res = new int[k];
        for(int i=Math.max(0,k-n2); i<= Math.min(k,n1); i++){
            int[] arr1 = getKMaxElements(nums1,i);
            int[] arr2 = getKMaxElements(nums2,k-i);
            int[] temp = merge(arr1,arr2,k);
            if(greater(temp,0,res,0)){
                res = temp;
            }
        }
        return res;
    }
}
