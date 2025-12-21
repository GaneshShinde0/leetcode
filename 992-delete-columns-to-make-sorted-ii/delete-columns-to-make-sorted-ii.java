class Solution {
    public int minDeletionSizeFails(String[] strs) {
        int n = strs[0].length();
        int res = 0;
        boolean[] sorted = new boolean[strs.length];
        sorted[0]=true;
        for(int i=0;i<n;i++){
            boolean[] locallySorted = Arrays.copyOf(sorted, strs.length);
            locallySorted[0]=true;
            for(int j=1;j<strs.length;j++){
                if(sorted[j]) continue;
                if(strs[j].charAt(i)<strs[j-1].charAt(i)){
                    res++;
                    break;
                }else if(strs[j].charAt(i)>strs[j-1].charAt(i)){
                    locallySorted[j] = true;
                }
                if(j==strs.length-1){
                    for(int k=0;k<strs.length;k++){
                        sorted[k]=sorted[k] || locallySorted[k];
                    }
                }
            }
        }
        return res;
        
    }

    public int minDeletionSize(String[] strs) {
        int n = strs.length;
        int w = strs[0].length();
        int ans = 0;

        // curr: All rows we have written
        // For Example, with A = ["abc","def","ghi"] we mighthave
        // curr = ["abc","def","ghi"]
        String[] curr = new String[n];
        Arrays.fill(curr, new String());
        // System.out.println(Arrays.toString(curr));
        for(int j=0;j<w;j++){
            // curr2: what we potentially can write, includign the newest column [A[i][j] for i]
            // E.g. If curr = ["ab","de","gh"] and col = ["c","f","i"]
            // then curr2 = ["abc","def","ghi"]
            String[] curr2 = Arrays.copyOf(curr, n);
            // System.out.println(Arrays.toString(curr2));
            for(int i=0;i<n;i++){
                curr2[i]+=strs[i].charAt(j);
            }
            if(isSorted(curr2)){
                curr=curr2;
            }else{
                ans++;
            }
        }
        return ans;
    }
    public boolean isSorted(String[] curr){
        for(int i=1;i<curr.length;i++){
            if(curr[i-1].compareTo(curr[i])>0) return false;
        }
        return true;
    }
}