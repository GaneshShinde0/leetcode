class Solution {
    public String minimumString(String a, String b, String c) {
        int m = a.length(), n = b.length(), o = c.length();
        List<String> li = new ArrayList<>();
        li.add(merge(merge(a,b),c));
        li.add(merge(merge(b,a),c));
        li.add(merge(merge(a,c),b));
        li.add(merge(merge(c,a),b));
        li.add(merge(merge(b,c),a));
        li.add(merge(merge(c,b),a));
        Collections.sort(li,(x,y)->{
            if(x.length()!=y.length()) return Integer.compare(x.length(),y.length());
            else return x.compareTo(y);
        }
        );
        return li.get(0);

    }
    private String mergeInitial(String s1, String s2){
        if(s1.contains(s2)) return s1;
        int m = s1.length(), n = s2.length();
        StringBuilder sb = new StringBuilder(s1);
        for(int i=n-1;i>=0;i--){
            sb.insert(m,s2.charAt(i));
            if(sb.indexOf(s2)!=-1) return sb.toString();
        }
        return sb.toString();
    }

    // Merge Using KMP Algorithm
    private String merge(String s1, String s2){
        if(s1.contains(s2)) return s1;
        String combined = s2 + '#' + s1;
        int[] lps = new int[combined.length()];
        // Standard KMP LPS (Longest Prefix Suffix) building logic
        int len = 0; // Length of the previous longest pprefix suffix.
        int i=1;

        while(i<combined.length()){
            if(combined.charAt(i)==combined.charAt(len)){
                len++;
                lps[i]=len;
                i++;
            }else{
                if(len!=0){
                    len = lps[len-1];
                }else{
                    lps[i]=0;
                    i++;
                }
            }
        }
        int overlap = lps[combined.length()-1];
        return s1+s2.substring(overlap);
    }
}