class Solution {
    public int minimumSum(int n, int k) {
        Set<Integer> set = new HashSet<>();
        int sum =0;
        for(int i=1;i<=n;i++){
            System.out.println(set);
            if(set.contains(k-i)){
                n++;
                continue;
            }
            set.add(i);
            sum+=i;
        }
        return sum;
    }
}