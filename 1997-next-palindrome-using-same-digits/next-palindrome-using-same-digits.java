class Solution {
    public String nextPalindrome(String num) {
        int len = num.length();
        int[] arr = new int[len / 2];
        for(int i = 0; i < arr.length; i++) {
            arr[i] = num.charAt(i) - '0';
        }
        if(!nextPermutation(arr)) return "";
        
        StringBuilder sb = new StringBuilder();
        for(int item: arr) {
            sb.append(item);
        }

        if(len % 2 == 0) return sb.toString() + sb.reverse().toString();
        else return sb.toString() + num.substring(len / 2, len / 2 + 1) + sb.reverse().toString();
    }

    private boolean nextPermutation(int[] nums) {
        int n = nums.length - 1, p = -1;
        for(int i = n - 1; i >= 0; i--) {
            if(nums[i] < nums[i + 1]) {
                p = i;
                break;
            }
        }

        if(p == -1) {
            reverse(nums, 0, n);
            return false;
        }

        for(int i = n; i >= 0; i--) {
            if(nums[i] > nums[p]){
                swap(nums, p, i);
                break;
            }
        }
        reverse(nums, p + 1, n);
        return true;
    }

    private void reverse(int[] nums, int s, int e){
        while(s < e) swap(nums, s++, e--);
    }

    private void swap(int[] nums, int s, int e){
        int t = nums[s];
        nums[s] = nums[e];
        nums[e] = t;
    }
}