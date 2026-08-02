class Solution {
    public int shortestWay(String source, String target) {
        char[] cs = source.toCharArray(), ts = target.toCharArray();
        int res = 0;
        for (int i = 0; i < ts.length; ) {
            int oriI = i;
            for (int j = 0; j < cs.length; j++) {
                if (i < ts.length && cs[j] == ts[i])
                    i++;
            }
            if (i == oriI) return -1;
            res++;
        }
        return res;
    }
    public int shortestWay2(String source, String target) {
        char[] cs = source.toCharArray(), ts = target.toCharArray();
        int res = 0;
        for (int i = 0; i < ts.length; ) {
            int oriI = i;
            for (int j = 0; j < cs.length; j++) {
                if (i < ts.length && cs[j] == ts[i])
                    i++;
            }
            if (i == oriI) return -1;
            res++;
        }
        return res;
    }
    public int shortestWay1(String source, String target) {
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