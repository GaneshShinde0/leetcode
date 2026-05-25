class Solution {
    public int countDivisibleSubstringsInitial(String word) {
        int[] map = {1,1,2,2,2,3,3,3,4,4,4,5,5,5,6,6,6,7,7,7,8,8,8,9,9,9};
        char[] chars = word.toCharArray();
        int res = 0;
        for(int i=0;i<chars.length;i++){
            int len = 1;
            int sum = 0;
            for(int j=i;j<chars.length;j++){
                sum+=map[chars[j]-'a'];
                if(sum%len==0) res++; // (sum%(j-i+1)==0) also works
                len++;
            }
        }
        return res;
    }
    /*
    Optimized O(N)
    Since maximum mapped value for a character is 9, the average value of any divisible substring must be an integer between 1 and 9.
    By Rearranging the formula `Prefix[j]-Prefix[i] = Avg(j-i)
    => Prefix[j]-Avg*j = Prefix[i]-Avg*i, we can use hashMap to count matching prefixesin a single pass for each possible average.
    */

    public int countDivisibleSubstrings(String word){
        int[] map = {1,1,2,2,2,3,3,3,4,4,4,5,5,5,6,6,6,7,7,7,8,8,8,9,9,9};
        char[] chars = word.toCharArray();
        int n = word.length();
        int res = 0;
        // Average of any valid substring must be between 1 and 9.
        for(int avg = 1;avg<=9;avg++){
            Map<Integer, Integer> count = new HashMap<>(); // Store frequency of (prefixSum - a*length)
            count.put(0,1);
            int prefixSum = 0;
            for(int i=0;i<n;i++){
                prefixSum+=map[chars[i]-'a'];
                int val = prefixSum - avg*(i+1); // Calculate the transformed value.
                // If we've seen this value before, it means there are valid substrings ending here.
                res += count.getOrDefault(val,0);
                // Record the current value for future substrings.
                count.put(val, count.getOrDefault(val,0)+1);
            }
        }
        return res;
    }
}