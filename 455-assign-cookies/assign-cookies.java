class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int gPtr = 0, sPtr = 0;
        while(gPtr<g.length && sPtr<s.length){
            if(g[gPtr]<=s[sPtr]){
                gPtr++;
                sPtr++;
            }else{
                sPtr++;
            }
        }
        return gPtr;
    }
}