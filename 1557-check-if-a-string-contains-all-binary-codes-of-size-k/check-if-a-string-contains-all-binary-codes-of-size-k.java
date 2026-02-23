class Solution {
    public static boolean hasAllCodes(String s, int k){
        int need = 1<<k;
        boolean[] got = new boolean[need];
        int allOne = need-1;
        int hashVal = 0;

        for(int i=0;i<s.length();i++){
            // Calculate hash for s.substr(i-k+1,i+1)
            hashVal = ((hashVal<<1) & allOne) | (s.charAt(i)-'0');
            // Hash only available when i-k+1>0
            if(i>=k-1 && !got[hashVal]){
                got[hashVal] = true;
                need--;
                if(need==0) return true;
            }
        }
        return false;
    }
    public boolean hasAllCodesONK(String s, int k) {
        int need = 1<<k;
        Set<String> got = new HashSet<>();
        for(int i=k;i<=s.length();i++){
            String curr = s.substring(i-k,i);
            if(!got.contains(curr)){
                got.add(curr);
                need--;
                if(need==0) return true;
            }
        }
        return false;
    }
    public boolean hasAllCodesInitial(String s, int k) {
        List<String> codes = new ArrayList<>();
        findCodes(codes,0, k, new StringBuilder());
        for(String code:codes){
            if(s.indexOf(code)==-1)return false;
        }
        // System.out.println(codes);
        return true;
    }
    private void findCodes(List<String> codes,int start, int k, StringBuilder sb){
        if(start==k){
            codes.add(sb.toString());
            return;
        }else{
            sb.append("0");
            findCodes(codes, start+1,k,new StringBuilder(sb));
            sb.deleteCharAt(sb.length()-1);
            sb.append("1");
            findCodes(codes,start+1,k,new StringBuilder(sb));
        }
    }
}