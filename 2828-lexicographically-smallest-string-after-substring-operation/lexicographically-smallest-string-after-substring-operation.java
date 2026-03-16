/*
Input: s = "cbabc"
Output: "baabc";

Input: s = "a"=> z

Input: s = zzasdf
Output: s = yyasdf

Basically until we get A we can reduce.

Input: s = "aaaaaa";
we have a then we will reach till last character for which a is present and replace that with z, so we will get smallest string after operation
Output: s = "aaaaaz"

// We should be able to manipulate individual character;=> Transform string to char Array.
*/

class Solution {
    public String smallestString(String s) {
        int n = s.length(), i=0;
        char[] arr = s.toCharArray();
        while(i<n && arr[i]=='a') i++;
        if(i==n) arr[n-1]='z'; //  We have to change atleast one.
        while(i<n && arr[i]!='a'){
            arr[i]--;
            i++;
        }
        return String.valueOf(arr);

    }
}