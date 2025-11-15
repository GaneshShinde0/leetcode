/*
Count the number of substrings with Dominant ones.

Enumeration:
Enumerating all substringsand checking whether they are 1 significant strings would consume lot of time. 
Considering the characteristics of 1 significant strings, the number of 1s must be greater than or equal to the square of the number of 0s. Therefore, we can enumerate substrings by the number of 0's they contain, which reduces the range of enumeration to (n)^1/2, where n is the length of the string.

Consider the right boundary i of a substring and let cnt0 denote the number of occurences of 0 in that substring. Suppose the position of the cnt 0 th 0 is 0. We can then calculate how many valid left boundaries exist between the cnt0 th and the (cnt0+1) th 0. It is easy to see that upper limit of cnt0 is (n)^1/2 so the total time complexity is O((n)3/2)

For conveniennce, we define pre[j] as the position of the nearest 0 before position j. Then the substring ending at i th contian cnt0 zeros can have at most cnt1 = i- pre[j] - cnt0 ones. The analysis proceeds by considering two cases.

    - If cnt1<cnt0^2, there is no 1 significant substrings satisfying current condition.
    - Otherwise, such a substring exists, but the number of valid left boundaries is constrained by both j-pre[j] and cnt1-cnt0^2+1.

We process each i as described above, accumulating the number of valid left boundaries to obtain the final answer. To conveniently handle consecutive 1s at the very beginning of the string, we can add a sentinel 0 to the left end of the original string.

*/

class Solution{
    public int numberOfSubstringsInitial(String s){
        int n = s.length();
        int[] pre = new int[n+1];
        pre[0] = 0;
        for(int i=0;i<n;i++){
            if(i==0 || i>0 && s.charAt(i-1)=='0'){
                pre[i+1] = i;
            }else{
                pre[i+1] = pre[i];
            }
        }
        System.out.println(Arrays.toString(pre));
        int res = 0;
        for(int i=1;i<=n;i++){
            int cnt0 = s.charAt(i-1)=='0'?1:0;
            int j = i;
            while(j>0 && cnt0*cnt0<=n){
                int cnt1 = (i-pre[j])-cnt0;
                if(cnt0*cnt0<=cnt1){
                    res+=Math.min(j-pre[j], cnt1-cnt0*cnt0+1);
                }
                j = pre[j];
                cnt0++;
            }
        }
        return res;
    }

    public int numberOfSubstringsSecond(String s) {

        int n = s.length();
        int[] prefix0 = new int[n + 1];
        int[] prefix1 = new int[n + 1];

        // build prefix zero & one counts
        for (int i = 1; i <= n; i++) {
            prefix0[i] = prefix0[i - 1] + (s.charAt(i - 1) == '0' ? 1 : 0);
            prefix1[i] = prefix1[i - 1] + (s.charAt(i - 1) == '1' ? 1 : 0);
        }

        int result = 0;

        // iterate left pointer
        for (int i = 0; i < n; i++) {

            // We stop when zeros grow too large
            // Because once zeros > sqrt(n), they cannot be dominated anymore
            int maxZerosToTry = (int) Math.sqrt(n) + 2;

            // expand right pointer
            for (int j = i; j < n; j++) {

                int zeros = prefix0[j + 1] - prefix0[i];
                int ones = prefix1[j + 1] - prefix1[i];

                // if zeros too large → break early
                if (zeros > maxZerosToTry) break;

                // Check condition
                if (ones >= zeros * zeros) {
                    result++;
                }
            }
        }

        return result;
    }
    public int numberOfSubstrings(String s) {
        int n = s.length();
        int dominantCount = 0;
        List<Integer> zeros = new ArrayList<>();
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='0') zeros.add(i);
        }
        if(zeros.size()==0) return n*(n+1)/2;
        int zeroInd = 0;
        for(int i=0;i<n;i++){
            while(zeroInd<zeros.size() && zeros.get(zeroInd)<i) zeroInd++;

            List<Integer> validZero = new ArrayList<>();
            for(int z = zeroInd; z<zeros.size() && z<(zeroInd+201); z++){
                validZero.add(zeros.get(z));
            }
            validZero.add(n);
            int zeroCount = 0;
            int last = i;

            for(int vz:validZero){
                int minOne = zeroCount*zeroCount;
                int minInd = Math.max(i+minOne+zeroCount-1,last); // Minimum Index After which everything would become valid;
                if(minInd<vz) dominantCount += (vz-minInd);
                last = vz;
                zeroCount++;
            }
        }
        return dominantCount;
    }
}