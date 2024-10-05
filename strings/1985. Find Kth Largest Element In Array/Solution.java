import java.math.BigInteger;
class Solution {
    // Very slow 885 ms
    public String kthLargestNumberNaive(String[] nums, int k) {
        Arrays.sort(nums, (a, b) -> new BigInteger(a).compareTo(new BigInteger(b)));
        return nums[nums.length-k];
    }

    public String kthLargestNumber(String[] arr, int k) {
        
        Arrays.sort(arr, new Comparator<String>() {
            public int compare(String a, String b) {
                
                if (a.length() != b.length()) {
                    return Integer.compare(a.length(), b.length());
                }
                
                return a.compareTo(b);
            }
        });

        
        return arr[arr.length - k];
    }
}
