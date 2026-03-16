class Solution {
    public String smallestString(String s) {
        int i = 0, n = s.length();
        char[] arr = s.toCharArray();
        while(i<n && arr[i]=='a') i++;
        if(i==n) arr[n-1]='z';
        while(i<n && arr[i]!='a'){
            arr[i]-=1;
            i++;
        }
        return String.valueOf(arr);
    }
}