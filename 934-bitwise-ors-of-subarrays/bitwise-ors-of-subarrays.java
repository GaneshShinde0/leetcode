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
    // Following is also slow
    public int subarrayBitwiseORsOne(int[] arr) {
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

    public int subarrayBitwiseORsTwo(int[] arr) {
        Set<Integer> ans = new HashSet<>();
        Set<Integer> curr = new HashSet<>();

        for (int x : arr) {
            Set<Integer> next = new HashSet<>();
            next.add(x);
            for (int y : curr) {
                next.add(x | y);
            }
            curr = next;
            ans.addAll(curr);
        }

        return ans.size();
    }
    public int subarrayBitwiseORs(int[] arr) {
        Set<Integer> result=new HashSet<>();
        for(int i=0;i<arr.length;i++){
            result.add(arr[i]);
            for(int j=i-1;j>=0;j--){
                if(arr[j]==(arr[j] | arr[i])) break;
                arr[j]|=arr[i];
                result.add(arr[j]);
            }
        }
        return result.size();
    }
}