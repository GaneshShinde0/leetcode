class Solution {
    public int minOperations(String s) {
        int n = s.length();
        if(n<=1) return 0;
        char firstChar = s.charAt(0), lastChar = s.charAt(n-1);
        if(n==2 && firstChar>lastChar) return -1;
        char biggest = firstChar, smallest = firstChar;
        boolean alreadySorted = true;
        for(int i=1;i<n;i++){
            char c = s.charAt(i);
            if(s.charAt(i)<s.charAt(i-1)) alreadySorted = false;
            biggest = c>biggest?c:biggest;
            smallest = c<smallest?c:smallest;
        }
        int res = 0;
        if(alreadySorted) return 0;
        if(firstChar == smallest || lastChar==biggest) return 1;
        if(firstChar == biggest && lastChar == smallest){
            boolean b1 = true;
            boolean b2 = true;
            for(int i=1;i<n;i++){
                if(s.charAt(i)==biggest) b1 = false;
            }
            for(int i=0;i<n-1;i++){
                if(s.charAt(i)==smallest) b2 = false;
            }
            if(b1 && b2) return 3;
        }
        return 2;
    }
}