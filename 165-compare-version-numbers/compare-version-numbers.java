class Solution {
    public int compareVersionInitial(String version1, String version2) {
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
    public int compareVersion2(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        int max = Math.max(v1.length, v2.length);

        for (int i = 0; i < max; i++) {
            int n1 = i < v1.length ? Integer.parseInt(v1[i]) : 0;
            int n2 = i < v2.length ? Integer.parseInt(v2[i]) : 0;

            if (n1 != n2) {
                return n1 > n2 ? 1 : -1;
            }
        }
        return 0;
    }

    public int compareVersion(String version1, String version2) {
        int i = 0, j = 0;
        int n1 = version1.length(), n2 = version2.length();

        while (i < n1 || j < n2) {
            int num1 = 0, num2 = 0;

            // Parse next number from version1
            while (i < n1 && version1.charAt(i) != '.') {
                num1 = num1 * 10 + (version1.charAt(i) - '0');
                i++;
            }

            // Parse next number from version2
            while (j < n2 && version2.charAt(j) != '.') {
                num2 = num2 * 10 + (version2.charAt(j) - '0');
                j++;
            }

            if (num1 != num2) {
                return num1 > num2 ? 1 : -1;
            }

            // Skip the '.'
            i++;
            j++;
        }

        return 0;
    }
}