class Solution {

    public String getPermutation(int n, int k) {
        int[] fact = new int[n];
        fact[0]=1;
        for(int i=1;i<n;i++) fact[i] = i*fact[i-1];
        k = k-1;
        List<Integer> li= new ArrayList<>();
        StringBuilder res = new StringBuilder();
        for(int i=1;i<=n;i++) li.add(i);
        for(int i=n;i>=1;i--){
            int block_size = fact[i-1];
            int idx = k/block_size;
            res.append(li.get(idx));
            li.remove(idx);
            k%=block_size;
        }
        return res.toString();
    }

























    public String getPermutationDoesNotWork(int n, int k) {
        StringBuilder sb = new StringBuilder();
        for(int i=1;i<=n;i++) sb.append(i);
        List<String> li = new ArrayList<>();
        permute(sb.toString(),0,n-1,k,li);
        System.out.println(li);
        return li.get(k);
    }
    private String swap(String s, int i, int j){
        char[] arr = s.toCharArray();
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        return new String(arr);
    }

    private void permute(String s, int start, int end , int k, List<String> li){
        if(start==end){
            li.add(s);
        }else{
            for(int i=end;i>=start;i--){
                s = swap(s,i,end);
                permute(s,start+1,end,k-1,li);
                s = swap(s,i,end);
            }
        }
    }
}