class Solution {
    public int maxNumberOfApples(int[] weight) {
        Arrays.sort(weight);
        int res = 0, i=0, n = weight.length;
        while(res<=5000 && i<n){
            res+=weight[i];
            if(res<=5000) i++;
        }
        return i;
    }
}