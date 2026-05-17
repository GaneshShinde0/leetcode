class Solution {
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