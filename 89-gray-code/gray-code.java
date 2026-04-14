class Solution {
    public List<Integer> grayCodeInitial(int n) {
        List<Integer> li = new ArrayList<>();
        li.add(0);
        for(int i=1;i<=n;i++){
            int size = li.size();
            int add = 1<<(i-1);
            for(int j=size-1;j>=0;j--){
                li.add(li.get(j)+add);
            }
        }
        return li;
    }
    // Another one
    public List<Integer> grayCode(int n){
        List<Integer> result = new ArrayList<>();
        for(int i=0; i<(1<<n);i++){
            result.add(i^(i>>1)); // i xor with (i)>>1 i.e. after removing lsb of I ... This effectively aligns the kth bit with the k+1 th bit.
        }
        return result;
    }
}
/*
1 => [0,1]
2 => [0,1,3,2]
3 => [0,1,3,2,6,7,5,4]
*/