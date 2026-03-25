class Solution {
    public int distinctPoints(String s, int k) {
        Set<Long> set = new HashSet<>();
        set.add(0l);
        int x = 0, y = 0;
        for(int i=k;i<s.length();i++){
            // Choose Current Step;
            switch(s.charAt(i)){
                case 'U':y++; break;
                case 'D':y--; break;
                case 'L':x--; break;
                case 'R':x++; break;
            }
            // Remove Old Step
            switch(s.charAt(i-k)){
                case 'U':y--; break;
                case 'D':y++; break;
                case 'L':x++; break;
                case 'R':x--; break;
            }
            set.add(x*100000l+y);

        }
        return set.size();
    }
}