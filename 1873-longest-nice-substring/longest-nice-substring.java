class Solution {
    private static final int DIFF_IN_ASCII_VALUE = 32;
    public String longestNiceSubstringDoesNotWork(String s) {
        int n = s.length();
        String res = "";
        for(int i=0;i<n;i++){
            Set<Character> set = new HashSet<>();
            for(int j=i;j<n;j++){
                char c = s.charAt(j);
                set.add(c);
                boolean isUpperPresent = (c >= 'a' && c <= 'z')&& set.contains((char)(c - DIFF_IN_ASCII_VALUE));
                boolean isLowerPresent = (c >= 'A' && c <= 'Z')&& set.contains((char)(c + DIFF_IN_ASCII_VALUE));
                if(i==0){
                    System.out.println(set);
                    System.out.println("Res Length: "+ res.length()+", Current SubString: "+s.substring(i,j+1)+" : Is Upper Present: "+isUpperPresent+", Is Lower Present: "+isLowerPresent);
                }
                if ((isUpperPresent||isLowerPresent)&& (res.length() < (j - i + 1))) {
                    res = s.substring(i, j + 1);
                }
            }
        }
        return res;
    }

    public String longestNiceSubstringWorks(String s) {
        int n = s.length();
        String res = "";
        for(int i=0;i<n;i++){
            Set<Character> set = new HashSet<>();
            for(int j=i;j<n;j++){
                String sub = s.substring(i,j+1);
                boolean isUpperPresent=true;
                boolean isLowerPresent=true;
                boolean temp = true;
                for(int k=0;k<sub.length();k++){
                    char c = sub.charAt(k);
                    isUpperPresent = (c >= 'a' && c <= 'z')&& (sub.indexOf(c-DIFF_IN_ASCII_VALUE)!=-1); 
                    isLowerPresent = (c >= 'A' && c <= 'Z')&& (sub.indexOf(c+DIFF_IN_ASCII_VALUE)!=-1);
                    temp = temp && (isUpperPresent||isLowerPresent);
                    // if(i==3)System.out.println("Current SubString: "+res+", Res Length: "+ res.length()+", Current SubString: "+s.substring(i,j+1)+" : Is Upper Present: "+isUpperPresent+", Is Lower Present: "+isLowerPresent);

                }
                if ((temp)&& (res.length() < (j - i + 1))) {
                        res = s.substring(i, j+1);
                        // System.out.println("Current SubString: "+res+", Res Length: "+ res.length()+", Current SubString: "+s.substring(i,j+1)+" : Is Upper Prsent: "+isUpperPresent+", Is Lower Present: "+isLowerPresent);
                    }
            }
        }
        return res;
    }

    
    public String longestNiceSubstring(String s) {
        int n = s.length();
        String res = "";
        for(int i=0;i<n;i++){
            Set<Character> set = new HashSet<>();
            for(int j=i;j<n;j++){
                String sub = s.substring(i,j+1);
                boolean isUpperPresent=false;
                boolean isLowerPresent=false;
                boolean temp = true;
                for(int k=0;k<sub.length();k++){
                    char c = sub.charAt(k);
                    isUpperPresent = (c >= 'a' && c <= 'z')&& (sub.indexOf(c-DIFF_IN_ASCII_VALUE)!=-1); 
                    isLowerPresent = (c >= 'A' && c <= 'Z')&& (sub.indexOf(c+DIFF_IN_ASCII_VALUE)!=-1);
                    temp = temp && (isUpperPresent||isLowerPresent);
                }
                if ((temp)&& (res.length() < (j - i + 1))) {
                        res = s.substring(i, j+1);
                    }
            }
        }
        return res;
    }
}