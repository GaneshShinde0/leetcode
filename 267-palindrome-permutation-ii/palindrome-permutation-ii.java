class Solution {
    Set<String> set = new HashSet<>();
    public List<String> generatePalindromes(String s) {
        int[] freq = new int[26];
        for(char c:s.toCharArray()){
            freq[c-'a']++;
        }
        int odds = 0;
        char middle = 'A';
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<26;i++){
            if(freq[i]%2==1){
                middle = (char) (i+'a');
                odds++;
            }
            if(odds == 2)  return new ArrayList<>(set);
            for (int j = 0; j < freq[i] / 2; j++) {
                sb.append((char) (i + 'a'));
            }
        }
        permutations(0,sb.toString(),middle);
        return new ArrayList<>(set);
    }

    private void permutations(int start, String s, char middle){
        if(start==s.length()){
            StringBuilder sb = new StringBuilder(s);
            if(middle!='A') sb.append(middle);
            String reverse = sb.reverse().toString();
            set.add(s+reverse);
        }else{
            for(int i=start;i<s.length();i++){
                s = swap(s,i,start);
                permutations(start+1,s,middle);
                s = swap(s,i,start);
            }
        }
    }

    private boolean isPalindrome(String s){
        int i = 0, j= s.length()-1;
        while(i<j){
            if(s.charAt(i)!=s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }

    private String swap(String s, int i, int j){
        char[] arr = s.toCharArray();
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        return new String(arr);
    }
}