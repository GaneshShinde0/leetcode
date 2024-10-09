class N392IsSubSequence {
    // Following is my solution which took around 2 ms
    public boolean isSubsequence2ms(String s, String t) {
        int spt=0,tpt=0;
        while(spt<s.length()&&tpt<t.length()){
            if(s.charAt(spt)==t.charAt(tpt)){
                spt++;
            }
            tpt++;
        }
        return spt==s.length();
    }

    public boolean isSubsequence(String s, String t) {
        int temp = -1;
        for (char sc: s.toCharArray()) {
            int pos = t.indexOf(sc, temp+1);
            if (pos == -1)
                return false;
            if (pos < temp)
                return false;
            temp = pos;
        }
        return true;
    }
}
