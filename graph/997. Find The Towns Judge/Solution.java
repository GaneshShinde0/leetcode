class Solution {
    public int findJudgeInitialSolution(int n, int[][] trust) {
        if(n==1) return n;
        if(trust.length==0) return -1;
        int dest = trust[0][1];
        int count=0;
        int[] temp = new int[n];
        for(int[] arr:trust){
            temp[arr[1]-1]++;
        }
        int res=-1;
        // System.out.println(Arrays.toString(temp));
        for(int i=0;i<n;i++){
            // if(res>0 && res!=n-2) return -1;
            if(temp[i]==n-1){
                res = i;
                break;
            }
        }
        if(res==-1) return res;
        res++;
        for(int[] arr:trust){
            if(arr[0]==res) return -1;
        }
        return res;
    }

    public int findJudge(int n, int[][] trust) {
        int[] person = new int[n+1];
        for(int i=0;i<trust.length;i++){
            person[trust[i][1]]++;
        }
        int re = -1;
        for(int i=0;i<person.length;i++){
            if(person[i]==n-1){
                re=i;
            }
        }
        for(int i=0;i<trust.length;i++){
            if(trust[i][0]==re){
                re=-1;
                break;
            }
        }
        return re;
    }
}
