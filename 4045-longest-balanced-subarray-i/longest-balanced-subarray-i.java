// class Solution {
//     public int longestBalanced(int[] nums) {
//         int n = nums.length;
//         int[] evenCounts = new int[n];
//         int[] oddCounts = new int[n];
//         int evenCount = 0, oddCount = 0;
//         for(int i=0;i<n;i++){
//             if(nums[i]%2==0) evenCount++;
//             else oddCount++;
//             evenCounts[i]=evenCount;
//             oddCounts[i]=oddCount;
//         }
//         int res = 0;
//         for(int i=0;i<n;i++){
//             for(int j=i+1;j<n;j++){
//                 if(evenCounts[i]==oddCounts[j]){
//                     res = Math.max(Math.max(i+1,j+1),res);
//                 }
//             }
//         }
//         return res;
//     }
// }
class Solution {
    public int longestBalanced(int[] nums) {
        int n = nums.length;
        int res = 0;

        for (int i = 0; i < n; i++) {
            Set<Integer> evenSet = new HashSet<>();
            Set<Integer> oddSet = new HashSet<>();

            for (int j = i; j < n; j++) {
                if (nums[j] % 2 == 0) {
                    evenSet.add(nums[j]);
                } else {
                    oddSet.add(nums[j]);
                }

                if (evenSet.size() == oddSet.size()) {
                    res = Math.max(res, j - i + 1);
                }

                // Prune: if evenSet or oddSet becomes too unbalanced, no point continuing
                if (Math.abs(evenSet.size() - oddSet.size()) > (n - j)) break;
            }
        }
        return res;
    }
}

