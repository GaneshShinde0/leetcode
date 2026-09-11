class Solution {
    public int totalNumbersInitialSolution(int[] digits) {
        HashSet<Integer> map = new HashSet<>();
        int n = digits.length;
        for(int i=0;i<n;i++){
            for(int j=0; j<n; j++){
                for(int k=0; k<n; k++){
                    if(i!=j&&i!=k&&j!=k){
                        if(digits[i]!=0){
                            if(digits[k]%2==0){
                                int number = digits[i]*100+digits[j]*10+digits[k];
                                map.add(number);
                            }
                        }
                    }
                }
            }
        }
        return map.size();
    }
    public int totalNumbers(int[] digits) {
        int[] freq = new int[10];
        for (int d : digits) freq[d]++;

        int count = 0;
        for (int num = 100; num <= 998; num += 2) {
            int a = num / 100, b = (num / 10) % 10, c = num % 10;
            int[] need = new int[10];
            need[a]++; need[b]++; need[c]++;
            if (need[a] <= freq[a] && need[b] <= freq[b] && need[c] <= freq[c]) {
                count++;
            }
        }
        return count;
    }
}