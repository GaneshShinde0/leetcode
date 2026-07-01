class Solution {
    public int[][] generateSchedule(int n) {
        if(n<5) return new int[0][0];
        int[][] res = new int[n*(n-1)][2];
        int ptr = 0;
        if(n%2==1){
            for(int i=0;i<2*n;i+=2) res[ptr++]=new int[]{i%n,(i+1)%n};
            for(int i=0;i<2*n;i+=2) res[ptr++]=new int[]{(i+1)%n,i%n};
        }else{
            for(int i=0;i<n;i+=2) res[ptr++] = new int[]{i,i+1};
            for(int i=0;i<n;i+=2) res[ptr++] = new int[]{i+1,i};
            for(int i=1;i<n;i+=2) res[ptr++] = new int[]{i,(i+1)%n};
            for(int i=1;i<n;i+=2) res[ptr++] = new int[]{(i+1)%n,i};
        }
        for(int diff = 2; diff<(n+1)/2; diff++){
            int start = res[ptr-1][0]+1;
            for(int i=start;i<start+n;i++) res[ptr++] = new int[]{(i+n)%n, (i+n+diff)%n};
            start = res[ptr-1][1]-1;
            for(int i=start;i<start+n;i++) res[ptr++] = new int[]{(i+n+diff)%n, (i+n)%n};
        }
        if(n%2==0){
            int start = res[ptr-1][0]-1;
            for(int i=start;i<start+n;i++) res[ptr++] = new int[]{i%n,(i+n/2)%n};
        }
        return res;
    }
}