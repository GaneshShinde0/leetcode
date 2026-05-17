class Solution {
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        int n = nums.length;
        int[] res = new int[n];
        int left = 0, right = n - 1;
        
        int i = a >= 0 ? n - 1 : 0;
        int diff = a >= 0 ? -1 : 1;
        
        while (left <= right) {
            int leftCalc = calc(nums[left], a, b, c);
            int rightCalc = calc(nums[right], a, b, c);
            
            boolean pickLeft = (a >= 0) ? (leftCalc > rightCalc) : (leftCalc < rightCalc);
            
            if (pickLeft) {
                res[i] = leftCalc;
                left++;
            } else {
                res[i] = rightCalc;
                right--;
            }
            
            i += diff; 
        }
        
        return res;
    }
    
    private int calc(int x, int a, int b, int c) {
        return x * x * a + x * b + c;
    }
}
class Solution1 {
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        int n = nums.length;
        int left = 0, right = n-1;
        int[] res = new int[n];
        int i = 0;
        if(a<0){
            while(left<=right){
                int leftCalc = calc(nums[left],a,b,c);
                int rightCalc = calc(nums[right],a,b,c);
                if(leftCalc<rightCalc){
                    res[i++]=leftCalc;
                    left++;
                }else{
                    res[i++]=rightCalc;
                    right--;
                }
            }
        }else{
            while(left<=right){
                int leftCalc = calc(nums[left],a,b,c);
                int rightCalc = calc(nums[right],a,b,c);
                if(leftCalc>rightCalc){
                    res[i++]=leftCalc;
                    left++;
                }else{
                    res[i++]=rightCalc;
                    right--;
                }
            }
            reverse(res);
        }
        return res;
    }
    private void reverse(int[] arr){
        int start = 0, end = arr.length-1;
        while(start<end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
    private int calc(int x, int a, int b, int c){
        return x*x*a+x*b+c;
    }
}