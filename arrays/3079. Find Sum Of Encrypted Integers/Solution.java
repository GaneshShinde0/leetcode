class Solution {
    public int sumOfEncryptedInt(int[] nums) {
        int sum = 0;
        for(int i:nums){
            sum+=getLargest(i);
        }
        return sum;
    }
    public int getLargest(int num){
        int largest = 0;
        int digits=0;
        while(num>0){
            if(largest<num%10) largest = num%10;
            num=num/10;
            digits++;
        }
        int res =0;
        while(digits>0){
            res=res*10+largest;
            digits--;
        }

        return res;
    }

    public int sumOfEncryptedIntFastest(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            if (num <= 99) {
                if (num <= 9) {
                    sum += num;
                } else {
                    sum += 11 * Math.max(num % 10, num / 10);
                }
            } else if (num <= 999) {
                sum += 111 * Math.max(num % 10, Math.max((num / 10) % 10, num / 100));
            } else {
                sum += 1111;
            }
        }
        return sum;
    }
}
