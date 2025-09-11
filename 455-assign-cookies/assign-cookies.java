class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int childrens = g.length, chocolates = s.length;
        int currentChild = 0;
        int res =0;
        for(int i=0;i<s.length;i++){
            if(currentChild<childrens && s[i]>=g[currentChild]){
                res++;
                currentChild++;
            }
        }
        return res;
    }
}