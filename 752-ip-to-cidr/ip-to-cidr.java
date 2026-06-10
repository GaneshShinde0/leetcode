/*
Given IP:
- 255.0.0.7  -> 11111111 00000000 00000000 00000111


*/
class Solution {
    public List<String> ipToCIDR(String ip, long n) {
        List<String> result = new ArrayList<>();
        long num = getNum(ip);
        for(long i=num;i<num+n;){
            long step = (long) Math.pow(2,getLastBitPos(i));
            while(step>(num+n-i)) step/=2;
            long temp = 32-getLastBitPos(step);
            result.add(getIP(i)+"/"+temp);
            i+=Math.pow(2,32-temp);
            if(i==0||i>num+n)break;
        }
        return result;
    }
    private long getLastBitPos(long num){
        long pos = 0;
        if(num==0) return 32; 
        while(num%2!=1){
            pos++;
            num/=2;
        }
        return pos;
    }

    private String getIP(long num){
        StringBuilder sb = new StringBuilder();
        int i=0;
        while(i<4){
            sb.insert(0,""+num%256);
            sb.insert(0,'.');
            num/=256;
            i++;
        }
        int len = sb.length();
        return sb.toString().substring(1);
    }

    private long getNum(String ip){
        String[] arr = ip.split("\\.");
        long num = 0;
        for(int i=0;i<arr.length;i++){
            num = num*256+(Integer.parseInt(arr[i]));
        }
        return num;
    }
}