class Solution {
    public int magicalString(int n) {
        StringBuilder sb = new StringBuilder();
        sb.append("122");
        int curr = 1;
        for(int i=2;i<n;i++){
            int freq = sb.charAt(i)-'0';
            while(freq>0){
                sb.append(curr);
                freq--;
            }
            curr = curr==1?2:1;
        }
        int res = 0;
        for(int i=0;i<n;i++){
            if(sb.charAt(i)=='1') res++;
        }
        return res;
    }
}