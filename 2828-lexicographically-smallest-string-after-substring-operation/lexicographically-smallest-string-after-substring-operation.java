class Solution {
    public String smallestString(String s) {
        char[] arr = s.toCharArray();
        int i=0, n = s.length();
        while(i<n && s.charAt(i)=='a') i++;
        if(i==n) arr[n-1]='z';
        while(i<n && s.charAt(i)!='a'){
            arr[i]--;
            i++;
        }
        return new String(arr);
    }
}