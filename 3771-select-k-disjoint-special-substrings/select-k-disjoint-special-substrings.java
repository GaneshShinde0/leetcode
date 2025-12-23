class Solution {
    public boolean maxSubstringLength(String s, int k) {
        int[][] startEnd = new int[26][2];
        for(int[] se:startEnd)Arrays.fill(se,-1);
        for(int i=0;i<s.length();i++){
            if(startEnd[s.charAt(i)-'a'][0]==-1) startEnd[s.charAt(i)-'a'][0]=i;
            startEnd[s.charAt(i)-'a'][1]=i;
        }
        List<int[]> intervals = new ArrayList<>();
        for(int i=0;i<26;i++){
            if(startEnd[i][0]==-1) continue;
            int start = startEnd[i][0];
            int end = startEnd[i][1];
            int j=start;
            for(;j<=end;j++){
                int idx = s.charAt(j)-'a';
                if(startEnd[idx][1]>end) end = startEnd[idx][1];
                if(startEnd[idx][0]<start) break;
            }
            if(j==end+1 && !(start==0 && end ==s.length()-1)){
                intervals.add(new int[]{start,end});
            }
        }
        Collections.sort(intervals,(a,b)->a[1]-b[1]);
        int count = 0, lastEnd = -1;
        for(int[] interval:intervals){
            if(interval[0]>lastEnd){
                count++;
                lastEnd=interval[1];
            }
        }
        return count>=k;
    }
}