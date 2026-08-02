class Solution {
    public int shortestWay(String source, String target) {
        int tP = 0, sP = 0, res = 0, sLen = source.length();
        boolean taken = false;
        while(tP<target.length()){
            char c = target.charAt(tP);
            if(sP==sLen){
                taken = false;
                sP = 0;
                res++;
            }
            while(sP<sLen){
                if(c==source.charAt(sP)){
                    tP++;
                    sP++;
                    taken = true;
                    break;
                }
                sP++;
            }
            if(!taken) return -1;
        }
        return res+1;
    }
}