public class Solution {

    public int[] findEvenNumbersON3(int[] digits) {
        Set<Integer> nums = new HashSet<>();
        int n = digits.length;
        // Traverse the indices of three digits
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                for (int k = 0; k < n; ++k) {
                    // Determine whether it meets the condition of the target even number
                    if (i == j || j == k || i == k) {
                        continue;
                    }
                    int num = digits[i]*100+digits[j]*10+digits[k];
                    if(num>99&& num%2==0){
                        nums.add(num);
                    }
                }
            }
        }
        // Converted to an array sorted in ascending order
        List<Integer> res = new ArrayList<>(nums);
        Collections.sort(res);
        int[] result = new int[res.size()];
        for(int i=0; i<res.size();i++){
            result[i] = res.get(i);
        }
        return result;
    }

    public int[] findEvenNumbers(int[] digits){
        int[] freq = new int[10];
        for(int digit: digits) freq[digit]++;
        List<Integer> list = new ArrayList<>();
        for(int i=1;i<=9; i++){
            if(freq[i]==0) continue;
            freq[i]--;
            for(int j=0; j<=9; j++){
                if(freq[j]==0) continue;
                freq[j]--;
                for(int k=0; k<=8;k+=2){
                    if(freq[k]==0) continue;
                    list.add(i*100+j*10+k);
                }
                freq[j]++;
            }
            freq[i]++;
        }
        int n = list.size();
        int[] res = new int[n];
        for(int i=0; i<n; i++){
            res[i]=list.get(i);
        }
        return res;
    }
}
