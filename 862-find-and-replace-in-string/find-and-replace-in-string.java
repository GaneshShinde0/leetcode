class Solution {
    class IndexSourceTarget{
        int index;
        String source;
        String target;
        IndexSourceTarget(int index, String source, String target){
            this.index = index;
            this.source = source;
            this.target = target;
        }
    }
    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        StringBuilder sb = new StringBuilder(s);
        int m = sources.length;
        int diff = 0;
        IndexSourceTarget[] arr = new IndexSourceTarget[m];
        for(int i=0;i<m;i++){
            arr[i]=new IndexSourceTarget(indices[i], sources[i], targets[i]);
        }
        Arrays.sort(arr,(a,b)->Integer.compare(a.index,b.index));
        for(int i=0;i<m;i++){
            IndexSourceTarget curr = arr[i];
            int idx = curr.index;
            String currSource = curr.source;
            String currTarget = curr.target;
            if(s.indexOf(currSource,idx)==idx){
                sb.delete(idx+diff,idx+diff+currSource.length());
                sb.insert(idx+diff,currTarget);
                diff+=currTarget.length()-currSource.length();
            }
        }
        return sb.toString();
    }
}

/*
"vmokgggqzp"

-"vmosggqzp"
-"vmossozp"
-"vbfrssozp"


*/