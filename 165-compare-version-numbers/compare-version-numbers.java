class Solution {
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        int min = Math.min(v1.length,v2.length);
        int max = Math.max(v1.length,v2.length);
        int i=0;
        for(;i<min;i++){
            int n1 = Integer.parseInt(v1[i]);
            int n2 = Integer.parseInt(v2[i]);
            // System.out.println("N1: "+n1+", N2: "+n2);
            if(n1>n2) return 1;
            else if(n2>n1) return -1;
        }
        while(v1.length>v2.length &&i<max){
            if(Integer.parseInt(v1[i])>0) return 1;
            i++;
        } 
        while(v2.length>v1.length&&i<max){
            if(Integer.parseInt(v2[i])>0) return -1;
            i++;
        }
        return 0;
    }
}