/*
S1 = "0"
S2 = "011"
S3 = "0111001"
S4 = "011100110110001"
*/

class Solution {
    boolean stage = true;
    static Set<Integer> set = new HashSet<>();
    static{
        int prev = 0;
        for(int i=0;i<21;i++){
            set.add(prev*2+1);
            prev = prev*2+1;
        }
    }
    public char findKthBit(int n, int k) {
        System.out.println(set);
        if(n==1) return '0';
        if(set.contains(k-1)) return '1';
        int len = (int) Math.pow(2,n);
        if(k<len/2) return findKthBit(n-1,k);
        else{
            char bit = findKthBit(n-1,len-k);
            return (bit=='0')?'1':'0';
        }
    }
}