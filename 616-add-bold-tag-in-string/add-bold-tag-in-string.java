class Solution {
    public String addBoldTag(String s, String[] words) {
        int N = s.length();
        boolean[] bold = new boolean[N];
        for(int i=0;i<N;i++){
            for(String word:words){
                search:{
                    for(int k=0;k<word.length();k++){
                        if(k+i>=N || s.charAt(k+i)!=word.charAt(k)) break search;
                    }
                    for(int j=i;j<i+word.length();++j){
                        bold[j] = true;
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<N;i++){
            if(bold[i] && (i==0||!bold[i-1])) sb.append("<b>");
            sb.append(s.charAt(i));
            if(bold[i] && (i==N-1||!bold[i+1])) sb.append("</b>");
        }
        return sb.toString();
    }
}