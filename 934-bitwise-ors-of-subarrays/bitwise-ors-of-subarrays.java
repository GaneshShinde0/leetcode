class Solution {
    public int subarrayBitwiseORsBruteForce(int[] arr) {
        Set<Integer> set = new HashSet<>();
        int n = arr.length;
        for(int i=0; i<n; i++){
            int or = arr[i];
            for(int j=i+1; j<n;j++){
                set.add(or);
                or |= arr[j];
            }
            set.add(or);
        }
        // System.out.println(set);
        return set.size();
    }

    public int subarrayBitwiseORs(int[] arr) {
        Set<Integer> ans = new HashSet<>();
        Set<Integer> cur = new HashSet<>();
        cur.add(0);
        for(int x: arr){
            Set<Integer> cur2 = new HashSet();
            for(int y:cur){
                cur2.add(x|y);
            }
            cur2.add(x);
            cur = cur2;
            ans.addAll(cur);
        }
        return ans.size();
    }
}