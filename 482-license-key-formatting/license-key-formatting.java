class Solution {
    public String licenseKeyFormatting(String s, int k) {
        StringBuilder sb = new StringBuilder();
        s = s.replace("-", "");  // Remove all hyphens
        int i = s.length() - 1;
        int grp = 0;
        while (i >= 0) {
            sb.append(s.charAt(i));  // Append at the end of the StringBuilder (better than insert at start)
            grp++;
            if (grp % k == 0 && i != 0) {
                sb.append('-');  // Append hyphen after every k characters, but not at the start or end
            }
            i--;
        }
        return sb.reverse().toString().toUpperCase();  // Reverse the result before returning it
    }


    public String licenseKeyFormattingInitialSolution(String s, int k) {
        StringBuilder sb = new StringBuilder();
        s=s.replace("-","");
        int i=s.length()-1;
        int grp=0;
        while(i>=0){
            if(s.charAt(i)!='-'){
                sb.insert(0,s.charAt(i));
                grp++;
            }
            if(grp%k==0&&s.charAt(i)!='-'&&i!=0){
                sb.insert(0,'-');
            }
            i--;
        }
        return sb.toString().toUpperCase();
    }
    //     int grp = 0;
    //     boolean initial = true;
    //     while(i<sb.length()){
    //         if(sb.charAt(i)!='-'){
    //             grp++;
    //         }else if(initial){
    //             grp=0;
    //             initial=false;
    //             continue;
    //         }else if (sb.charAt(i)=='-'&& grp%k!=0){
    //             sb.deleteCharAt(i);
    //             i--;
    //         }
    //         i++;
    //     }
    //     return sb.toString().toUpperCase();
    // }
}