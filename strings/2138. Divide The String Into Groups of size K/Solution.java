class Solution {
    public String[] divideStringInitialSolution(String s, int k, char fill) {
        String[] res = new String[(int) Math.ceil(1.0*s.length()/k)];
        int j=0;
        for(int i=0;i+k<=s.length();i+=k){
            res[j]=s.substring(i,i+k);
            j++;
        }
        if(s.length()%k!=0)res[res.length-1]=s.substring((s.length()/k)*k)+(fill+"").repeat(k-s.length()%k);
        return res;
    }

    public String[] divideString(String s, int k, char fill) {
        int n = s.length();
        int remainder = n % k;
        
        // If the length isn't divisible by k, calculate how much fill is needed
        if (remainder != 0) {
            int fillCount = k - remainder;
            // Use StringBuilder to append fill characters
            StringBuilder sb = new StringBuilder(s);
            for (int i = 0; i < fillCount; i++) {
                sb.append(fill);
            }
            s = sb.toString();
            n += fillCount; // Update length
        }
        
        String[] result = new String[n / k];
        for (int i = 0, j = 0; i < n; i += k) {
            result[j++] = s.substring(i, i + k);
        }
        
        return result;
    }
}
