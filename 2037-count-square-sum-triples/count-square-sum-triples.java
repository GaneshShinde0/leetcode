class Solution {
    public int countTriples(int n) {
        Set<Integer> set = new HashSet<>();
        int nSqare = n*n;
        for(int i=1;i<=n;i++) set.add(i*i);
        int res = 0;
        for(int i=1;i<=n;i++){
            int a = i*i;
            for(int j=i+1;j<=n;j++){
                int b = j*j;
                if(set.contains(a+b)) res++;
            }
        }
        return res*2;
    }
}