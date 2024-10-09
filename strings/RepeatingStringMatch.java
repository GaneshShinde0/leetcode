class RepeatingStringMatch {

    // Following Causes timeout because of repetative appends and then toString()
    public int repeatedStringMatchTimeout(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int count=0;
        while(!sb.toString().contains(b) && sb.toString().length()<2*(Math.max(b.length(),a.length()))){
            sb.append(a);
            count++;
        }
        if (sb.toString().contains(b)){
            return count;
        }
        return -1;
    }

    public int repeatedStringMatch260Ms(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        
        // Append string `a` until `sb` length is at least the length of `b`
        while (sb.length() < b.length()) {
            sb.append(a);
            count++;
        }
        
        // Check if `b` is in the current `sb`
        if (sb.toString().contains(b)) {
            return count;
        }
        
        // Append one more time to cover possible overlap
        sb.append(a);
        count++;
        
        // Check again after the additional append
        if (sb.toString().contains(b)) {
            return count;
        }
        
        // If `b` is still not found, return -1
        return -1;
    }

    public int repeatedStringMatch(String a, String b) {
        boolean alpha[] = new boolean[26];

        for(char x : a.toCharArray()){
            alpha[x-'a'] = true;
        }

        for(char x : b.toCharArray()){
            if(!alpha[x-'a']) return -1;
        }

        int count = b.length()/a.length();

        StringBuilder s = new StringBuilder(a.repeat(count));

        for(int i=0; i<3; i++){
            if(s.indexOf(b)>=0) return count+i;
            s.append(a);
        }

        return -1;
    }
}
